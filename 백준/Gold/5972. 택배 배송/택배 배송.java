import java.util.*;
import java.io.*;

class Edge {
    int to;
    long cost;
    Edge(int to, long cost) {
        this.to = to;
        this.cost = cost;
    }
}
@SuppressWarnings("unchecked")
public class Main {
    static int N,M;
    static List<Edge>[] adj;
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            adj = new List[N+1];
            for(int i=1; i<=N; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                adj[A].add(new Edge(B,cost));
                adj[B].add(new Edge(A,cost));
            }
            int result = solve();
            
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }
    public static int solve() {
        // cost 대비 최단거리 배열
        // pq 사용 (비용 낮은 경로우선)
        // 더 짧은 경로 찾으면 스킵
        int start = 1;
        int end = N;
        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (e1,e2) -> Long.compare(e1.cost,e2.cost)
        ); // 누적 비용(dist) 삽입용 큐
        
        dist[start] = 0;
        pq.add(new Edge(start,0));
        
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            int curr_node = curr.to;
            long curr_cost = curr.cost;
            
            if(dist[curr_node] < curr_cost) continue; // 스킵로직
            
            for(Edge neighbor : adj[curr_node]) { // 현재 위치에서 연결된 다음노드
                int next_node = neighbor.to;
                long next_cost = neighbor.cost;
                
                if(dist[curr_node] + next_cost < dist[next_node]) {
                    dist[next_node] = dist[curr_node] + next_cost;
                    pq.add(new Edge(next_node, dist[next_node]));
                }
            }
        }
        return (int) dist[end];
    }
}