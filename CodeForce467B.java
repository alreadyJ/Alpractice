import java.util.Scanner;

public class CodeForce467B {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n, m, k, my, count = 0, countOne;
        String str;
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int[] others = new int[m];
        for (int i = 0; i < m; i++) {
            others[i] = sc.nextInt();
        }
        my = sc.nextInt();

        for (int i = 0; i < m; i++) {
            str = Integer.toBinaryString(my^others[i]);
            countOne = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    countOne++;
                }
            }
            if (countOne <= k) {
                count++;
            }
        }
        System.out.println(count);

    }

}