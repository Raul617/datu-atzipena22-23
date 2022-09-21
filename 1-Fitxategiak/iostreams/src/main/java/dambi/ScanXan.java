package dambi;

import java.io.*;
import java.util.Scanner;
    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia hitz hitzez irakurtzen du, 
    * hitz bakoitza xanadu.txt fitxategian berriz idatziz.
    */
public class ScanXan {
    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("iostreams/xanadu.txt")));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
