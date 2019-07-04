package com.anne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReverseList {
    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverseList(head, head.next);
    }

    private ListNode reverseList(ListNode preNode, ListNode curNode) {
        if (curNode == null) {
            return preNode;
        }
        ListNode tempNode = curNode.next;
        curNode.next = preNode;
        return reverseList(curNode, tempNode);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = CommonUtil.stringToListNode(line);

            ListNode ret = new ReverseList().solution(head);

            String out = CommonUtil.listNodeToString(ret);

            System.out.print(out);
        }
    }
}
