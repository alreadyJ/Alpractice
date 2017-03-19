import java.util.Scanner;

/**
 * Created by user on 2017-03-17.
 */
public class CodeForce339B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m,  currentHome = 1, diff;
        long result = 0;
        String str;
        String[] works;
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        str = sc.nextLine();
        works = str.split(" ");

        for(int i = 0; i < m; i++) {
            diff = Integer.parseInt(works[i]) - currentHome;
            if (diff >= 0) {
                result += diff;
            }else {
                result += (n + diff);
            }
            currentHome = Integer.parseInt(works[i]);
        }

        System.out.print(result);

    }
}
