import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] totalSum = new int[100001];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                totalSum[i] = totalSum[i-1] + num;
            }
            
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                // 누적합
                int sum = totalSum[end] - totalSum[start-1];

                sb.append(sum).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            }
        }
    }