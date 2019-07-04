package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static com.anne.CommonUtil.listNodeToString;
import static com.anne.CommonUtil.stringToListNode;

public class InsertionSortList {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newListDummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while (cur != null) {
            ListNode tempNode = newListDummyHead;
            while (tempNode.next != null && tempNode.next.val < cur.val) {
                tempNode = tempNode.next;
            }
            ListNode tempNext =tempNode.next;
            ListNode curNext = cur.next;
            tempNode.next = cur;
            cur.next = tempNext;
            cur = curNext;
        }
        return newListDummyHead.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new InsertionSortList().solution(head);

            String out = listNodeToString(ret);

            System.out.print(out);

        }

    }
}
