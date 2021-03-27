Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false

Input: p = [1,2,1], q = [1,1,2]
Output: false
 
Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

// ----------- Code --------------
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;    // if both of them are null, then return true;  // 都为空的话，显然相同
        if (p == null || q == null) return false;  // if only one of them is null, then return false; // 一个为空，一个非空，显然不同
        if (p.val != q.val) return false; 		  // if the root node is not equal, then return false  // 两个都非空，但 val 不一样也不行
        // p 和 q 该比的都比完了    
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);  // else check the subtree (left and right)
    }
}