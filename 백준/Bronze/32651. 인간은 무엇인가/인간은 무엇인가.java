import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());
            String result = "No";
            if(N % 2024 == 0 && N <= 100000) {
                result = "Yes";
            }
            bw.write(result);
            bw.flush();
        }
    }
}