import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            Arrays.fill(dp,4);
            dp[0] = 0;
            // n = k + i^2 -> k = n - i^2
            // dp[n] = dp[n-i^2] + 1 (마지막 더한 i^2 개수)
            
                                 
            for(int i =1; i<=n; i++) {
                for(int j = 1; j*j<=i; j++) {
                    int num = j*j;
                    dp[i] = Math.min(dp[i],dp[i-num]+1);
                }
            }
            bw.write(String.valueOf(dp[n]));
            bw.flush();
        }
    }
}