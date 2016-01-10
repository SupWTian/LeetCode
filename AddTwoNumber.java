package com.leetcode.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
        	return l2;
        }
        if(l2==null){
        	return l1;
        }
        ListNode result = null;
        ListNode current = null;
        while(l1!=null&&l2!=null){
        	int sum = l1.val+l2.val;
        	if(sum>=10){
        		if(result == null){
        			result = new ListNode(sum%10);
            		current = result;
            		if(l1.next!=null){
            			l1.next.val +=1;
            		}else{
            			l1.next = new ListNode(1);
            		}
            		
        		}else{
        			current.next = new ListNode(sum%10);
        			current = current.next;
        			if(l1.next!=null){
            			l1.next.val +=1;
            		}else{
            			l1.next = new ListNode(1);
            		}
        		}
        	}else{
        		if(result==null){
        			result = new ListNode(sum);
            		current = result;
        		}else{
        			current.next = new ListNode(sum);
        			current = current.next;
        		}        		
        	}
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1!=null){
        	int value = l1.val;
        	if(value>=10){
        		current.next = new ListNode(value%10);
        		current= current.next;
        		if(l1.next!=null){
        			l1.next.val = l1.next.val+1;
        		}else{
        			l1.next = new ListNode(value/10);
        		}
        		l1= l1.next;
        	}else{
        		current.next = l1;
        		current = current.next;
        		l1= l1.next;
        	}
        }
        while(l2!=null){
        	current.next = l2;
        	l2=l2.next;
        	current = current.next;
        }
        return result;
    }
	public static void main(String[] args) throws IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		ListNode l2 = new ListNode(9);
		/*
		while(cin.nextToken()!=cin.TT_EOF){
			int n = (int)cin.nval;
			cin.nextToken();
			int m = (int)cin.nval;
			ListNode current = l1;
			for(int i=0;i<n;i++){
				cin.nextToken();
				current.next = new ListNode((int)cin.nval); 
				current = current.next;
			}
			current = l2;
			for(int i=0;i<m;i++){
				cin.nextToken();
				current.next = new ListNode((int)cin.nval); 
				current = current.next;
			}
			break;
		}*/		
		ListNode ls=new AddTwoNumber().addTwoNumbers(l1,l2);
		while(ls!=null){
			System.out.print(ls.val+" ");
			ls=ls.next;
		}
	}
}
