package com.devfun.settingweb_boot.service;

import com.devfun.settingweb_boot.dao.StatisticMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StatisticServiceImpl implements StatisticService {
    private StatisticMapper uMapper;

    public StatisticServiceImpl(StatisticMapper uMapper) {
        this.uMapper = uMapper;
    }

    @Override
    public HashMap<String, Object> yearloginNum (String year) {
        //TODO Auto-generated method stub
        HashMap<String, Object> retVal = new HashMap<String,Object>();

        try {
            retVal = uMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);

        }catch(Exception e) {
            e.printStackTrace();
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }

        return retVal;
    }
}
