package dambi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.StubNotFoundException;
import java.util.Scanner;

public class MainMenua 
{
    static String[] zutabeak;        

    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        int aukera = 0;

        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Karpeta edo fitxeroa bilatu");
            System.out.println("2.- Karpetaren edukia bistaratu");
            System.out.println("3.- Fitxategia sortu");
            System.out.println("4.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    bilatu();
                    break;
                case 2:
                    edukiBistaratu();
                    break;
                case 3:
                    fitxategiaSortu();
                    break;
                case 4:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
}

public static void bilatu(){
    Scanner in = new Scanner(System.in);

    System.out.println("Sartu karpetaren izena: ");   

    String karpeta= in.nextLine();

    File f = new File(karpeta);
        if (f.exists()) {
            System.out.println("Karpeta existitzen da");
        }
        else{
            System.out.println("Karpeta ez da existitzen.");
        }
}

public static void edukiBistaratu() throws IOException{
    Scanner in = new Scanner(System.in);

    System.out.println("Sartu karpetaren izena: ");   

    String karpeta= in.nextLine();

    File f = new File(karpeta);
        if (f.exists()) {
            System.out.println("EDUKIERA");

            BufferedReader obj = new BufferedReader(new FileReader(karpeta));

            String strng;
            while ((strng = obj.readLine()) != null)
                System.out.println(strng);
        }
        else{
            System.out.println("Karpeta ez da existitzen.");
        }
    }


public static void fitxategiaSortu() throws IOException{
    Scanner in = new Scanner(System.in);

    System.out.println("Zer zoaz deskribatzera?");   
    String karpeta= in.next();

    System.out.println("Zein?");   
    String fitxategia= in.next();

    System.out.println("Nolakoa da?");
    in.nextLine();
    String deskribapena= in.nextLine();

    if(karpeta.toLowerCase().equals("arrainak") || karpeta.toLowerCase().equals("ugaztunak")){

        File f = new File("C:\\Users\\parra.raul\\Desktop\\Datu Atzipena\\1-Fitxategiak\\fileio\\src\\karpeta_berriak\\animaliak\\" + karpeta + "\\" + fitxategia + ".txt" );
            if(f.createNewFile()){
                BufferedWriter obj = new BufferedWriter(new FileWriter(f));
                obj.write(deskribapena);
                obj.close();
                System.out.println("Fitxategia gorde da.");
            }



    }

    if(karpeta.toLowerCase().equals("barazkiak") || karpeta.toLowerCase().equals("esnekiak")){

        File f = new File("C:\\Users\\parra.raul\\Desktop\\Datu Atzipena\\1-Fitxategiak\\fileio\\src\\karpeta_berriak\\elikagaiak\\"+ karpeta + "\\" + fitxategia + ".txt" );
        if(f.createNewFile()){
            BufferedWriter obj = new BufferedWriter(new FileWriter(f));
            obj.write(deskribapena);
            obj.close();
            System.out.println("Fitxategia gorde da.");
        }


    }


}   

}
