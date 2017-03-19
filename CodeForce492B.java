import java.util.Scanner;

/**
 * Created by user on 2017-03-16.
 */
public class CodeForce492B {
    public static void main(String[] args) {
        int n, l;
        String str;
        double max = 0.0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        int[] lanterns = new int[n];
        sc.nextLine();
        str = sc.nextLine();
        for (int i = 0; i < n; i++) {
            lanterns[i] = Integer.parseInt(str.split(" ")[i]);
        }

        for (int i = 0; i < lanterns.length - 1; i++) {
            for (int j = i + 1; j < lanterns.length; j++) {
                if (lanterns[i] > lanterns[j]) {
                    int tmp = lanterns[i];
                    lanterns[i] = lanterns[j];
                    lanterns[j] = tmp;
                }
            }
        } // sorting

        for (int i = 0; i < lanterns.length - 1; i++) {
            int difference = lanterns[i + 1] - lanterns[i];
            if (difference > max) {
                max = difference;
            }
        }
        max /= 2;
        int first = lanterns[0] - 0;
        int last = l - lanterns[n - 1];

        if (first > max) {
            max = first;
        }
        if (last > max) {
            max = last;
        }

        System.out.print(max);

    }
}
