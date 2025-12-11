import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            
            bw.write(String.format("%.1f", W*H*0.5));
            bw.flush();
        }
    }
}