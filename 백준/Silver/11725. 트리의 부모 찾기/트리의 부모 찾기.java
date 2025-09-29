import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            List<List<Integer>> node = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            int[] parent = new int[N+1];
            
            // 자료구조
            for(int i = 0; i<=N; i++) {
                node.add(new ArrayList<>());
            }
            // 노드연결
            for(int i = 0; i<N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                node.get(a).add(b);
                node.get(b).add(a);
            }
            queue.offer(1);
            parent[1] = 1;
            
            while(!queue.isEmpty()) {
                int current = queue.poll();
                for(int i : node.get(current)){
                    if(parent[i] == 0) {
                        parent[i] = current;
                        queue.offer(i);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 2; i <= N; i++) {
                sb.append(parent[i]).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}