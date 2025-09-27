import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            HashMap<String,Integer> nameToNum = new HashMap<>();
            HashMap<Integer,String> numToName = new HashMap<>();
            for(int i = 1; i <= N; i++) {
                String name = br.readLine();
                nameToNum.put(name,i);
                numToName.put(i,name);
            }
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < M; i++) {
                String question = br.readLine();
                if(isInt(question)) {
                    int num = Integer.parseInt(question);
                    String answer = numToName.get(num);
                    sb.append(answer).append("\n");
                } else {
                    int answer = nameToNum.get(question);
                    sb.append(answer).append("\n");
                }
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static boolean isInt(String question) {
        try {
            int num = Integer.parseInt(question);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}