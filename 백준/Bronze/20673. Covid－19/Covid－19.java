import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int A = Integer.parseInt(br.readLine());
            int B = Integer.parseInt(br.readLine());
            
            if(A <= 50 && B <= 10) {
                bw.write("White");
            } else if (B > 30) bw.write("Red");
            else bw.write("Yellow");
            bw.flush();
        }
    }   
}