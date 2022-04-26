package pl.lublin.wsei.java.cwiczenia.lab2c.samodzielnie;
import java.util.ArrayList;
public class Noblista {
    String  Imie, Nazwisko, Rok, Kategoria, Uzasadnienie, Kraj, DataRow;
    public Noblista(String datarow){
        DataRow=datarow;
        Split();
    }
    void Split(){
       ArrayList<String> colums = new ArrayList<>();

       int TextStart=0;
       int TextEnd=0;
       char[] textArray = this.DataRow.toCharArray();

       for (int i=0; i< textArray.length; i++){
           TextEnd++;

       }
        for (int i=0; i < colums.size(); i++ ){
                switch (i){
                    case 1:
                        this.Imie=colums.get(i);
                        break;
                    case 2:
                        this.Nazwisko=colums.get(i);
                        break;
                    case 12:
                        this.Rok=colums.get(i);
                        break;
                    case 13:
                        this.Kategoria=colums.get(i);
                        break;
                    case 12:
                        this.Rok=colums.get(i);
                        break;
                    case 12:
                        this.Rok=colums.get(i);
                        break;
                }
        }
    }
}
