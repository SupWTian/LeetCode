package com.leetcode.oj;

public class SwapPairs {
	public static ListNode swapPairs(ListNode head) {
	    if(head==null || head.next==null) return head;

	    ListNode newhead = new ListNode(0);
	    ListNode p = newhead;

	    while(head!=null && head.next!=null) {
	        ListNode tmp = head.next;
	        p.next = tmp.next; // temporarily unlink head and head.next

	        tmp.next = head;
	        head.next = p.next; // relink the two nodes
	        p.next = tmp;

	        p = head;
	        head = head.next;
	    }
	    return newhead.next;
	}
	/*
	public ListNode swapPairs(ListNode head) {
	    if(head==null || head.next==null) return head;

	    ListNode tmp = head.next;
	    tmp.next = swapPairs(tmp.next);

	    head.next = tmp.next;
	    tmp.next = head;

	    return tmp;
	}
	*/
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = swapPairs(head);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
