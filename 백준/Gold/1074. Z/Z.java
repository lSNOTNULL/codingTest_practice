import java.util.*;
import java.io.*;

public class Main {
    static int N,r,c,cnt = 0;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int len = (int) Math.pow(2,N);
            // int len = 1 << N;
            
            findZ(len);
            bw.write(String.valueOf(cnt));
            bw.flush();
        }
    }
    public static void findZ(int size) { // (0,0) 기준
        int half = size/2;
        if(size == 1) {
            return;
        }
        int area_size = half*half;
        // 해당 사분면에 없으면 사분면 블럭크기만큼 cnt ++
        if(r < half && c < half) { // 1사분면
            // cnt 변화없음
        } else if (r < half && c >= half) {
            c -= half; // 해당 사분면에서 0,0 좌표로 작동하도록 변경
            cnt += area_size * 1;
        } else if (r >= half && c < half) {
            r -= half;
            cnt += area_size * 2; 
        } else if (r >= half && c >= half) {
            r -= half;
            c -= half;
            cnt += area_size * 3;
        }
        findZ(half);
    }
}