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
    public int kthSmallest(TreeNode root, int k) {
        int res = -1;
        int count = 0;
        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){
                count++;
                if(count==k) res = curr.val;
                curr = curr.right;
            }else{
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred = pred.right;
                }

                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    pred.right=null;
                    count++;
                    if(count==k) res = curr.val;
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}