package Zy.Controller;

import Zy.Pojo.Admin;
import Zy.Pojo.Book;
import Zy.Pojo.BookType;
import Zy.Service.BookService;
import Zy.Service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("Book")
public class BookController {
    /*查询全部书籍功能模块*/
    @Autowired
    BookService SelectAllBook;
    @Autowired
    TypeService SelectAllBookType;
    @RequestMapping("BookManage")
    public String BookManage(Admin admin, HttpServletRequest req){
/*        HttpSession BookmanageSession=req.getSession();
        BookmanageSession.setAttribute("admin",admin);*/
        HttpSession AdminSession=req.getSession();
        admin= (Admin) AdminSession.getAttribute("Admin"); //获取用户信息对象

        ArrayList<Book> Bookdata= (ArrayList<Book>) SelectAllBook.SelectAll(); //调用业务层查询所有图书信息按照数组形式返回
        ArrayList<BookType> Booktypedata = (ArrayList<BookType>) SelectAllBookType.SelectAll(); //调用业务层查询所有图书类型信息按照数组形式返回

        HttpSession BookdataSession=req.getSession();
        BookdataSession.setAttribute("Bookdata",Bookdata);  //把返回的图书信息放进session里面
        BookdataSession.setAttribute("Booktypedata",Booktypedata); //把返回的图书类型信息放进session里面
        if(admin.getStatus()!=2){    //通过status身份判断是管理员还是读者
            return "select";   //身份为读者跳转到读者界面
        }else{
            return "admin_book";  //身份为管理员跳转到管理员界面
        }
    }
    /*查询特定书籍功能模块*/
    @Autowired
    BookService SelectBook;
    @RequestMapping("SelectBook")
    public String SelectBook(String name, String tip, HttpServletRequest req){
        System.out.println(name);
        ArrayList<BookType> Booktypedata = (ArrayList<BookType>) SelectAllBookType.SelectAll(); //调用业务层查询所有图书类型信息按照数组形式返回
        ArrayList<Book> selctbookdata= (ArrayList<Book>) SelectBook.SelectBook(name); //查询名为name的书籍并返回book类型的数组

        HttpSession Selectbookdatasession=req.getSession();
        Selectbookdatasession.setAttribute("Bookdata",selctbookdata); //将返回的book类型的数组放进session里面
        Selectbookdatasession.setAttribute("Booktypedata",Booktypedata);//把返回的图书类型信息放进session里面

        /*因为在管理员界面和读者界面都有查找功能，为了将查找的结果返回正确的页面，设置了tip，tip=1表示管理员界面*/
        if(tip.equals("1")){
            return "admin_book";
        }else{
            return "select";
        }
    }
    /*添加图书模块*/
    @Autowired
    BookService AddbookService;
    @RequestMapping("AddBook")
    public String AddBook(Book book,HttpServletRequest req){
        AddbookService.AddBook(book);  //将表单获得的图书信息存入数据库
        return "redirect:/Book/BookManage";  //跳转回查询全部书籍功能模块
    }
    /*修改图书信息模块*/
    @Autowired
    BookService UpdatebookService;
    @RequestMapping("UpdateBook")
    public String UpdateBook(Book book,String updatebid){
        int bid=Integer.parseInt(updatebid);  //获取隐藏表单信息 bid值
        book.setBid(bid);
        UpdatebookService.UpdateBook(book);//将表单数据获取更新至数据库里
        return "redirect:/Book/BookManage";  //跳转回查询全部书籍功能模块更新
    }
    /*删除图书模块*/
    @Autowired
    BookService DeleteBookService;
    @RequestMapping("DeleteBook")
    public String DeleteBook(Integer bid){
        DeleteBookService.DeleteBook(bid);  //根据传入的bid值删除所对应的图书信息
        return  "redirect:/Book/BookManage";  //跳转回查询全部书籍功能模块更新
    }
}
