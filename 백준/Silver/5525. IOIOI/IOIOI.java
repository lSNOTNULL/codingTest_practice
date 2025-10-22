import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            String S = br.readLine();
            int cnt = 0;
            int answer = 0;
            
            for(int i = 1; i < M-1; i++) {
                if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                    cnt++;
                    if(cnt >= N) answer++;
                    i++;
                } else {
                    cnt = 0;
                }
            }
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }        
}