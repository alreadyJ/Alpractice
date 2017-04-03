import java.util.Scanner;

/**
 * Created by root on 17. 3. 28.
 */
public class CodeForce24A {
    public static void main(String[] args) {
        int n, start = 0, currentNode;
        String input;
        boolean escape;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] list = new int[n][3];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            input = sc.nextLine();
            list[i][0] = Integer.parseInt(input.split(" ")[0]);
            list[i][1] = Integer.parseInt(input.split(" ")[1]);
            list[i][2] = Integer.parseInt(input.split(" ")[2]);
        }

        escape = false;
        for (int i = 0; i < n; i++) {   // 출발점 찾기
            for (int j = 0; j < n; j++) {
                if (list[i][0] == list[j][0]&&
                        list[i][1] != list[j][1]){
                    start = i;
                    escape = true;
                    break;
                }
            }
            if(escape){
                break;
            }
        }
        if (escape) {
            currentNode = start;
        }else{
            currentNode = 0;    // 이경우는 cost1 = 0;
        }
        int cost1 = solving(list, currentNode, start);

        for (int i = 0; i < n; i++) {
            if (list[start][0] == list[i][0] &&
                    list[start][1] != list[i][1]) {
                start = i;
                break;
            }
        }

        currentNode = start;

        int cost2 = solving(list, currentNode, start);

        int cost = (cost1 < cost2) ? cost1 : cost2;
        System.out.print(cost);
    }





    static int solving(int[][] listCopy, int currentNode,int start) {
        boolean flag;
        int cost = 0;
        int[][] list = new int[listCopy.length][3];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] = listCopy[i][j];
            }
        }
        while (true) {
            flag = false;
            for (int i = 0; i < list.length; i++) { // search
                if (list[i][0] == list[currentNode][1]) {
                    currentNode = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                // 넘어감
            }else {
                for (int i = 0; i < list.length; i++) { // research
                    if (list[i][1] == list[currentNode][1] &&
                            list[i][0] != list[currentNode][0]) {
                        int temp = list[i][0];
                        list[i][0] = list[i][1];
                        list[i][1] = temp;
                        cost += list[i][2];
                        currentNode = i;
                        flag = true;
                        break;
                    }
                }
            }

            if (list[start][0] == list[currentNode][1]) {
                break;
            }
        }// 오른쪽으로 돌린 것
        return cost;
    }
}