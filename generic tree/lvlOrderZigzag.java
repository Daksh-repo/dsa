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
// my way
    public static void levelOrderZigzag(Node root){
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        Stack<Node> st = new Stack<>();
        int flag = 0;
        while(q.size() != 0){
            Node curr = q.remove();
            if(flag){
                for(Node child : curr.children){
                    cq.add(child);
                }
                st.push(curr);

            }else{
                System.out.print(curr.data + " ");
                for(Node child : curr.children){
                    cq.add(child);
                }
            }

            if(q.size() == 0){
                if(st.size() != 0){
                    while(st.size() != 0){
                        Node c = st.peek();
                        st.pop();
                        System.out.print(c.data + " ");
                    }
                }
                flag = (flag == 1) ? 0 : 1;
                q = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
       
    }

// another way
public static void levelOrderLinewiseZZ(Node node){
      
      LinkedList<Node> que = new LinkedList<>();
      LinkedList<Node> st = new LinkedList<>();
      
      que.addLast(node);
      int lvl = 0;
      while(que.size() != 0){
          int qSize = que.size();
          while(qSize-->0){
              if(lvl%2 == 0){
                  Node curr = que.removeFirst();
                  System.out.print(curr.data + " ");
                  for(Node child :  curr.children){
                      que.addLast(child);
                  }
              }else{
                  Node curr = que.removeFirst();
                  for(Node child : curr.children){
                      que.addLast(child);
                  }
                  st.addFirst(curr);
              }
          }
          lvl++;
          while(st.size() > 0){
              Node val = st.removeFirst();
              System.out.print(val.data + " ");
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
        
        levelOrderZigzag(root);
    }
}