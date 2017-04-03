import java.util.Scanner;

/**
 * Created by user on 2017-03-31.
 * cycle 찾기
 */
public class CodeForce103B {
    static boolean[][] table = new boolean[101][101];
    static boolean[] visit = new boolean[101];
    static int n, m, x, y, count = 0;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            table[x][y] = true;
            table[y][x] = true;
        }
        dfs(1);
        if ((n == m) && (count == n)) {
            System.out.print("FHTAGN!");
        }else {
            System.out.print("NO");
        }
    }
    public static void dfs(int v) {
        visit[v] = true;
        count++;
        for (int i = 1; i < n + 1; i++) {
            if (table[v][i] && !(visit[i])) {
                dfs(i);
            }
        }
    }
}
