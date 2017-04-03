import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by user on 2017-03-31.
 */
public class CodeForce429A {
    static ArrayList<Integer> changedList = new ArrayList<Integer>();
    static String[] listInit;
    static String[] listGoal;
    static int cnt = 0;
    static int n, x, y;
    public static void main(String[] args) {
        String input;
        int depth  = 0;
        int even = 0,odd = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        LinkedList<Integer>[] vertex = new LinkedList[n + 1];
        listInit = new String[n];
        listGoal = new String[n];
        int[] tempOne = new int[n - 1];
        int[] tempTwo = new int[n - 1];

        for (int i = 1; i < n + 1; i++) {
            vertex[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            tempOne[i] = x;
            tempTwo[i] = y;
        }
        // 어떤 쪽에 1이 있는지 확인
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            if (tempTwo[i] == 1) {
                flag = true;
                break;
            }
            if (tempOne[i] == 1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < n - 1; i++) {
                vertex[tempTwo[i]].add(tempOne[i]);
            }
        }else {
            for (int i = 0; i < n - 1; i++) {
                vertex[tempOne[i]].add(tempTwo[i]);
            }
        }
        //
        sc.nextLine();
        input = sc.nextLine();
        listInit = input.split(" ");
        input = sc.nextLine();
        listGoal = input.split(" ");
        dfs(vertex, 1, depth, even, odd);  // 뒤집기를 위한 dfs
        System.out.println(cnt);
        for (int i = 0; i < changedList.size(); i++) {
            System.out.println(changedList.get(i));
        }
    }

    public static void dfs(LinkedList<Integer>[] vertex,int v, int depth, int even, int odd) {
        depth++;       // 현재의 depth
        if (depth % 2 == 0) {
            if (even % 2 == 1) {
                listInit[v - 1] = (listInit[v - 1].equals("1")) ? "0" : "1";
            }
        }else{
            if (odd % 2 == 1) {
                listInit[v - 1] = (listInit[v - 1].equals("1")) ? "0" : "1";
            }
        }
        if (!listInit[v - 1].equals(listGoal[v - 1])) {
            // 노드를 봤을 때, 목표와 다른 경우 해당 노드를 뒤집어 준다.
            listInit[v - 1] = listGoal[v - 1];
            cnt++; // 횟수 증가
            changedList.add(v);
            if (depth % 2 == 0) {
                even++;
            }else{
                odd++;
            }
        }
        for (int i = 0 ; i < vertex[v].size(); i++) {
            dfs(vertex, vertex[v].get(i),depth, even, odd);
        }

        if (depth % 2 == 0) {
            even--;
        }else {
            odd--;
        }
        depth--;
    }
}
