/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
package com.null7ptr.lc.lvl2.lc0111;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0 || right == 0){ 
            // to make sure that the height of leaf nodes is taken
            return Math.max(left, right) + 1;
        }else{
            return Math.min(left, right) + 1;
        }
    }
}
