package com.leetcode.oj;

public class Test {

	/**
	 * @param args
	 */
	public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
        int org = x;
        long resultRes = 0;
        while(x!=0){
            int temp = x%10;
            x/=10;
            resultRes = resultRes*10 + temp;
        }
        System.out.println(resultRes);
        System.out.println(org);
        return org == resultRes;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(Integer.MAX_VALUE));
	}

}
