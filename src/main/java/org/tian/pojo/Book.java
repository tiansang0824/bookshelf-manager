package org.tian.pojo;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookDescription;

    public Book() {
    }

    /*包含id的构造函数*/
    public Book(int bookid, String bookName, String bookAuthor, String bookDescription) {
        this.bookId = bookid;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
    }

    /*不包含id的构造函数
    * 该函数仅用于添加book对象信息到数据库的时候使用，请注意使用场合。
    * */
    public Book(String bookName, String bookAuthor, String bookDescription) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
}
