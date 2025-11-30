import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solve(arr,N);
            
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void solve(int[] arr, int N) {
        // 절댓값 sum 크기에 따라 포인터 좌,우 이동 결정
        // sum == 0 종료
        int start = 0;
        int end = N-1;
        long minSum = Long.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        
        while(start < end) {
            long sum = (long) arr[start] + arr[end];
            
            if(Math.abs(minSum) > Math.abs(sum)) {
                minStart = start;
                minEnd = end;
                minSum = sum;
            }
            
            if(sum < 0) {
                start++;
            }else if (sum > 0) {
                end--;
            } else {
                break;
            }
        }
        sb.append(arr[minStart]).append(" ").append(arr[minEnd]);
    }
}