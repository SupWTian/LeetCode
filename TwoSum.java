package com.leetcode.oj;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 
 * 
 * 此方法行不通，排序后丢失了原数组的索引序号，返回的是排序后的序号
 *  
 * */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
	        quickSort(nums,0,nums.length-1);
	        int []result = new int[2];
	        int length = nums.length;
	        int small = nums[0];
	        int big = nums[length-1];
	        int i=0,j=length-1;
	        while(i<j){
	            int sum = small+big;
	            if(sum<target){
	                i++;
	                small = nums[i];
	            }else if(sum>target){
	                j--;
	                big = nums[j];
	            }else{
	                result[0]=i+1;
	                result[1]=j+1;
	                break;
	            }
	        }
	        return result;
	    }
    public void quickSort(int []input,int low,int high){
        if(low<high){
            int middle = partion(input,low,high);
            quickSort(input,low,middle-1);
            quickSort(input,middle+1,high);
        }
    }
    public int partion(int []input,int low,int high){
        int pivotkey = input[low];
        while(low<high){
            while(low<high&&input[high]>=pivotkey){
                high--;
            }
            if(low<high){
                input[low]=input[high];
                low++;
            }
            while(low<high&&input[low]<=pivotkey){
                low++;
            }
            if(low<high){
                input[high]=input[low];
                high--;
            }
        }
        input[low]=pivotkey;
        return low;
    }
	public static void main(String[] args) {
		int []nums = {1,2,4,99,77,66,55,33,78,100,102};
		int target = 166;
		int[] output = new TwoSum().twoSum(nums, target);
		for(int oneNum:output){
			System.out.println(oneNum);
		}

	}
}
