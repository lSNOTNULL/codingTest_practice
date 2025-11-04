import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());
            
            bw.write(String.valueOf(A.multiply(B)));
            bw.flush();
            
        }
    }
}