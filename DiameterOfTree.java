public class DiameterOfTree {
    static class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Info{
        int diam;
        int ht;
        Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter(Node root){//TC-0(n) because here we didnt calculate height seperately 
        if(root==null){
            return new Info(0, 0);
        }
        Info leftInfo=diameter(root.left);
        Info rightInfo=diameter(root.right);
        int diam=Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam, ht);
    }
    public static void main(String[] args) {
                   /* 1 
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
            //root.left.left.left=new Node(4);
            System.out.println(diameter(root).diam);
    }
}