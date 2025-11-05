import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(Character.toUpperCase(c));
                }
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}