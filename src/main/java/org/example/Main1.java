package org.example;

import java.util.Arrays;

public class Main1 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        if (nums[nums.length-1] == nums[0]) return 2;

        int left, right;
        left = right = 2;

        while (left != nums.length && (nums[left] != nums[left-1] || nums[left-1] != nums[left-2])) {
            left++;
            right++;
        }

        while (right != nums.length) {
            while (right != nums.length && nums[right-1] == nums[right]) right++;
            if (right == nums.length) break;

            if (right+1 != nums.length && nums[right+1] == nums[right]) {
                nums[left] = nums[right];
                left++;
                right++;
                nums[left] = nums[right];
                left++;
                right++;
            } else {
                nums[left] = nums[right];
                left++;
                right++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums) + " " + Arrays.toString(nums));
        System.out.println();

        int[] nums1 = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums1) + " " + Arrays.toString(nums1));
        System.out.println();

        int[] nums2 = {1,1,1};
        System.out.println(removeDuplicates(nums2) + " " + Arrays.toString(nums2));
        System.out.println();

        int[] nums3 = {1,1,2,2};
        System.out.println(removeDuplicates(nums3) + " " + Arrays.toString(nums3));
        System.out.println();

        int[] nums4 = {1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums4) + " " + Arrays.toString(nums4));
        System.out.println();

        int[] nums5 = {1,1,2,2,2};
        System.out.println(removeDuplicates(nums5) + " " + Arrays.toString(nums5));
        System.out.println();
    }
}