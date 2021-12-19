package org.bowen.dao;



/**
 * @author bowencoder
 * @date 2021/12/18 11:14
 */
public class BubbleSorting {


    public static void main(String[] args) {
        int [] arr ={2,6,8,7,9,4,1,5};
        sort(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }

    }
    public static void sort( int [] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[i]<array[j]){
                    int temp;
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
}
