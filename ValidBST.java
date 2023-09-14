public class ValidBST {
    static class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
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
    public static boolean isValidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data ){
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static void main(String[] args) {
        int valuse[]={1,1};
        Node root=null;
        for (int i = 0; i < valuse.length; i++) {
            root=insert(root, valuse[i]);
        }
       System.out.println( isValidBST(root, null, null));
    }
}
