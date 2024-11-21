# [1.two-sum](https://leetcode.com/problems/two-sum/description/)

## Problem Description

```
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
```

## Key Points

- Use a hash map to store numbers as keys and their indices as values for fast lookup.
- Instead of iterating through the array multiple times, calculate the difference (target - nums[i]) for each element and check if it's already in the map.
- This approach trades space complexity for improved time complexity, reducing the time complexity from O(N²) (nested loops) to O(N).

## Java Code

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
    //     int[] comb =new int[2];
    //     int n = nums.length;
    //     for (int i =0;i<n-1;i++){
    //         for (int j=n-1;j>i;j--){
    //             if(nums[i]+nums[j] == target){
    //             comb[0] = i;
    //              comb[1] = j;
    //              return comb;
    //             }
    //         }
    //     }
    // return comb;

    Map<Integer,Integer> map = new HashMap<>();
    for (int i=0;i<nums.length;i++){
        if(map.containsKey(target-nums[i])){
            return new int[]{map.get(target-nums[i]),i};
        }
        map.put(nums[i],i);
    }
    return new int[]{};
    }
}

```
**_Complexity Anlysis_**

- _Time Complexity_: O(N)
- _Space Complexity_：O(N)
