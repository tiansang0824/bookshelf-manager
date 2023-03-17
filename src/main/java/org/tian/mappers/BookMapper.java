package org.tian.mappers;

import org.tian.pojo.Book;

import java.util.List;

public interface BookMapper {
    /*查询所有book信息。*/
    List<Book> selectAllBooks();

    /*按照id查找某一本书。*/
    Book selectOne(int bookId);

    /*按照填入的数据在书架上添加一本书。*/
    int addBook(Book newBook);

    /*修改指定id的book的信息。*/
    void editBook(Book book);

}
