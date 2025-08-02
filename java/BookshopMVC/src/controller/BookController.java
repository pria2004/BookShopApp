package controller;

import model.Book;
import dao.BookDAO;
import view.BookForm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class BookController {

    private BookForm view;
    private BookDAO dao;

    public BookController(BookForm view, BookDAO dao) {
        this.view = view;
        this.dao = dao;

        // Initial table load
        loadTableData();

        // Button actions
        view.btnAdd.addActionListener(e -> addBook());
        view.btnUpdate.addActionListener(e -> updateBook());
        view.btnDelete.addActionListener(e -> deleteBook());
        view.btnClear.addActionListener(e -> clearForm());
        view.btnExit.addActionListener(e -> exit());
        // Key listener for search field
        view.txtId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                fetchBookById();
            }
        });
    }

    private void loadTableData() {
        try {
            List<Book> bookList = dao.getAllBooks();
            String[] columns = {"ID", "Name", "Edition", "Price"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);

            for (Book book : bookList) {
                model.addRow(new Object[]{
                        book.getId(),
                        book.getName(),
                        book.getEdition(),
                        book.getPrice()
                });
            }

            view.table.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage());
        }
    }
    public void exit() {
    	System.exit(0);
    }
    private void addBook() {
        String name = view.txtName.getText();
        String edition = view.txtEdition.getText();
        String priceText = view.txtPrice.getText();

        if (name.isEmpty() || edition.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            Book book = new Book(0, name, edition, price);
            boolean inserted = dao.insert(book);

            if (inserted) {
                loadTableData();
                clearForm();
                JOptionPane.showMessageDialog(null, "Book Added.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add book.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid price value.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void updateBook() {
        String idText = view.txtId.getText();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Book ID to update.");
            return;
        }

        try {
            int id = Integer.parseInt(idText);
            String name = view.txtName.getText();
            String edition = view.txtEdition.getText();
            double price = Double.parseDouble(view.txtPrice.getText());

            Book book = new Book(id, name, edition, price);
            boolean updated = dao.update(book);

            if (updated) {
                loadTableData();
                clearForm();
                JOptionPane.showMessageDialog(null, "Book Updated.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update book.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number input.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void deleteBook() {
        String idText = view.txtId.getText();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Book ID to delete.");
            return;
        }

        try {
            int id = Integer.parseInt(idText);
            boolean deleted = dao.delete(id);

            if (deleted) {
                loadTableData();
                clearForm();
                JOptionPane.showMessageDialog(null, "Book Deleted.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete book.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid ID format.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void fetchBookById() {
        String idText = view.txtId.getText();

        if (idText.isEmpty()) {
            clearForm();
            return;
        }

        try {
            int id = Integer.parseInt(idText);
            Book book = dao.getBookById(id);

            if (book != null) {
                view.txtName.setText(book.getName());
                view.txtEdition.setText(book.getEdition());
                view.txtPrice.setText(String.valueOf(book.getPrice()));
            } else {
                clearForm();
            }

        } catch (NumberFormatException ex) {
        	// silently ignore
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error fetching book: " + ex.getMessage());
        }
    }

    private void clearForm() {
        view.txtName.setText("");
        view.txtEdition.setText("");
        view.txtPrice.setText("");
    }
}
