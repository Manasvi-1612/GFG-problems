
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class GfG {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0) {
            int B = sc.nextInt();
            int arr[][] = new int[B][B];
            for(int i = 0; i < B; i++) {
                for(int j = 0; j < B; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int ans[] = obj.findMaxRow(arr, B);
            for(int i = 0; i < 2; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public int bs(int[] row,int l,int h,int N,int c){
        int mid=(l+h)/2;
        if(l<=h){
            if(row[mid]==1){
                return bs(row,l,mid-1,N,N-mid);
            }else{
                return bs(row,mid+1,h,N,c);
            }
        }
        return c;
    }
    public int[] findMaxRow(int mat[][], int N) {
        int[] a=new int[2];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int c=bs(mat[i],0,N-1,N,0);
            if(max<c){
                max=c;
                a[0]=i;
                a[1]=max;
            }
        }
        return a;
    }
};
