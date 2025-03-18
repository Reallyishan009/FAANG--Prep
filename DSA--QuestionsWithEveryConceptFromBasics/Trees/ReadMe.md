# Trees in Data Structures and Algorithms with Java

Trees are fundamental hierarchical data structures that are widely used across computer science. Let me explain trees in depth, with Java implementations and key interview questions.

## Basic Tree Concepts

A tree is a non-linear data structure consisting of nodes connected by edges. It has the following properties:

- One node is designated as the **root** node
- Every node (except the root) is connected to exactly one parent node
- Each node can have zero or more child nodes
- Nodes with no children are called **leaf** nodes
- Nodes that share the same parent are called **siblings**

### Basic Tree Node Implementation in Java

```java
class TreeNode {
    int data;
    List<TreeNode> children;
    
    public TreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
    
    public void addChild(TreeNode child) {
        children.add(child);
    }
}
```

## Binary Trees

A binary tree is a special type of tree where each node has at most two children, referred to as the left child and right child.

### Binary Tree Node Implementation

```java
class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    
    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
```

## Binary Search Trees (BST)

A binary search tree is a binary tree with the following properties:
- The left subtree of a node contains only nodes with keys less than the node's key
- The right subtree of a node contains only nodes with keys greater than the node's key
- Both the left and right subtrees are also binary search trees

### BST Implementation

```java
class BST {
    BinaryTreeNode root;
    
    public BST() {
        root = null;
    }
    
    // Insert a value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }
    
    private BinaryTreeNode insertRec(BinaryTreeNode root, int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
            return root;
        }
        
        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);
            
        return root;
    }
    
    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }
    
    private boolean searchRec(BinaryTreeNode root, int value) {
        if (root == null)
            return false;
            
        if (root.data == value)
            return true;
            
        if (value < root.data)
            return searchRec(root.left, value);
            
        return searchRec(root.right, value);
    }
    
    // Delete a value from the BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }
    
    private BinaryTreeNode deleteRec(BinaryTreeNode root, int value) {
        if (root == null)
            return null;
            
        if (value < root.data)
            root.left = deleteRec(root.left, value);
        else if (value > root.data)
            root.right = deleteRec(root.right, value);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
                
            // Node with two children
            root.data = minValue(root.right);
            
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        
        return root;
    }
    
    private int minValue(BinaryTreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
}
```

## Tree Traversals

There are multiple ways to traverse a tree:

### Depth-First Traversals

1. **Inorder Traversal** (Left, Root, Right)
```java
public void inorder(BinaryTreeNode node) {
    if (node == null)
        return;
        
    inorder(node.left);
    System.out.print(node.data + " ");
    inorder(node.right);
}
```

2. **Preorder Traversal** (Root, Left, Right)
```java
public void preorder(BinaryTreeNode node) {
    if (node == null)
        return;
        
    System.out.print(node.data + " ");
    preorder(node.left);
    preorder(node.right);
}
```

3. **Postorder Traversal** (Left, Right, Root)
```java
public void postorder(BinaryTreeNode node) {
    if (node == null)
        return;
        
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.data + " ");
}
```

### Breadth-First Traversal (Level Order)

```java
public void levelOrder(BinaryTreeNode root) {
    if (root == null)
        return;
        
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
        BinaryTreeNode current = queue.poll();
        System.out.print(current.data + " ");
        
        if (current.left != null)
            queue.add(current.left);
            
        if (current.right != null)
            queue.add(current.right);
    }
}
```

## Balanced Trees

A balanced tree is one where the heights of the two subtrees of any node differ by at most one.

### AVL Tree

AVL trees are self-balancing binary search trees where the heights of the left and right subtrees differ by at most one.

```java
class AVLNode {
    int data, height;
    AVLNode left, right;
    
    public AVLNode(int data) {
        this.data = data;
        this.height = 1; // Initial height of new node is 1
    }
}

class AVLTree {
    AVLNode root;
    
    // Get height of the node
    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }
    
    // Get balance factor of node
    int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
    
    // Right rotate subtree rooted with y
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        
        // Perform rotation
        x.right = y;
        y.left = T2;
        
        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    // Left rotate subtree rooted with x
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        
        // Perform rotation
        y.left = x;
        x.right = T2;
        
        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    // Insert a node
    AVLNode insert(AVLNode node, int data) {
        // Perform standard BST insert
        if (node == null)
            return new AVLNode(data);
            
        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else // Duplicate keys not allowed
            return node;
            
        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        // Get the balance factor
        int balance = getBalance(node);
        
        // If unbalanced, then there are 4 cases
        
        // Left Left Case
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);
            
        // Right Right Case
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);
            
        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
}
```

