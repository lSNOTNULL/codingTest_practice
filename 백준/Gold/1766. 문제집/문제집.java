import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static List<List<Integer>> adj;
    static int[] degree;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            /*
            N개의 문제는 모두 풀어야 한다.
            먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
            가능하면 쉬운 문제부터 풀어야 한다.
            */
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adj = new LinkedList<>();
            
            for(int i=0; i<=N; i++) {
                adj.add(new ArrayList<>());
            }
            degree = new int[N+1];
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                adj.get(first).add(next);
                degree[next]++;
            }
            
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=1; i<=N; i++) {
            if(degree[i] == 0) {
                pq.offer(i);
            }
        }
        while(!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");
            
            for(int next : adj.get(current)) {
                degree[next]--;
                if(degree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
    }
}