import com.sun.javafx.scene.control.DoubleField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Date;

public class Market extends Application {

    private ObservableList<Products> products = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Market Inventory");

        TextField nameField = new TextField();
        TextField idField = new TextField();
        DoubleField priceField = new DoubleField();
        DatePicker datePicker = new DatePicker();

        Button addButton = new Button("add Product");

        TableView<Products> productsTableView = new TableView<>();
        productsTableView.setItems(products);

        TableColumn<Products, Integer> idColumn = new TableColumn<>("id");
//        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());

        TableColumn<Products, String> nameColumn = new TableColumn<>("name");

        TableColumn<Products, Double> priceColumn = new TableColumn<>("price");
//        priceColumn.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());


        TableColumn<Products, Date> dateColumn = new TableColumn<>("date");


    }
}
