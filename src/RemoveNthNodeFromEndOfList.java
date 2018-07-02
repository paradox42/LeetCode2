import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public static void main(String args[]){
        ListNode list = construct(new int[]{1,2,3,4,5});

        Solution s = new Solution();
        list = s.removeNthFromEnd(list,5);

        ListNode curr = list;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static ListNode construct(int[] list){
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        int i = 0;
        while(i != list.length-1){
            curr.val = list[i];
            curr.next = new ListNode(0);
            curr = curr.next;
            i++;
        }
        curr.val = list[list.length-1];
        return head;
    }

    public static class Solution{
        int count = 0;
        int len = 1;
        public ListNode removeNthFromEnd(ListNode head, int n){
            if(head.next != null){
                len ++;
                removeNthFromEnd(head.next, n);
                count ++;
                if(count == n){
                    head.next = head.next.next;
                }
            }
            if(len == n){
                head = head.next;
            }
            return head;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
