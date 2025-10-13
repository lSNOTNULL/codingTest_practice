import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int currentNum = A;
            int cnt = 0;
            
            while(B > A) {
                cnt++;
                if(B % 10 == 1) {
                    B = (B-1)/10;
                }else if(B % 2 == 0) {
                    B /= 2;
                } else {
                    break;
                }
            }
            if(B == A) {
                bw.write(String.valueOf(cnt+1));
                
            }else bw.write("-1");
            bw.flush();
        }
    }
}