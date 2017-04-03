import java.util.Arrays;
import java.util.Scanner;

public class CodeForce490B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String input;
        int[] list = new int[1000001];
        int[] list2 = new int[1000001];
        Arrays.fill(list, 0);
        Arrays.fill(list2, 0);
        n = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            input = sc.nextLine();
            list[Integer.parseInt(input.split(" ")[0])] = Integer.parseInt(input.split(" ")[1]);
            list2[Integer.parseInt(input.split(" ")[0])]++;
            list2[Integer.parseInt(input.split(" ")[1])]--;
        }

        int i = 0;
        while(true) {
            if (list2[i] == 1) {
                break;
            }
            i++;
        }
        int j = list[0];
        while(i != 0 && j != 0) {
            System.out.print(i + " ");
            System.out.print(j + " ");
            i = list[i];
            j = list[j];
        }
        if (n % 2 == 1) {
            System.out.print(i);
        }

    }

}