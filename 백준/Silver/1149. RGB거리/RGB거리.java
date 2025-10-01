import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N][3];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<3; i++){
                dp[0][i] = Integer.parseInt(st.nextToken());
            }
  
            for(int i = 1; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int costR = Integer.parseInt(st.nextToken());
                int costG = Integer.parseInt(st.nextToken());
                int costB = Integer.parseInt(st.nextToken());
                // 누적합
                dp[i][0] = costR + Math.min(dp[i-1][1],dp[i-1][2]);
                dp[i][1] = costG + Math.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2] = costB + Math.min(dp[i-1][0],dp[i-1][1]);
            }
            int minCost = Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2]));
            bw.write(String.valueOf(minCost));
            bw.flush();
        }
    }
}