package com.leetcode.oj;

public class Atoi {
	public static int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        long result = 0;
        if (len > 0) {
            char firstChar = str.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    for(int i=1;i<=len-1;i++){
                        if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                            result = result*10 + str.charAt(i)-48;
                            long temp = -result;
                            if(temp<Integer.MIN_VALUE){
                            	result = Integer.MIN_VALUE;
                            	break;
                            }
                        }else{
                            //return 0;
                            break;
                        }
                    }
                } else if (firstChar == '+'){
                    for(int i=1;i<=len-1;i++){
                        if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                            result = result*10 + str.charAt(i)-48;
                            if(result>Integer.MAX_VALUE){
                            	result= Integer.MAX_VALUE;
                            	break;
                            }
                        }else{
                            //return 0;
                            break;
                        }
                    }
                }else{
                    return 0;
                }
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
            }else{
            	for(int i=0;i<=len-1;i++){
                    if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                        result = result*10 + str.charAt(i)-48;
                        if(result>Integer.MAX_VALUE){
                        	result= Integer.MAX_VALUE;
                        	break;
                        }
                    }else{
                        //return 0;
                        break;
                    }
                }
            }           
        }else{
            return 0;
        }
        return (int)result;
    }
	public static void main(String[] args) {
		String input = "9223372036854775809";
		//Long.parseLong(input);
		int value = myAtoi(input);
		System.out.println("max="+Integer.MAX_VALUE);
		System.out.println("min="+Integer.MIN_VALUE);
		System.out.println(value);
		input.trim();

	}

}
