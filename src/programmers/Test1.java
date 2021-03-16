package programmers;

import java.util.*;

public class Test1 {
    public static void main(String args[]) {

        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        Arrays.sort(A);
        Arrays.sort(B);

        List<Integer> tempList = new ArrayList<>();
        for(int temp : B) {
            tempList.add(temp);
        }

        int count = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<tempList.size(); j++) {
                if(tempList.get(j) > A[i]){
                    count++;
                    tempList.remove(j);
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
