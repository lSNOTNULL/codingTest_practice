import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int cnt = 0;
            
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(br.readLine());
            }
            for(int i = N-1 ; i >=0 ; i--) {
                int coin = A[i];
                
                if(K >= coin) {
                    cnt += K/coin;
                    K %= coin;
                }
            }
            bw.write(String.valueOf(cnt));
        }
    }
}