package com.flf.service.impl;

import java.util.List;
import com.flf.entity.MsgType;
import com.flf.mapper.MsgTypeMapper;
import com.flf.service.MsgTypeService;


public class MsgTypeServiceImpl implements MsgTypeService{
	
	private MsgTypeMapper msgTypeMapper;

	public void deleteMsgTypeById(Integer id) {
		msgTypeMapper.deleteMsgTypeById(id);
	}

	public MsgType getMsgTypeById(Integer id) {
		return msgTypeMapper.getMsgTypeById(id);
	}

	public List<MsgType> listAllParentMsgType() {
		return msgTypeMapper.listAllParentMsgType();
	}

	public void saveMsgType(MsgType msgType) {
		if(msgType.getId()!=null && msgType.getId().intValue()>0){
			msgTypeMapper.updateMsgType(msgType);
		}else{
			msgTypeMapper.insertMsgType(msgType);
		}
	}

	public List<MsgType> listSubMsgTypeByParentId(Integer parentId) {
		return msgTypeMapper.listSubMsgTypeByParentId(parentId);
	}
	
	public List<MsgType> listAllMsgType() {
		List<MsgType> rl = this.listAllParentMsgType();
		for(MsgType msgType : rl){
			List<MsgType> subList = this.listSubMsgTypeByParentId(msgType.getId());
			msgType.setSubMsgType(subList);
		}
		return rl;
	}

	public List<MsgType> listAllSubMsgType(){
		return msgTypeMapper.listAllSubMsgType();
	}

	public MsgTypeMapper getMsgTypeMapper() {
		return msgTypeMapper;
	}

	public void setMsgTypeMapper(MsgTypeMapper msgTypeMapper) {
		this.msgTypeMapper = msgTypeMapper;
	}

}
