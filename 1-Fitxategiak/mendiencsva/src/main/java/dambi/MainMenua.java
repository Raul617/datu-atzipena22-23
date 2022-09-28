package dambi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

/**
 * Hello world!
 *
 */
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
            System.out.println("1.- Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- 1000m > Mendiak");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    mendienlista();
                    break;
                case 2:
                    mendialtuena();
                    break;
                case 3:
                    mendiakesportatu();
                    break;
                case 4:
                    mendi1000();
                    break;
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
}

public static void mendienlista() throws IOException{
    BufferedReader inputStream = null;
    try {
        inputStream = new BufferedReader(new FileReader("mendiencsva/Mendiak.csv"));
        
        String banatzailea = ";";
        String l;
        while ((l = inputStream.readLine()) != null) {
            zutabeak = l.split(banatzailea);//split para separar en la linea
            System.out.printf("%10s | %8s | %10s ",zutabeak[0],zutabeak[1],zutabeak[2]);
            System.out.println();
        }
        inputStream.close();
    }
            
    catch (FileNotFoundException e) {
                System.out.println("File not Found");
            
    }
    
    }

    public static void mendialtuena() throws IOException{
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("mendiencsva/Mendiak.csv"));
            int lerrozenbakia = 0;
            String banatzailea = ";";
            String mendiak [] = null;
            String l;
            while ((l = inputStream.readLine()) != null) {
                zutabeak = l.split(banatzailea);
                if(lerrozenbakia != 0 && (mendiak == null || Integer.parseInt(mendiak[1])<Integer.parseInt(zutabeak[1]))){

                    mendiak = zutabeak;
                }     
                lerrozenbakia++;     
            }
            System.out.printf("Mendirik handiena honako hau da: " + "%10s | %8s | %10s ",mendiak[0],mendiak[1],mendiak[2]);
            inputStream.close();
        }
                
        catch (FileNotFoundException e) {
                    System.out.println("File not Found");
                
        }
        
        }

        public static void mendiakesportatu() throws IOException{
            BufferedReader inputStream = null;
            PrintWriter outputStreamN = null;
            PrintWriter outputStreamB = null;
            PrintWriter outputStreamA = null;
            PrintWriter outputStreamG = null;
            try {
                inputStream = new BufferedReader(new FileReader("mendiencsva/Mendiak.csv"));
                outputStreamA = new PrintWriter(new FileWriter("mendiencsva/Araba.csv"));
                outputStreamN = new PrintWriter(new FileWriter("mendiencsva/Nafarroa.csv"));
                outputStreamB = new PrintWriter(new FileWriter("mendiencsva/Bizkaia.csv"));
                outputStreamG = new PrintWriter(new FileWriter("mendiencsva/Gipuzkoa.csv"));
                int lerrozenbakia = 0;
                String banatzailea = ";";
                String l;
                while ((l = inputStream.readLine()) != null) {
                    zutabeak = l.split(banatzailea);
                    if(zutabeak[2].equals("Nafarroa")){
                        outputStreamN.println(l);
                    }     
                    else if(zutabeak[2].equals("Araba")){
                        outputStreamA.println(l);
                    }
                    else if(zutabeak[2].equals("Bizkaia")){
                        outputStreamB.println(l);
                    }
                    else if(zutabeak[2].equals("Gipuzkoa")){
                        outputStreamG.println(l);
                    }
                    
                }
                
  
                inputStream.close();
                outputStreamA.close();
                outputStreamB.close();
                outputStreamN.close();
                outputStreamG.close();
            }   
            catch (FileNotFoundException e) {
                        System.out.println("File not Found");
                    
            }

            }

            public static void mendi1000() throws IOException{
                BufferedReader inputStream = null;
                try {
                    inputStream = new BufferedReader(new FileReader("mendiencsva/Mendiak.csv"));
                    int lerrozenbakia = 0;
                    String banatzailea = ";";
                    String mendiak [] = null;
                    String l;
                    while ((l = inputStream.readLine()) != null) {
                        zutabeak = l.split(banatzailea);
                        if(lerrozenbakia != 0 &&  Integer.parseInt(zutabeak[1])>1000){
        
                            System.out.printf("%10s | %8s | %10s ",zutabeak[0],zutabeak[1],zutabeak[2] + "\n");
                        }     
                        lerrozenbakia++;     
                    
                    }
                    
                    inputStream.close();
                }
                        
                catch (FileNotFoundException e) {
                            System.out.println("File not Found");
                        
                }
                
                }

}
