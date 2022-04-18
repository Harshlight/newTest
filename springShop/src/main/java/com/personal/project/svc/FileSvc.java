package com.personal.project.svc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.personal.project.dao.ImgpathDAO;
import com.personal.project.dao.PfimgDAO;
import com.personal.project.vo.ImgpathVO;
import com.personal.project.vo.PfimgpathVO;
import com.personal.project.vo.ShopVO;
import com.personal.project.vo.UserVO;



@Service
public class FileSvc {
	
	@Autowired 
	private ImgpathDAO idao;

	@Autowired
	private PfimgDAO pdao;
	
//	/opt/tomcat9/webapps/ROOT/WEB-INF/classes/com/personal/project/svc
//	/opt/tomcat9/webapps/ROOT/WEB-INF/classes/static/img
	
	public List<ImgpathVO> insertproductimg(ShopVO s, @RequestParam("imgpath")MultipartFile[] mfiles) {
		String savePath = ("/opt/tomcat9/webapps/ROOT/WEB-INF/classes/static/img");
		try {
			List <ImgpathVO> ivolist = new ArrayList<>();
			for(int i=0;i<mfiles.length;i++) {
 				mfiles[i].transferTo(new File(savePath+"/"+mfiles[i].getOriginalFilename()));
					String filename = mfiles[i].getOriginalFilename();
		            ImgpathVO ivo = new ImgpathVO();
		            ivo.setNum(s.getNum());
		            ivo.setName(s.getName());
		            ivo.setImgpath(filename);
		            ivolist.add(ivo);
		 		}
				return ivolist;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	
	public boolean insert(List<ImgpathVO> insertproductimg) {
		int rows = 0;
		for(int i=0; i<insertproductimg.size(); i++) {
			rows += idao.insert(insertproductimg.get(i));
		}
		if (rows==insertproductimg.size()) {
			return true;
		} else {
			return false;
		}
		
	}

	public ImgpathVO find(int num) {
		return idao.select(num);
	}
	
	public List<ImgpathVO> selectimgpath(int num) {
		return idao.selectimgpath(num);
	}

	public boolean delete(int num) {
		return idao.delete(num);
	}
	
	public List<PfimgpathVO> insertpfimg(UserVO vo, @RequestParam("pfiles")MultipartFile[] mfiles) {
		String savePath = ("/opt/tomcat9/webapps/ROOT/WEB-INF/classes/static/pfimg");
		try {
			List <PfimgpathVO> pflist = new ArrayList<>();
			for(int i=0;i<mfiles.length;i++) {
				mfiles[i].transferTo(new File(savePath+"/"+mfiles[i].getOriginalFilename()));
				String filename = mfiles[i].getOriginalFilename();
				PfimgpathVO ivo = new PfimgpathVO();
				ivo.setNum(vo.getNum());
				ivo.setUid(vo.getUid());
				ivo.setPfimg(filename);
				pflist.add(ivo);
			}
				return pflist;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} 
	
	public boolean pfimg(List<PfimgpathVO> pflist) {
		int rows = 0;
		for(int i=0; i<pflist.size(); i++) {
			rows += pdao.insert(pflist.get(i));
		}
		if (rows==pflist.size()) {
			return true;
		} else {
			return false;
		}
		
	}

	public List<PfimgpathVO>  selectpfimgpath(UserVO vo) {
		return pdao.selectpfimgpath(vo);
	}
	
}
