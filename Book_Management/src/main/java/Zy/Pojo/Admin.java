package Zy.Pojo;

public class Admin {
    private Integer aid;  //用户id
    private Integer status;  //用户身份辨别,1代表普通读者,2代表管理员
    private Integer lend_num; //可借阅天数
    private Integer max_num;  //最大借阅天数
    private String username;  //账户
    private String password;  //密码
    private String name;  //用户姓名
    private String email;  //用户邮箱
    private String phone;  //用户手机

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLend_num() {
        return lend_num;
    }

    public void setLend_num(Integer lend_num) {
        this.lend_num = lend_num;
    }

    public Integer getMax_num() {
        return max_num;
    }

    public void setMax_num(Integer max_num) {
        this.max_num = max_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", status=" + status +
                ", lend_num=" + lend_num +
                ", max_num=" + max_num +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
