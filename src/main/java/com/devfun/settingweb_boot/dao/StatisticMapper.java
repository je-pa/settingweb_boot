package com.devfun.settingweb_boot.dao;

import java.util.HashMap;

import com.devfun.settingweb_boot.dto.StatisticDto;
import org.apache.ibatis.annotations.Mapper;

// 인터페이스를 통해 사용할 Mapper를 추상화
public interface StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
}
