package com.personal.project.listxml;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.personal.project.vo.ShopVO;

//@Repository
//public interface ListMapper extends JpaRepository<ShopVO, Integer> {
//	Page <ShopVO> findAllByNum(Integer num, Pageable pageable);
//	
//}

@Mapper
public interface ListMapper {
	List<ShopVO> getProductList();
}