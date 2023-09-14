public class DeleteNodeBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static Node deleteNode(Node root,int val){
        if(root.data>val){
            root.left=deleteNode(root.left, val);
        }
        else if(root.data<val){
            root.right=deleteNode(root.right, val);
        }
        else{
            //case 1->leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2-single child
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }      
                //case 3->both children
                Node IS=findInorderSuccessor(root.right);
                root.data=IS.data;
                root.right=deleteNode(root.right, IS.data);
            
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static Node findInorderSuccessor(Node root){

        while (root.left!=null) {
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int valuse[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for (int i = 0; i < valuse.length; i++) {
            root=insert(root, valuse[i]);
        }
        inorder(root);
        System.out.println();
        root=deleteNode(root, 6);
        System.out.println(root.data);
        inorder(root);   
    }
}
