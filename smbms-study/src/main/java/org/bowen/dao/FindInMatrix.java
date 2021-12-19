package org.bowen.dao;

/**
 * @author bowencoder
 * @date 2021/12/18 16:44
 */
public class FindInMatrix {

    public static void main(String[] args) {
        int [][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        findInMatrix(arr,100);
    }

    public static boolean findInMatrix(int[][] matrix,int target){
        if (matrix == null||matrix.length == 0||matrix[0]==null||matrix[0].length==0){
            return false;
        }
        int rows = matrix.length - 1,cols = matrix[0].length;
        int i =rows - 1;
        int j =0;
        while (i>=0&&j<cols){
            if (target == matrix[i][j]){
                System.out.println(target+"在["+(i+1)+","+(j+1)+"]");
                return true;}
            if (target>matrix[i][j])
                ++j;
            else if (target<matrix[i][j])
                --i;
        }
        System.out.println(target+"不在数组中");
        return false;
    }

}
