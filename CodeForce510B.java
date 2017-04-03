import java.util.Scanner;
import java.util.Stack;

/**
 * Created by kjm81 on 2017-03-27.
 */
public class CodeForce510B {
    static boolean yesOrNoFlag = false;
    static Stack<String> stack = new Stack<String>();
    public static void main(String[] args) {
        int n, m;
        String input;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        String[][] list = new String[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            list[i][0] = "-1";
            list[i][m + 1] = "-1";
        }
        for (int i = 0; i < m + 2; i++) {
            list[0][i] = "-1";
            list[n + 1][i] = "-1";
        }

        for (int i = 1; i < n + 1; i++) {
            input = sc.nextLine();
            for (int j = 1; j < m + 1; j++) {
                list[i][j] = input.split("")[j - 1];
            }

        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++){
                if (list[i][j] != "-1") {
                    depthPrioritySearch(list, i, j);
                    zeroToMinus(list);
                }
            }
        }
        if (yesOrNoFlag) {
            System.out.print("Yes");
        }else {
            System.out.print("No");
        }
    }

    public static void zeroToMinus(String[][] list) {
        for (int i = 1; i < list.length - 1; i++) {
            for (int j = 1; j < list[i].length - 1; j++) {
                if (list[i][j] == "0") {
                    list[i][j] = "-1";
                }
            }
        }
    }

    public static void depthPrioritySearch(String[][] list, int x, int y) {
        if (yesOrNoFlag) {
            return;
        }
        String currentChar = list[x][y];
        String previousRow, previousCol;
        if (stack.size() == 0) {
            previousRow = "0";
            previousCol = "0";
        }else {
            previousRow = stack.peek().split(",")[0];
            previousCol = stack.peek().split(",")[1];
        }// 이전값 저장
        list[x][y] = "0";   // 방문한 노드는 0으로 세팅
        stack.push(x + "," + y);    // stack에 푸시
        if (list[x - 1][y].equals(currentChar) &&
                !(x - 1 == Integer.parseInt(previousRow)&&
                        y == Integer.parseInt(previousCol))) {
            // 위쪽 이동
            depthPrioritySearch(list,x - 1, y);
        }
        if(list[x + 1][y].equals(currentChar) &&
                !(x + 1 == Integer.parseInt(previousRow) &&
                        y == Integer.parseInt(previousCol))){
            // 아래쪽 이동
            depthPrioritySearch(list, x + 1, y);
        }
        if(list[x][y - 1].equals(currentChar) &&
                !(x == Integer.parseInt(previousRow) &&
                        y - 1 == Integer.parseInt(previousCol))){
            // 왼쪽 이동
            depthPrioritySearch(list, x, y - 1);
        }
        if(list[x][y + 1].equals(currentChar) &&
                !(x == Integer.parseInt(previousRow) &&
                        y + 1 == Integer.parseInt(previousCol))){
            // 오른쪽 이동
            depthPrioritySearch(list, x, y + 1);
        } // 이동을 못하는 경우
        //현재값은 저장이 되어있지
        // 여기만 잘하면 될 거같음
        //지금 갈 곳이 스택에 저장되어있지 않으면서
        // 0인 녀석 그리고 이전 값이 아닌 녀석

        // 스택에 있는지 확인

        // 여기 부터 뒤로 감
        // 스택에는 현재 값까지 들어있음

        if (!(x - 1 == Integer.parseInt(previousRow) && y == Integer.parseInt(previousCol)) &&
                list[x - 1][y].equals("0")) {// 지나온 곳이 아니면서 갈 곳이 0인 녀석이 있다면
            if (stack.search((x - 1) + "," + y) != -1) { // 이녀석은 한번 방문한 노드가 아니라면
                yesOrNoFlag = true;
            }
        }else if(!(x + 1 == Integer.parseInt(previousRow) && y == Integer.parseInt(previousCol)) &&
                list[x + 1][y].equals("0")){
            if (stack.search((x + 1) + "," + y) != -1) { // 이녀석은 한번 방문한 노드가 아니라면
                yesOrNoFlag = true;
            }
        }else if(!(x == Integer.parseInt(previousRow) && y - 1 == Integer.parseInt(previousCol)) &&
                list[x][y - 1].equals("0")){
            if (stack.search(x + "," + (y - 1)) != -1) { // 이녀석은 한번 방문한 노드가 아니라면
                yesOrNoFlag = true;
            }
        }else if(!(x == Integer.parseInt(previousRow) && y + 1 == Integer.parseInt(previousCol)) &&
                list[x][y + 1].equals("0")){
            if (stack.search(x + "," + (y + 1)) != -1) { // 이녀석은 한번 방문한 노드가 아니라면
                yesOrNoFlag = true;
            }
        }
        stack.pop();
        return;

    }





}