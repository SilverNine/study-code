package programmers;

import java.util.HashMap;

public class Spy {
    public static void main(String[] args) {
        Spy spy = new Spy();

        System.out.println(spy.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(int value : clothesMap.values()) {
            //안입는것, yellowhat,green_turban 3개
            //안입는것, bluesunglasses 2개
            answer = answer * (value + 1);
        }

        //안입는것, 안입는것의 경우의 수를 빼준다.
        return answer - 1;
    }
}
