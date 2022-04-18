// package com.personal.project.util;
//package com.personal.project.shopxml;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.personal.project.vo.ShopVO;
//
//@Repository("mysqlDao")
//public class ShopMysqlDAO implements shopxml {
//	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
////	@Override
////	public boolean insert(ShopVO s) {
////		String sql = "INSERT INTO shop VALUES(NULL,?,?,?,?,?,?)";
////		int rows = jdbcTemplate.update(sql, s.getName(), s.getCom(), s.getSum(),s.getPrice(),s.getPdate(),s.getImgpath());
////		return rows>0;
////	}
//	
//	@Override
//	public boolean insert(ShopVO s) {
//		String sql = "INSERT INTO shop VALUES(NULL,?,?,?,?,?)";
//		int rows = jdbcTemplate.update(sql, s.getName(), s.getCom(), s.getSum(),s.getPrice(),s.getPdate());
//		return rows>0;
//	}
//
////	@Override
////	public boolean insertimg(ShopVO s) {
////		String sql = "INSERT INTO shopimg VALUES(NULL,?)";
////		int rows = jdbcTemplate.update(sql, s.getName(), s.getCom(), s.getSum(),s.getPrice(),s.getPdate(),s.getImgpath());
////		return rows>0;
////	}
//	
//	@Override 
//	public int insertAndGetId(ShopVO s) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ShopVO select(int num) {
//		String sql = "SELECT * FROM shop WHERE num=?";
//		return jdbcTemplate.queryForObject(sql, (rs,i)->
//			new ShopVO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getString(6))
//			,num);	
//	}
//
////	@Override
////	public boolean update(ShopVO s) {
////		String sql = "UPDATE shop SET sum=?, price=?, imgpath=? WHERE num=?";
////		int rows = jdbcTemplate.update(sql, s.getSum(), s.getPrice(), s.getImgpath(), s.getNum());
////		return rows>0;
////	}
//	@Override
//	public boolean update(ShopVO s) {
//		String sql = "UPDATE shop SET sum=?, price=? WHERE num=?";
//		int rows = jdbcTemplate.update(sql, s.getSum(), s.getPrice(), s.getNum());
//		return rows>0;
//	}
//
//	@Override
//	public boolean delete(int num) {
//		String sql = "DELETE FROM shop WHERE num=?";
//		int rows = jdbcTemplate.update(sql,num);
//		return rows>0;
//	}
//
//	@Override
//	public List<ShopVO> getList() {
//		String sql = "SELECT * FROM shop";
//		return jdbcTemplate.query(sql, (rs,i)->
//			new ShopVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getString(6)));
//	}
//
//}
