package com.leetcode.oj;

public class IntegrationListNode {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0,countB = 0;
        //ListNode result = null;
        ListNode current = headA;
        while(current!=null){
            countA++;
            current = current.next;
        }
        current = headB;
        while(current!=null){
            countB++;
            current = current.next;
        }
        int k = 0;
        if(countA<countB){
            current = headA;
            headA = headB;
            headB = current;
            k = countB-countA;
        }else{
        	k = countA-countB;
        }
        for(int i=0;i<k;i++){
            headA = headA.next;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
	}
	public static void main(String[] args) {
		ListNode headA = null;
		ListNode headB = new ListNode(2);
		getIntersectionNode(headA,headB);
	}
}
