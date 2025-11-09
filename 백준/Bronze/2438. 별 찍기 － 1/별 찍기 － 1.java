import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++) {
                for(int j=0; j<=i; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}