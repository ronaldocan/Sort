package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/6/9.
 */
public class Solution1<Item extends Comparable> {
    public static int[] sort(int[] data)
    {
        int nonZerosCount = 0;
        int[] result = new int[data.length];

        for(int i=0;i<data.length;i++) {
            if (0 != data[i]) {
                result[nonZerosCount] = data[i];
                nonZerosCount++;
            }
        }
        int length = data.length;
//        System.out.println(result.length);
        while(nonZerosCount < length)
        {
            result[nonZerosCount] = 0;
            nonZerosCount++;
        }
        return result;
    }
    public static void arr(int[] data)
    {
        int[] count = {0,0,0};
        for( int i = 0 ; i < data.length ; i ++ ){
            assert( data[i] >= 0 && data[i] <= 2 );
            count[data[i]] ++;
        }

        int index = 0;
        for( int i = 0 ; i < count[0] && i < data.length ; i ++ )
            data[index++] = 0;
        for( int i = 0 ; i < count[1] && i < data.length; i ++ )
            data[index++] = 1;
        for( int i = 0 ; i < count[2] && i <= data.length; i ++ )
            data[index++] = 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 0;
        arr[2] = 2;
        arr[3] = 1;
        arr[4] = 1;
        Solution1.arr(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
