/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tippmixnativ;

/**
 *
 * @author asus
 */
public class TippmixNativ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // String [][] meccsek = new String [1][10];
       String [][] meccsek = {
           {"a1","Manchester United - Liverpool", "H"},
           {"a2","Manchester United - Liverpool", "H"},
           {"a3","Manchester United - Liverpool", "D"},
           {"a4","Manchester United - Liverpool", "H"},
           {"a5","Manchester United - Liverpool", "H"},
           {"a6","Manchester United - Liverpool", "H"},
           {"a7","Manchester United - Liverpool", "H"},
           {"a8","Manchester United - Liverpool", "H"},
           {"a9","Manchester United - Liverpool", "H"},
           {"a10","Manchester United - Liverpool", "H"}
       };
       
       Double[][] oddsok = {
           {1.83,2.82,3.1},
           {1.83,2.82,3.1},
           {1.83,2.82,3.1},
           {1.83,2.82,3.1},
           {1.83,2.82,3.1},
           {1.83,2.82,3.1},
           {1.83,2.82,3.1},
           {1.83,2.82,3.1},
           {1.83,2.82,3.1},
           {1.83,2.82,3.1}
       };
       
       String tipp[] = {"a3","D"};
       String tobbtipp [][] = {{"a1","H"},{"a234","D"},{"a3","H"}};
       //TippmixNativ.jatek1(meccsek, tipp);
       //TippmixNativ.jatek2(meccsek, tobbtipp);
       TippmixNativ.jatek3(meccsek, tipp, oddsok, 1000);
       
       
    }
    
    public static void jatek1(String[][] meccsek, String[] tipp){
        int szamlalo = 0;
        for(String[] meccs: meccsek){
            if(meccs[0].equals(tipp[0]) && meccs[2].equals(tipp[1])){
                System.out.println("Győztes");
                break;
            }
            else if(meccs[0].equals(tipp[0]) && !(meccs[2].equals(tipp[1]))){
                System.out.println("Vesztes");
                break;
            }
            else{
                szamlalo ++;
            }
            
            
        }
        if(szamlalo == meccsek.length){
            System.out.println("Érvénytelen tipp");
        }
    }
    
    public static void jatek2(String[][] meccsek, String[][] tippek){
        int gyoztes = 0;
        int vesztes = 0;
        int szamlalo = 0;
        for(String[] meccs: meccsek){
            for(String[] tipp : tippek)
            if(meccs[0].equals(tipp[0]) && meccs[2].equals(tipp[1])){
                gyoztes++;
            }
            else if(meccs[0].equals(tipp[0]) && !(meccs[2].equals(tipp[1]))){
                vesztes ++;
            }
            else{
                szamlalo ++;
            }
        }
        
        if(tippek.length == gyoztes){
            System.out.println("Minden tipp győztes volt, nyertél");
        }
        else if(vesztes > 0){
            System.out.println("Legalább egy tipped helytelen, vesztettél!");
        }
        else{
            System.out.println("Érvénytelen szelvény");
        }
    }
    
    public static void jatek3 (String[][] meccsek, String[] tipp, Double[][] oddsok, int tet){
        int szamlalo = 0;
        for(int i=0; i < meccsek.length ; i++){
            String[] meccs = meccsek[i];
            if(meccs[0].equals(tipp[0]) && meccs[2].equals(tipp[1])){
                Integer kimenetel = 0;
                if(tipp[1].equals("H")){
                    kimenetel = 0;
                }
                if(tipp[1].equals("D")){
                    kimenetel = 1;
                }
                if(tipp[1].equals("V")){
                    kimenetel = 2;
                }
                System.out.println("Győztes, a nyeremény: " + tet * oddsok[i][kimenetel]);
                break;
            }
            else if(meccs[0].equals(tipp[0]) && !(meccs[2].equals(tipp[1]))){
                System.out.println("Vesztes");
                break;
            }
            else{
                szamlalo ++;
            }
            
            
        }
        if(szamlalo == meccsek.length){
            System.out.println("Érvénytelen tipp");
        }
    }
    
    
    
}
