import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer>[] node;
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            node = new ArrayList[N+1];
            int cnt = Integer.MAX_VALUE;
            int userNum = 0;
            
            for(int i = 0; i <= N; i++) {
                node[i] = new ArrayList<>();
            }
            
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                node[A].add(B);
                node[B].add(A);
            }
            for(int i = 1; i <= N; i++) {
                // 베이컨 수 비교하여 작을때만 갱신
                // 갱신 시 번호도 갱신 (같은 경우엔 제외)
                int num = BFS(i);
                if(num < cnt) {
                    cnt = num;
                    userNum = i;
                }
                
            }
            bw.write(String.valueOf(userNum));
            bw.flush();
        }
    }
    public static int BFS(int userNum) { // n번째 사람의 베이컨 수 출력
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[N+1];
        int distSum = 0;
        
        visited[userNum] = true;
        queue.offer(userNum);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            distSum += distance[current];
            
            for(int num : node[current]) {
                if(!visited[num]) {
                    visited[num] = true;
                    queue.offer(num);
                    distance[num] = distance[current] + 1; 
                }
            }
        }
        return distSum;
    }
}