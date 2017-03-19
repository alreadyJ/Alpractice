import java.util.Scanner;

/**
 * Created by user on 2017-03-17.
 */
public class CodeForce158B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int count = 0, one = 0, two = 0, three = 0, four = 0;
        String str;
        n = sc.nextInt();
        sc.nextLine();
        str = sc.nextLine();
        String[] groups = str.split(" ");
        for (int i = 0; i < n; i++) {
            switch (Integer.parseInt(groups[i])) {
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                default:
                    break;
            }
        }


        count += four;

        if (three >= one) {
            one = 0;
        }else {
            one -= three;
        }
        count += three;

        if (two % 2 == 0) {
            count += (two / 2);
        }else {
            count += ((two - 1) / 2);

            if (one > 1) {
                one -= 2;
                count++;
            }else if (one == 1){
                one -= 1;
                count++;
            }else {
                count++;
            }
        }

        int x = one / 4;
        int y = one % 4;

        count += (x);

        if (y > 0) {
            count++;
        }
    }
}
