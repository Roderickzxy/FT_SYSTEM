package com.flf.service.impl;

import java.util.List;
import com.flf.entity.PicType;
import com.flf.mapper.PicTypeMapper;
import com.flf.service.PicTypeService;


public class PicTypeServiceImpl implements PicTypeService{
	
	private PicTypeMapper picTypeMapper;

	public void deletePicTypeById(Integer id) {
		picTypeMapper.deletePicTypeById(id);
	}

	public PicType getPicTypeById(Integer id) {
		return picTypeMapper.getPicTypeById(id);
	}

	public List<PicType> listAllParentPicType() {
		return picTypeMapper.listAllParentPicType();
	}

	public void savePicType(PicType picType) {
		if(picType.getId()!=null && picType.getId().intValue()>0){
			picTypeMapper.updatePicType(picType);
		}else{
			picTypeMapper.insertPicType(picType);
		}
	}

	public List<PicType> listSubPicTypeByParentId(Integer parentId) {
		return picTypeMapper.listSubPicTypeByParentId(parentId);
	}
	
	public List<PicType> listAllPicType() {
		List<PicType> rl = this.listAllParentPicType();
		for(PicType picType : rl){
			List<PicType> subList = this.listSubPicTypeByParentId(picType.getId());
			picType.setSubPicType(subList);
		}
		return rl;
	}

	public List<PicType> listAllSubPicType(){
		return picTypeMapper.listAllSubPicType();
	}

	public PicTypeMapper getPicTypeMapper() {
		return picTypeMapper;
	}

	public void setPicTypeMapper(PicTypeMapper picTypeMapper) {
		this.picTypeMapper = picTypeMapper;
	}
}
