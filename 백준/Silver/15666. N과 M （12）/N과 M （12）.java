import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] inputArr;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            inputArr = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }
            Arrays.sort(arr);
            solve(arr,0,0);
            
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void solve(int[] arr, int depth, int start) {
        if(depth == M) {
            for(int num : inputArr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        int lastUsed = 0;
        for(int i=start; i<N; i++) {
            if(lastUsed == arr[i]) {
                continue;
            }
            inputArr[depth] = arr[i];
            lastUsed = arr[i];
            solve(arr,depth+1, i);
        }
    }
}