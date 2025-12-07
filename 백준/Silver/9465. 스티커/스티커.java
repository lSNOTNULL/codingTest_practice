import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int T = Integer.parseInt(br.readLine());
            
            for(int i=0; i<T; i++) {
                int n = Integer.parseInt(br.readLine());
                int[][] sticker = new int[2][n];
                for(int j=0; j<2; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for(int k =0; k<n; k++) {
                        sticker[j][k] = Integer.parseInt(st.nextToken());
                    }
                }
                solve(sticker,n);
                
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void solve(int[][] sticker, int n) {
        // 뗀 스티커의 인접 스티커는 고를수없음 && 최대값
        int[][] dp = new int[3][n];
        int result = 0;
        dp[0][0] = 0;
        dp[1][0] = sticker[0][0];
        dp[2][0] = sticker[1][0];
        
        for(int i=1; i<n; i++){
            dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
            dp[1][i] = sticker[0][i] + Math.max(dp[0][i-1], dp[2][i-1]);
            dp[2][i] = sticker[1][i] + Math.max(dp[0][i-1], dp[1][i-1]);
        }
        result = Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1]));
        
        sb.append(result).append("\n");
    }
}