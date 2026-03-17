public class BinarySearchTree {

    class Node {
        // Allowed to have up to 2 nodes
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Adding a value to the BST
    public void add(int value) {
        root = addRecursive(value, root);
    }

    // //Inserting that value in the BST,
    // //Checking if left or right depending on number added
    private Node addRecursive(int value, Node current) {
        if (current == null) {
            return new Node(value);
        }
        if (value <= current.data) {
            current.left = addRecursive(value, current.left);
        } else {
            current.right = addRecursive(value, current.right);
        }
        return current;
    }

    public void addIterative(int value) {
        // Case 1: Root is empty
        if (root == null) {
            root = new Node(value);
        } else {
            // Root is not empty
            Node current = this.root;

            // Navigate to the correct leaf
            while (current.left != null || current.right != null) {
                if (value <= current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            // Choose what child to add to the leaf
            if (value <= current.data) {
                current.left = new Node(value);
            } else {
                current.right = new Node(value);
            }
        }
    }
}

//Worst Case Sceneario: O(n)
//Average Case Sceneario: O(log n)
