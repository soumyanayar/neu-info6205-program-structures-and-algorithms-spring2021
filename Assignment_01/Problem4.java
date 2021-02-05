package Assignment_01;

import java.util.LinkedList;
import java.util.Queue;

// Problem Statement:
// Print sum of all the left leaves. 
// https://leetcode.com/problems/sum-of-left-leaves/

public class Problem4 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        boolean shouldAdd = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (shouldAdd) {
                    if (node.left == null && node.right == null) {
                        sum = sum + node.val;
                    }
                    shouldAdd = false;
                }
                if (node.left != null) {
                    queue.offer(null);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                shouldAdd = true;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();

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

        int sumOfLeftLeavesOfTheTree = problem4.sumOfLeftLeaves(root);
        System.out.println("The sum of the left leaves of the tree is: " + sumOfLeftLeavesOfTheTree);
    }
}
