import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}

public class AddTwoNum {
    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] arr) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int value : arr) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummyHead.next;
    }

    // Helper method to display a linked list
    public static void displayLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read first linked list
        System.out.println("Enter the number of elements in the first list:");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the elements for the first list:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }

        // Read second linked list
        System.out.println("Enter the number of elements in the second list:");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the elements for the second list:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }

        // Create linked lists and add numbers
        ListNode l1 = createLinkedList(arr1);
        ListNode l2 = createLinkedList(arr2);
        Solution2 sol = new Solution2();
        ListNode result = sol.addTwoNumbers(l1, l2);

        // Display the result
        System.out.println("Resultant Linked List:");
        displayLinkedList(result);

        scanner.close();
    }
}
