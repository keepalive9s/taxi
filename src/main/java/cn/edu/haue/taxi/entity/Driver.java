package cn.edu.haue.taxi.entity;

import cn.edu.haue.taxi.util.IDUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Driver {
    private String id;

    private String name;

    private String gender;

    private String password;

    private String phone;

    private String licenseNum;

    private String drivingLicenseNum;

    private String drivingLicenseClass;

    private Integer taxiId;

    private Date endTime;

    private Integer age;

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

    public String getDrivingLicenseNum() {
        return drivingLicenseNum;
    }

    public void setDrivingLicenseNum(String drivingLicenseNum) {
        this.drivingLicenseNum = drivingLicenseNum;
    }

    public String getDrivingLicenseClass() {
        return drivingLicenseClass;
    }

    public void setDrivingLicenseClass(String drivingLicenseClass) {
        this.drivingLicenseClass = drivingLicenseClass;
    }

    public Integer getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Integer taxiId) {
        this.taxiId = taxiId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getAge() {
        return IDUtil.getAgeByIDNumber(this.drivingLicenseNum);
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}