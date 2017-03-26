package com.flf.mapper;

import java.util.List;
import com.flf.entity.Pic;

public interface PicMapper {
	Pic getPicById(Integer id);
	List<Pic> listAllPic();
	List<Pic> listPagePic(Pic pic);
	List<Pic> listPicJoinPicType(Pic pic);
	void insertPic(Pic pic);
	void updatePic(Pic pic);
	void deletePicById(Integer id);
	int getCountByTitle(Pic pic);
}