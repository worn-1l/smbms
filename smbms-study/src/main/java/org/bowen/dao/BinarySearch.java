package org.bowen.dao;

/**
 * @author bowencoder
 * @date 2021/12/18 13:09
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        binarySearch(arr,5);
    }


    public static int binarySearch(int[] array,int value){
        int low = 0;
        int high = array.length - 1;
        while (low <= high){
            int middle = low + ((high - low) >> 1);
            if (value == array[middle])
                return middle;
            if (value > array[middle])
                low = middle + 1;
            else
                high = middle - 1;
        }
        return -1;
    }

}
