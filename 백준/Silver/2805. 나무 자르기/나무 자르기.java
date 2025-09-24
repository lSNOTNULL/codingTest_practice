import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] H = new int[N];
            long low = 0;
            long high = 0;
            long answer = 0;
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                H[i] = Integer.parseInt(st.nextToken());
                if(H[i] > high) high = H[i];
            }
            
            while(low <= high) {
                long mid = ((long)low + high) /2;
                long sum = 0;
                
                for(int i = 0; i < N; i++) {
                    if(H[i] > mid) {
                        sum += H[i] - mid;
                    }
                }
                if(sum >= M) {  
                    low = mid + 1;
                    answer = mid;
                }else {
                    high = mid - 1;
                }
                
            }
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
}