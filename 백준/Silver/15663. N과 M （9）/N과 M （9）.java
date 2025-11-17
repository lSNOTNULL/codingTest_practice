import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] inputArr,arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            inputArr = new int[M];
            visited = new boolean[N];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }
            Arrays.sort(arr);
            solve(0);
            
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void solve(int depth){
        if(depth == M) {
            for(int num : inputArr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        int lastUsed = 0;
        for(int i=0; i<N; i++) {
            int num = arr[i];
            
            if(!visited[i] && lastUsed != num) {
                visited[i] = true;
                inputArr[depth] = num;
                lastUsed = num;
                
                solve(depth+1);
                
                visited[i] = false;
            }
        }
    }
}