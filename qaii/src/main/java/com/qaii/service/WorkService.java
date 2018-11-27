package com.qaii.service;

import java.util.List;

import com.qaii.domain.Work;

public interface WorkService {
	
	int getCountNum();
	
	List<Work> getAllWorkMsg();
	
	int deleteMsg(Integer[] eid);

	Work getMessage(int id);

	int updateMsg(Work work);

	int insertMsg(Work work);
	
	int countEachMonthwork(String firstDay, String endDay);

	int insertMessage(Work work);
	
	List<Work> listNotPass();
	//查询字段带path的表名
	List<String> selectAllpathTable();
	//查询字段中是file_path的表名
	List<String> selectTable();
	//查询字段中是path的表名
	List<String> selectTablenamePath();
	List<String> selectPathBytableName(String Tablename);
	List<String> selectPathBytableNamePath(String Tablename);
	List<String> selectqueUrl();
}
