package Zy.Service;

import Zy.Pojo.BookHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HistoryService {
    public List<BookHistory> SelectBorrow(); //正在借阅的所有信息
    public void UpdataBorrow(BookHistory bookHistory); //还书,更改status为0
    public List<BookHistory> SelectReturn(); //图书归还的所有信息
    public List<BookHistory> ReaderSelectBorrow(Integer aid); //读者查看正在借阅的所有信息
    public BookHistory GetAdminbyhid(Integer hid); //根据hid获得BookHistory对象
    public void BorrowBook(BookHistory bookHistory);// 借阅图书
    public List<BookHistory> GetAdminbybid(Integer bid); //根据bid获得BookHistory对象
    public List<BookHistory> GetBorrowHistory(Integer aid);  //读者查看账户借阅历史
}
