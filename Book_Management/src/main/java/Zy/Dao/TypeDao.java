package Zy.Dao;

import Zy.Pojo.BookType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TypeDao {
    public List<BookType> SelectAll(); //查询所有的图书类型
    public void AddBookType(BookType bookType);  //添加图书分类
    public void UpdateBookType(BookType bookType);  //修改图书分类
    public void DeleteBookType(Integer tid);  //删除图书分类
}
