import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                String answer = DSLR(start,end);
                sb.append(answer).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static String DSLR(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        String[] visited = new String[10000];
        queue.offer(start);
        visited[start] = "";
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            // DSLR 각 메서드 호출하며 탐색
            if(curr == end) {
                return visited[end];
            }
            for(int i=0; i<4; i++) {
                int next =0;
                char operation = ' ';
                
                switch(i) {
                    case 0:
                        next = D(curr);
                        operation = 'D';
                        break;
                    case 1:
                        next = S(curr);
                        operation = 'S';
                        break;
                    case 2:
                        next = L(curr);
                        operation = 'L';
                        break;
                    case 3:
                        next = R(curr);
                        operation = 'R';
                        break;
                }
                if(visited[next] == null) {
                    queue.offer(next);
                    visited[next] = visited[curr] + operation;
                }
            }
        }
        return "error";
    }
    public static int D(int curr) {
        return (curr*2) % 10000;
    }
    public static int S(int curr) {
        return curr == 0 ? 9999 : curr-1;
    }
    public static int L(int curr) {
        return (curr%1000) * 10 + curr/1000;
    }
    public static int R(int curr) {
        return (curr%10) * 1000 + curr/10;
    }
}