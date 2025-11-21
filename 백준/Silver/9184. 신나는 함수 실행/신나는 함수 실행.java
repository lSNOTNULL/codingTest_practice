import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st;
            dp = new int[21][21][21];
            
            while(true) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if(a==-1 && b==-1 && c==-1) {
                    // 종료 트리거
                    break;
                }
                int answer = w(a,b,c);
                sb.append("w(")
                    .append(a).append(", ")
                    .append(b).append(", ")
                    .append(c).append(")")
                    .append(" = ").append(answer)
                    .append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static int w(int a, int b, int c) {
        if(a<=0 || b<=0 || c<=0) {
            return 1; // 1
        }
        if(a>20 || b>20 || c>20) {
            return w(20,20,20); // 20 상한선
        }
        if(dp[a][b][c] != 0) return dp[a][b][c];
        
        if(a<b && b<c) {
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return dp[a][b][c];
        } else {
            dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
            return dp[a][b][c];
        }
    }
}