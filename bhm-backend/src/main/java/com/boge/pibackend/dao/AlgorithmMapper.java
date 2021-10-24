package com.boge.pibackend.dao;

import com.boge.pibackend.entity.Algorithm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgorithmMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Algorithm record);

    Algorithm selectByPrimaryKey(Long id);

    List<Algorithm> selectAll();

    int updateByPrimaryKey(Algorithm record);
}