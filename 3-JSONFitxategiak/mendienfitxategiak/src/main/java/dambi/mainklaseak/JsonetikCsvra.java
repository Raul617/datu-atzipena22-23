package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class JsonetikCsvra {
    public static void main(String[] args) {

        Jsona jsona = new Jsona("data/Mendiak.json");
        Csva csva = new Csva("","data/Nafarroa.csv");
        Mendiak mendiak = jsona.irakurri();
        Mendiak nafarroa = new Mendiak();

        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getProbintzia().equals("Nafarroa")) {
                    nafarroa.add(m);
                }
            }

            System.out.println(csva.idatzi(nafarroa) + " mendi idatzi dira xml fitxategian.");
        }


    }
}
