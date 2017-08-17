package sort;

/**
 * Created by Administrator on 2017/6/7.
 */
public class InsertSort {
    private InsertSort() {

    }
    public static void sort(Comparable[] arr){

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    public static void sort(Comparable[] arr, int l, int r) {
        for(int i = l + 1;i < r;i++) {
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                swap(arr,j,j-1);
            arr[j] = e;
        }
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
