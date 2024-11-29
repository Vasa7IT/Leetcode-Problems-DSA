# [15. 3Sum](https://leetcode.com/problems/3sum/description/)

## Problem Description

```
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
```

## Key Points for the `threeSum` Program

1. **Sorting for Efficient Pair Search**:
   - The array is sorted initially using `Arrays.sort(nums)` to enable the two-pointer approach.

2. **Outer Loop for First Element**:
   - Use a loop to fix the first number of the triplet.
   - Skip duplicate values for `nums[i]` using the condition:
     ```java
     if (i > 0 && nums[i] == nums[i - 1]) {
         continue;
     }
     ```

3. **Two-Pointer Technique**:
   - Initialize two pointers for each `i`:
     ```java
     int l = i + 1, r = nums.length - 1;
     ```
   - Adjust the pointers based on the sum:
     - If `sum == 0`, a valid triplet is found:
       ```java
       List<Integer> triplets = new ArrayList<>();
       triplets.add(nums[i]);
       triplets.add(nums[l]);
       triplets.add(nums[r]);
       lstOfLst.add(triplets);
       ```
     - Move pointers to avoid duplicates:
       ```java
       while (l < r && nums[l] == nums[l + 1]) {
           l++;
       }
       while (l < r && nums[r] == nums[r - 1]) {
           r--;
       }
       ```
     - If `sum > 0`, decrement `r` to reduce the sum:
       ```java
       r--;
       ```
     - If `sum < 0`, increment `l` to increase the sum:
       ```java
       l++;
       ```

4. **Avoid Duplicates in Triplets**:
   - Ensure unique triplets by skipping duplicate values for `nums[l]` and `nums[r]`.

5. **Edge Cases**:
   - Handle cases where the array length is less than 3 or no triplets exist by returning an empty list.

## Java Code

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lstOfLst = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1,r=nums.length-1;
        while(l<r){
            int sum = nums[i]+nums[l]+nums[r];
            if(sum == 0){
                List<Integer> triplets = new ArrayList<>();
                triplets.add(nums[i]);
                triplets.add(nums[l]);
                triplets.add(nums[r]);
                lstOfLst.add(triplets);
                while(l<r && nums[r]==nums[r-1]){
                    r--;
                }
                while(l<r && nums[l]==nums[l+1]){
                    l++;
                }
            l++;
            r--;
            }
            else if(sum >0){
                r--;
            }
            else{
                l++;
            }
           
            }
        }
        return lstOfLst;
    }
}
```

**Time Complexity**:
   - Sorting the array: **O(n log n)**.
   - Iterating and using the two-pointer technique: **O(n²)**.
   - Overall complexity: **O(n²)**.
