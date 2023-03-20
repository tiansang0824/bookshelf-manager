package org.tian.pojo;

public class Book {
    /**
     * 下面是一个book所需要的全部属性。
     * 特殊说明，当userid为0或者null的时候，说明没有人使用该book。
     */
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private int userId;

    public Book() {
    }

    /*包含id的构造函数*/
    public Book(int bookId, String bookName, String bookAuthor, String bookDescription,int userId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.userId = userId;
    }
    /*包含除了userId以外的全部参数。*/
    public Book(int bookId, String bookName, String bookAuthor, String bookDescription) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        userId = 0;
    }
    /*不包含id的构造函数
    * 该函数仅用于添加book对象信息到数据库的时候使用，请注意使用场合。
    * */
    public Book(String bookName, String bookAuthor, String bookDescription) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
    }

    public Book(String bookName, String bookAuthor, String bookDescription, int userId) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", userId='" + userId + '\'' +
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
