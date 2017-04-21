import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by kjm81 on 2017-04-12.
 */
public class CodeForce158C {
    static boolean[][] nodeTable = new boolean[505][505];
    static String[] nodeString = new String[505];
    static int currentNode = 0, createdNode;
    static boolean[] visited = new boolean[505];
    static String[] pathDirectory = new String[505];
    static int pathNode = 0;
    static boolean flag;
    public static void main(String[] args) {
        int n;
        nodeTable[0][0] = true;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String commandLine = "";
        String command = "";
        String directoryList = "";
        String[] directorys = new String[505];
        nodeString[0] = "/";
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            commandLine = sc.nextLine();
            command = commandLine.split(" ")[0];
            if (commandLine.split(" ").length > 1) {
                directoryList = commandLine.split(" ")[1];
            }
            if (command.equals("pwd")) {    // 현재 디렉토리 찍기
                dfs(0);
                for (int j = 0 ; j < pathDirectory.length; j++) {
                    if (pathDirectory[j] == null) {
                        break;
                    }else {
                        System.out.print(pathDirectory[j]);
                        if (j > 0)
                            System.out.print("/");
                    }
                }
                System.out.println();
                flag = false;
                Arrays.fill(visited,false);
                Arrays.fill(pathDirectory, null);
            }else {        // cd로 이동하기
                // 절대 위치 이동인지 아닌지를 구분
                directorys = directoryList.split("/");

                if (directoryList.charAt(0) == '/' && directorys.length > 0)  {
                    directorys[0] = "/";
                    currentNode = 0;
                }
                for(int j = 0; j < directorys.length; j++) {
                    if (directorys[j].equals("..")) {
                        for (int k = 0; k < nodeTable.length; k++) {
                            if (nodeTable[k][currentNode]) {
                                currentNode = k;
                                break;
                            }
                        }
                    }else {
                        int searchedNode = searchNode(directorys[j]);
                        if (searchedNode == -1){
                            // 없으면 노드 생성 후 이동
                            createdNode = insertNode(directorys[j]);
                            nodeTable[currentNode][createdNode] = true;
                            currentNode = createdNode;
                        }else {
                            // currentNode중에 연결된 것이 있으면 그 노드로 이동
                            currentNode = searchedNode;
                        }
                    }
                }
            }
        }
    }

    static int searchNode(String node){
        for (int i = 0 ; i < nodeString.length; i++) {
            if (nodeString[i] == null) {
                return -1;
            }
            if (nodeString[i].equals(node) && nodeTable[currentNode][i]) {
                return i;
            }
        }
        return -1;
    }
    static int insertNode(String node) {
        for (int i = 0 ; i < nodeString.length; i++) {
            if (nodeString[i] == null) {
                nodeString[i] = node;
                return i;
            }
        }
        return -1;
    }

    static void dfs(int v) {
        visited[v] = true;
        if (!flag) {
            pathDirectory[pathNode] = nodeString[v];
        }
        pathNode++;
        if (v == currentNode) {
            flag = true;
            for (int i = pathNode; i <  pathDirectory.length; i++) {
                pathDirectory[i] = null;
            }
        }
        for (int i = 0; i < nodeTable.length; i++) {
            if (nodeTable[v][i] && !(visited[i]) && !flag) {
                dfs(i);
            }
        }
        pathNode--;
    }

}