//https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/?envType=daily-question&envId=2025-01-25

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] arr = nums.clone();
        Arrays.sort(arr);

        // Map to store group numbers for each number
        HashMap<Integer, Integer> map = new HashMap<>();
        // Map to store groups and their elements
        HashMap<Integer, LinkedList<Integer>> groupMap = new HashMap<>();

        int groupNum = 0;
        map.put(arr[0], groupNum);
        groupMap.put(groupNum, new LinkedList<>());
        groupMap.get(groupNum).add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > limit) {
                groupNum++;
            }

            map.put(arr[i], groupNum);
            groupMap.putIfAbsent(groupNum, new LinkedList<>());
            groupMap.get(groupNum).add(arr[i]);
        }

        // Construct the result array
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int group = map.get(nums[i]);
            ans[i] = groupMap.get(group).getFirst();
            groupMap.get(group).removeFirst();
        }

        return ans;
    }
}
