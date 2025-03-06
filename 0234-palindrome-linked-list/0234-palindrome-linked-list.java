class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; // Single node is always a palindrome

        // Step 1: Find middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Compare first half with reversed second half
        ListNode first = head, second = prev;
        while (second != null) {  // Only need to compare second half
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }
}
