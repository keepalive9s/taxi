package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Admin;
import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(String username);

    int insert(Admin record);

    Admin selectByPrimaryKey(String username);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}