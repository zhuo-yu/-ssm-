package Zy.Service;

import Zy.Pojo.Book;

import java.util.List;

public interface BookService {
    public List<Book> SelectAll();//查询所有的图书信息
    public List<Book> SelectBook(String name);//查询特定的书籍
    public void AddBook(Book book);  //添加图书
    public void UpdateBook(Book book); //修改图书信息
    public void DeleteBook(Integer bid); //删除图书
    public void SubBook(Integer bid); //借阅减数据库存
    public Book GetBookBybid(Integer bid);// 根据bid获得book对象信息
}
