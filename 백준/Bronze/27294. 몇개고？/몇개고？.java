import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int result = 0;
            
            if(S == 1 || T <= 11 || T >16) { // 아침,저녁, 술
                result = 280;    
            } else {
                result = 320;
            }
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }
}