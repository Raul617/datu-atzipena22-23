package dambi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


public class MendiakCSVtoXML {
    private static String[] zutabeak;
    public static void main(String[] args) throws IOException {
            Mendiak mendiak = new Mendiak();
            BufferedReader inputStream = null;
            try {
            
                inputStream = new BufferedReader(new FileReader("C:\\Users\\parra.raul\\Desktop\\Datu Atzipena\\2-XMLFitxategiak\\mendienxmlak\\Mendiak.csv"));
                
                String banatzailea = ";";
                String l;
                int i = 0;
                while ((l = inputStream.readLine()) != null) {
                    if(i!=0){
                    zutabeak = l.split(banatzailea);//split para separar en la linea
                    Mendia mendia = new Mendia();
                    mendia.setMendia(zutabeak[0]);
                    mendia.setAltuera(Integer.parseInt(zutabeak[1]));
                    mendia.setProbintzia(zutabeak[2]);
                    mendiak.add(mendia);
                }
                i++;
                }
                inputStream.close();


            }
                    
            catch (FileNotFoundException e) {
                        System.out.println("File not Found");
                    
            }
            try
            {
    
                /* init jaxb marshaler */
                JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    
                /* set this flag to true to format the output */
                jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
    
                /* marshaling of java objects in xml (output to file and standard output) */
                jaxbMarshaller.marshal( mendiak, new File( "Mendiak.xml" ) );
                jaxbMarshaller.marshal( mendiak, System.out );
            }
            catch( JAXBException e )
            {
                e.printStackTrace();
            }

    }
}
