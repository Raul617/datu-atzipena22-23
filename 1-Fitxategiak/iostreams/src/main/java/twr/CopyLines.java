package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia lerroz lerro irakurtzen du, 
    * lerro bakoitza characteroutput.txt fitxategian idatziz.
    */
public class CopyLines {
    public static void main(String[] args) throws IOException {




        try(BufferedReader inputStream = new BufferedReader(new FileReader("iostreams/xanadu.txt"));PrintWriter outputStream = new PrintWriter(new FileWriter("iostreams/characteroutput.txt"));) {
            
            

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } 
    }
}
