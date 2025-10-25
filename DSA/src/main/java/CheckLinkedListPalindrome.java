import static java.util.Collections.reverse;

class ListNode{
    int value;
    ListNode next;

    ListNode(int value){
        this.value=value;
    }
}

public class CheckLinkedListPalindrome {

    public static void main(String[] args) {
       ListNode head=new ListNode(1);
       head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(1);

        System.out.println("Is palindrome - " +isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode slow=head, fast=head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode first=head;
        ListNode second=reverse(slow);

        while (second!=slow){
            if(first.value!=second.value)
                return false;
            first=first.next;
            second=second.next;
        }


        return true;
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev=null;

        while (node!=null){
            ListNode newNode=node.next;
            node.next=prev;
            prev=node;
            node=newNode;
        }
return prev;
    }
}
