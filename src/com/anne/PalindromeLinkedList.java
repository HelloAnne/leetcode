package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.anne.CommonUtil.booleanToString;
import static com.anne.CommonUtil.stringToListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newTail = slow;
        ListNode newHead = reverse(null, newTail);
        while (newHead!=null && head!= null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;

    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next=pre;
        return cur;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new PalindromeLinkedList().isPalindrome(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
