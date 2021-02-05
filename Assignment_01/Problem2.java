package Assignment_01;
// Find Minimum depth of all the leaves in a tree. 

// https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class Problem2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return (1 + minDepth(root.right));
        }
        if (root.left != null && root.right == null) {
            return (1 + minDepth(root.left));
        }
        if (root.left != null && root.right != null) {
            return (1 + Math.min(minDepth(root.left), minDepth(root.right)));
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();

        // Create a test case tree
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child11 = new TreeNode(4);
        TreeNode child12 = new TreeNode(5);
        TreeNode child21 = new TreeNode(6);
        TreeNode child22 = new TreeNode(7);
        TreeNode child111 = new TreeNode(8);
        TreeNode child112 = new TreeNode(9);
        TreeNode child121 = new TreeNode(10);
        TreeNode child122 = new TreeNode(11);

        root.left = child1;
        root.right = child2;
        child1.left = child11;
        child1.right = child12;
        child2.left = child21;
        child2.right = child22;
        child11.left = child111;
        child11.right = child112;
        child12.left = child121;
        child12.right = child122;

        int minimumDepthOftheTree = problem2.minDepth(root);
        System.out.println("The minimum depth of the tree is: " + minimumDepthOftheTree);
    }
}
