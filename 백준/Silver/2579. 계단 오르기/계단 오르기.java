import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 사전 작업
            int stairCnt = Integer.parseInt(br.readLine());
            
            int scores[] = new int[stairCnt + 1];
            int dp[] = new int[stairCnt + 1];
            
                // 계단별 점수 저장
            for(int i = 1; i <= stairCnt; i++) {
                scores[i] = Integer.parseInt(br.readLine());
            }
            
            dp[1] = scores[1];
            if(stairCnt >= 2) dp[2] = scores[1] + scores[2];
            if(stairCnt >= 3) dp[3] = Math.max(scores[1], scores[2]) + scores[3];
            
            // 계산 작업
            for(int i = 4; i <= stairCnt; i++) {
                // -2,0 or -3,-1,0
                dp[i] = Math.max(dp[i-2], dp[i-3] + scores[i-1]) + scores[i];
            }
            bw.write(String.valueOf(dp[stairCnt]));
            bw.flush();
        }
    }
}