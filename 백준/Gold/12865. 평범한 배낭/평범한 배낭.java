import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] items = new int[N][2];
            int[] dp = new int[K+1]; // 각 무게별 가져갈 수 있는 최대가치
            // W의 합이 K를 넘지않는 최대 Value
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int weight = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                items[i][0] = weight;
                items[i][1] = value;
            }
            
            for(int i=0; i<N; i++) {
                int weight = items[i][0];
                int value = items[i][1];
                for(int j=K; j>=weight; j--) { // 역순조회로 중복방지
                    int ifTaken = value + dp[j-weight];
                    dp[j] = Math.max(dp[j],ifTaken);
                }
            }
            bw.write(String.valueOf(dp[K]));
            bw.flush();
        }
    }
}