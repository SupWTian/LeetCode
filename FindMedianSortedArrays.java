package com.leetcode.oj;
public class FindMedianSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int [] nums = new int[m+n];
		int flag1 = 0,flag2 = 0,location = 0;
		while(flag1<m && flag2<n){
			if(nums1[flag1]<=nums2[flag2]){
				nums[location]=nums1[flag1];
				location++;
				flag1++;
			}
			else{
				nums[location]=nums2[flag2];
				location++;
				flag2++;
			}
		}
		while(flag1<m){
			nums[location]=nums1[flag1];
			location++;
			flag1++;
		}
		while(flag2<n){
			nums[location]=nums2[flag2];
			location++;
			flag2++;
		}
		for(int item :nums){
			System.out.println(item);
		}
		if(((m+n) & 0x01)==0){
			return (nums[(m+n)/2-1] + nums[(m+n)/2])/2.0;
		}else{
			return nums[(m+n)/2];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1 = {};
		int []nusm2 = {2,3};
		double result = findMedianSortedArrays(nums1,nusm2);
		System.out.println(result);
	}
}
