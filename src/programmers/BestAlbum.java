package programmers;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();

        for(int value : bestAlbum.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 1250})) {
            System.out.println(value);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genresMap = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genresKeySetList = new ArrayList<>(genresMap.keySet());

        // 오름차순
        //Collections.sort(genresKeySetList, Comparator.comparing(genresMap::get));
        // 내림차순
        Collections.sort(genresKeySetList, (o1, o2) -> (genresMap.get(o2).compareTo(genresMap.get(o1))));

        HashMap<Integer, Integer> tempPlayMap = new HashMap<>();
        List<Integer> finalPlayList = new ArrayList<>();

        Loop1:
        for(String genresKey : genresKeySetList) {

            Loop2:
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genresKey)) {
                    tempPlayMap.put(i, plays[i]);
                }
            }

            List<Integer> playKeySetList = new ArrayList<>(tempPlayMap.keySet());
            HashMap<Integer, Integer> finalTempPlayMap = tempPlayMap;
            Collections.sort(playKeySetList, (o1, o2) -> (finalTempPlayMap.get(o2).compareTo(finalTempPlayMap.get(o1))));

            Loop3:
            for (int i = 0; i<playKeySetList.size(); i++) {
                if(i>=2) break;
                finalPlayList.add(playKeySetList.get(i));
            }

            tempPlayMap = new HashMap<>();
        }

        return finalPlayList.stream().mapToInt(i->i).toArray();
    }
}
