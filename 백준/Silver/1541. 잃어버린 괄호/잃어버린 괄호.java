import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String input = br.readLine();
            String[] parts = input.split("-");
            
            int result = 0;
            for(int i = 0; i < parts.length; i++) {
                int sum = calculate(parts[i]);
                if(i == 0) {
                    result += sum;
                } else {
                    result -= sum;
                }
            }
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }
    public static int calculate(String parts) {
        String[] num = parts.split("\\+");
        int sum = 0;
        for(String i : num) {
            int number = Integer.parseInt(i);
            sum += number;
        }
        return sum;
    }
}