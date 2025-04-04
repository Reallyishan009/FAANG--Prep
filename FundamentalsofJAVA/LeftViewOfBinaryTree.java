import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class LeftViewOfBinaryTree {
    public void printLeftView(TreeNode root) {
        ArrayList<TreeNode> ar = new ArrayList<>();
        printLeftViewUtil(root, ar, 0);

        for (TreeNode node : ar) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    private void printLeftViewUtil(TreeNode root, ArrayList<TreeNode> ar, int level) {
        if (root == null) {
            return;
        }

        if (level >= ar.size()) {
            ar.add(root);
        }

        printLeftViewUtil(root.left, ar, level + 1);
        printLeftViewUtil(root.right, ar, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
        tree.printLeftView(root);
    }
}
