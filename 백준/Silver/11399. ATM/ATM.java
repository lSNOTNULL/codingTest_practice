import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] P = new int[N];
            int time = 0;
            int totalTime = 0;
            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                P[i] = num;
            }
            Arrays.sort(P);
            for(int i=0; i<N; i++) {
                time += P[i];
                totalTime += time;
            }
            bw.write(String.valueOf(totalTime));
            bw.flush();
        }
    }
}