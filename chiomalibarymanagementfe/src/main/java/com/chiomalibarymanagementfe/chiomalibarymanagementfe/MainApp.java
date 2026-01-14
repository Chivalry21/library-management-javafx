package com.chiomalibarymanagementfe.chiomalibarymanagementfe;

import com.chiomalibarymanagementfe.chiomalibarymanagementfe.entity.Book;
import com.chiomalibarymanagementfe.chiomalibarymanagementfe.client.BookServiceClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class MainApp extends Application {

//    TableView<Book> table = new TableView<>();
//    TextField titleField = new TextField();
//    TextField authorField = new TextField();
//    TextField isbnField = new TextField();
//    TextField dateField = new TextField();
//
//    BookServiceClient service = new BookServiceClient();
//
//    @Override
//    public void start(Stage stage) {
//        // Table columns
//        TableColumn<Book, Integer> idCol = new TableColumn<>("ID");
//        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
//        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
//
//        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
//        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
//
//        TableColumn<Book, String> isbnCol = new TableColumn<>("ISBN");
//        isbnCol.setCellValueFactory(new PropertyValueFactory<>("isbn"));
//
//        table.getColumns().addAll(idCol, titleCol, authorCol, isbnCol);
//
//        // Load initial data
//        refreshTable();
//
//        // When user selects a row, populate form
//        table.setOnMouseClicked(event -> {
//            Book book = table.getSelectionModel().getSelectedItem();
//            if (book != null) {
//                titleField.setText(book.getTitle());
//                authorField.setText(book.getAuthor());
//                isbnField.setText(book.getIsbn());
//               // dateField.setText(book.getPublishedDate());
//            }
//        });
//
//        // Buttons
//        Button addBtn = new Button("Add");
//        addBtn.setOnAction(e -> addBook());
//
//        Button updateBtn = new Button("Update");
//        updateBtn.setOnAction(e -> updateBook());
//
//        Button deleteBtn = new Button("Delete");
//        deleteBtn.setOnAction(e -> deleteBook());
//
//        Button refreshBtn = new Button("Refresh");
//        refreshBtn.setOnAction(e -> refreshTable());
//
//        HBox form = new HBox(10, titleField, authorField, isbnField, dateField);
//        HBox buttons = new HBox(10, addBtn, updateBtn, deleteBtn, refreshBtn);
//
//        VBox layout = new VBox(10, table, form, buttons);
//        Scene scene = new Scene(layout, 900, 600);
//
//        stage.setScene(scene);
//        stage.setTitle("Library Management System");
//        stage.show();
//    }
//
//    private void refreshTable() {
//        table.getItems().setAll(service.getAllBooks());
//    }
//
//    private void addBook() {
//        Book book = new Book();
//        book.setTitle(titleField.getText());
//        book.setAuthor(authorField.getText());
//        book.setIsbn(isbnField.getText());
//       // book.setPublishedDate(dateField.getText());
//
//        service.createBook(book);
//        refreshTable();
//    }
//
//    private void updateBook() {
//        Book selected = table.getSelectionModel().getSelectedItem();
//        if (selected == null) return;
//
//        selected.setTitle(titleField.getText());
//        selected.setAuthor(authorField.getText());
//        selected.setIsbn(isbnField.getText());
//       // selected.setPublishedDate(dateField.getText());
//
//        service.updateBook(selected.getId(), selected);
//        refreshTable();
//    }
//
//    private void deleteBook() {
//        Book selected = table.getSelectionModel().getSelectedItem();
//        if (selected == null) return;
//
//        service.deleteBook(selected.getId());
//        refreshTable();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
@Override
public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/library.fxml"));
    Scene scene = new Scene(loader.load(), 1000, 600);
    scene.getStylesheets().add(getClass().getResource("/style/app.css").toExternalForm());

    stage.setTitle("Library Management System");
    stage.setScene(scene);
    stage.show();
}

    public static void main(String[] args) {
        launch();
    }
}

