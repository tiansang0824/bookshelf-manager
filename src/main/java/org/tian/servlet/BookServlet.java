package org.tian.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.tian.mappers.BookMapper;
import org.tian.operations.BookOperation;
import org.tian.pojo.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet({"/book/selectAllBooks", "/book/selectOne","/book/addBook", "/book/editBook", "/book/boundUser"})
public class BookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        BookOperation bookOperation = new BookOperation();

        if ("/book/selectAllBooks".equals(servletPath)) {

            // 查询全部book

            List<Book> books = null;
            books = bookOperation.selectAll();
            // 在后台迭代一次，用于检查问题。
            for (Book b :
                    books) {
                System.out.println(b);
            }
            request.getSession().setAttribute("books", books);
            request.getRequestDispatcher("/pages/bookSelection.jsp").forward(request, response);

        } else if ("/book/selectOne".equals(servletPath)) {

            // 查询一本book。

            String id_String = request.getParameter("id");
            int id = Integer.parseInt(id_String);

            Book book = bookOperation.selectOne(id);

            request.setAttribute("book", book);

            request.getRequestDispatcher("/pages/bookDetail.jsp").forward(request, response);
        } else if ("/book/addBook".equals(servletPath)) {
            String bookName = request.getParameter("bookName");
            String bookAuthor = request.getParameter("bookAuthor");
            String bookDescription = request.getParameter("bookDescription");

            Book book = new Book(bookName, bookAuthor, bookDescription, 1);
            System.out.println(book);

            bookOperation.addBook(book); // TODO: 这里的函数

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if ("/book/editBook".equals(servletPath)) {

            // 编辑book函数。

            int bookId = Integer.parseInt(request.getParameter("bookId"));
            String bookName = request.getParameter("bookName");
            String bookAuthor = request.getParameter("bookAuthor");
            String bookDescription = request.getParameter("bookDescription");

            Book book = new Book(bookId, bookName, bookAuthor, bookDescription, 1);
            System.out.println(book);

            bookOperation.EditBook(book);

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if ("/book/boundUser".equals(servletPath)) {

            int bookId = Integer.parseInt(request.getParameter("bookId"));
            String bookName = request.getParameter("bookName");
            String bookAuthor = request.getParameter("bookAuthor");
            String bookDescription = request.getParameter("bookDescription");

            Book book = new Book(bookId, bookName, bookAuthor, bookDescription, 1);
            System.out.println(book);

            // todo: 函数没写完，写完这个完工。
        }


    }
}
