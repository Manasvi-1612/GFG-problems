//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
         if(D*9 <= S){
             return "-1";
         }
         
         char[] arr=new char[D];
         int i=D-1;
         
         //first smallest
         int s= S-1;
         while(i>0){
            if(s>9){
                arr[i]=(char)(9+'0');
                s=s-9;
            }else{
                arr[i]=(char)(s+'0');
                s=0;
            } 
            i--;
         }
         arr[0]=(char)(s+1+'0');
         
         //second smallest
         int c=D-1;
         for(int j=0;j<D;j++){
             if(arr[j]=='9'){
                 c=j;
                 break;
             }
         }
         arr[c]-=1;
         arr[c-1]+=1;
        
        String str=new String(arr);
        return str;
    }
}
