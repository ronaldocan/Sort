package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2017/5/26.
 */
public class MergeSort {
    private MergeSort() {
    }
    private static void merge(Comparable[] arr, int l, int mid, int r){
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){
            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }
    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            insertionSort(arr,l,r);
            return;
        }
        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }
    private static void  sort(Comparable[] arr) {
        int n  = arr.length;
        sort(arr,0,n - 1);
    }
    private static void sortBU(Comparable[] arr){
        for(int size = 1;size <= arr.length;size += size ) {
            for(int i = 0;i + size < arr.length;i += size + size) {
                merge(arr,i,i + size - 1,Math.min(i + size + size - 1,arr.length-1));
            }
        }
    }
    public static void insertionSort(Comparable[] arr, int size) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;

        }
    }
    public static void insertionSort(Comparable[] arr, int l, int r){

        assert l >= 0 && l <= r && r < arr.length;

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        long time1 = System.currentTimeMillis();
        sortBU(arr);
        long time2 = System.currentTimeMillis();
        long time3 = System.currentTimeMillis();
        sort(arr);
        long time4 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println(time4 - time3);
        return;
    }
}
