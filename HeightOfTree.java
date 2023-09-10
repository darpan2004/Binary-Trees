public class HeightOfTree {
    //aaj savamiyo ghodaliyo swikar mehad ee malir ri re hith kun gan
    static class Node{
        Node left ,right;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh, rh)+1;
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftcount=count(root.left);
        int rightcount=count(root.right);
        return leftcount+rightcount+1;
    }
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
      
        int leftsum=sumOfNodes(root.left);
        int rightsum=sumOfNodes(root.right);
        return leftsum+rightsum+root.data;

    }
    public static int diameter(Node root){//TC=0(n^2) since we are calculating height at each node
        if(root==null){
            return 0;
        }
        int leftDiam=diameter(root.left);
        int leftHt=height(root.left);
        int rightDiam=diameter(root.right);
        int rightHt=height(root.right);
        int selfDiam=leftHt+rightHt+1;
        return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
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
        System.out.println(height(root));
         System.out.println(count(root));
         System.out.println(sumOfNodes(root));
         System.out.println(diameter(root));
     }
}
