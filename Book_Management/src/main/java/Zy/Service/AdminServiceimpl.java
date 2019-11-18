package Zy.Service;

import Zy.Dao.AdminDao;
import Zy.Pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminService")
public class AdminServiceimpl implements AdminService{
    @Autowired
    AdminDao adminDao;
    @Override
    public Admin Login(Admin admin) {
        return adminDao.Login(admin);//业务层登录检验
    }

    @Override
    public void Register(Admin admin) {
        adminDao.Register(admin);//注册用户
    }

    @Override
    public List<Admin> SelectAll() {
        return adminDao.SelectAll(); //查找所有用户信息,并以数组形式返回
    }

    @Override
    public void UpdateAdmin(Admin admin) {
        adminDao.UpdateAdmin(admin); //根据传入的admin值修改数据库的信息
    }

    @Override
    public void UpdatePassword(Admin admin) {
        adminDao.UpdatePassword(admin); //根据传入的admin值修改数据库中的密码
    }

    @Override
    public void UpdateReader(Admin admin) {
        adminDao.UpdateReader(admin);  //管理员界面修改读者信息
    }

    @Override
    public void DeleteReader(Integer aid) {
        adminDao.DeleteReader(aid);  //根据传入的aid值删除对应的读者
    }

    @Override
    public void AddReader(Admin admin) {
        adminDao.AddReader(admin);  //根据表单传入的admin信息增加相应的读者
    }

}
