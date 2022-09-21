package dambi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia lerroz irakurtzen du, 
    * lerro bakoitzaren zenbakia eta lerro osoa characteroutput.txt fitxategian idatziz.
    */
public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("iostreams/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("iostreams/characteroutput.txt"));
            int lerroa = 1;
            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(lerroa + " - " + l);
                lerroa++;
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
