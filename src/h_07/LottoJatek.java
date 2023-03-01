package h_07;

import static h_07.H_07.feltolt;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tóth Milán
 */
public class LottoJatek {

    private static int ellenorzottSzelvenyek;

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
     * Bekéri a számokat
     *
     * @return
     */
    public static Integer[] beker() {

        Integer[] userTippek;
        ArrayList<Integer> tippekMasolata = new ArrayList<>();

        try ( Scanner be = new Scanner(System.in)) {

            // Ameddig 3-nál több vagy 0-nál kevesebb szelvényt add meg
            do {
                out.print("Hány szelvényt ellenőrizzek? ");
                ellenorzottSzelvenyek = be.nextInt();
            } while (ellenorzottSzelvenyek < 0 || ellenorzottSzelvenyek > 3);

            // Akkor lesz a tömb, ahány elemet megad a felhasználó
            userTippek = new Integer[ellenorzottSzelvenyek];

            // Annyi számot kér be, amennyit a felhasználó megadott
            for (int i = 0; i < ellenorzottSzelvenyek; i++) {

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

                    // Az 1. rossz probálkozásnál nem címezhetünk túl a tömbön
                    if (i > 0) {
                        i--;
                    }
                    i = 0;
                }

                tippekMasolata.add(szam);
                userTippek[i] = szam;

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
        for (int i = 0; i < ellenorzottSzelvenyek; i++) {
            if (tippek[i] == lottoSzamok[i]) {
                talalatok++;
            }
        }

        return talalatok;
    }
}
