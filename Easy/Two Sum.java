class Solution {
    public int[] twoSum(int[] nums, int target) {
    //Brute-force approach
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

    // Hash map approach
    Map<Integer,Integer> map = new HashMap<>();
    for (int i=0;i<nums.length;i++){
        //check the needed value in keys
        if(map.containsKey(target-nums[i])){
            return new int[]{map.get(target-nums[i]),i};
        }
        //store the arr val in key
        map.put(nums[i],i);
    }
    return new int[]{};
    }
}
