import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            /*
             * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
               각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.  
             */
            int T = Integer.parseInt(br.readLine());          
            
            //출력 횟수 구하기
            int[] cnt0 = new int[41];
            int[] cnt1 = new int[41];
            
            cnt0[0] = 1;
            cnt0[1] = 0;
            cnt1[0] = 0;
            cnt1[1] = 1;
            // 기본세팅
            for(int i = 2; i <= 40; i++) {
                cnt0[i] = cnt0[i-1] + cnt0[i-2];
                cnt1[i] = cnt1[i-1] + cnt1[i-2];     
            }
            StringBuilder sb = new StringBuilder();
            // 출력 세팅
            for(int i = 0 ; i < T; i++) {           
                int N = Integer.parseInt(br.readLine());
                // 출력
                sb.append(cnt0[N]).append(" ").append(cnt1[N]).append("\n");
            }
            bw.write(sb.toString());
        }
    }
}