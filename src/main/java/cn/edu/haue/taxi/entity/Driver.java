package cn.edu.haue.taxi.entity;

import cn.edu.haue.taxi.util.IDUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

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
    //临时字段
    private Integer taxiId;
    //临时字段
    private String plateNum;
    //临时字段
    private Double deposit;
    //临时字段
    private Double freeDeposit;
    //临时字段
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    //临时字段
    private String state;
    //计算字段
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

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getFreeDeposit() {
        return freeDeposit;
    }

    public void setFreeDeposit(Double freeDeposit) {
        this.freeDeposit = freeDeposit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}