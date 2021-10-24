package com.boge.pibackend.dao;

import com.boge.pibackend.entity.Bridgetowerdata;
import com.boge.pibackend.entity.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BridgetowerdataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bridgetowerdata record);

    Bridgetowerdata selectByPrimaryKey(Long id);

    List<Bridgetowerdata> selectAll();

    int updateByPrimaryKey(Bridgetowerdata record);

    List<Bridgetowerdata> selectTen();
}