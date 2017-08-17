package interview;

/**
 * Created by Administrator on 2017/6/19.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aL1 = reverseList(l1);
        ListNode aL2 = reverseList(l2);
        ListNode ano = new ListNode(0);
        while(aL1 != null && aL2 != null){
            ano.next = new ListNode(aL1.val + aL2.val);
        }
        return ano;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){
            return head;
        }
        ListNode prenode=new ListNode(0);
        prenode.next=head;
        ListNode p=prenode;
        for(int i=1;i<m;i++){
            p=p.next;
        }
        ListNode t=p;
        int[] temp=new int[n-m+1];
        for(int i=0;i<n-m+1;i++){
            t=t.next;
            temp[i]=t.val;
        }
        t=p;
        for(int i=0;i<n-m+1;i++){
            t=t.next;
            t.val=temp[n-m-i];
        }
        return head;
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode l = new ListNode(0);
        ListNode p = l;
        ListNode r = new ListNode(0);
        ListNode q = r;
        while(head != null){
            if(head.val < x){
                p.next = head;
                p = p.next;
            }
            else{
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = r.next;
        return l.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}