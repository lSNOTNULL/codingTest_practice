import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            String method = st.nextToken();
            int B = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            
            while(!(A == 0 && method.equals("W") && B == 0)) {
                if(method.equals("W")) {
                    if(A-B < -200) {
                        sb.append("Not allowed").append("\n");
                    } else
                    sb.append(String.valueOf(A-B)).append("\n");
                } if(method.equals("D")) {
                    sb.append(String.valueOf(A+B)).append("\n");
                }
                
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                method = st.nextToken();
                B = Integer.parseInt(st.nextToken());
                
                
            }
            bw.write(sb.toString());
            bw.flush();
            
        }
    }   
}