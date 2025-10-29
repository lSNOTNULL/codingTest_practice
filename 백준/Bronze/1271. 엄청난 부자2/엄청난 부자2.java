import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger n = new BigInteger(st.nextToken());
            BigInteger m = new BigInteger(st.nextToken());
            StringBuilder sb = new StringBuilder();
            BigInteger answer = n.divide(m);
            BigInteger remain = n.remainder(m);
            sb.append(answer).append("\n").append(remain);

            
            bw.write(sb.toString());
            bw.flush();
        }
    }
}