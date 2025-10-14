import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){ 
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int k = 0; k < N; k++) {
                for(int i = 0; i < N; i++) {
                    for(int j =0; j < N; j++) {
                        if(arr[i][k] == 1 && arr[k][j] == 1) {
                            arr[i][j] = 1;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j <N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}