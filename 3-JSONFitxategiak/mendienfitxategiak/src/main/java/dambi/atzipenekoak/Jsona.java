package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class Jsona {
    
    Mendiak mendiak;
    
    private String strFileIn;
    private String strFileOut;
    static String[] zutabeak;

    public Jsona(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Jsona(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Mendiak irakurri(){
        Mendiak mendiak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            mendiak = new Mendiak();
            for(int i = 0; i< jsonarray.size();i++){
                JsonObject jsonobj = jsonarray.getJsonObject(1);
                Mendia mendia = new Mendia();
                mendia.setId(jsonobj.getInt("id"));
                mendia.setMendia(jsonobj.getString("Mendia"));
                mendia.setAltuera(jsonobj.getInt("Altuera"));
                mendia.setProbintzia(jsonobj.getString("Probintzia"));
                mendiak.add(mendia);
            }
      
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " Fitxategia irakurtzerakoan");
        }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak){

        int mendiKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for(Mendia m : mendiak.getMendiak()){
            jab.add(Json.createObjectBuilder()  
            .add("Id", m.getId())
            .add("Mendia", m.getMendia())
            .add("Altuera", m.getAltuera())
            .add("Probintzia", m.getProbintzia())
            .build()
            );
            mendiKopurua++;
        }
        model = jab.build();

        try(JsonWriter JsonWriter = Json.createWriter(new FileOutputStream(strFileOut))){
            JsonWriter.writeArray(model);
        }
        catch (FileNotFoundException fnfe){
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return mendiKopurua;
    }
}
