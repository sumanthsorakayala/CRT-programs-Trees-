class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

class BST_del_iter {

    public static Node delIterative(Node root, int key) {
        Node curr = root;
        Node prev = null;

        // Check if the key is actually present in the BST.
        // The variable prev points to the parent of the key
        // to be deleted.
        while (curr != null && curr.key != key) {
            prev = curr;
            if (key < curr.key)
                curr = curr.left;
            else
                curr = curr.right;
        }

        // Key not present
        if (curr == null)
            return root;

        // Check if the node to be deleted has at most one child.
        if (curr.left == null || curr.right == null) {
            Node newCurr;

            // If the left child does not exist.
            if (curr.left == null)
                newCurr = curr.right;
            else
                newCurr = curr.left;

            // Check if the node to be deleted is the root.
            if (prev == null)
                return newCurr;

            // Check if the node to be deleted is prev's left or
            // right child and then replace this with newCurr.
            if (curr == prev.left)
                prev.left = newCurr;
            else
                prev.right = newCurr;
        } else {
          
            // Node to be deleted has two children.
            Node p = null;
            Node temp = curr.right;
            while (temp.left != null) {
                p = temp;
                temp = temp.left;
            }

            if (p != null)
                p.left = temp.right;
            else
                curr.right = temp.right;

            curr.key = temp.key;
        }
        return root;
    }

    // Utility function to do inorder traversal
    public static void inorder(Node root) {
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

        root = delIterative(root, x);
        inorder(root);
    }
}