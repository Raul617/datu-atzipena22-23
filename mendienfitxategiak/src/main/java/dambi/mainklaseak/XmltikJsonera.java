package dambi.mainklaseak;

import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class XmltikJsonera {
    public static void main(String[] args) {

        Xmla xmla = new Xmla("data/Mendiak.xml");
        Jsona jsona = new Jsona("","data/Bizkaia.json");

        Mendiak mendiak = xmla.irakurri();
        Mendiak bizkaikoak = new Mendiak();

        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getProbintzia().equals("Bizkaia")) {
                    bizkaikoak.add(m);
                }
            }

            System.out.println(jsona.idatzi(bizkaikoak) + " mendi idatzi dira xml fitxategian.");
        }


    }
}
