import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = 1;
            int second = 1;
            for(int i=0; i<5; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(i<=1) first *= num;
                else {
                    second *= num;
                }
            }
            bw.write(String.valueOf(first - second));
            bw.flush();
        }
    }
}