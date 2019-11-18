package Zy.Pojo;

public class BookHistory {
    private Integer hid; //借阅历史id
    private Integer bid; //图书id
    private Integer aid; //用户id
    private Integer card; //图书号
    private String bookname; //图书名称
    private String adminname; //用户账户
    private String username; //用户姓名
    private String begintime;  //借阅开始时间
    private String endtime;  //借阅截至时间
    private Integer status;  //表示借阅状态,1表示正在借阅，0表示以还书

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "BookHistory{" +
                "hid=" + hid +
                ", bid=" + bid +
                ", aid=" + aid +
                ", card=" + card +
                ", bookname='" + bookname + '\'' +
                ", adminname='" + adminname + '\'' +
                ", username='" + username + '\'' +
                ", begintime='" + begintime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", status=" + status +
                '}';
    }
}
