import java.util.Scanner;

/**
 * Created by kjm81 on 2017-04-07.
 */
public class CodeForce604B {
    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] list = new int[2 * k];
        int[] resultList = new int[k];
        for (int i = 2 * k - n; i < 2 * k; i++){
            list[i] = sc.nextInt();
        }

        // 뒤에서 k개로 끊음
        int max = 0;
        for (int i = 0; i < k; i++) {
            resultList[i] = list[2* k - i - 1] + list[i];
            if (resultList[i] > max) {
                max = resultList[i];
            }
        }
        System.out.print(max);

    }
}