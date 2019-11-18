package Zy.Controller;

import Zy.Pojo.Admin;
import Zy.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("Admin")
public class AdminController {
    /*登录验证功能模块*/
    @Autowired
    AdminService loginService;
    @RequestMapping("Login")
    public String Login(Admin admin, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Admin LoginAdmin=loginService.Login(admin); //查询数据库是否有次账户信息
        HttpSession AdminSession=req.getSession();
        AdminSession.setAttribute("Admin",LoginAdmin);
        if(LoginAdmin !=null){
            if(LoginAdmin.getStatus()!=1){  //验证身份,如果status不是1则说明用户是管理员,跳转至管理员界面
                return "admin"; //跳转至管理员界面
            }else{
                return "index2"; //跳转至读者界面
            }
        }else{
            HttpSession failSession=req.getSession();
            failSession.setAttribute("fail","您的账户名或者密码输入有误,请重新输入");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");  //重定向跳转回登录界面
            return null;
        }
    }
    /*注册功能模块*/
    @Autowired
    AdminService registerService;
    @RequestMapping("Register")
    public void Register(Admin admin,HttpServletRequest req,HttpServletResponse resp) throws IOException {
        registerService.Register(admin);  //将表单获得的数据存入数据库
        HttpSession RegisterSession=req.getSession();
        RegisterSession.setAttribute("register","注册成功");
        resp.sendRedirect(req.getContextPath()+"/login.jsp");
        return;
    }
    /*查询所有用户模块*/
    @Autowired
    AdminService SelectAllService;
    @RequestMapping("SelectAll")
    public String SelectAll(HttpServletRequest req){

        ArrayList<Admin> admindata= (ArrayList<Admin>) SelectAllService.SelectAll(); //获取所有用户信息
        HttpSession admindateSession=req.getSession();
        admindata.remove(1); //因为是读者管理所以不能管理管理员的信息,所以要将管理员从数组中去除掉
        admindateSession.setAttribute("AllAdmindata",admindata);  //将所有用户信息放进session,用于jsp中读取
        return "admin_user";
    }
    /*修改用户信息模块*/
    @Autowired
    AdminService UpdateAdminService;
    @RequestMapping("UpdateAdmin")
    public String UpdateAdmin(Admin admin,HttpServletRequest req){
        HttpSession GetAdminSession=req.getSession(); //获取登录时获得的用户信息
        Admin admin1= (Admin) GetAdminSession.getAttribute("Admin");   //获得需要修改的用户信息的id
        admin.setAid(admin1.getAid());
        UpdateAdminService.UpdateAdmin(admin); //将更改的数据更新到数据库中
        return "redirect:/Book/BookManage";
    }
    /*修改用户密码模块*/
    @Autowired
    AdminService UpdatePasswordService;
    @RequestMapping("UpdatePassword")
    public String UpdatePassword(Admin admin,HttpServletRequest req,HttpServletResponse resp) throws IOException, InterruptedException {
        HttpSession GetAdminSession=req.getSession();//获取登录时获得的用户信息
        Admin admin1= (Admin) GetAdminSession.getAttribute("Admin");//获得需要修改的用户信息的id
        admin.setAid(admin1.getAid());
        String oldpassword=admin1.getPassword();// 获取原密码
        String newpassword=req.getParameter("confirmpassword"); //获取表单上的原密码
        if(oldpassword.equals(newpassword)){   //判断原密码和表单的原密码是否一致
            UpdatePasswordService.UpdatePassword(admin);
            return "redirect:/login.jsp";  //修改成功跳回登陆界面
        }else{
            resp.getWriter().write("<script type='text/javascript'>confirm('password error'); </script>");
            return "redirect:/Book/BookManage";
        }
    }
    /*修改读者信息模块*/
    @Autowired
    AdminService UpdateReaderService;
    @RequestMapping("UpdateReader")
    public String UpdateReader(Admin admin,String aid){
        int aid1=Integer.parseInt(aid);  //获取隐藏表单数据aid,来确定修改用户的id
        admin.setAid(aid1);
        System.out.println(aid1);
        UpdateReaderService.UpdateReader(admin); // 将表单读取的读者信息更新至数据库
        return "redirect:/Admin/SelectAll";
    }
    /*删除读者模块*/
    @Autowired
    AdminService DeleteReaderService;
    @RequestMapping("DeleteReader")
    public String DeleteReader(Integer aid){
        DeleteReaderService.DeleteReader(aid);  //根据表单获得的aid删除对应的读者
        return "redirect:/Admin/SelectAll";
    }
    /*添加读者账户模块*/
    @Autowired
    AdminService AddReaderService;
    @RequestMapping("AddReader")
    public String AddReader(Admin admin){
        AddReaderService.AddReader(admin);  //根据表单传入的信息添加相应的读者账户
        return "redirect:/Admin/SelectAll";
    }
}
