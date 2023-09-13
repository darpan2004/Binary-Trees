import java.util.ArrayList;

public class MinDistanceBetweenNodes {
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
    public static boolean getpath(Node root,int n,ArrayList<Node> path){
       
        if(root==null){
            return false;
        }
         path.add(root);
         if(root.data==n){
            return true;
        }
        Boolean foundLeft=getpath(root.left, n, path);
        boolean foundRight=getpath(root.right, n, path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();
        getpath(root,n1,path1);
        getpath(root,n2,path2);

        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca=path1.get(i-1);
        
        
        return lca;
    }
    public static int  getMinDistance(Node lca,int n1,int n2){
         lca=lca(lca, n1, n2);
         int dist1=dist1(lca, n1,0);
         int dist2=dist1(lca, n2,0);
         return dist1+dist2;
        
    }
    public static int dist1(Node root, int n1,int i){
        if(root==null){
            return -1;
        }
        if(root.data==n1){
            return i;
        }
        int leftDistance=dist1(root.left, n1, i+1);
        int rightDistance=dist1(root.right, n1,i+1);
        if (leftDistance != -1) {
            return leftDistance;
        }
        if (rightDistance != -1) {
            return rightDistance;
        }
    
        // If n1 is not found in either subtree, return -1 to indicate that it wasn't found.
        return -1;
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
            System.out.println(getMinDistance(root, 4, 6));
    }
}
