import java.util.TreeMap;

public class Tree {
    class Node{
        int data; 
        Node [] children;

        public Node(int data, int numchild) {
            this.data = data;
            children = new Node[numchild];
        }
    }

    public Node root;

    public Tree(){
        root = null;
    }

    public Tree(Node root){
        this.root = root;    
    }

    public static void main(String[] args) {
        
    }
}
