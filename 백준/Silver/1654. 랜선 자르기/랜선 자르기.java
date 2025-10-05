import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] len = new int[K];
            long start = 1;
            long end = 0;
            long maxLen = 0;
            
            for(int i = 0; i < K; i++) {
                len[i] = Integer.parseInt(br.readLine());
                end = Math.max(end,len[i]);
            }
            
            while(start <= end) {
                int cnt = 0;
                long mid = (start + end)/2;
                
                for(int i = 0; i < K; i++) {
                    cnt += (len[i] / mid);
                }
                if(cnt >= N) {
                    maxLen = mid;
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
            bw.write(String.valueOf(maxLen));
            bw.flush();
        }
    }
}