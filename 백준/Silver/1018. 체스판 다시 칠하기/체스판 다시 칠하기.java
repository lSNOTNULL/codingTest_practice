import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. 입력 받기: M, N과 보드 상태를 입력받음
        // Scanner를 사용하여 M(행의 수)과 N(열의 수)을 읽는다.
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        // 그리고 M x N 크기의 2차원 char 배열을 만들어서 보드 상태를 저장한다.
        // 각 줄을 입력받아 문자 배열에 한 글자씩 저장한다.
        char[][] board = new char[M][N];
        
        for(int i=0; i<M ; i++) {
            String row = sc.next();
            for(int j=0; j<N; j++){
                board[i][j] = row.charAt(j);
            }
        }
        sc.close();
        

        // 2. 결과 변수 초기화
        // 최소 덧칠 횟수를 저장할 변수 'minPaintCount'를 선언하고
        // 가장 큰 값으로 초기화한다.
        int minPaintCount = Integer.MAX_VALUE;

        // 3. 사용할 모든 8x8 보드 탐색
        // 이중 for 문을 사용하여 보드의 모든 가능한 8x8 정사각형의 시작점 (row, col)을 탐색한다.
        
        // r은 0부터 M-8까지 반복
        for(int i=0; i <= M-8; i++){
            // c는 0부터 N-8까지 반복
            for(int j=0; j <= N-8; j++){
                
                int changes_W =0;
                int changes_B =0;
                
        // 4. 각 8x8 보드에 대한 덧칠 횟수 계산
        // 현재 시작점 (r, c)에서 8x8 보드를 검사한다.
        // 4-1. 흰색으로 시작하는 경우의 덧칠 횟수 계산
                for(int r=i; r < i+8; r++ ){
                    for(int c=j; c < j+8; c++){
                        char currentColor = board[r][c];
                        
                        // r+c 가 짝수일 때, 흰색이 아니면 덧칠횟수 증가
                        if((r+c)%2 ==0) {
                            if (currentColor != 'W') changes_W++;
                            if (currentColor != 'B') changes_B++;
                        }else {
                            if (currentColor != 'W') changes_B++;
                            if (currentColor != 'B') changes_W++;
                        }
                    }
                }
        // 5. 최솟값 갱신
        // 현재 8x8 보드의 최소 덧칠 횟수(changes_W와 changes_B 중 더 작은 값)를 구한다.
        // 이 값을 전체 최소 덧칠 횟수 minPaintCount와 비교하여 더 작은 값으로 갱신한다.
                int currentMin = Math.min(changes_W, changes_B);
                
                minPaintCount = Math.min(minPaintCount,currentMin);
            }
        }
        // 6. 결과 출력
        // 모든 8x8 보드에 대한 계산이 끝난 후, minPaintCount에 저장된 최종 값을 출력한다.
        System.out.println(minPaintCount);
    }
}