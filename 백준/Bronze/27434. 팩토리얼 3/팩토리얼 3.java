import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            BigInteger answer = BigInteger.ONE;
            
            answer = factorial(1,N);
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static BigInteger factorial(int start, int end) {
        BigInteger num = BigInteger.valueOf(start);
        if(start < end) {
            int mid = start + (end - start) / 2;
            num = factorial(start,mid).multiply(factorial(mid+1,end));
        }
        return num;
    }
}