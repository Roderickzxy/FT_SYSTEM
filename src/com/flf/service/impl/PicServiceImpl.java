package com.flf.service.impl;

import java.util.List;

import com.flf.entity.Pic;
import com.flf.mapper.PicMapper;
import com.flf.service.PicService;

public class PicServiceImpl implements PicService{

	private PicMapper picMapper;
	
	//删除一条记录
	public void deletePicById(Integer id) {
		picMapper.deletePicById(id);
	}
	
	//获取单条记录
	public Pic getPicById(Integer id) {
		return picMapper.getPicById(id);
	}
	
	//修改记录
	public boolean updatePic(Pic Pic) {
		if(picMapper.getCountByTitle(Pic)>0)
			return false;
		else{
			picMapper.updatePic(Pic);
			return true;
		}
	}
	
	//插入一条记录
	public boolean insertPic(Pic Pic) {
		if(picMapper.getCountByTitle(Pic)>0)
			return false;
		else{
			picMapper.insertPic(Pic);
			return true;
		}
	}
	
	//获取所有有记录
	public List<Pic> listAllPic() {
		return picMapper.listAllPic();
	}
	
	public List<Pic> listPagePic(Pic Pic) {
		return picMapper.listPagePic(Pic);
	}
	
	
	public List<Pic> listPicJoinPicType(Pic pic) {
		return picMapper.listPicJoinPicType(pic);
	}
	
	public PicMapper getPicMapper() {
		return picMapper;
	}

	public void setPicMapper(PicMapper picMapper) {
		this.picMapper = picMapper;
	}
}
