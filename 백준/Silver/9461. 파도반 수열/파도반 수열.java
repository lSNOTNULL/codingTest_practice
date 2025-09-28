import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            long[] dp = new long[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;
            // P(9) = P(4) + P(8)
            // P(N) = P(N-5) + P(N-1)
            for(int i = 6; i <= 100; i++) {
                dp[i] = dp[i-5] + dp[i-1];
            }     
            for(int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                sb.append(dp[N]).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}