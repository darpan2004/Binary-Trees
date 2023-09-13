public class SumTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
             this.left=null;
             this.right=null;
        }
    }
    public static void sum(Node root){
        if(root==null){
            return;
        }
        root.data=sumTree(root, 0)-root.data;
        sum(root.left);
        sum(root.right);
    }
    public static int sumTree(Node root,int sum){
        
        if(root==null){
            return 0;
        }

        int leftSum=sumTree(root.left, sum+root.data);
       int rightSum= sumTree(root.right, sum+root.data);
        return leftSum+rightSum+root.data;
    }
    public static void main(String[] args) {
           /*   1 
               /   \
              2     3
             / \   / \
            4   5 6   7
            */
            Node root=new Node(1);
            root.left=new Node(2);
            root.right=new Node(3);
            root.left.left=new Node(4);
            root.left.right=new Node(5);
            root.right.left=new Node(6);
            root.right.right=new Node(7);
           // System.out.println(sumTree(root, 0));
           sum(root);
           System.out.println(root.left.left.data);
    }
}
