package basic;

/**
 * Created by SilverNine on 2017. 3. 4..
 */
public class Test {
    public static void main(String[] args) {
        //입력값 12345
        int inputNumber = 12345;
        try {
            cal(inputNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int cal(int inputNumber) throws Exception {
        //5자리 이상 정수인지 판단
        if(inputNumber < 10000) {
            throw new Exception("10000 이상을 입력해주세요");
        }

        //10의 자리 버림
        inputNumber = inputNumber - (inputNumber % 100) + (inputNumber % 10);

        System.out.println("10의 자리 버림 : " + inputNumber);

        //100의 자리 올림
        inputNumber = inputNumber - (inputNumber % 100) + (inputNumber % 10);
        if(inputNumber % 1000 > 99) {
            inputNumber = inputNumber - (inputNumber % 1000) + 1000 + (inputNumber % 100);
        }

        System.out.println("100의 자리 올림 : " + inputNumber);

        return inputNumber;
    }
}
