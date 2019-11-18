package Zy.Service;

import Zy.Pojo.BookType;

import java.util.List;

public interface TypeService {
    public List<BookType> SelectAll(); //查询所有的图书类型
    public void AddBookType(BookType bookType);  //添加图书分类
    public void UpdateBookType(BookType bookType);  //修改图书分类
    public void DeleteBookType(Integer tid);  //删除图书分类
}
