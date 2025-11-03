import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<List<Integer>> jump = new LinkedList<>();
            // 1-6 주사위, 1-100칸 이동 but 98+3 = 101 의경우 이동불가
            // 사다리 N 올라감, 뱀 M 내려감
            for(int i=0; i<=100; i++) {
                jump.add(new ArrayList<>());
            }
            // 사다리,뱀 이동 칸 배열 입력
            for(int i=0; i<N+M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                jump.get(start).add(end);
            }
            
            // 100번 칸 도착을 위한 주사위 최소 횟수
            // BFS이용, 최소값을 보장함
            int answer = BFS(jump);
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static int BFS(List<List<Integer>> jump) {
        int[] dist = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(current == 100) {
                return dist[100];
            }
            int maxDice = Math.min(6,100-current);
            for(int i=1; i<=maxDice; i++) {
                int next = current + i;
                
                if(!jump.get(next).isEmpty()) {
                    next = jump.get(next).get(0);
                }
                if(dist[next] == 0) {
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
}