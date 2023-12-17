package org.example.twopointers;

public class RemoveNthNode {

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {

        LinkedListNode left , right = head;


        for(int i =0; i<n; i++) {

            right = head.next;
        }





        return null;
    }
}
