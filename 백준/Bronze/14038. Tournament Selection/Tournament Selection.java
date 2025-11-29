import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int cnt = 0;
            int answer = 0;
            for(int i=0; i<6; i++) {
                String result = br.readLine();
                if(result.equals("W")) cnt++;
            }
            if(cnt >= 5) {
                answer = 1;
            } else if(cnt >=3) {
                answer = 2;
            } else if(cnt >=1) {
                answer = 3;
            } else {
                answer = -1;
            }
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
}