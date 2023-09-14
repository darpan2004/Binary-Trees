import java.util.ArrayList;

public class RootToLeaf {
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
    public static void rootToLeaf(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.data);
        if(root.left==null && root.right==null){
            System.out.println(list);
            return;
        }
        rootToLeaf(root.left, list);
        rootToLeaf(root.right, list);
        if(list.size()!=0){
        list.remove(list.size()-1);
        }

        return;
    }
    public static void main(String[] args) {
        int valuse[]={8,5,3,6,10,11,14};
        Node root=null;
        for (int i = 0; i < valuse.length; i++) {
            root=insert(root, valuse[i]);
        }

        ArrayList<Integer> list=new ArrayList<>();
        rootToLeaf(root, list);
    }
}
