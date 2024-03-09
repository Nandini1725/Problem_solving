import java.util.*;
import java.util.Scanner;

class solution{
  public static void solve(int[] height, int[] queries){
    Arrays.sort(height);
    for(int i=0;i<queries.length;i++){
      int low=0;
      int high=height.length-1;
      int count=0;
      
      while(low<=high){
        int mid = low + (high-low)/2;
        if(height[mid]>=queries[i]){
          count=high-mid+1;
          high=mid-1;
        }
        else{
          low=mid+1;
        }
      }
      System.out.println(count);
    }
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int q = sc.nextInt();
    int[] height = new int[h];
    int[] queries = new int[q];
    for(int i=0;i<h;i++){
      height[i]=sc.nextInt();
    }
    for(int i=0;i<q;i++){
      queries[i]=sc.nextInt();
    }
    
    solve(height,queries);
  }
}
