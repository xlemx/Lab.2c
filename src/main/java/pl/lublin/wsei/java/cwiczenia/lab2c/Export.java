package pl.lublin.wsei.java.cwiczenia.lab2c;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import pl.lublin.wsei.java.cwiczenia.lab2c.Controller;
import pl.lublin.wsei.java.cwiczenia.lab2c.samodzielnie.Noblista;
import pl.lublin.wsei.java.cwiczenia.lab2c.samodzielnie.NoblistaMain;

import java.io.*;
import java.util.ArrayList;

public class Export {
    public NoblistaMain noblistaMain;
    ArrayList<Noblista> NobelExport = new ArrayList<>();
    @FXML
    public TextField textYear;
    public TextField textCategory;
    public TextField textCountry;

    public void Export(ActionEvent actionEvent) throws FileNotFoundException {


        NobelExport.clear();

        boolean delete = false;
        String TextFilterYear = textYear.getText();
        if(TextFilterYear == null) TextFilterYear = "";
        if(TextFilterYear != ""){
            for (int i = 0; i < noblistaMain.noblista.size(); i++) {
                if(noblistaMain.noblista.get(i).getRok().equals(TextFilterYear)){
                    NobelExport.add(noblistaMain.noblista.get(i));
                }
            }
            delete = true;
        }


        String TextFilterCountry = textCountry.getText();
        if(TextFilterCountry == null) TextFilterCountry = "";
        if(!TextFilterCountry.equals("")){
            if(NobelExport.size() > 0 && delete){
                for (int i = 0; i < NobelExport.size(); i++) {
                    if(!NobelExport.get(i).getKraj().equals(TextFilterCountry)){
                        NobelExport.remove(i);
                        i--;
                    }
                }
            }
            else if(NobelExport.size() <= 0 && !delete){
                for (int i = 0; i < noblistaMain.noblista.size(); i++) {
                    if(noblistaMain.noblista.get(i).getKraj().equals(TextFilterCountry)){
                        NobelExport.add(noblistaMain.noblista.get(i));
                    }
                }
                delete = false;
            }
        }

        if(NobelExport.size() > 0){
            delete = true;
        }


        String TextFilterCategory = textCategory.getText();
        if(TextFilterCategory == null) TextFilterCategory = "";
        if(!TextFilterCategory.equals("")){
            if(NobelExport.size() > 0 && delete){
                for (int i = 0; i < NobelExport.size(); i++) {
                    if(!NobelExport.get(i).getKategoria().equals(TextFilterCategory)){
                        NobelExport.remove(i);
                        i--;
                    }
                }
            }
            else if(NobelExport.size() <= 0 && !delete){
                for (int i = 0; i < noblistaMain.noblista.size(); i++) {
                    if(noblistaMain.noblista.get(i).getKategoria().equals(TextFilterCategory)){
                        NobelExport.add(noblistaMain.noblista.get(i));
                    }
                }
            }
        }


        if(TextFilterCountry != "" && TextFilterYear != "" && TextFilterCategory != "" && NobelExport.size() <= 0){
            return;
        }

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT pliki (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File fileSave = fileChooser.showSaveDialog(null);
        String pathToSave = fileSave.getAbsolutePath();

        PrintStream out2 = null;
        try{
            out2 = new PrintStream(new FileOutputStream(pathToSave));
            if(NobelExport.size() > 0){
                for (int i = 0; i < NobelExport.size(); i++) {
                    out2.println(NobelExport.get(i).getDataRow());
                }
            }else{
                for (int i = 0; i < noblistaMain.noblista.size(); i++) {
                    out2.println(noblistaMain.noblista.get(i).getDataRow());
                }
            }
        }catch (IOException e){
            e.getMessage();
        }
        finally {
            out2.close();
        }
    }
}


