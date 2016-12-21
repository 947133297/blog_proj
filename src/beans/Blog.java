package beans;

import java.util.Date;

public class Blog {
    private int bid;
    private String master="";
    private String name="";
    private String introduction="";
    private int status;
    private Date createTime;
    public Blog(String master,String blogName,String intro){
        this.master=master;
        this.name=blogName;
        this.introduction=intro;
    }

    public Blog(int bid,String master,String blogName,String intro,int status,Date createTime){
        this.bid=bid;
        this.master=master;
        this.name=blogName;
        this.introduction=intro;
        this.status=status;
        this.createTime=createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public int getBid() {
        return bid;
    }

    public int getStatus() {
        return status;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getMaster() {
        return master;
    }

    public String getName() {
        return name;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
