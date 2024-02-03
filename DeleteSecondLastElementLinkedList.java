class DeleteSecondLastElementLinkedList{
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void main(String[] args) {
        //head = [1,3,4,7,1,2,6]
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7,
            new ListNode(1, new ListNode(2, new ListNode(6, null)))))));
        head = deleteSecondLast(head);
        while (head.next != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print(head.val);
    }

    public static class ListNode {
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

    public static int countListOfHeads(ListNode head){
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++; //returns length of the list
        }
        return count;
    }

    public static ListNode deleteSecondLast(ListNode head) {
        //head = [1,3,4,7,1,2,6]
        ListNode original = head;
        int count = countListOfHeads(head);
        if(count == 1){
            return head;
        }
        int secondLast = count - 2;
        // Delete the secondLast node
        int j = 1;
        while (j < secondLast) {
            head = head.next;
            j++;
        }
        // Delete the middle node
        head.next = head.next.next;
        return original;
    }
}
