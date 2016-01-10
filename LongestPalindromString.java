package com.leetcode.oj;

public class LongestPalindromString {

	public static String longestPalindrome(String s) {
        String longest = "";
        for(int i=0;i<s.length();i++){
            String p1 = expandAroundCenter(s,i,i);
            String p2 = expandAroundCenter(s,i,i+1);
            longest = (p1.length()>p2.length()?p1:p2).length()>longest.length()?((p1.length()>p2.length()?p1:p2)):longest;
        }
        return longest;
    }
    public static String expandAroundCenter(String s,int left,int right){
        while(left>=0&&right<=s.length()-1&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
	public static void main(String[] args) {
		String str = "abcba";
		String result = longestPalindrome(str);
		System.out.println(result);
		System.out.println(str.substring(0,1));
	}
}
