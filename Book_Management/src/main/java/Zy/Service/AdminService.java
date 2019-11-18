package Zy.Service;

import Zy.Pojo.Admin;

import java.util.List;

public interface AdminService {
    public Admin Login(Admin admin);//业务层登录检验
    public void Register(Admin admin);//用户注册
    public List<Admin> SelectAll();  //查找所有用户信息
    public void UpdateAdmin(Admin admin);  //修改个人信息
    public void UpdatePassword(Admin admin);  //修改用户密码
    public void UpdateReader(Admin admin); //修改读者信息
    public void DeleteReader(Integer aid); //删除读者信息
    public void AddReader(Admin admin); //添加读者
}
