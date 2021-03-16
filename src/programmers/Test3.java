package programmers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test3 {
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
        for(int i=A.length-1; i>=0; i--) {
            for(int j=tempList.size()-1; j>=0; j--) {
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
