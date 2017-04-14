import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by kjm81 on 2017-04-07.
 */
public class CodeForce707B {
    static int[] u = new int[100005];
    static int[] v = new int[100005];
    static int[] l = new int[100005];
    static int[] storages = new int[100005];
    public static void main(String[] args) {
        int n, m, k, x, y, z;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            z = sc.nextInt();
            storages[z] = 1;
        }

        int min = 2000000000;
        for (int i = 0; i < m; i++) {
            if (storages[u[i]] == 1 && storages[v[i]] == 0) {
                if (min > l[i]) {
                    min = l[i];
                }
            }
            if (storages[v[i]] == 1 && storages[u[i]] == 0) {
                if (min > l[i]) {
                    min = l[i];
                }
            }
        }

        if (min == 2000000000) {
            System.out.print(-1);
        }else {
            System.out.print(min);
        }
    }
}