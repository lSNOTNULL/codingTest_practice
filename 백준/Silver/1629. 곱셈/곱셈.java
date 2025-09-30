import java.util.*;
import java.io.*;

public class Main {
    static int C;
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            long answer = pow(A,B);
            
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static long pow(long A,long B) {
        if(B == 0) return 1;
        
        long half = pow(A,B/2);
        long result = (half*half) % C;
        if(B%2 == 1) {
            result = (result*A) % C;
        }
        return result;
    }
 }