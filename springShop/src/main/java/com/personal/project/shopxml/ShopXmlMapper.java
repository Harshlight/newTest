package com.personal.project.shopxml;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.personal.project.vo.ShopVO;

@Mapper
public interface ShopXmlMapper {
	
	boolean insert(ShopVO s);
	int insertAndGetId(ShopVO s);
	ShopVO select(int num);
	boolean update(ShopVO s);
	boolean delete(int num);
	List<ShopVO> getList();
}
