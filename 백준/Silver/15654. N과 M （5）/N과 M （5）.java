import java.util.*;
import java.io.*;

public class Main{
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] inputArr;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            inputArr = new int[M];
            visited = new boolean[N];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num; 
            }
            Arrays.sort(arr);
            DFS(N,M,0);
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void DFS(int N,int M,int depth) {
       // M개 숫자 모두채우면 출력후 종료
        if(depth == M) {
            for(int num : inputArr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 저장용 배열
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                inputArr[depth] = arr[i];
                DFS(N,M,depth+1);
                visited[i] = false;
            }
        }
    }
}