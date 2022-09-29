package dambi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia bytez byte irakurtzen du, 
    * byte bakoitza characteroutput.txt fitxategian idatziz, ez badu aurkitzen fitxategia mezu bat ateratzen da.
    */
public class CopyBytesFNEKontrolatuz {
    public static void main(String[] args) throws IOException {



        try(FileReader inputStream = new FileReader("iostreams/xanadug.txt");FileWriter outputStream = new FileWriter("iostreams/characteroutput.txt");) {
            

            int c;
            
            while ((c = inputStream.read()) != -1) {
                c=Character.toUpperCase(c);
                    outputStream.write(c); 
            }
        }catch (FileNotFoundException e) {
                System.out.println("File not Found");
            
        } 
    }
}
