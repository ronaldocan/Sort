package sort;

/**
 * Created by Administrator on 2017/6/7.
 */
public class QuickSortTwoWays {
    private static void sort(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable e = arr[l];
        int lt = l + 1;
        int gt = r;
        while (true) {
            while(lt <= r && arr[lt].compareTo(e)<0)
                lt ++;
            while(gt >= 1 && arr[gt].compareTo(e)>0)
                gt --;
            if(lt > gt)
                break;
            swap( arr, l, gt );
            l ++;
            gt --;
        }

        swap(arr, l, gt);

        return gt;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort.QuickSortTwoWays", arr);

        return;
    }
}
