import java.util.*;
public class Leetcode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        } int key=0;int j=0;
        ArrayList<Integer> a=new ArrayList<>();
        int largest=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>largest){
                largest=arr[i];
                key=i;
            }
        }
      //  System.out.println(largest+"sakjhgsdf"+ key);
        // for(int i=0;i<key;i++){
        //     if(arr[i]<largest){
        //         continue;
        //     }
        // }

    }
}
