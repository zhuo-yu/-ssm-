package Zy.Dao;

import Zy.Pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookDao {
    public List<Book> SelectAll();//查询所有的图书信息
    public List<Book> SelectBook(@Param(value="name") String name);//查询特定的书籍
    public void AddBook(Book book);  //添加图书
    public void UpdateBook(Book book); //修改图书信息
    public void DeleteBook(Integer bid); //删除图书
    public void SubBook(Integer bid); //借阅减bid所对应的书籍库存
    public Book GetBookBybid(Integer bid);// 根据bid获得book对象信息
}
