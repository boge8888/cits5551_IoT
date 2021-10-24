package com.boge.pibackend.dao;

import com.boge.pibackend.entity.Bridge;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BridgeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bridge record);

    Bridge selectByPrimaryKey(Long id);

    List<Bridge> selectAll();

    int updateByPrimaryKey(Bridge record);
}