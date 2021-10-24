package com.boge.pibackend.dao;

import com.boge.pibackend.entity.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Data record);

    Data selectByPrimaryKey(Long id);

    List<Data> selectAll();

    int updateByPrimaryKey(Data record);

    List<Data> selectTen();
}