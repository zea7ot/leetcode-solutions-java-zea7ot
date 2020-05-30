/**
 * https://leetcode.com/problems/couples-holding-hands/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/couples-holding-hands/discuss/113362/JavaC%2B%2B-O(N)-solution-using-cyclic-swapping
 * 
 * Similar Problems:
 *  2   0268    https://leetcode.com/problems/first-missing-positive/
 *  4   0041    https://leetcode.com/problems/first-missing-positive/
 */
package com.polyg7ot.lc.lvl4.lc0765;

public class SolutionApproach0CyclicSwapping {
    public int minSwapsCouples(int[] row) {
        final int N = row.length;
        
        int[] partners = new int[N];
        int[] pos = new int[N];
        
        for(int i = 0; i < N; i++){
            partners[i] = (i % 2 == 0) ? i + 1 : i - 1;
            pos[row[i]] = i;
        }
        
        int ans = 0;
        for(int i = 0; i < N; i += 2){
            int j = i + 1;
            if(row[j] != partners[row[i]]){
                j = pos[partners[row[i]]];
                swap(row, i + 1, j);
                swap(row, row[i + 1], row[j]);
                
                ans++;
            }
        }
        
        return ans;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}