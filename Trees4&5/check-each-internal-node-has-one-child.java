import java.util.*;
import java.util.Scanner;


class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int cnt=0;
        for(int i=0;i<n-2;i++){
            if(arr[i]>arr[i+1] && arr[i]>arr[i+2])
            cnt++;
            else if(arr[i]<arr[i+1] && arr[i]<arr[i+2])
            cnt++;
        }
        if(cnt==n-2) System.out.print(true);
        else System.out.print(false);
    }
}
