package com.boge.pibackend.dao;

import com.boge.pibackend.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Device record);

    Device selectByPrimaryKey(Long id);

    List<Device> selectAll();

    int updateByPrimaryKey(Device record);
}