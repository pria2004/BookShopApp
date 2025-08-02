package main;
import view.BookForm;
import controller.BookController;
import dao.BookDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        BookForm form = new BookForm();
        BookDAO dao = new BookDAO();
        new BookController(form, dao);
        form.setVisible(true);
    }
}
