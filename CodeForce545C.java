import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2017-03-27.
 */
public class CodeForce545C {
    public static void main(String[] args) {
        int n, parentCount;
        String input;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] list = new int[n][];
        int[][] dinamicPro = new int[n][];
        int[] checkArray = new int[n];
        int[] checkTemp = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            list[i] = new int[2];
            input = sc.nextLine();
            list[i][0] = Integer.parseInt(input.split(" ")[0]);
            list[i][1] = Integer.parseInt(input.split(" ")[1]);
        }
        // 위까지 input

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                // 첫시행 초기화 안될경우가 있으므로 다시 계산
                dinamicPro[i] = new int[3];
                checkArray = new int[3];
                dinamicPro[i][0] = 1;
                checkArray[0] = -1;
                dinamicPro[i][1] = 0;
                checkArray[1] = 0;
                if ((list[i + 1][0] - list[i][0]) > list[i][1]) {
                    dinamicPro[i][2] = 1;
                    checkArray[2] = 1;
                }else {
                    dinamicPro[i][2] = -2;
                    checkArray[2] = -2;
                }

            }else {
                parentCount = 0;
                for (int j = 0; j < dinamicPro[i - 1].length;  j++) {
                    if (dinamicPro[i - 1][j] != -2) {
                        parentCount++;
                    }
                }
                dinamicPro[i - 1] = arraySwap(dinamicPro[i - 1], parentCount);
                checkArray = checkArraySwap(checkArray, parentCount);
                //print(dinamicPro[i - 1].length);
                dinamicPro[i] = new int[3 * parentCount];
                Arrays.fill(dinamicPro[i], -2);
                checkTemp = new int[3 * parentCount];
                Arrays.fill(checkTemp, -2);
                for (int j = 0; j < 3 * parentCount; j++) {
                    // 부모 상태 판정

                    if(checkArray[j / 3] == -1 ||
                            checkArray[j / 3] == 0) { // 부모가 왼쪽 또는 중점  
                        // 현재 나무가 넘어지는 경우? 

                        switch (j % 3) {  //현재의 입장에서
                            case 0: // 왼쪽으로 넘어진다.
                                if (list[i][0] - list[i - 1][0] > list[i][1]) {
                                    // 왼쪽으로 넘어진다면
                                    dinamicPro[i][j] = 1;
                                    dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                                    checkTemp[j] = -1;
                                }else {
                                    dinamicPro[i][j] = -2;
                                    checkTemp[j] = -2;
                                }
                                break;
                            case 1: // 가운데 있는다.
                                // 얘는 무조건 서있을 수 있음
                                dinamicPro[i][j] = 0;
                                dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                                checkTemp[j] = 0;
                                break;
                            case 2: // 오른쪽으로 넘어진다.
                                // 오른쪽만 보면 됨
                                if (i == n - 1) {
                                    dinamicPro[i][j] = 1;
                                    dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                                    checkTemp[j] = 1;
                                }else {
                                    if (list[i + 1][0] - list[i][0] > list[i][1]) {
                                        // 오른쪽으로 넘어진다면 
                                        dinamicPro[i][j] = 1;
                                        dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                                        checkTemp[j] = 1;
                                    }else {
                                        checkTemp[j] = -2;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    else if (checkArray[j / 3] == 1) {   // 부모가 오른쪽
                        if (i ==  3*parentCount - 1) {
                            dinamicPro[i][j] = 1;
                            dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                            checkTemp[j] = 1;
                        }else {
                            //부모가 오른쪽으로 넘어갔다.

                            switch (j % 3) {  //현재의 입장에서
                                case 0: // 왼쪽으로 넘어진다.
                                    if (list[i][0] - (list[i - 1][0] + list[i][1]) > list[i][1]) {
                                        // 왼쪽으로 넘어진다면
                                        dinamicPro[i][j] = 1;
                                        dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                                        checkTemp[j] = -1;
                                    }else {
                                        dinamicPro[i][j] = -2;
                                        checkTemp[j] = -2;
                                    }
                                    break;
                                case 1: // 가운데 있는다.
                                    // 얘는 무조건 서있을 수 있음
                                    dinamicPro[i][j] = 0;
                                    dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                                    checkTemp[j] = 0;
                                    break;
                                case 2: // 오른쪽으로 넘어진다.
                                    // 오른쪽만 보면 됨
                                    if (i == n - 1) {
                                        dinamicPro[i][j] = 1;
                                        dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                                        checkTemp[j] = 1;
                                    }else {
                                        if (list[i + 1][0] - list[i][0] > list[i][1]) {
                                            // 오른쪽으로 넘어진다면 
                                            dinamicPro[i][j] = 1;
                                            dinamicPro[i][j] += dinamicPro[i - 1][j / 3];
                                            checkTemp[j] = 1;
                                        }else {
                                            checkTemp[j] = -2;
                                        }
                                    }
                                    break;
                                default:
                                    break;
                            }

                        }
                    }
                }
                checkArray = new int[3 *parentCount];
                checkArray = checkTemp;
            }
        }
        int max = 0;
        for (int y = 0; y < dinamicPro[n - 1].length; y++) {
            if (max < dinamicPro[n - 1][y]) {
                max = dinamicPro[n - 1][y];
            }
        }

        System.out.print(max);
    }

    public static int[] arraySwap(int[] array,int parentCount) {
        int[] tempArray = new int[parentCount];
        int j = 0;
        for (int i = 0; i < array.length;i++) {
            if (array[i] != -2) {
                tempArray[j] = array[i];
                j++;
            }
        }
        return tempArray;
    }

    public static int[] checkArraySwap(int[] array,int parentCount) {
        int[] tempArray = new int[parentCount];
        int j = 0;
        for (int i = 0; i < array.length;i++) {
            if (array[i] != -2) {
                tempArray[j] = array[i];
                j++;
            }
        }
        return tempArray;
    }


}
