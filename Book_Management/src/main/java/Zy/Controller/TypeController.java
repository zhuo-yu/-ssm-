package Zy.Controller;

import Zy.Pojo.BookType;
import Zy.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("Type")
public class TypeController {
    /*查询所有图书类型*/
    @Autowired
    TypeService SelectAllService;
    @RequestMapping("SelectAll")
    public String SelectAll(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<BookType> booktype= (ArrayList<BookType>) SelectAllService.SelectAll(); //查询数据库的所有图书类型并以数组形式返回
        HttpSession booktypeSession=req.getSession();
        booktypeSession.setAttribute("booktypedata",booktype);  //将存有图书类型的数组对象存入session中,用以在jsp页面取得对象信息
        return "admin_booktype";
    }
    /*添加图书分类模块*/
    @Autowired
    TypeService AddBookTypeService;
    @RequestMapping("AddBookType")
    public String AddBookType(BookType bookType){
        AddBookTypeService.AddBookType(bookType);  //将表单获取的新增图书类型数据存入数据库
        return "redirect:/Type/SelectAll";
    }
    /*修改图书分类模块*/
    @Autowired
    TypeService UpdateBookType;
    @RequestMapping("UpdateBookType")
    public String UpdateBookType(BookType bookType){
        UpdateBookType.UpdateBookType(bookType); //将表单获取的修改的图书分类信息存入数据库
        return "redirect:/Type/SelectAll";
    }
    /*删除图书*/
    @Autowired
    TypeService DeleteBookTypeService;
    @RequestMapping("DeleteBookType")
    public String DeleteBookType(Integer tid){
        DeleteBookTypeService.DeleteBookType(tid); //根据表单获得的id删除对应的图书类型
        return "redirect:/Type/SelectAll";
    }
}
