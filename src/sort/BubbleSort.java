package sort;

/**
 * BubbleSort
 * performance : O(n^2)
 * space complexity : O(1)
 */
public class BubbleSort {
    /**
     * pseudo code
     * for i between 0 and (array length - 2):
     *   if(array(i + 1) < array(i)):
     *     switch array(i) and array(i + 1)
     *
     * repeat until a complete iteration where no elements are switched.
     */

    public static void sort(Integer[] targetList) {
        int temp;
        for(int i=0 ; i<targetList.length-1 ; i++) {
            for(int j=i; j<targetList.length-1 ; j++) {
                if(targetList[j] > targetList[j+1]){
                    temp = targetList[j+1];
                    targetList[j+1] = targetList[j];
                    targetList[j] = temp;
                }
            }
        }

        for(int target : targetList) {
            System.out.println(target);
        }
    }

    public static void main(String[] args) {
        sort(new Integer[]{1,3,5,2,4,7,6});
    }
}