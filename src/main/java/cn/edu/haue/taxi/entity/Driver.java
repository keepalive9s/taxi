package cn.edu.haue.taxi.entity;

import cn.edu.haue.taxi.util.IDUtil;

public class Driver {
    private String id;

    private String name;

    private String gender;

    private Integer age;

    private String password;

    private String phone;

    private String licenseNum;

    private String identityNum;

    private Integer taxiId;

    private String plateNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return IDUtil.getAgeByIDNumber(this.identityNum);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public Integer getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Integer taxiId) {
        this.taxiId = taxiId;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                ", identityNum='" + identityNum + '\'' +
                ", taxiId=" + taxiId +
                ", plateNum='" + plateNum + '\'' +
                '}';
    }
}