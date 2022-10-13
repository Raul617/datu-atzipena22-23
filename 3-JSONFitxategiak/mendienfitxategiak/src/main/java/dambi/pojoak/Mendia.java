package dambi.pojoak;




import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;





@XmlType( propOrder = { "mendia", "altuera", "probintzia"} )
@XmlRootElement( name = "Mendia" )

public class Mendia {
    int id = 0;

    String mendia; 

    int altuera;

    String probintzia;



    @XmlAttribute( name = "id" )
    public void setId(int id){

        this.id = id;
    }

    public int getId(){

        return id;
    }

    @XmlElement( name = "Mendia" )
    public void setMendia(String mendia){

        this.mendia = mendia;
    }

    public String  getMendia(){

        return mendia;
    }

    public int getAltuera(){

        return altuera;
    }

    @XmlElement( name = "Altuera" )
    public void setAltuera(int altuera){

        this.altuera = altuera;
    }

    public String getProbintzia(){

        return probintzia;
    }

    @XmlElement( name = "Probintzia" )
    public void setProbintzia(String probintzia){

        this.probintzia = probintzia;
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer("Id: " + getId() + "\n");
        str.append( "Mendia: " + getMendia() + "\n" );
        str.append( "Altuera: " + getAltuera() + "\n" );
        str.append("Probintzia: " + getProbintzia() + "\n");

        return str.toString();
    }

}
