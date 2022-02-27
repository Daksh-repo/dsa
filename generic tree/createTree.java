import java.util.*;

class Main{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(data){
            this.data = data;
        }
    }
    public static void main(String args[]){
        Node root = new Node(10);

        Node twenty = new Node(20);
        root.children.add(twenty);

        Node thirty = new Node(30);
        root.children.add(thirty);

        Node forty = new Node(40);
        root.chidren.add(forty);

        Node fifty = new Node(50);
        twenty.children.add(fifty);

        Node sixty = new Node(60);
        twenty.children.add(sixty);
        
    }
}