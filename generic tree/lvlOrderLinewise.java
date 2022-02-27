import java.util.*;

class Main{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data){
            this.data = data;
        }
    }
    
    
// *************************************************************************************************************
//my way
    public static void levelOrderLinewise(Node root){
        
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        
        q.add(root);
        
        while(q.size() != 0){
            Node curr = q.remove();
            System.out.print(curr.data + " ");
            for(Node child : curr.children){
                cq.add(child);
                
            }
            if(q.size() == 0){
                q = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }


//another way
public static void levelOrderLinewiseUsingLinkedList(Node node){
      
      LinkedList<Node> ll = new LinkedList<>();
      
      ll.addLast(node);
      
      while(ll.size() != 0){
          int llSize = ll.size();
          
          while(llSize-->0){
              Node curr = ll.removeFirst();
              System.out.print(curr.data + " ");
              for(Node child : curr.children){
                  ll.addLast(child);
              }
          }
          System.out.println();
      }
  }
// *************************************************************************************************************
    
    
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
        
        levelOrderLinewise(root);
    }
}