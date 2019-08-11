package com.demo.linkedlist;


import java.util.List;

public class AddTwoLinkedList {


     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         extractNumbers(createListNode());
        return null;
     }

    private int extractNumbers(ListNode l1) {
         StringBuffer var = new StringBuffer() ;
         while(l1!=null){
             var.append(l1.val);
             l1=l1.next;
          }
         return Integer.parseInt(var.toString());
    }


    private ListNode createListNode(){
         ListNode list = new ListNode(2);
         list.next = new ListNode(5).next=new ListNode(3);
        return list;
    }

    public static void main(String[] args) {
        AddTwoLinkedList addList = new AddTwoLinkedList();
        System.out.println(addList.extractNumbers(addList.createListNode()));
    }

}
