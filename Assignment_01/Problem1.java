package Assignment_01;

// Problem Statement: 

// Find out if a Tree is Balanced. 
// ( Tree is balanced if for every node difference between height of left and right is <=1)
// https://leetcode.com/problems/balanced-binary-tree/

public class Problem1 {
    // Checks if tree is balanced or not.
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return (Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left)
                && isBalanced(root.right));
    }

    // Finds the height of the tree.
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return (1 + Math.max(left, right));
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();

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

        boolean isBalanced = problem1.isBalanced(root);
        if (isBalanced) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }
    }
}