package com.leetcode.oj;

import java.util.HashMap;

public class TwoSumAccept {

	public  int[] twoSum(int[] nums, int target) {        
        int []result = new int[2];  
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	if(map.containsKey(nums[i])){
        		int index = map.get(nums[i]);
        		result[0] = index+1;
        		result[1] = i+1;
        		break;
        	}
        	else{
        		//map中保存的是目前的节点和与其匹配符合条件的值
        		map.put(target-nums[i], i);
        	}
        }        
        return result;
    }
	public static void main(String[] args) {
		int []nums = {1,2,4,99,77,66,55,33,78,100,102};
		int target = 201;
		int []output=new TwoSumAccept().twoSum(nums,target);
		for(int veryNum:output){
			System.out.println(veryNum);
		}		
	}
}
