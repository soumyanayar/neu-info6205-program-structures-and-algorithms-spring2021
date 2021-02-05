package Assignment_01;

// Print all the leaves of a tree.
// https://leetcode.com/problems/find-leaves-of-binary-tree/

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findHeight(root, result);
        return result;
    }

    public int findHeight(TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return -1;
        }
        int leftSubTreeHeight = findHeight(node.left, result);
        int rightSubTreeHeight = findHeight(node.right, result);

        int currentNodeHeight = 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);

        if (result.size() == currentNodeHeight) {
            result.add(new ArrayList<Integer>());
        }
        result.get(currentNodeHeight).add(node.val);
        return currentNodeHeight;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();

        // Create a test case tree
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child11 = new TreeNode(4);
        TreeNode child12 = new TreeNode(5);

        root.left = child1;
        root.right = child2;
        child1.left = child11;
        child1.right = child12;

        List<List<Integer>> leaves = problem3.findLeaves(root);
        System.out.print("[");
        for (List<Integer> leavesAtEachLevel : leaves) {
            System.out.print("[");
            for (int leafAtLevel : leavesAtEachLevel) {
                System.out.print(leafAtLevel + " ");
            }
            System.out.print("]");
        }
        System.out.println("]");
    }
}
