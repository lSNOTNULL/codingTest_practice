import java.util.*;
import java.io.*;

public class Main{
    static int[][] square;
    static int whiteCnt = 0;
    static int blueCnt = 0;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());
            square = new int[N][N];
 
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            cutPaper(square,0,0,N);
            
            StringBuilder sb = new StringBuilder();
            sb.append(whiteCnt).append("\n").append(blueCnt);
            bw.write(sb.toString());
            bw.flush();
        }
    }
    // 4분할하여 각 섹터별 재귀
    // 단색 검증 메서드추가
    public static void cutPaper(int[][] square,int row, int col, int N) {
        if(checkColor(square, row, col, N)) {
            if(square[row][col] == 0) {
                whiteCnt++;
            } else blueCnt++;
            return;
        }
        int half = N/2;
        if(half == 0) return;
        // 1사분면
        cutPaper(square,row,col,half);
        // 2
        cutPaper(square,row,col+half,half);
        // 3
        cutPaper(square,row+half,col,half);
        // 4
        cutPaper(square,row+half,col+half,half);
    }
    
    public static boolean checkColor(int[][] square, int row, int col, int N) {
        int firstColor = square[row][col];
        for(int i = row; i < row + N; i++) {
            for(int j = col; j < col + N; j++) {
                if(firstColor != square[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }    
}