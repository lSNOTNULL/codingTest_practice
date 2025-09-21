import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
           
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            HashSet<String> noHear = new HashSet<>();
            
            for(int i = 0; i<N; i++){
                noHear.add(br.readLine());
            }
            ArrayList<String> result = new ArrayList<>();
            
            for(int i=0; i<M; i++){
                String name = br.readLine();
                if(noHear.contains(name)) {
                    result.add(name);
                }
            }
            
            Collections.sort(result);
            
            StringBuilder sb = new StringBuilder();
            sb.append(result.size()).append("\n");
            
            for(String name : result) {
                sb.append(name).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
           }
    }
}