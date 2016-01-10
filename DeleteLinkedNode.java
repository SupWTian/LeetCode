package com.leetcode.oj;

class LinkedNode{
	int value;
	LinkedNode next;
	LinkedNode(int value){
		this.value = value;
	}
}
public class DeleteLinkedNode {
	public static void deleteNode (LinkedNode node){
		if(node.next==null){
			node = null;
		}else{
			node.value = node.next.value;
			node.next = node.next.next;
		}
	}
	public static void main(String[] args) {
		LinkedNode first = new LinkedNode(0);
		LinkedNode second = first.next = new LinkedNode(1);
		LinkedNode three = second.next = new LinkedNode(2);
		deleteNode(three);
		LinkedNode current = first;
		while(current!=null){
			System.out.println(current.value);
			current = current.next;
		}
	}

}
