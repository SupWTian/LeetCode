package com.leetcode.oj;

public class RemoveDumpNums {

	public static int removeDuplicates(int[] nums) {
        int count = 0;
        int times = 1;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]==nums[i-1] && times>2){
        		times++;
        		continue;
        	}
        	else if(nums[i]==nums[i-1] && times<2){
        		times++;
        		count++;
        		nums[count] = nums[i];
        	}else if(nums[i]!=nums[i-1]){
        		times=1;
        		count++;
        		nums[count] = nums[i];
        	}
        }
        return count+1;        
    }
	public static void main(String[] args) {
		int[] nums ={1,1,1,3,3,3,3,3,3,3,4,4,4,5,5,5,6,7};
		int result = removeDuplicates(nums);
		System.out.println(result);
		for(int i=0;i<result;i++){
			System.out.print(nums[i]);
		}
	}
}
