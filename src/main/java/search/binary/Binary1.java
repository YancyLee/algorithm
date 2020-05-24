package search.binary;

public class Binary1 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,7,8,10,23,43,64,100,232,255};
        int target = 2;
        System.out.println(binarySearch(arr,0,arr.length -1,target));
    }

    private static int binarySearch(int[] array,int beginIndex,int endIndex,int target) {
        if (array == null || array.length == 0) {
            return 0;
        }
        else if (array.length == 1) {
            return 0;
        } else if(beginIndex > endIndex) {
            return -1;
        } else {
            int i = (endIndex-beginIndex)/2 + beginIndex;
            if (array[i] > target) {
                return binarySearch(array,beginIndex,i - 1,target);
            } else if (array[i] < target) {
                return binarySearch(array,i + 1,endIndex,target);
            } else {
                return i + 1;
            }
        }
    }


}
