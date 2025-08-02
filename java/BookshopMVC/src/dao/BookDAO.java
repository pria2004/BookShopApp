package dao;

import model.Book;
import java.util.*;
import java.sql.*;

public class BookDAO {
    private Connection con;

    public BookDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javacrud", "root", "");
    }

    public boolean insert(Book book) throws SQLException {
        String sql = "INSERT INTO book(name, edition, price) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, book.getName());
        pst.setString(2, book.getEdition());
        pst.setDouble(3, book.getPrice());
        return pst.executeUpdate() > 0;
    }
    
    

    public boolean update(Book book) throws SQLException {
        String sql = "UPDATE book SET name=?, edition=?, price=? WHERE id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, book.getName());
        pst.setString(2, book.getEdition());
        pst.setDouble(3, book.getPrice());
        pst.setInt(4, book.getId());
        return pst.executeUpdate() > 0;
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM book WHERE id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        return pst.executeUpdate() > 0;
    }

    public Book getBookById(int id) throws SQLException {
        String sql = "SELECT * FROM book WHERE id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return new Book(rs.getInt("id"), rs.getString("name"), rs.getString("edition"), rs.getDouble("price"));
        }
        return null;
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Book b = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("edition"), rs.getDouble("price"));
            list.add(b);
        }
        return list;
    }
}
