package Trees;

public class Q2InOrderTraversal {
    public void InorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        InorderTraversal(node.left);  
        System.out.print(node.val + " ");    
        InorderTraversal(node.right);    
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        
        Q2InOrderTraversal traversal = new Q2InOrderTraversal();

        
        System.out.println("In-order traversal of the tree:");
        traversal.InorderTraversal(root);
        // Expected output: 4 2 5 1 3
    }
}
