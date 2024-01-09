package com.example.jj;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HelloApplication extends Application {

    private TextField userField;
    private TextField balanceField;
    private TextField banknameField;
    private PieChart chart;

    @Override
    public void start(Stage stage) throws IOException {
        Label userLabel = new Label("User:");
        userField = new TextField();
        Label balanceLabel = new Label("Balance:");
        balanceField = new TextField();
        Label banknameLabel = new Label("Bank name:");
        banknameField = new TextField();
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            BankAccountDAO.addInfo(userField.getText(), Double.parseDouble(balanceField.getText()), banknameField.getText());
            chart.setData(getData());
        });

        chart = new PieChart(getData());
        chart.setTitle("Bank Account");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(balanceLabel, 0, 1);
        grid.add(balanceField, 1, 1);
        grid.add(banknameLabel, 0, 2);
        grid.add(banknameField, 1, 2);
        grid.add(addButton, 1, 3);
        grid.add(chart, 0, 4, 2, 1);

        VBox root = new VBox(grid);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 800 , 600);
        stage.setTitle("Banks");
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<PieChart.Data> getData() {
        Map<String, List<BankAccount>> groupedBooks = BankAccountDAO.getInfo().stream()
                .collect(Collectors.groupingBy(book -> {
                    double balance = book.getBalance();
                    int interval = (int)Math.floor(balance / 500);
                    return (interval * 500) + "-" + ((interval + 1) * 500);

                }));

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (Map.Entry<String, List<BankAccount>> entry : groupedBooks.entrySet()) {
            String label = entry.getKey();
            int value = entry.getValue().size();
            data.add(new PieChart.Data(label, value));
        }

        return data;
    }


    public static void main(String[] args) {
        launch();
    }
}