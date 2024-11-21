class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left =0 ,right = n-1;
        //Binary Search -(log n)
        while(left<=right){
            int mid =left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else if(nums[mid]>target){
                right = mid-1;
            }
        }
            return left;
    }
}
