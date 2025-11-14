import java.util.*;
import java.io.*;

public class Main {
    static int M,N;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[M];
            visited = new boolean[N+1];
            
            DFS(1,0);
            
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void DFS(int start, int depth) {
        if(depth == M) {
            for(int num : arr) { // 비내림차순 정렬준비
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<=N; i++) {
            arr[depth] = i;
            DFS(i, depth+1);
        }
    }
}