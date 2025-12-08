import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] board;
    static int result;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            N = Integer.parseInt(br.readLine());
            board = new int[N];
            result = 0;
            
            solve(0);
            
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }
    public static void solve(int row) {
        if(row == N) {
            result++;
            return;
        }
        for(int i=0; i<N; i++) {
            board[row] = i;
            
            if(isPossible(row)) {
                solve(row+1);
            }
        }
    }
    public static boolean isPossible(int row) {
        for(int i=0; i<row; i++) {
            if(board[i] == board[row]) {
                return false;
            }
            if(Math.abs(row-i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}