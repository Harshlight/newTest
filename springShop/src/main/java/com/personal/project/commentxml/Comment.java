package com.personal.project.commentxml;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.personal.project.vo.ShopCommentVO;

@Mapper
public interface Comment {
	boolean inputcomment(ShopCommentVO scvo);
	ShopCommentVO selectcomment(int num);
	List<ShopCommentVO> selectcommentList(int num);
}
