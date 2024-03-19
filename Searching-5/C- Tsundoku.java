// brute force approach
import java.util.*;
import java.util.Scanner;

class solution{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] deskA = new int[n]; 
    int[] deskB = new int[m];
    for(int i=0;i<n;i++){
      deskA[i] = sc.nextInt();
    }
    for(int i=0;i<m;i++){
      deskB[i] = sc.nextInt();
    }
    int i=0;
    int j=0;
    int sum=0;
    int cnt=0;
    while((i>=0 && i<n) && (j>=0 && i<m)){
      if(deskA[i]<=deskB[j]){
        sum = deskA[i];
        i++;
        cnt++;
      }
      else if(deskA[i]>deskB[j]){
        sum = deskB[j];
        j++;
        cnt++;
      }
      if(sum>k)
      break;
    }
    System.out.println(cnt-1);
  }
}


//binary search approach
