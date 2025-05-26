class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST_del_rec_optimized {

    /* Given a binary search tree and a key, this 
       function deletes the key and returns the 
       new root */
    static Node delNode(Node root, int k) {
        // Base case
        if (root == null) {
            return root;
        }

        // If the key to be deleted is smaller than 
        // the root's key, then it lies in the left
        // subtree
        if (k < root.key) {
            root.left = delNode(root.left, k);
            return root;
        }

        // If the key to be deleted is greater
        // than the root's key, then it lies in 
        // the right subtree
        else if (k > root.key) {
            root.right = delNode(root.right, k);
            return root;
        }

        // If key is same as root's key, then this 
        // is the node to be deleted
        // Node with only one child or no child
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // Node with two children: Get the inorder
        // successor (smallest in the right subtree). 
        // Also find parent of the successor
        Node succParent = root;
        Node succ = root.right;
        while (succ.left != null) {
            succParent = succ;
            succ = succ.left;
        }

        // Copy the inorder successor's content 
        // to this node
        root.key = succ.key;

        // Delete the inorder successor
        if (succParent.left == succ) {
            succParent.left = succ.right;
        } else {
            succParent.right = succ.right;
        }
        
        return root;
    }

    // Utility function to do inorder traversal
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // Driver code
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        int x = 15;

        root = delNode(root, x);
        inorder(root);
    }
}