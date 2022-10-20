package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class XmltikCsvra {
    public static void main(String[] args) {

        Xmla xmla = new Xmla("data/Mendiak.xml");
        Csva csva = new Csva("","data/Bizkaia.csv");

        Mendiak mendiak = xmla.irakurri();
        Mendiak bizkaikoak = new Mendiak();

        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getProbintzia().equals("Bizkaia")) {
                    bizkaikoak.add(m);
                }
            }

            System.out.println(csva.idatzi(bizkaikoak) + " mendi idatzi dira xml fitxategian.");
        }


    }
}
