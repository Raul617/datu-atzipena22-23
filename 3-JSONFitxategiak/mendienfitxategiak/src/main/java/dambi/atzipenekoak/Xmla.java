package dambi.atzipenekoak;

import dambi.pojoak.Mendiak;

public class Xmla {

    Mendiak mendiak; 

    private String strFileIn;
    private String strFileOut;
    static String[] zutabeak;

    public Xmla(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Xmla(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }
    
}
