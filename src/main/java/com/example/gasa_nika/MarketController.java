package com.example.gasa_nika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.Map;
import java.util.stream.Collectors;

public class MarketController {

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    private TextField textField4;

    @FXML
    private PieChart pieChart;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/products";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    @FXML
    protected void addButtonClick() {

        Integer value1 = Integer.valueOf(textField1.getText());
        String value2 = textField2.getText();
        String value3 = textField3.getText();
        String value4 = textField4.getText();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO products (id, name, price, date) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, String.valueOf(value1));
                preparedStatement.setString(2, value2);
                preparedStatement.setString(3, value3);
                preparedStatement.setString(4, value4);

                preparedStatement.executeUpdate();

                System.out.println("ki");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void PieChart() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM products";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    double amount = resultSet.getDouble("column2"); // Assuming column2 represents the amount
                    String category = resultSet.getString("column1"); // Assuming column1 represents the category

                    pieChartData.add(new PieChart.Data(category, amount));
                }

                // Use Java Stream API to group by category
                Map<String, Double> groupedData = pieChartData.stream()
                        .collect(Collectors.groupingBy(PieChart.Data::getName,
                                Collectors.summingDouble(PieChart.Data::getPieValue)));

                // Clear existing data and add grouped data to the PieChart
//                    pieChart.getData().clear();
//                    groupedData.forEach((category, sum) -> pieChart.getData().add(new PieChart.Data(category, sum)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
