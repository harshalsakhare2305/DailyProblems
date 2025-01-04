//https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1
class Solution {
    public int countTriplets(int[] arr, int target) {
        int c = 0;

        
        if (arr.length < 3) {
            return 0;
        }

       

       
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                   
                    if (arr[left] == arr[right]) {
                       
                        int count = right - left + 1;
                        c += (count * (count - 1)) / 2;
                        break; 
                    } else {
                        
                        int countLeft = 1;
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            countLeft++;
                            left++;
                        }

                       
                        int countRight = 1;
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            countRight++;
                            right--;
                        }

                        
                        c += countLeft * countRight;

                        
                        left++;
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return c;
    }
}
