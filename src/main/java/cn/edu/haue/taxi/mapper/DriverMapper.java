package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Driver;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface DriverMapper {
    int deleteByPrimaryKey(String id);

    int insert(Driver record);

    Driver selectByPrimaryKey(String id);

    List<Driver> selectAll();

    int updateByPrimaryKey(Driver record) throws DataAccessException;
}