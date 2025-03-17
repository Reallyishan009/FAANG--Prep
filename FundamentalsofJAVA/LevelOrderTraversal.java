import java.util.LinkedList;
import java.util.Queue;

public class TreeNode{
    int val;
    TreeNode left ;
    TreeNode right;
     TreeNode(int x){
        this.val = x;
        this.left = this.right = null;

    }
}

public class LevelOrderTraversal {
    public static void printLevelOrder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.println(current.val);

            if(current.left!=null){
                queue.add(current.left);
            }
             if (current.right!=null){
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        printLevelOrder(root);
    }
}
