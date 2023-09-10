//QUESTION//
//here the question is that we have a normal tree and we are also givern another tree ,
//now we have to check wether the other tree is subtree of any  of the node of given tree;
public class SubtreeOfAnotherTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
            boolean leftans=isSubtree(root.left, subRoot);
            boolean rightans=isSubtree(root.right, subRoot);
            return leftans || rightans;
        
    }
    public static boolean isIdentical(Node node,Node subRoot){

        if(node==null && subRoot==null){
            return true;
        }
        else if(node==null || subRoot==null || node.data!=subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
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

            Node subroot=new Node(2);
            subroot.left=new Node(4);
        //    subroot.right=new Node(5);
          
         System.out.println(isSubtree(root, subroot));
    }
}
