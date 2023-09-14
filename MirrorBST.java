public class MirrorBST {
    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
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

    public static void mirrorBST(Node root) {
        if(root==null){
            return ;
        }
       Node temp=root.left;
       root.left=root.right;
       root.right=temp;
       
       mirrorBST(root.left);
       mirrorBST(root.right);
       
       // System.out.println(node.data);
    }

    public static void getNode(Node root, int i, int k) {
        if (root == null) {
            return;
        }
        if (k == i) {
            System.out.println(root.data);
            return;
        }
        getNode(root.left, i++, k);
        getNode(root.right, i++, k);
        return;

    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int valuse[] = {7,4,5,2,6,8};
        Node root = null;
        for (int i = 0; i < valuse.length; i++) {
            root = insert(root, valuse[i]);
        }
        inorder(root);
        System.out.println();
         mirrorBST(root);
         inorder(root);
    }
}
