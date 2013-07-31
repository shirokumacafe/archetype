package com.shirokumacafe.archetype.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Users {
    private Integer userId;

    private String userCode;

    private String userName;

    private String loginName;

    private String password;

    private String salt;

    private Integer sex;

    private String idcardAddress;

    private String idcard;

    private String homeAddress;

    private String tel;

    private String contactTel;

    private String contactName;

    private String bankDict;

    private String bankAccount;

    private Date birthday;

    private Integer state;

    private String postionLevelDict;

    private BigDecimal salary;

    private Integer postionState;

    private Date joinDate;

    private Date leaveDate;

    private Date regularDate;

    private String nationDict;

    private String photo;

    private String remark;

    private String postionDict;

    private String majorDict;

    private String educationDict;

    private String graduate;

    private String polity;

    private String qq;

    private String email;

    private Integer createId;

    private Integer updateId;

    private Date createTime;

    private Date updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdcardAddress() {
        return idcardAddress;
    }

    public void setIdcardAddress(String idcardAddress) {
        this.idcardAddress = idcardAddress == null ? null : idcardAddress.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getBankDict() {
        return bankDict;
    }

    public void setBankDict(String bankDict) {
        this.bankDict = bankDict == null ? null : bankDict.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPostionLevelDict() {
        return postionLevelDict;
    }

    public void setPostionLevelDict(String postionLevelDict) {
        this.postionLevelDict = postionLevelDict == null ? null : postionLevelDict.trim();
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getPostionState() {
        return postionState;
    }

    public void setPostionState(Integer postionState) {
        this.postionState = postionState;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Date getRegularDate() {
        return regularDate;
    }

    public void setRegularDate(Date regularDate) {
        this.regularDate = regularDate;
    }

    public String getNationDict() {
        return nationDict;
    }

    public void setNationDict(String nationDict) {
        this.nationDict = nationDict == null ? null : nationDict.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPostionDict() {
        return postionDict;
    }

    public void setPostionDict(String postionDict) {
        this.postionDict = postionDict == null ? null : postionDict.trim();
    }

    public String getMajorDict() {
        return majorDict;
    }

    public void setMajorDict(String majorDict) {
        this.majorDict = majorDict == null ? null : majorDict.trim();
    }

    public String getEducationDict() {
        return educationDict;
    }

    public void setEducationDict(String educationDict) {
        this.educationDict = educationDict == null ? null : educationDict.trim();
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate == null ? null : graduate.trim();
    }

    public String getPolity() {
        return polity;
    }

    public void setPolity(String polity) {
        this.polity = polity == null ? null : polity.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}