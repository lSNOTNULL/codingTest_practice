import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> node;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            
            node = new ArrayList<>();
            visited = new boolean[N+1];
                      
            for(int i = 0; i <= N; i++) {
                node.add(new ArrayList<>());
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                node.get(a).add(b);
                node.get(b).add(a);
            }
            for(int i =1; i<=N; i++) {
                Collections.sort(node.get(i));
            }
            DFS(V);
            sb.append("\n");
            Arrays.fill(visited,false);
            BFS(V);
            
            bw.write(sb.toString());
            bw.flush();
        } 
    }
    public static void DFS(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        
        for(int i : node.get(v)) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        sb.append(v).append(" ");
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i : node.get(current)) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }  
            }
        }
        
    }
}