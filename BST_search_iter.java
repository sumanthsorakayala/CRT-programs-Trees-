class Node {
    int data;
    Node left, right;

    public Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class BST_search_iter {
    
    // Function to search in a bst.
    static boolean search(Node root, int x) {
        
        Node curr = root;
        
        while (curr != null) {
            
            // If curr node is x
            if (curr.data == x)
                return true;
                
            // Search in right subtree
            else if (curr.data < x) 
                curr = curr.right;
                
            // Search in left subtree
            else
                curr = curr.left;
        }
        
        // If x is not found.
        return false;
    }

    public static void main(String[] args) {
        
        // Create a hard coded BST.
        //        20
        //       /  \
        //      8   22
        //     / \
        //   4   12
        //       /  \
        //     10   14
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        
        int x = 12;
        System.out.println(search(root, x));
    }
}