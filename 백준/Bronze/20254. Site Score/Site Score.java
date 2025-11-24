import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        int result = 0;
        for(int i=0; i<4; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        result += 56*arr[0] + 24*arr[1] + 14*arr[2] + 6*arr[3];
        System.out.println(result);
    } 
}