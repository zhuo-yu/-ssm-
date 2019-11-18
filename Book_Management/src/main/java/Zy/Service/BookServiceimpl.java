package Zy.Service;

import Zy.Dao.BookDao;
import Zy.Pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceimpl implements BookService{
    @Autowired
    BookDao bookDao;
    @Override
    public List<Book> SelectAll() {
        return bookDao.SelectAll(); //查询所有图书信息
    }

    @Override
    public List<Book> SelectBook(String name) {
        return bookDao.SelectBook(name); //查询特定的书籍
    }

    @Override
    public void AddBook(Book book) {
        bookDao.AddBook(book);  //添加图书
    }

    @Override
    public void UpdateBook(Book book) {
        bookDao.UpdateBook(book); //修改图书信息
    }

    @Override
    public void DeleteBook(Integer bid) {
        bookDao.DeleteBook(bid); //根据图书id删除图书
    }

    @Override
    public void SubBook(Integer bid) {
        bookDao.SubBook(bid); //读者借阅书籍库存减一操作
    }

    @Override
    public Book GetBookBybid(Integer bid) {
        return bookDao.GetBookBybid(bid);  //根据bid获取Book对象
    }

}
