package MidTerm;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem2 {
    TreeNode root;

    void printLeafNodes(TreeNode node) {
        if (node == null)
            return;

        printLeafNodes(node.right);

        if (node.left == null && node.right == null) {
            System.out.print(node.val + " ");
        }
        printLeafNodes(node.left);
    }

    void printLeftPerimeter(TreeNode node) {
        if (node == null)
            return;

        if (node.left != null) {
            printLeftPerimeter(node.left);
            System.out.print(node.val + " ");
        } else if (node.right != null) {

            printLeftPerimeter(node.right);
            System.out.print(node.val + " ");
        }
    }

    void printRightPerimeter(TreeNode treeNode) {
        if (treeNode == null)
            return;

        if (treeNode.right != null) {
            System.out.print(treeNode.val + " ");
            printRightPerimeter(treeNode.right);

        } else if (treeNode.left != null) {
            System.out.print(treeNode.val + " ");
            printRightPerimeter(treeNode.left);
        }
    }

    /*
     * Time Complexity: O(n) where n is the total number of nodes in the tree.
     * 
     * Space Complexity: O(h) needed for the program call stack where h is the
     * height of the tree
     */
    public void printPerimeter(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");

        printRightPerimeter(root.right);
        printLeafNodes(root.right);
        printLeafNodes(root.left);
        printLeftPerimeter(root.left);
    }

    public static void main(String args[]) {
        Problem2 tree1 = new Problem2();
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.left.left = new TreeNode(4);
        tree1.root.left.right = new TreeNode(5);
        tree1.root.left.left.left = new TreeNode(8);
        tree1.root.left.left.right = new TreeNode(9);
        tree1.root.left.right.left = new TreeNode(10);
        tree1.root.left.right.right = new TreeNode(11);
        tree1.root.right = new TreeNode(3);
        tree1.root.right.left = new TreeNode(6);
        tree1.root.right.right = new TreeNode(7);
        tree1.root.right.left.right = new TreeNode(13);
        tree1.root.right.right.left = new TreeNode(14);
        tree1.printPerimeter(tree1.root);
        System.out.println();
    }
}
