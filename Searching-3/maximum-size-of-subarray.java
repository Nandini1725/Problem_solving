import java.util.*;
import java.util.Scanner;

class solution{
    public static boolean ispossible(int mid, int[] arr, int s){
        int sum=0;
        for(int i=0;i<mid;i++){
            sum+=arr[i];
            if(sum>s)
            return false;
        }
        int j=0;
        for(int i=mid;i<arr.length;i++){
            sum+=arr[i]-arr[j];
            j++;
            if(sum>s) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int s = sc.nextInt();
        int low=1;
        int high=n;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(ispossible(mid,arr,s)==true){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        System.out.println(ans);
    }
}
