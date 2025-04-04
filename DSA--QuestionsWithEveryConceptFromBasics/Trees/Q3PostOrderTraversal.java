package Trees;

public class Q3PostOrderTraversal {
    public void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);  
        
        postorderTraversal(node.right);    
        System.out.print(node.val + " ");    
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        
        Q3PostOrderTraversal traversal = new Q3PostOrderTraversal();
        System.out.println("Post-order traversal of the tree:");
        traversal.postorderTraversal(root);
       
    }
}
