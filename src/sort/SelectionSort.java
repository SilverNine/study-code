package sort;

/**
 * SelectionSort
 * Worst case : O(n^2)
 * Bast case : O(n^2)
 * Average case : O(n^2)
 * Worst case space complexity : O(n) total, O(1) auxiliary
 */
public class SelectionSort {
    public static void sort(Integer[] targetList) {
        int minIndex, temp;

        for(int i=0 ; i<targetList.length-1 ; i++) {
            minIndex = i;

            for(int j=i+1; j<targetList.length ; j++) {
                if(targetList[minIndex] > targetList[j]) {
                    minIndex = j;
                }
            }

            temp = targetList[i];
            targetList[i] = targetList[minIndex];
            targetList[minIndex] = temp;
        }

        for(int target : targetList) {
            System.out.println(target);
        }
    }

    public static void main(String[] args) {
        sort(new Integer[]{1,3,5,2,4,7,6});
    }
}