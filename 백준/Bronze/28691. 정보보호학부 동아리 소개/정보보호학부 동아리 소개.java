import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            String input = br.readLine();
            String output;
            
            if (input.equals("M")) {
                output = "MatKor";
            } else if (input.equals("W")) {
                output = "WiCys";
            } else if (input.equals("C")) {
                output = "CyKor";
            } else if (input.equals("A")) {
                output = "AlKor";
            } else if (input.equals("$")) {
                output = "$clear";
            } else {
                output = "Unknown"; 
            }
            
            bw.write(output);
            bw.flush();
        }
    }
}