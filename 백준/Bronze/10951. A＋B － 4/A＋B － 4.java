import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            String line;
            StringBuilder sb = new StringBuilder();
            
            while((line = br.readLine()) != null) {
                 StringTokenizer st = new StringTokenizer(line);
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                
                sb.append(A+B).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}