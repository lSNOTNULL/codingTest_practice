import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
           int T = Integer.parseInt(br.readLine());           
            // 한 줄씩 문자열로 받음
            for(int i = 0; i < T ; i++) {
                String ps = br.readLine();
                // 문자열을 배열로 쪼개서 스택 구조로 검증
                Stack<Character> stack = new Stack<>();
                boolean isVPS = true;
                
                for(char ch : ps.toCharArray()) {
                    if (ch == '(') {
                        stack.push(ch);
                    } else if (ch == ')') {
                        if (stack.isEmpty()) {
                           isVPS = false;
                            break; 
                        } else {
                            stack.pop();
                        }                     
                    }
                }
                // 검증 후 남아있다면 짝 안맞음
                if (!stack.isEmpty()) {
                    isVPS = false;
                }
                if (isVPS) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
                bw.flush();
            }
            
           }
    }
}