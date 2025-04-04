package Trees;

public class Q1PreOrderTraversal {
    public void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " "); 
        preorderTraversal(node.left);     
        preorderTraversal(node.right);    
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

       
        Q1PreOrderTraversal traversal = new Q1PreOrderTraversal();
        System.out.println("Preorder Traversal of the tree:");
        traversal.preorderTraversal(root); // Expected output: 1 2 4 5 3
    }
}
