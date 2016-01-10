package com.leetcode.oj;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
public class PreAndInCreateTree {
	/*
	public static TreeNode createTree(int preS,int inS,int length,int[]preorder,int[]inorder){
		if (preorder == null || preorder.length ==0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preS]);
        if(length ==1 && preorder[preS] == inorder[inS])
            return node;
        int i = 0;
        //找到分界点
        while (i <=length-1 && preorder[preS]!= inorder[inS+i])
            i++;
        //左半边长度
        int leftLen = i;
        //右半边长度
        int rightLen = length-leftLen-1;
        if(leftLen>=1){
        	node.left=createTree(preS+1,inS,leftLen,preorder,inorder);
        }
        if(rightLen>=1){
            node.right=createTree(preS+leftLen+1,inS+leftLen+1,rightLen,preorder,inorder);
        }
        return node;
    }*/
	public static TreeNode createTree(int inS,int postE,int length,int[]inorder,int[]postorder){
		if (inorder == null || inorder.length ==0){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postE]);
        if(length ==1 && inorder[inS] == postorder[postE])
            return node;
        int i = 0;
        //找到分界点
        while (i <=length-1 && postorder[postE]!= inorder[inS+i])
            i++;
        //左半边长度
        int leftLen = i;
        //右半边长度
        int rightLen = length-leftLen-1;
        if(leftLen>=1){
        	node.left=createTree(inS,postE-rightLen-1,leftLen,inorder,postorder);
        }
        if(rightLen>=1){
            node.right=createTree(inS+leftLen+1,postE-1,rightLen,inorder,postorder);
        }
        return node;
	}
	public static int getNodeNums(TreeNode root){
		if(root==null){
			return 0;
		}
		return getNodeNums(root.left)+getNodeNums(root.right)+1;
	}
	public static int getLeafNums(TreeNode root){
		if(root ==null){
			return 0;
		}
		if(root.left==null && root.right==null){
			return 1;
		}
		return getLeafNums(root.left)+getLeafNums(root.right);
	}	
	public static int getKLeaveNodeNums(TreeNode root,int k){
		if(root == null || k==0){
			return 0;
		}
		if(k==1){
			return 1;
		}
		return getKLeaveNodeNums(root.left,k-1)+getKLeaveNodeNums(root.right,k-1);
	}	
	public static int getDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		return (leftDepth>rightDepth?leftDepth:rightDepth) + 1;
	}
	
	public static void main(String[] args) {
		//int[] preOrder={1,2,4,7,3,5,6,8};
		int[] inOrder={4,7,2,1,5,3,8,6};
		int[] postOrder={7,4,2,5,8,6,3,1};
		TreeNode root= createTree(0,postOrder.length-1,inOrder.length,inOrder,postOrder);
		
		
		//二叉树的前序非递归遍历
		/*
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p!=null||!stack.isEmpty()){
			if(p!=null){
				System.out.print(p.val+" ");
				stack.push(p);
				p = p.left;
			}
			else{
				p = stack.pop();
				p = p.right;
			}
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode last = root;
		stack.push(p);
		while(!stack.isEmpty()){
			p = stack.peek();
			if((p.left==null&&p.right==null)||(p.left==last&&p.right==null)||p.right==last){
				System.out.print(p.val+" ");
				last = p;
				stack.pop();
			}
			else{
				if(p.right!=null){
                    stack.push(p.right);
                }
                if(p.left!=null){
                    stack.push(p.left);
                }   
			}
		}*/
	}
}
