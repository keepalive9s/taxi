package cn.edu.haue.taxi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Complain {
    private String id;

    private String driverId;

    private Integer taxiId;

    private Integer passengerId;

    private String reason;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private String location;

    private Date createTime;

    private Integer state;

    private String result;

    //临时字段，不持久化
    private String driverName;

    //临时字段，不持久化
    private String passengerName;

    //临时字段，不持久化
    private String passengerPhone;

    //临时字段，不持久化
    private String plateNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Integer getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Integer taxiId) {
        this.taxiId = taxiId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "id='" + id + '\'' +
                ", driverId='" + driverId + '\'' +
                ", taxiId=" + taxiId +
                ", passengerId=" + passengerId +
                ", reason='" + reason + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", createTime=" + createTime +
                ", state=" + state +
                ", result='" + result + '\'' +
                ", driverName='" + driverName + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", passengerPhone='" + passengerPhone + '\'' +
                ", plateNum='" + plateNum + '\'' +
                '}';
    }
}