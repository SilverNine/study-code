package test;


import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


/**
 * 입력 텍스트를 이미지로 만들어 준다
 *
 * @author parkwon
 * @since 2017.03.24
 */
public class MakeImage {

    /**
     * 테스트용 진입점
     *
     * @param args 파라미터
     * @since 2017.03.24
     */
    public static void main(String[] args) {
        try {
            new MakeImage();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 생성자
     *
     * @since 2017.03.24
     */
    public MakeImage() throws Exception {
        //      drawText("어머니가 짜장면이 싫다고 하셨어", "/Users/SilverNine/Desktop/writes/title.png");
        ArrayList<String> texts = new ArrayList<String>();

        File file = new File("/Users/SilverNine/Desktop/test.txt");
        FileReader filereader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        while ((line = bufReader.readLine()) != null) {
            texts.add(line);
        }
        bufReader.close();

        texts.forEach(text -> {
            try {
                //최고품질로 맞춘 JPG 하지만 PNG 보다 품질 낮음
                drawTextWithImageToJPG(text, "/Users/SilverNine/Desktop/writes/" + text + ".jpg", "/Users/SilverNine/Desktop/test.jpg");
                //PNG 화질 좋음
                drawTextWithImageToPNG(new String[] { text }, "/Users/SilverNine/Desktop/writes/" + text + ".png",
                        "/Users/SilverNine/Desktop/test.png");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * 텍스트를 이미지로 만들어준다
     *
     * @param text    텍스트
     * @param fileLoc 파일위치
     * @throws Exception 오류
     * @since 2017.03.27
     */
    public void drawText(String text, String fileLoc) throws Exception {
        Font font = new Font("나눔고딕", Font.PLAIN, 28);
        Rectangle r = getFontrect(text, font);

        int width = (int) r.getWidth();
        int height = (int) r.getHeight();

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = getG2D(img);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();

        // 이미지 파일을 생성한다
        ImageIO.write(img, "png", new File(fileLoc));
    }


    /**
     * 웹 이미지 내부에 텍스트를 포함하여 이미지로 만들어준다 PNG
     *
     * @param texts              텍스트 문자열
     * @param fileLoc            파일위치
     * @param backgrondImagePath 이미지 경로
     * @throws Exception 오류
     * @since 2017.03.27
     */
    public void drawTextWithImageToPNG(String[] texts, String fileLoc, String backgrondImagePath) throws Exception {
        final int FONT_SIZE = 18;
        final int POS_X = 300;
        final int POS_Y = 400;
        BufferedImage img = ImageIO.read(new File(backgrondImagePath));

        Graphics g = img.getGraphics();
        Font font = new Font("나눔고딕", Font.PLAIN, FONT_SIZE);

        // 배경 이미지 RESIZE 처리
        // 우선은 첫 라인 정보만 가져온다. 일반적으로 가장 길게 설정하는 것이 맞다고 생각함.
        //Rectangle rect = getFontrect(texts[0], font);

        //int oriWidth = img.getWidth();
        //int oriHeight = img.getHeight();

        //double ratio = (rect.getWidth() + POS_X*2) / oriWidth;
        //int newWidth = (int) (rect.getWidth() + POS_X*2);
        //int newHeight = (int) (oriHeight * ratio);
        //img = resizeImage(img, newWidth, newHeight*texts.length);

        // 텍스트 처리
        for (int i = 0; i < texts.length; i++) {
            Graphics2D g2d = getG2D(img);
            g2d.setFont(font);

            int x = POS_X;
            int y = (FONT_SIZE + POS_Y) * (i + 1);

            // 그림자 처리
            drawStringDropshadow(g2d, texts[i], x, y);
        }
        g.dispose();

        // 배경 이미지 CROP 처리
        //img = cropImage(img, new Rectangle(0, 0, newWidth, (FONT_SIZE+POS_Y)*texts.length+POS_Y) );

        // 이미지 파일을 생성한다
        ImageIO.write(img, "png", new File(fileLoc));
    }


    /**
     * 웹 이미지 내부에 텍스트를 포함하여 이미지로 만들어준다 JPG
     *
     * @param text               텍스트 문장
     * @param fileLoc            파일위치
     * @param backgrondImagePath 이미지 경로
     * @throws Exception 오류
     * @since 2017.03.27
     */
    public void drawTextWithImageToJPG(String text, String fileLoc, String backgrondImagePath) throws Exception {
        final int FONT_SIZE = 18;
        final int POS_X = 500;
        final int POS_Y = 600;
        BufferedImage img = ImageIO.read(new File(backgrondImagePath));

        Font font = new Font("나눔고딕", Font.PLAIN, FONT_SIZE);

        // 텍스트 처리
        Graphics2D g2d = getG2D(img);
        g2d.setFont(font);

        // 그림자 처리
        drawStringDropshadow(g2d, text, POS_X, (FONT_SIZE + POS_Y));

        // 이미지 파일을 생성한다
        JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
        jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpegParams.setCompressionQuality(1f);

        final ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
        // specifies where the jpg image has to be written
        writer.setOutput(new FileImageOutputStream(new File(fileLoc)));

        // writes the file with given compression level
        // from your JPEGImageWriteParam instance
        writer.write(null, new IIOImage(img, null, null), jpegParams);

        writer.dispose();
    }


    /**
     * 입력받은 문자열의 사각영역을 반환한다
     *
     * @param text 문자열
     * @param font 폰트
     * @return 사각크기
     * @since 2017.03.24
     */
    private Rectangle getFontrect(String text, Font font) {
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        return new Rectangle(0, 0, width, height);
    }


    /**
     * 아웃라인 처리
     *
     * @param g2d  2D 그래픽스
     * @param text 문자열
     * @param x    X좌표
     * @param y    Y좌표
     * @param cin  내부 색상
     * @param cout 외부 색상
     * @since 2017.03.27
     */
    private void drawStringOutline(Graphics2D g2d, String text, int x, int y, Color cin, Color cout) {
        g2d.setColor(cout);
        g2d.drawString(text, ShiftWest(x, 1), ShiftNorth(y, 1));
        g2d.drawString(text, ShiftWest(x, 1), ShiftSouth(y, 1));
        g2d.drawString(text, ShiftEast(x, 1), ShiftNorth(y, 1));
        g2d.drawString(text, ShiftEast(x, 1), ShiftSouth(y, 1));

        g2d.setColor(cin);
        g2d.drawString(text, x, y);
    }


    /**
     * 그림자 텍스트를 그려준다
     *
     * @param g2d  2D 그래픽스
     * @param text 문자열
     * @param x    X좌표
     * @param y    Y좌표
     * @since 2017.03.27
     */
    private void drawStringDropshadow(Graphics2D g2d, String text, int x, int y) {
        g2d.setColor(new Color(20, 20, 20));
        g2d.drawString(text, ShiftEast(x, 2), ShiftSouth(y, 2));
        g2d.setColor(new Color(220, 220, 220));
        g2d.drawString(text, x, y);
    }


    /**
     * 폰트를 회전 처리한다
     *
     * @param font  폰트
     * @param angle 회전각 0~360 / -를 넣으면 반시계 방향으로 계산
     * @return 회전처리 된 폰트
     * @since 2017.03.24
     */
    private Font rotatedFont(Font font, double angle) {
        // 폰트 회전처리
        AffineTransform form = new AffineTransform();
        form.rotate(Math.toRadians(angle), 0, 0);
        return font.deriveFont(form);
    }


    /**
     * 이미지 크롭처리
     *
     * @param img  이미지
     * @param rect 사각정보
     * @return 신규 이미지
     * @since 2017.03.24
     */
    private BufferedImage cropImage(BufferedImage img, Rectangle rect) {
        BufferedImage dest = img.getSubimage(rect.x, rect.y, rect.width, rect.height);
        return dest;
    }


    /**
     * 이미지 리사이징
     *
     * @param img  이미지
     * @param newW 새로운 넓이
     * @param newH 새로운 높이
     * @return 신규 이미지
     * @since 2017.03.24
     */
    private BufferedImage resizeImage(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }


    /**
     * 이미지에서 2D 그래픽스 개체를 얻어온다
     *
     * @param img 이미지버퍼
     * @return 2D 그래픽스
     * @since 2017.03.24
     */
    private Graphics2D getG2D(BufferedImage img) {
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        return g2d;
    }


    /**
     * 좌표 이동처리 - 위쪽 / 북
     *
     * @param p        현 좌표
     * @param distance 이동거리
     * @return 변경된 좌표
     * @since 2017.03.27
     */
    int ShiftNorth(int p, int distance) {
        return (p - distance);
    }


    /**
     * 좌표 이동처리 - 아래쪽 / 남
     *
     * @param p        현 좌표
     * @param distance 이동거리
     * @return 변경된 좌표
     * @since 2017.03.27
     */
    int ShiftSouth(int p, int distance) {
        return (p + distance);
    }


    /**
     * 좌표 이동처리 - 오른쪽 / 동
     *
     * @param p        현 좌표
     * @param distance 이동거리
     * @return 변경된 좌표
     * @since 2017.03.27
     */
    int ShiftEast(int p, int distance) {
        return (p + distance);
    }


    /**
     * 좌표 이동처리 - 왼쪽 / 서
     *
     * @param p        현 좌표
     * @param distance 이동거리
     * @return 변경된 좌표
     * @since 2017.03.27
     */
    int ShiftWest(int p, int distance) {
        return (p - distance);
    }
}