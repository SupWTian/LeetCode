package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        if(nums==null || nums.length<3){
			return result;
		}
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
        	if(i>0 && nums[i]==nums[i-1]){
        		continue;
        	}
        	int low = i+1;
        	int high = nums.length-1;
        	int traget = -nums[i];
        	while(high>low){
        	    if(nums[low]+nums[high]==traget){
        	        result.add(Arrays.asList(nums[i],nums[low],nums[high]));
        	        //用于去掉重复的组合（几个while语句）
        	        while(low<high && nums[high] == nums[high-1]){
        	            high--;
        	        } 
        	        high--;
        	        while(low<high && nums[low]==nums[low+1]){
        	            low++;
        	        }
        	        low++;
        	    }else if(nums[low]+nums[high]>traget){
        	        while(low<high && nums[high] == nums[high-1]) {
        	            high--;
        	        }
        	        high--;
        	    }else{
        	        while(low<high && nums[low]==nums[low+1]){
        	            low++;
        	        }
        	        low++;
        	    }
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