## Important Tree Operations

### Finding Height of a Tree

```java
public int height(BinaryTreeNode root) {
    if (root == null)
        return 0;
    
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    
    return Math.max(leftHeight, rightHeight) + 1;
}
```

### Checking if a Binary Tree is Balanced

```java
public boolean isBalanced(BinaryTreeNode root) {
    if (root == null)
        return true;
        
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    
    if (Math.abs(leftHeight - rightHeight) <= 1 && 
        isBalanced(root.left) && 
        isBalanced(root.right))
        return true;
        
    return false;
}
```

### Finding the Lowest Common Ancestor

```java
public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
    if (root == null || root == p || root == q)
        return root;
        
    BinaryTreeNode left = lowestCommonAncestor(root.left, p, q);
    BinaryTreeNode right = lowestCommonAncestor(root.right, p, q);
    
    if (left != null && right != null)
        return root;
        
    return (left != null) ? left : right;
}
```

## Important Interview Questions

1. **Validate Binary Search Tree**: Determine if a binary tree is a valid BST.

```java
public boolean isValidBST(BinaryTreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean isValidBST(BinaryTreeNode node, long min, long max) {
    if (node == null)
        return true;
        
    if (node.data <= min || node.data >= max)
        return false;
        
    return isValidBST(node.left, min, node.data) && 
           isValidBST(node.right, node.data, max);
}
```

2. **Maximum Path Sum**: Find the maximum path sum in a binary tree.

```java
class Solution {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(BinaryTreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }
    
    private int findMaxPathSum(BinaryTreeNode node) {
        if (node == null)
            return 0;
            
        // Find max path sum from left and right subtrees
        int leftSum = Math.max(0, findMaxPathSum(node.left));
        int rightSum = Math.max(0, findMaxPathSum(node.right));
        
        // Update the maximum path sum that passes through current node
        maxSum = Math.max(maxSum, leftSum + rightSum + node.data);
        
        // Return the maximum sum of path ending at current node
        return Math.max(leftSum, rightSum) + node.data;
    }
}
```

3. **Serialize and Deserialize Binary Tree**: Convert a binary tree to a string and back.

```java
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(BinaryTreeNode root) {
        if (root == null)
            return "X";
            
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        
        return root.data + "," + leftSerialized + "," + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public BinaryTreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }
    
    private BinaryTreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        
        if (val.equals("X"))
            return null;
            
        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        
        return node;
    }
}
```

## Common FAANG Interview Questions on Trees

1. **Construct Binary Tree from Preorder and Inorder Traversal**
   - Given preorder and inorder traversal arrays, construct the binary tree

2. **Binary Tree Level Order Traversal**  
   - Return the level order traversal of a binary tree's values

3. **Convert Sorted Array to Binary Search Tree**
   - Convert a sorted array to a height-balanced BST

4. **Diameter of Binary Tree**
   - Find the length of the longest path between any two nodes in a tree

5. **Flatten Binary Tree to Linked List**
   - Flatten a binary tree into a "right-pointer-only" linked list in-place

6. **Binary Tree Maximum Path Sum**
   - Find the maximum path sum in a binary tree

7. **Symmetric Tree**
   - Check if a binary tree is a mirror of itself

8. **Validate Binary Search Tree**
   - Determine if a binary tree is a valid BST

9. **Kth Smallest Element in a BST**
   - Find the kth smallest element in a BST

10. **Serialize and Deserialize Binary Tree**
    - Design an algorithm to serialize and deserialize a binary tree

11. **Lowest Common Ancestor of a Binary Tree**
    - Find the lowest common ancestor of two nodes in a binary tree

12. **Binary Tree Right Side View**
    - Return the values visible from the right side of a binary tree

13. **Count Complete Tree Nodes**
    - Count the number of nodes in a complete binary tree

