import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            String line = br.readLine();
            String[] parts = line.split(" ");
            
            int A = Integer.parseInt(parts[0]);
            int B = Integer.parseInt(parts[1]);
            
            int sum = A + B;
            
            bw.write(String.valueOf(sum));
            
            bw.flush();
        }
    }
}