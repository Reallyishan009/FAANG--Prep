package DynamicProgramming;
import java.lang.*;
import java.util.*;
public class FibonacciNumber {
            public static void main(String[] args) {
            // YOUR CODE GOES HERE
            // Please take input and print output to standard input/output (stdin/stdout)
            // DO NOT USE ARGUMENTS FOR INPUTS
            // E.g. 'Scanner' for input & 'System.out' for output
            Scanner scn = new Scanner(System.in);
            int A = scn.nextInt();
    
            int dp[] = new int[A+1];
            Arrays.fill(dp,-1);
    
            System.out.print(fab(A,dp));
            scn.close();
            
        }
    
        public static int fab(int A, int dp[]){
            if(A==0 || A==1){
                return A;
            }
    
            if(dp[A]!=-1){
                return dp[A];
            }
    
            int ans = fab(A-1,dp) +fab(A-2,dp);
            dp[A]= ans;
    
            return ans;
        }
    }   