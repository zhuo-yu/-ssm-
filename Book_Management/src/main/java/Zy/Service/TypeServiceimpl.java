package Zy.Service;

import Zy.Dao.TypeDao;
import Zy.Pojo.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TypeService")
public class TypeServiceimpl implements TypeService{
    @Autowired
    TypeDao typeDao;
    @Override
    public List<BookType> SelectAll() {
        return typeDao.SelectAll(); //查询所有图书类型,并返回图书类型的数组
    }

    @Override
    public void AddBookType(BookType bookType) {
        typeDao.AddBookType(bookType); //添加图书分类
    }

    @Override
    public void UpdateBookType(BookType bookType) {
        typeDao.UpdateBookType(bookType); //修改图书分类
    }

    @Override
    public void DeleteBookType(Integer tid) {
        typeDao.DeleteBookType(tid);  //根据id删除图书
    }
}
