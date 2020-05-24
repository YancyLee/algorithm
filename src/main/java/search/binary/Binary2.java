package search.binary;

import java.util.Arrays;

/**
 *  循环使用二分查找法
 */
public class Binary2 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,7,8,10,23,43,64,100,232,255};
        int target = 23;
        System.out.println(binarySearch(arr,target));
    }


    public static int binarySearch(int[] arr,int target){

        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        while (low < high) {
            mid = (low + high) >>> 1;
            if (arr[mid] > target){
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
