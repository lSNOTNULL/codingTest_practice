import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[][] tree;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            tree = new char[26][2];
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                char root = st.nextToken().charAt(0);
                char left = st.nextToken().charAt(0);
                char right = st.nextToken().charAt(0);
                int idx = root - 'A';
                tree[idx][0] = left;
                tree[idx][1] = right;
            }
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void solve() {
        // 전위, 중위, 후위
        preorder('A');
        sb.append('\n');
        inorder('A');
        sb.append('\n');
        postorder('A');
    }
    public static void preorder(char root) {
        // Root - L - R
        if(root == '.') {
            return;
        }
        sb.append(root);
        int idx = root - 'A';
        preorder(tree[idx][0]);
        preorder(tree[idx][1]);
    }
    public static void inorder(char root) {
        // L - Root - R
        if(root == '.') {
            return;
        }
        int idx = root - 'A';
        inorder(tree[idx][0]);
        sb.append(root);
        inorder(tree[idx][1]);
    }
    public static void postorder(char root) {
        // L - R - Root
        if(root == '.') {
            return;
        }
        int idx = root - 'A';
        postorder(tree[idx][0]);
        postorder(tree[idx][1]);
        sb.append(root);
    }
}