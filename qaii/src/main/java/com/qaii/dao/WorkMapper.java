package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Work;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
    
    int selectCountNum();
    
    List<Work> getAllWorkMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
    
    int countEachMonthwork(String firstDay, String endDay);
    
    Work getMessage(Integer id);
    
    int insertMessage(Work record);
    
    List<Work> listNotPass();
    List<String> selectAllpathTable();
    List<String> selectTablename();
    List<String> selectTablenamePath();
    List<String> selectPathBytableName(@Param(value = "Tablename") String Tablename);
    List<String> selectPathBytableNamePath(@Param(value = "Tablename") String Tablename);
    List<String> selectqueUrl();

    int countMessageNotice();
}