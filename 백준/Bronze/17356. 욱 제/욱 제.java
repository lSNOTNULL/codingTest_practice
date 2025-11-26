import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        double M = (double) (B-A) / 400;
        double result = 0;
        
        
        result = 1 / (1+ Math.pow(10,M));
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}