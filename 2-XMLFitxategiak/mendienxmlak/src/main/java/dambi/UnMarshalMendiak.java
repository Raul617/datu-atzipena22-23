package dambi;


import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;




public class UnMarshalMendiak
{
    public static void main( String[] args )
    {

        try
        {

            System.out.println(new File("").getAbsolutePath());
            
            File file = new File( "hirumendi.xml" );

            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );

            /**
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Mendiak mendiak = (Mendiak)jaxbUnmarshaller.unmarshal( file );
            System.out.println( mendiak );
            
            // para sacar solo la altura de cada monte de la lista
            for(int i = 0; i < mendiak.getMendiak().size();i++){

                float AltueraO = (mendiak.getMendiak().get(i).getAltuera()* 3.28084f) ;
                mendiak.getMendiak().get(i).setAltuera((int) (AltueraO));
            }

            //crea otro fichero mendiakaltueraoinatan.
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( mendiak, new File( "mendiakaltueraoinatan.xml" ) );
            jaxbMarshaller.marshal( mendiak, System.out );
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }

}
