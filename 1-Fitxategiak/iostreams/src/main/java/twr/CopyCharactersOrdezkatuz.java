package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia karaktere karaktere irakurtzen du, 
    * karaktere bakoitza characteroutput.txt fitxategian idatziz, karakterea a baldin bada "o"-gatik ordezkatzen du..
    */
public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {


        try(FileReader inputStream = new FileReader("iostreams/xanadu.txt");FileWriter outputStream = new FileWriter("iostreams/characteroutput.txt");) {
            
            

            int c;
            while ((c = inputStream.read()) != -1) {
                if(c=='a'){
                   outputStream.write('o'); 
                }
                else{
                    outputStream.write(c); 
                }
            }
        } 
    }
}
