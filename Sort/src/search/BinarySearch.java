package search;

/**
 * Created by Administrator on 2017/6/4.
 */
public class BinarySearch<Item extends Comparable> {
    public int find(Item[] arr, int n, Item target) {
        int l = 0,r = n -1;
        while (l <= r) {
//            int mid = (l + r) / 2;
            int mid = l + (r - l)/2;
            if(arr[mid].compareTo(target) == 0)
                return mid;
            if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            }
        }
        return -1;
    }
    public int find(Item[] arr, int l,int r, Item target){
        if( l > r )
            return -1;
        int mid = l + (r - l)/2;
//            int mid = (l + r) / 2;
        if( arr[mid].compareTo(target) == 0 )
            return mid;
        else if( arr[mid].compareTo(target) > 0 )
            return find(arr, l, mid-1, target);
        else
            return find(arr, mid+1, r, target);
    }

    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);
        System.out.println();
    }
}
