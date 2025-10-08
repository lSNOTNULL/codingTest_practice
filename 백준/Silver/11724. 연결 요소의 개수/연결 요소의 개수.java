import java.util.*;
import java.io.*;

public class Main{
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            graph = new ArrayList<>();
            visited = new boolean[N+1];
            
            for(int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    DFS(i);
                    // BFS(i);
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt));
            bw.flush();
        }
    }
    public static void DFS(int M) {
        visited[M] = true;
        for(int num : graph.get(M)) {
            if(!visited[num]) {
                DFS(num);
            }
        }
    }
    public static void BFS(int M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(M);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int num : graph.get(current)) {
                if(!visited[num]) {
                    queue.offer(num);
                    visited[num] = true;
                }
            }
        }
    }
}