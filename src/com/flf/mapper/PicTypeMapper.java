package com.flf.mapper;

import java.util.List;
import com.flf.entity.PicType;

public interface PicTypeMapper {
	List<PicType> listAllParentPicType();
	List<PicType> listSubPicTypeByParentId(Integer parent);
	PicType getPicTypeById(Integer id);
	void insertPicType(PicType picType);
	void updatePicType(PicType picType);
	void deletePicTypeById(Integer id);
	List<PicType> listAllSubPicType();
	int getCountPicTypeByName(PicType picType);
}
