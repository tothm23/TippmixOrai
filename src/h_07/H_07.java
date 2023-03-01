package h_07;

import java.util.Random;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tóth Milán
 */
public class H_07 {

    public static void main(String[] args) {
        int[] lottoSzamok = feltolt();
        Integer[] tippek = beker();

        out.println("\nTalálatok száma: " + lotto(lottoSzamok, tippek));

        out.println("\nNyertes szelvény: ");
        for (int elem : lottoSzamok) {
            out.print(elem + " ");
        }

        out.println("\n\nTipp szelvény: ");

        for (Integer elem : tippek) {
            out.print(elem + " ");
        }

        out.println();

    }

    /**
     * Feltölti
     *
     * @return a tömböt
     */
    public static int[] feltolt() {

        int[] lottoSzamok = new int[5];
        ArrayList<Integer> lottoSzamokMasolata = new ArrayList<>();

        // Feltölti véletlen számokkal
        for (int i = 0; i < lottoSzamok.length; i++) {
            int veletlen = veletlenSzam(1, 91);

            // Ha van ismétlődés
            if (lottoSzamokMasolata.contains(veletlen)) {
                veletlen = veletlenSzam(1, 91);
                i--;
            }

            lottoSzamok[i] = veletlen;
            lottoSzamokMasolata.add(veletlen);
        }

        return lottoSzamok;
    }

    /**
     * Legenerálja a véletlen számot
     *
     * @param min
     * @param max
     * @return
     */
    public static int veletlenSzam(int min, int max) {
        return new Random().nextInt(min, max);
    }

    /**
     * Bekéri a számokat
     *
     * @return
     */
    public static Integer[] beker() {

        Integer[] userTippek = new Integer[5];
        ArrayList<Integer> tippekMasolata = new ArrayList<>();

        try ( Scanner be = new Scanner(System.in)) {
            // 5 számot fog bekérni
            for (int i = 0; i < userTippek.length; i++) {

                out.print("A(z) " + (i + 1) + ". szám: ");
                int szam = be.nextInt();

                // Ha van ismétlődés
                if (tippekMasolata.contains(szam)) {
                    out.println("Ilyen tipp már van!");
                    i--;
                }

                // Ha érvénytelenek a tippek
                if (szam < 1 || szam > 90) {
                    out.println("A tippnek 1-90 között kell lennnie!");
                    i--;
                }

                userTippek[i] = szam;
                tippekMasolata.add(szam);
            }
        }

        return userTippek;

    }

    /**
     * Ellenőrzi a tippeket
     *
     * @param lottoSzamok
     * @param tippek
     * @return
     */
    public static int lotto(int[] lottoSzamok, Integer[] tippek) {

        int talalatok = 0;

        // Ha egyezik a tipp az adott lottószámmal
        for (int i = 0; i < tippek.length; i++) {
            if (tippek[i] == lottoSzamok[i]) {
                talalatok++;
            }
        }

        return talalatok;
    }

}
