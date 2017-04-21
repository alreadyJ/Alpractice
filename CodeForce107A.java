import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by kjm81 on 2017-04-07.
 */
public class CodeForce107A {
    static int n, p, t = 0;
    static int[] vertex = new int[1005];
    static int[] diameter = new int[1005];
    static int[] vertexCount = new int[1005];
    static ArrayList<Integer> start = new ArrayList<Integer>();
    static int[] minList = new int[1005];
    static int[] p1 = new int[1005];
    static int[] p2 = new int[1005];
    static boolean flag = false;
    public static void main(String[] args) {
        int x, y, z;
        Arrays.fill(minList, 1000000000);
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = sc.nextInt();
        for (int i = 0; i < p; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            vertex[x]= y;
            diameter[x] = z;
            vertexCount[x]++;
            vertexCount[y]++;
        }
        for (int i = 0; i < vertex.length; i++) {
            if (vertexCount[i] == 1) {
                start.add(i);
            }
        }
        for (int i = 0; i < start.size(); i++) {
            p1[t] = start.get(i);
            dfs(start.get(i));
            flag = false;
            t++;
        }

        System.out.println(start.size() / 2);
        for (int i= 0; i < start.size(); i++) {
            if (minList[i] != 1000000000) {
                System.out.println(p1[i] + " " + p2[i] + " " + minList[i]);
            }
        }
    }

    public static void dfs(int v){
        if (vertex[v] != 0) {
            if (minList[t] > diameter[v] && diameter[v] != 0) {
                minList[t] = diameter[v];
            }
            dfs(vertex[v]);
        } else {
            if (!flag) {
                p2[t] = v;
                flag = true;
            }
        }
    }

}