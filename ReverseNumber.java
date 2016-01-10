package com.leetcode.oj;

public class ReverseNumber {

	public static int reverse(int x) {
		long result=0;
        if(x>0){
            String str = Integer.toString(x);
            result = Long.parseLong(reverseString(str));
        }else if(x<0){
            String str = Integer.toString(x).substring(1);
            result = Long.parseLong("-"+reverseString(str));
        }else{
        	result= 0;
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
        	return -1;
        }else{
        	return (int)result;
        }
    }
    public static String reverseString(String s){
        int i=0;
        int j=s.length()-1;
        char[]input =s.toCharArray();
        while(i<=j){
            char temp;
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<input.length;k++){
        	sb.append(input[k]);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		int str = 1534236469;
		System.out.println(reverse(str));
		String s= "124";
		Integer.parseInt(s);
	}

}
