package com.leetcode.oj;



public class LsubString {
	public static  int lengthOfLongestSubstring(String s) {
		int []loc = new int[256];
	       int max = 1;
	       int start = 0;
	       if("".equals(s)){
	           return 0;
	       }
	       for(int i=1;i<s.length();i++){
	           if(loc[s.charAt(i)]>start){
	               start = loc[s.charAt(i)]+1;
	           }
	           if(max<i-start+1){
	               max = i-start+1;
	           }
	           loc[s.charAt(i)] = i;
	       }
	       return max;
    }
	public static void main(String[] args) {
		String str = "abcabcbb";
		int value = lengthOfLongestSubstring(str);
		System.out.println(value);
		int a = 123;
		
	}
}
