package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class Csva {
    
    Mendiak mendiak;
    
    private String strFileIn;
    private String strFileOut;
    static String[] zutabeak;

    public Csva(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Csva(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Mendiak irakurri() {
      
        BufferedReader inputStream = null;
    try {
        inputStream = new BufferedReader(new FileReader(strFileIn));
        
        String banatzailea = ";";
        String l;
        Mendia mendia = new Mendia();
        int i= 0;
        while ((l = inputStream.readLine()) != null) {
            zutabeak = l.split(banatzailea);//split para separar en la linea
            mendia.setId(i); //  añades el id
            mendia.setMendia(zutabeak[0]); //  añades el nombre
            mendia.setAltuera(Integer.parseInt(zutabeak[1])); //  añades la Altura
            mendia.setProbintzia(zutabeak[2]); //  añades la Probintzia
            i++; // va sumando de 1 en 1 el id
            mendiak.add(mendia);
        }
        inputStream.close();
    }
            
    catch (Exception e) {
                System.out.println("File not Found");
            
    }
    return mendiak;
    }

    public int Idatzi(Mendiak mendiak) {
        int mendikopurua = 0;


            try (PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut))){            
                for(Mendia m : mendiak.getMendiak()){
                    if(mendikopurua==0){

                        outputStream.println("MENDIA;ALTUERA;PROBINTZIA");
                    }
                    mendikopurua++;

                    outputStream.println(m.getMendia() + ";" +m.getAltuera() + ";" + m.getProbintzia());
                }

            }   
            catch (Exception e) {
                        System.out.println(strFileOut + "Errorea gertatu da.");
                    
            }
            return mendikopurua;

    }

}
