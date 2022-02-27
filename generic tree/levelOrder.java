import java.util.*;

class Main{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data){
            this.data = data;
        }
    }
    
    public static void levelOrder(Node root){
        Queue<Node> q = new ArrayDeque<>();
        
        q.add(root);
        
        while(q.size() != 0){
            Node curr = q.remove();
            System.out.println(curr.data);
            for(Node child : curr.children){
                q.add(child);
            }
        }
        return;
    }
    
    
    
    
    public static void main(String args[]){
        Node root = new Node(10);

        Node twenty = new Node(20);
        root.children.add(twenty);

        Node thirty = new Node(30);
        root.children.add(thirty);

        Node forty = new Node(40);
        root.children.add(forty);

        Node fifty = new Node(50);
        twenty.children.add(fifty);

        Node sixty = new Node(60);
        twenty.children.add(sixty);
        
        Node seventy = new Node(70);
        sixty.children.add(seventy);
        
        levelOrder(root);
        // levelOrderLinewise(root);
    }
}