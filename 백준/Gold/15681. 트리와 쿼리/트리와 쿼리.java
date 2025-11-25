import java.util.*;
import java.io.*;

public class Main {
    static int N,R,Q;
    static List<List<Integer>> adj;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            adj = new ArrayList<>();
            dp = new int[N+1];
            
            for(int i=0; i<=N; i++) { // 1-based
                adj.add(new ArrayList<>());
            }
            for(int i=0; i<N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                adj.get(num1).add(num2);
                adj.get(num2).add(num1);
            }
            DFS(R,0);
            
            for(int i=0; i<Q; i++) {
                int v = Integer.parseInt(br.readLine());
                sb.append(dp[v]).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void DFS(int u, int parent) {
        dp[u] = 1;
        for(int v : adj.get(u)) {
            if(v != parent) {
                DFS(v,u);
                dp[u] += dp[v];
            }
        }
    }
}