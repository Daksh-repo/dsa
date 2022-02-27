import java.util.*;

public class Main{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data){
            this.data = data;
        }
    }

    public static Node constructTreeUsingArray(int[] arr){
        Stack<Node> st = new Stack<>();
        Node newNode = new Node(arr[0]);
        st.push(newNode);
        int i = 1;
        while(st.size() != 0 && i != arr.length){
            if(arr[i] == -1 && st.size() > 0){
                Node curr = st.peek();
                st.pop();
                if(st.size() == 0){
                    return curr;
                }
                st.peek().children.add(curr);
                i++;
            }
            // else if(arr[i] == -1 && st.size() == 1){
            //     Node curr = st.peek();
            //     st.pop();
            //     i++;
            //     return curr;
            // }
            else{
                Node newNode2 = new Node(arr[i]);
                st.push(newNode2);
                i++;
            }
        } 
        return newNode;
    }

    public static Node construct(int[] arr){
        Stack<Node> stack = new Stack<>();

        for(int val : arr){
            if(val == -1){
                Node curr = stack.pop()
                if(stack.size() == 0){
                    return curr;
                }
                stack.peek().children.add(curr);
            }else{
                Node newNode = new Node(val);
                stack.push(newNode);
            }
        }
        Node newNode = new Node(0);
        return newNode;
    }
// **************************************************************************************************
    public static int size(Node node) {
        int ans = 0;
        for (Node child : node.children) {
        ans += size(child);
        }
        return ans + 1;
    }
// **************************************************************************************************



    public static void levelOrderLineWise(Node root){
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
    public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = constructTreeUsingArray(arr);
        
        levelOrderLineWise(root);

        int sizeOfTree = size(root);

    }
}