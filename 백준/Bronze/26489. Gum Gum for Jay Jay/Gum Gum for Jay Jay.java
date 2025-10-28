import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int cnt = 0;
            String line;
            
            while((line = br.readLine()) != null) {
                cnt++;
            }
            bw.write(String.valueOf(cnt));
            bw.flush();
        }
    }
}