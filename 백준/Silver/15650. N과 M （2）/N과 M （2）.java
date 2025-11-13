import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[M];
            DFS(1,0);
            
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void DFS(int start, int depth) {
        // 1부터 N까지 M개의 수 출력
        if(depth == M) {
            for(int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<=N; i++) {
                arr[depth] = i;
                DFS(i+1,depth+1);
            }
    }
}