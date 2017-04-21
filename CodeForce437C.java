import java.util.Scanner;

/**
 * Created by kjm81 on 2017-04-12.
 */
public class CodeForce437C {
    static int[] nodeWeight = new int[2005];
    static int[] u = new int[2005];
    static int[] v = new int[2005];
    static int s = 0 ;
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i < n + 1; i++) {
            nodeWeight[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        // 가장큰 인덱스 찾기
        for (int i = 0; i < m; i++) {
            if (nodeWeight[u[i]] > nodeWeight[v[i]]) {
                s += nodeWeight[v[i]];
            }else {
                s += nodeWeight[u[i]];
            }
        }
        System.out.print(s);

    }
}