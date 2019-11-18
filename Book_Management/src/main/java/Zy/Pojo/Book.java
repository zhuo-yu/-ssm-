package Zy.Pojo;
/*图书的数据表*/
public class Book {
    private Integer bid; //id图书序号
    private Integer num; //图书数量
    private String name; //图书名字
    private String card; //图书号
    private String autho; //作者名字
    private String press; //图书出版社
    private String type; //图书分类

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getAutho() {
        return autho;
    }

    public void setAutho(String autho) {
        this.autho = autho;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", card='" + card + '\'' +
                ", autho='" + autho + '\'' +
                ", press='" + press + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
