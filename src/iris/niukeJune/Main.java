package iris.niukeJune;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] a = new int[3];
            int[] b = new int[3];
            int suma = 0;
            int sumb = 0;
            int[] t = {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
            for (int i = 0; i < 3; i++) {
                a[i] = sc.nextInt();
                suma += a[i];
                t[a[i]]--;
            }
            for (int i = 0; i < 3; i++) {
                b[i] = sc.nextInt();
                sumb += b[i];
                t[b[i]]--;
            }

            int dz = suma - sumb;
            int nw = 0;
            for (int i = 1; i <= 13; i++) {
                if (t[i] > 0) {
                    t[i]--;
                    int tmp = 0;
                    for (int j = 1; j <= 13 ; j++) {
                        if (j < (i+dz))
                            tmp += t[j];
                    }
                    t[i]++;
                    nw += t[i] * tmp;

                }
            }

            System.out.printf("%.4f",nw/(46.0*45.0));
            System.out.println();
        }
    }
}