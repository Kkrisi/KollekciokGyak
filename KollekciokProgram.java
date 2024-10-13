package main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;




public class KollekciokProgram {

    private static final Random rnd = new Random();
    
    private static ArrayList<Integer>egeszek;
    private static HashSet<Integer>kulonbozoek;
    private static HashMap<Integer, Integer> statisztika;
    
    
    
    public static void main(String[] args) {
        egeszek = new ArrayList<>();
        feltolt();
        kiirLista("Páros és páratlan: ");
        kiveszParatlant();
        kiirLista("csak páros: ");
        kulonbozoek();
        kiirHalmaz();
        melyikbolMennyi();
        kiirMap();
    }

    
    
    
    private static void feltolt() {
        for (int i = 0; i < 20; i++) {
            egeszek.add(rnd.nextInt(10,  21));
        }
    }

    
    
    
    
    private static void kiirLista(String cim) {
        System.out.println(cim);
        for (int szam : egeszek) {
            System.out.print(szam + " ");
        }
        System.out.println("");
    }

    
    
    
    
    private static void kiveszParatlant() {
        for (int i = egeszek.size()-1; i >=0 ; i--) {
            if(egeszek.get(i) % 2 == 1){
                egeszek.remove(i);
            }
        }
    }

    
    
    
    
    private static void kulonbozoek() {
        kulonbozoek = new HashSet<>(egeszek);
    }

    
    
    
    
    private static void kiirHalmaz() {
        System.out.println("Különböző elemek: ");
        for (int szam : kulonbozoek) {
            System.out.print(szam + " ");
        }
        System.out.println("");
    }

    
    
    
    
    private static void melyikbolMennyi() {
        statisztika = new HashMap<>();
        for (int szam : egeszek) {
            int kulcs = szam;
            if(statisztika.containsKey(kulcs)){
                //a meglévő értéket növeljük
                int ertek = statisztika.get(kulcs);
                statisztika.put(kulcs, ++ertek);
            }else{
                //létrehozzuk a kulcsot 1 értékkel
                statisztika.put(kulcs, 1);
            }
        }
    }

    
    
    
    
    private static void kiirMap() {
        System.out.println("Melyikből mennyi:");
        /*form tab */
        
        for(Map.Entry<Integer, Integer> entry : statisztika.entrySet()){
            int kulcs = entry.getKey();
            int ertek = entry.getValue();
            String s = "[%d] = %d%n".formatted(kulcs, ertek);
            System.out.printf(s);
        }
        
    }
}
