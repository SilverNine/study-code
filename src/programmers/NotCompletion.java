package programmers;

import java.util.HashMap;
import java.util.Map;

public class NotCompletion {
    public static void main(String args[]) {
        solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "mislav", "ana"});
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String person : participant){
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        for(String person : completion) {
            map.put(person, map.get(person) - 1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                answer = entry.getKey();
            }
        }

        System.out.println(answer);
        return answer;
    }
}