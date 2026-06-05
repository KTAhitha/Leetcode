/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode result=lists[0];
        for(int i=1;i<lists.length;i++){
            result=merge(result,lists[i]);
        }
        return result;
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        ListNode c1=l1,c2=l2;
        while(c1!=null && c2!=null){
            if(c1.val>c2.val){
                temp.next=c2;
                c2=c2.next;
            }else{
                temp.next=c1;
                c1=c1.next;
            }
            temp=temp.next;
        }
        if(c1!=null) temp.next=c1;
        if(c2!=null) temp.next=c2;
        return dummy.next;
    }
}