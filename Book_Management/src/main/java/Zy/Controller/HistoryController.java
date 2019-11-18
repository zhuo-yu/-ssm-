package Zy.Controller;

import Zy.Pojo.Admin;
import Zy.Pojo.Book;
import Zy.Pojo.BookHistory;
import Zy.Service.BookService;
import Zy.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("History")
public class HistoryController {
    /*管理员查看所有借阅信息模块*/
    @Autowired
    HistoryService SelectBorrowService;
    @RequestMapping("SelectBorrow")
    public String SelectBorrow(HttpServletRequest req){
        ArrayList<BookHistory> bookhistorydata= (ArrayList<BookHistory>) SelectBorrowService.SelectBorrow(); //获取正在借阅的所有成员信息，并以数组形式返回
        HttpSession bookhistorySession=req.getSession();
        bookhistorySession.setAttribute("bookhistorydata",bookhistorydata);  //将返回的数组对象装入session关键字中
        return "admin_borrow";
    }
    /*还书操作模块*/
    @Autowired
    HistoryService UpdateBorrowService;
    @RequestMapping("UpdateBorrow")
    public String UpdateBorrow(Integer hid,Integer tip){
        BookHistory bookHistory=UpdateBorrowService.GetAdminbyhid(hid); //根据链接获取的hid获得BookHistory对象信息
        Calendar c=Calendar.getInstance();  //获取日期
        int year=c.get(Calendar.YEAR);  //年
        int month=c.get(Calendar.MONTH)+1; //月
        int day=c.get(Calendar.DATE);  //日
        String endtime=""+year+"-"+month+"-"+day;
        bookHistory.setEndtime(endtime);   //设置BookHistory对象的endtime信息实时更新
        UpdateBorrowService.UpdataBorrow(bookHistory);  //将aid所对应的endtime修改以及借书还书标记status改变为还书状态
        if(tip!=1){
            return "redirect:/History/ReaderSelectBorrow";
        }else{
            return "redirect:/History/SelectBorrow";
        }

    }
    /*管理员查看所有归还信息模块*/
    @Autowired
    HistoryService SelectReturnService;
    @RequestMapping("SelectReturn")
    public String SelectReturn(HttpServletRequest req){
        ArrayList<BookHistory> returnbookdata = (ArrayList<BookHistory>) SelectReturnService.SelectReturn(); //查询所有status为0的归还记录,并以数组形式返回
        HttpSession returnBookSession=req.getSession();
        returnBookSession.setAttribute("returnbookdata",returnbookdata);//将返回的数组对象装入session关键字中
        return "admin_history";
    }
    /*读者身份查询借阅信息模块*/
    @Autowired
    HistoryService ReaderSelectBorrowService;
    @RequestMapping("ReaderSelectBorrow")
    public String ReaderSelectBorrow(HttpServletRequest req){
        HttpSession session=req.getSession();
        Admin reader= (Admin) session.getAttribute("Admin"); //得到登录用户对象信息
        Integer aid=reader.getAid();
        ArrayList<BookHistory> readerhistorydata= (ArrayList<BookHistory>) ReaderSelectBorrowService.ReaderSelectBorrow(aid);
        session.setAttribute("readerhistorydata",readerhistorydata);
        return "borrow";
    }
    /*读者借阅图书模块*/
    @Autowired
    HistoryService BorrowBook;
    @Autowired
    BookService GetBook;
    @RequestMapping("BorrowBook")
    public String BorrowBook(Integer bid,HttpServletRequest req){
        GetBook.SubBook(bid);  //bid所对应的书籍库存减一
        HttpSession getadmin=req.getSession();
        Admin admin= (Admin) getadmin.getAttribute("Admin");  //获得Admin账户对象
        Book book=GetBook.GetBookBybid(bid); //根据表单获得的bid获得book对象
        BookHistory bookHistory=new BookHistory(); //实例化一个bookHistory对象
        Calendar c=Calendar.getInstance();   //获取时间
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH)+1;
        int day=c.get(Calendar.DATE);
        String begintime=""+year+"-"+month+"-"+day;     //读者借阅时间
        int month2=month+1;
        String endtime=""+year+"-"+month2+"-"+day;   //借阅截至时间
        bookHistory.setBegintime(begintime);//设置bookHistory中的begintime
        bookHistory.setEndtime(endtime);//设置bookHistory中的endtime
        bookHistory.setAid(admin.getAid()); //设置bookHistory中的aid
        bookHistory.setBid(book.getBid()); //设置bookHistory中的bid
        bookHistory.setAdminname(admin.getName()); //设置bookHistory中的用户名
        bookHistory.setBookname(book.getName()); //设置bookHistory中的图书名
        bookHistory.setCard(Integer.parseInt(book.getCard())); //设置bookHistory中的card
        bookHistory.setUsername(admin.getUsername());//设置bookHistory中的username
        bookHistory.setStatus(1);
        BorrowBook.BorrowBook(bookHistory);  //执行借阅操作将begintime,endtime,status(借阅标记)更新进数据库
        return "redirect:/Book/BookManage";
    }
    /*读者查询历史记录模块*/
    @Autowired
    HistoryService GetBorrowHistoryService;
    @RequestMapping("GetBorrowHistory")
    public String GetBorrowHistory(HttpServletRequest req){
        HttpSession HistorySession=req.getSession();
        Admin admin= (Admin) HistorySession.getAttribute("Admin");  //获取用户对象信息
        ArrayList<BookHistory> bookHistoriedata= (ArrayList<BookHistory>) GetBorrowHistoryService.GetBorrowHistory(admin.getAid());
        HistorySession.setAttribute("bookHistoriedata",bookHistoriedata);//将获得的历史记录以数组形式装入session里面
        HistorySession.setMaxInactiveInterval(3600);
        return "history";
    }
}
