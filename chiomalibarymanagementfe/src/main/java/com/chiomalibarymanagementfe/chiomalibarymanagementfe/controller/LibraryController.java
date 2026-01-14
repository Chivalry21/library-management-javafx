package com.chiomalibarymanagementfe.chiomalibarymanagementfe.controller;




import com.chiomalibarymanagementfe.chiomalibarymanagementfe.client.BookServiceClient;
import com.chiomalibarymanagementfe.chiomalibarymanagementfe.entity.Book;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class LibraryController {


    @FXML private TableView<Book> bookTable;
    @FXML private TableColumn<Book, Integer> colId;
    @FXML private TableColumn<Book, String> colTitle;
    @FXML private TableColumn<Book, String> colAuthor;
    @FXML private TableColumn<Book, String> colIsbn;
    @FXML private TableColumn<Book, String> colDate;

    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField isbnField;
    @FXML private TextField dateField;
    @FXML
    private TextField searchField;

    @FXML
    private Button clearSearchBtn;
    private ObservableList<Book> allBooks;

    private final BookServiceClient service = new BookServiceClient();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("publishedDate"));

        bookTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSel, newSel) -> populateForm(newSel));

        loadBooks();
        searchField.textProperty().addListener((obs, oldVal, newVal) -> filterBooks(newVal));
    }

@FXML
    private void handleClearSearch() {
        searchField.clear();
        bookTable.setItems(allBooks);
    }
    // ------------------ SEARCH FILTER ------------------
    private void filterBooks(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            bookTable.setItems(allBooks);
            return;
        }

        String lowerKeyword = keyword.toLowerCase();

        ObservableList<Book> filtered = allBooks.filtered(book ->
                book.getTitle().toLowerCase().contains(lowerKeyword) ||
                        book.getAuthor().toLowerCase().contains(lowerKeyword) ||
                        book.getIsbn().toLowerCase().contains(lowerKeyword)
        );

        bookTable.setItems(filtered);
    }

    private void loadBooks() {
        allBooks = FXCollections.observableArrayList(service.getAllBooks());
        bookTable.setItems(allBooks);
    }

    private void populateForm(Book book) {
        if (book == null) return;

        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        isbnField.setText(book.getIsbn());
        dateField. setText(book.getPublishedDate().toString());
    }

    // ---------------- VALIDATION ----------------

    private boolean validateForm() {
        if (titleField.getText().isBlank() ||
                authorField.getText().isBlank() ||
                isbnField.getText().isBlank() ||
                dateField.getText().isBlank()) {

            showAlert(Alert.AlertType.WARNING, "Validation Error", "All fields are required");
            return false;
        }

        try {
            LocalDate.parse(dateField.getText());
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Date", "Date must be YYYY-MM-DD");
            return false;
        }

        return true;
    }

    // ---------------- BUTTON ACTIONS ----------------

    @FXML
    public void handleAdd() {
        if (!validateForm()) return;

        Book book = new Book();
        book.setTitle(titleField.getText());
        book.setAuthor(authorField.getText());
        book.setIsbn(isbnField.getText());
        book.setPublishedDate(LocalDate.parse(dateField.getText()));

        service.createBook(book);
        loadBooks();
        clearForm();
        showAlert(Alert.AlertType.INFORMATION, "Success", "Book Added Successfully");
    }

    @FXML
    public void handleUpdate() {
        Book selected = bookTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Select a book to update");
            return;
        }

        if (!validateForm()) return;

        selected.setTitle(titleField.getText());
        selected.setAuthor(authorField.getText());
        selected.setIsbn(isbnField.getText());
        selected.setPublishedDate(LocalDate.parse(dateField.getText()));

        service.updateBook(selected.getId(), selected);
        loadBooks();
        showAlert(Alert.AlertType.INFORMATION, "Success", "Book Updated Successfully");
    }

    @FXML
    public void handleDelete() {
        Book selected = bookTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Select a book to delete");
            return;
        }

        service.deleteBook(selected.getId());
        loadBooks();
        clearForm();
        showAlert(Alert.AlertType.INFORMATION, "Deleted", "Book Deleted");
    }

    @FXML
    public void handleRefresh() {
        loadBooks();
    }

    private void clearForm() {
        titleField.clear();
        authorField.clear();
        isbnField.clear();
        dateField.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}
