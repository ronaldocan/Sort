package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
public class ThreeSum {
    public static List<List<Integer>> ret = new ArrayList<List<Integer>>();

    public static List<List<Integer>> threeSum(int[] num) {
        if(num == null || num.length < 3) return ret;
        Arrays.sort(num);
        int len = num.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            find(num, i+1, len-1, num[i]);
        }
        return ret;
    }
    public static void find(int[] num,int begin,int end,int target){
        int l = begin, r = end;
        while(l < r){
            if(num[l] + num[r] + target == 0){
                List<Integer> ans = new ArrayList<>();
                ans.add(num[l]);
                ans.add(num[r]);
                ans.add(target);
                ret.add(ans);
                while(l < r && num[l] == num[l+1]) l++;
                while(l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            }
            else if (num[l] + num[r] + target < 0)
                l++;
            else
                r--;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head != null && head.val == val){
            ListNode delNode = head;
            head = delNode.next;
        }
        if(head == null)
            return head;
        ListNode cur = head;
        while(cur.next != null){
            if(cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;

            }
            else
                cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] num = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = ThreeSum.threeSum(num);
        System.out.println(list);
    }
}
