package programmers;

import java.util.ArrayList;

public class Stock {
    public int[] solution(int[] prices) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        for(int i=0; i<prices.length; i++){
            int term = 0;
            for(int j=i+1; j<prices.length; j++){
                term++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            returnList.add(term);
        }

        int[] returnArray = new int[returnList.size()];

        for(int i=0; i<returnList.size(); i++) {
            returnArray[i] = returnList.get(i);
        }

        return returnArray;
    }
}