import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
           ) {
            int N = Integer.parseInt(br.readLine());
            
            // for문을 통해 그리디 알고리즘 적용
            for(int count5 = N / 5; count5 >= 0; count5 --) {
                int remaining = N - (5 * count5);
                if(remaining >= 0 && remaining % 3 == 0) {
                    // 나누어진다면 최소 개수
                    int count3 = remaining / 3;
                    
                    bw.write(String.valueOf(count5 + count3));
                    return;
                }       
            }
            bw.write("-1");  
        }
    }
}