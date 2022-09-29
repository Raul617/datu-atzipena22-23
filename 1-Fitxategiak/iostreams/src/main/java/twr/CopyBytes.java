package dambi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia bytez byte irakurtzen du, 
    * byte bakoitza outagain.txt fitxategian idatziz.
    */
public class CopyBytes {
    public static void main(String[] args) throws IOException {



        try(FileInputStream in = new FileInputStream("iostreams/xanadu.txt");FileOutputStream out = new FileOutputStream("iostreams/outagain.txt");) {
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
         
        }
    }
}
