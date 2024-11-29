# [18. 4Sum](https://leetcode.com/problems/4sum/description/)

## Problem Description

```
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
```

## Key Points for the `fourSum` Program

1. **Sorting for Efficient Pair Search**:
   - The array is sorted using `Arrays.sort(nums)` to facilitate the use of nested loops and two-pointer approach.

2. **Nested Loops for First Two Elements**:
   - Use two nested loops to fix the first (`nums[i]`) and second (`nums[j]`) numbers of the quadruplet.
   - Skip duplicate values for `nums[i]` and `nums[j]` to avoid redundant quadruplets:
     ```java
     if (i > 0 && nums[i] == nums[i - 1])
         continue;
     if (j > i + 1 && nums[j] == nums[j - 1])
         continue;
     ```

3. **Two-Pointer Technique for Remaining Elements**:
   - For each pair `(i, j)`, initialize two pointers:
     ```java
     int l = j + 1, r = n - 1;
     ```
   - Use the two-pointer approach to find pairs `(nums[l], nums[r])` that satisfy the condition:
     ```java
     long sum = nums[i] + nums[j] + nums[l] + nums[r];
     ```

4. **Checking the Sum**:
   - If the `sum == target`, add the quadruplet to the result list:
     ```java
     lstOfLst.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
     ```
   - Skip duplicate values for `nums[l]` and `nums[r]`:
     ```java
     while (l < r && nums[l] == nums[l + 1])
         l++;
     while (l < r && nums[r] == nums[r - 1])
         r--;
     ```
   - Increment `l` and decrement `r` after processing:
     ```java
     l++;
     r--;
     ```
   - If `sum < target`, increment `l` to increase the sum:
     ```java
     l++;
     ```
   - If `sum > target`, decrement `r` to reduce the sum:
     ```java
     r--;
     ```

5. **Avoid Duplicates in Quadruplets**:
   - Ensure unique quadruplets by skipping duplicate values for both outer and inner loops, as well as for the two pointers.

6. **Edge Cases**:
   - Handle cases where the array length is less than 4 or when no quadruplets match the target by returning an empty list.

7. **Use of `long` for Overflow**:
   - Use `long` for `sum` to prevent integer overflow when summing four integers.

## Java Code

```java

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lstOfLst = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum = nums[i] + nums[j];
                    sum+= nums[l] + nums[r];
                    if (sum == target) {
                        lstOfLst.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        while (l < r && nums[r] == nums[r - 1])
                            r--;
                        l++;
                        r--;
                    } else if (sum < target)
                        l++;
                    else
                        r--;
                }
            }
        }
        return lstOfLst;
    }
}
```

**Time Complexity**:
   - Sorting the array: **O(n log n)**.
   - Nested loops with the two-pointer technique: **O(n³)**.
   - Overall complexity: **O(n³)**.
