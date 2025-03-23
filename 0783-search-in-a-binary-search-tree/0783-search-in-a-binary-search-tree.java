class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (root.val > val) {
            return searchBST(root.left, val);  // Search in left subtree
        } else {
            return searchBST(root.right, val); // Search in right subtree
        }
    }
}
