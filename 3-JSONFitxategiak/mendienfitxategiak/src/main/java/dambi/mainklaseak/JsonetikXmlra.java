package dambi.mainklaseak;


import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class JsonetikXmlra {
    public static void main(String[] args) {

        Jsona jsona = new Jsona("data/Mendiak.json");
        Xmla xmla = new Xmla("","data/Nafarroa.xml");
        Mendiak mendiak = jsona.irakurri();
        Mendiak nafarrokoak = new Mendiak();

        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getProbintzia().equals("Nafarroa")) {
                    nafarrokoak.add(m);
                }
            }

            System.out.println(xmla.idatzi(nafarrokoak) + " mendi idatzi dira xml fitxategian.");
        }


    }
}
