import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String S = br.readLine();
            int i = Integer.parseInt(br.readLine());
            char answer = S.charAt(i-1);
            
            bw.write(answer);
            bw.flush();
        }
    }
}