package seh.example.com.ashop;

import java.util.Date;

/**
 * Created by user on 2015-12-17.
 */
public class Member {
    private String memEmail;
    private Integer memCode;
    private String memName;
    private String memPassword;
    private String memPhone;
    private Date memJoinedDate;

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public Integer getMemCode() {
        return memCode;
    }

    public void setMemCode(Integer memCode) {
        this.memCode = memCode;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemPassword() {
        return memPassword;
    }

    public void setMemPassword(String memPassword) {
        this.memPassword = memPassword;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public Date getMemJoinedDate() {
        return memJoinedDate;
    }

    public void setMemJoinedDate(Date memJoinedDate) {
        this.memJoinedDate = memJoinedDate;
    }
}
