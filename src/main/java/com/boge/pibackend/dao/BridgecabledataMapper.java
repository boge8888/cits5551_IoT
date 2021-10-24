package com.boge.pibackend.dao;

import com.boge.pibackend.entity.Bridgecabledata;
import com.boge.pibackend.entity.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BridgecabledataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bridgecabledata record);

    Bridgecabledata selectByPrimaryKey(Long id);

    List<Bridgecabledata> selectAll();

    int updateByPrimaryKey(Bridgecabledata record);

    List<Bridgecabledata> selectTen();
}