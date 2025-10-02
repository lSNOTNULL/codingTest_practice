import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[1001];
            
            dp[1] = 1;
            dp[2] = 3;
            dp[3] = 5;
            
            for(int i = 3; i<=N; i++) {
                dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
            }
            bw.write(String.valueOf(dp[N]));
            bw.flush();
        }
    }
}