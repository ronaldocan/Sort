package sort;

import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/25.
 */
public class  SelectedSort<T> {
    public void selectSort(int[] arr, int size) {
        for(int i = 0 ;i < size;i ++) {
            int minIndex = i;
            for(int j = i + 1;j < size;j ++) {
                if (arr[minIndex] > arr[j]) {
                    int temp = arr[minIndex];
                    arr[minIndex] = arr[j];
                    arr[j] = temp;
                }
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

    public void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {
            for(int i = gap;i < arr.length;i++) {
                int j = 0;
                int temp = arr[i];
                for (j = i - gap; j >= 0 && temp < arr[j]; j = j - gap) {
                                        arr[j + gap] = arr[j];
                                     }
                arr[j + gap] = temp;
            }
            gap = gap / 3;
        }
    }
    public static void main(String[] args) {
        int n = 10000;
        int[] array = new int[n];
        Random r=new Random();
        for (int i = 0; i < n; i++) {
            int temp = r.nextInt(n)+1;
            array[i] = temp;
        }
        SelectedSort s = new SelectedSort();
        long time = System.currentTimeMillis();
        s.shellSort(array);

        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);

    }
}
