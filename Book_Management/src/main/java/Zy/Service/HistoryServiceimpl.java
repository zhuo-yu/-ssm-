package Zy.Service;

import Zy.Dao.HistoryDao;
import Zy.Pojo.BookHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("HistoryService")
public class HistoryServiceimpl implements HistoryService{
    @Autowired
    HistoryDao historyDao;
    @Override
    public List<BookHistory> SelectBorrow() {
        return historyDao.SelectBorrow();  //管理员身份查询正在借阅的所有信息
    }

    @Override
    public void UpdataBorrow(BookHistory bookHistory) {
        historyDao.UpdataBorrow(bookHistory);  //还书操作,将status的标记改为0(还书状态)
    }

    @Override
    public List<BookHistory> SelectReturn() {
        return historyDao.SelectReturn(); //管理员身份查询所有归还信息
    }

    @Override
    public List<BookHistory> ReaderSelectBorrow(Integer aid) {
        return historyDao.ReaderSelectBorrow(aid);  //读者身份查询正在借阅的所有信息
    }

    @Override
    public BookHistory GetAdminbyhid(Integer hid) {
        return historyDao.GetAdminbyhid(hid);  //根据hid获得Admin对象信息
    }

    @Override
    public void BorrowBook(BookHistory bookHistory) {
        historyDao.BorrowBook(bookHistory); //借阅操作,将begintime，endtime以及status(借阅还书标记)更新至数据库
    }

    @Override
    public List<BookHistory> GetAdminbybid(Integer bid) {
        return historyDao.GetAdminbybid(bid); //根据bid获得BookHistory对象
    }

    @Override
    public List<BookHistory> GetBorrowHistory(Integer aid) {
        return historyDao.GetBorrowHistory(aid);
    }
}
