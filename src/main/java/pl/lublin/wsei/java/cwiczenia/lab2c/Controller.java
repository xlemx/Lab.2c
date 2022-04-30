package pl.lublin.wsei.java.cwiczenia.lab2c;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.lublin.wsei.java.cwiczenia.lab2c.samodzielnie.Noblista;
import pl.lublin.wsei.java.cwiczenia.lab2c.samodzielnie.NoblistaMain;

import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    public TableColumn Name;
    public TableColumn Surname;
    public TableColumn Year;
    public TableColumn Category;
    public TableColumn Motivation;
    public TableColumn Country;
    public TableView Table;

    public static NoblistaMain main = new NoblistaMain();

    public void openFile(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (.xml)", ".xml");

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            main.LoadFile(file.getAbsolutePath());
            doTable();
        }
    }
private  final ObservableList<Noblista> data= FXCollections.observableArrayList();
    void doTable() {
        data.clear();
        Table.setItems(data);

        Name.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Imie")
        );

        Surname.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Nazwisko")
        );

        Year.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Rok")
        );

        Category.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Kategoria")
        );

        Motivation.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Uzasadnienie")
        );

        Country.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Kraj")
        );


        for(int i =0 ; i < main.noblista.size(); i++){
            data.add(main.noblista.get(i));
        }

    }

    public void exportFile(ActionEvent actionEvent) {

        if (main.noblista.size()<=0){
            return;
        }

        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("export.fxml"));
            Parent root = loader.load();
            (loader.<Export>getController()).noblistaMain=main;
            Stage stage = new Stage();
            stage.setTitle("Eksport Plikow");
            stage.setScene(new Scene(root, 424, 226));
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}