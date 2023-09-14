
public class PrintInRange {
    static class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return ;
        }
        if(k1<=root.data && k2>=root.data){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data>k1){
            printInRange(root.left, k1, k2);
          //  System.out.println(root.data);
        }
        else{
            printInRange(root.right, k1, k2);
         //   System.out.println(root.data);
        }
        return;
        
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

    public static void main(String[] args) {
        int valuse[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for (int i = 0; i < valuse.length; i++) {
            root=insert(root, valuse[i]);
        }
        printInRange(root, 9, 14 );
    }

}
