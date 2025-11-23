import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N][N];
            int[][] tri = new int[N][N];
            StringTokenizer st;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<=i; j++) {
                    tri[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = solve(N, dp, tri);
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }
    public static int solve(int N, int[][] dp, int[][] tri) {
        // 가장 왼쪽,오른쪽은 위에서 한 방향에서만 올수있음
        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i == 0) {
                    dp[0][0] = tri[0][0];
                } else if(j == 0) {
                    dp[i][0] = tri[i][0] + dp[i-1][0];
                } else if(j == i) {
                    dp[i][j] = tri[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = tri[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        for(int num : dp[N-1]) {
            result = Math.max(result,num);
        }
        return result;
    }
}