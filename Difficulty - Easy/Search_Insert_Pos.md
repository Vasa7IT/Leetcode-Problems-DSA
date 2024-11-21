# [35.Search Insert Position](https://leetcode.com/problems/search-insert-position/)

## Problem Description

```
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
```

## Key Points

- Use **Binary Search** to achieve a runtime complexity of **O(log n)**.
- Maintain two pointers, `left` and `right`, to represent the current search range.
- Calculate the mid-point and compare it with the `target`:
  - If `nums[mid]` equals the `target`, return `mid`.
  - If `nums[mid]` is less than the `target`, move the `left` pointer to `mid + 1`.
  - If `nums[mid]` is greater than the `target`, move the `right` pointer to `mid - 1`.
- If the target is not found, return the `left` pointer as the insertion position.

## Java Code

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

```

**_Complexity Anlysis_**

- Time Complexity: O(log n)
  
Binary Search reduces the search range by half with each iteration.
- Space Complexity: O(1)
  
No additional data structures are used, making the space usage constant.
