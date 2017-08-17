package sort;

import java.util.Random;

/**
 * Created by Administrator on 2017/5/26.
 */
public class QuickSort {

    // 我们的算法类不允许产生任何实例
    private QuickSort(){}

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        Random random = new Random();
        int x = random.nextInt(r-l)+l;
        swap(arr,l,x);
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }
    private static void sort3(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            insertionSort(arr, l, r);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );

        Comparable v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l+1;    // arr[lt+1...i) == v
        while( i < gt ){
            if( arr[i].compareTo(v) < 0 ){
                swap( arr, i, lt+1);
                i ++;
                lt ++;
            }
            else if( arr[i].compareTo(v) > 0 ){
                swap( arr, i, gt-1);
                gt --;
            }
            else{ // arr[i] == v
                i ++;
            }
        }

        swap( arr, l, lt );

        sort3(arr, l, lt-1);
        sort3(arr, gt, r);
    }
    private static int partition2(Comparable[] arr, int l, int r) {
        Random random = new Random();
        int x = random.nextInt(r - l) + l;
        swap(arr,l,x);
        Comparable v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while(i <= r && arr[i].compareTo(v) < 0) i ++;
            while (j >= l + 1 && arr[j].compareTo(v) > 0) j--;
            if (i > j) {
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
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
    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        if (r - l <= 15) {
            insertionSort(arr,l,r);
            return;
        }


        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort3(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        long time = System.currentTimeMillis();

        sort(arr);
        long time2 = System.currentTimeMillis();

        System.out.println(time/1000);
        System.out.println(time2/1000);
        System.out.println(time2 - time);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}