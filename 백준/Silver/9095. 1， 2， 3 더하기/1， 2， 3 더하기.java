import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            // 입력
            int T = Integer.parseInt(br.readLine());
            
            int[] dp = new int[11];
            
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            
            for(int i = 4; i <= 10; i++) {
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }
            // 출력
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <=T; i++) {
                int n = Integer.parseInt(br.readLine());
                sb.append(dp[n]).append("\n");
            }
            bw.write(sb.toString());
        }
    }
}