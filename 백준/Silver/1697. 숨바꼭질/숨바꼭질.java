import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 준비
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            Queue<Integer> queue = new LinkedList<>();
            int[] time = new int[100001];
            boolean[] visited = new boolean[100001];
            
            queue.add(N);
            time[N] = 0;
            visited[N] = true;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                
                if(current-1 >= 0 && !visited[current-1]) {
                    queue.add(current-1);
                    time[current-1] = time[current]+1;
                    visited[current-1] = true;
                }if(current+1 <= 100000 && !visited[current+1]) {
                    queue.add(current+1);
                    time[current+1] = time[current]+1;
                    visited[current+1] = true;
                } if(current*2 <= 100000 && !visited[current*2]) {
                    queue.add(current*2);
                    time[current*2] = time[current]+1;
                    visited[current*2] = true;
                }
            }
            bw.write(String.valueOf(time[K]));
            bw.flush();
        }
    }
}