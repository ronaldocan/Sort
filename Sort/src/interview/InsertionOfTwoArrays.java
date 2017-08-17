package interview;

import java.util.*;

/**
 * Created by Administrator on 2017/6/13.
 */
public class InsertionOfTwoArrays {
    private static HashMap<Integer, Integer> record = new HashMap<>();
    private static SortedSet<Integer> record2 = new TreeSet<>();
    public static List<Integer> insertionOfTwoArrays(int[] arr1,int[] arr2){
        List<Integer> list = new ArrayList<>();
        if(arr1.length < arr2.length){
            for (int i = 0; i < arr1.length; i++) {
//            record.put(arr1[i],arr1[i]);
                record2.add(arr1[i]);

            }
            Arrays.sort(arr2);
            for (int i = 0; i < arr2.length; i++) {
                if(record2.contains(arr2[i]))
                    list.add(arr2[i]);
            }
        }else
        {
            for (int i = 0; i < arr2.length; i++) {
//            record.put(arr1[i],arr1[i]);
                record2.add(arr2[i]);
            }
            Arrays.sort(arr1);
            for (int i = 0; i < arr1.length; i++) {
                if(record2.contains(arr1[i]))
                    list.add(arr1[i]);
            }
        }

        return list;
    }
    public int find(int[] arr, int l,int r, int target){
        if( l > r )
            return -1;
        int mid = l + (r - l)/2;
//            int mid = (l + r) / 2;
        if( arr[mid] == target )
            return mid;
        else if( arr[mid] > target)
            return find(arr, l, mid-1, target);
        else
            return find(arr, mid+1, r, target);
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 2, 1};
        int arr2[] = {2,2,1,2,3};
        List<Integer> list = InsertionOfTwoArrays.insertionOfTwoArrays(arr1, arr2);
        System.out.println(list);
    }

}
