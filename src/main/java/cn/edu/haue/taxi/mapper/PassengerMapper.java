package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Passenger;

public interface PassengerMapper {

    int insert(Passenger passenger);

    Passenger selectByPhone(String phone);

}
