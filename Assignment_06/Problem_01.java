package Assignment_06;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem_01 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(s);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (isSameTree(node, t)) {
                return true;
            }
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        } else {
            return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
        }
    }
}
