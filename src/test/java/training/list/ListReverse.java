package training.list;

public class ListReverse {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(
                1, new ListNode(
                2, new ListNode(
                3, new ListNode(

        ))));

        reverseList(listNode);
        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)            return head;
                ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
