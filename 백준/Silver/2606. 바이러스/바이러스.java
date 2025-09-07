import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
    
            // 사전작업
            int computers = Integer.parseInt(br.readLine());
            int connections = Integer.parseInt(br.readLine());
            
                // 네트워크 연결 그래프
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= computers; i++) {
                graph.add(new ArrayList<>());
            }
                // 감염용 큐
            Queue<Integer> queue = new LinkedList<>();
            boolean[] infected = new boolean[computers + 1];
            int cnt = 0;
            
            // 네트워크 연결작업
            for(int i = 0; i < connections; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // 양방향 연결
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            // 탐색작업
            queue.add(1);
            infected[1] = true;
            
            while(!queue.isEmpty()) {
                int current = queue.poll();
                
                for(int visit : graph.get(current)) {
                    if(!infected[visit]) {
                        infected[visit] = true;
                        cnt++;
                        queue.add(visit);
                    }
                }
            }
            bw.write(String.valueOf(cnt));
            bw.flush();
            
           }    
    }
}