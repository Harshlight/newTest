package com.personal.project.orderxml;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.personal.project.vo.OrderVO;

@Mapper
public interface OrderXmlMapper {
	int insertOrder(OrderVO ovo);
	List<OrderVO> getOrderList(String uid);
	List<OrderVO> getOrderCheckList();
}
