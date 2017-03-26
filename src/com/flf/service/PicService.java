package com.flf.service;

import java.util.List;

import com.flf.entity.Pic;

public interface PicService {
	Pic getPicById(Integer id);
	List<Pic> listAllPic();
	List<Pic> listPagePic(Pic pic);
	List<Pic> listPicJoinPicType(Pic pic);
	boolean insertPic(Pic pic);
	boolean updatePic(Pic pic);
	void deletePicById(Integer id);
}
