package com.flf.service;

import java.util.List;
import com.flf.entity.PicType;

public interface PicTypeService {
	List<PicType> listAllPicType();
	List<PicType> listAllParentPicType();
	List<PicType> listSubPicTypeByParentId(Integer parentId);
	PicType getPicTypeById(Integer id);
	void savePicType(PicType picType);
	void deletePicTypeById(Integer id);
	List<PicType> listAllSubPicType();
}
