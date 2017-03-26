package com.flf.mapper;

import java.util.List;
import com.flf.entity.MsgType;

public interface MsgTypeMapper {
	List<MsgType> listAllParentMsgType();
	List<MsgType> listSubMsgTypeByParentId(Integer parent);
	MsgType getMsgTypeById(Integer id);
	void insertMsgType(MsgType msgType);
	void updateMsgType(MsgType msgType);
	void deleteMsgTypeById(Integer id);
	List<MsgType> listAllSubMsgType();
	int getCountMsgTypeByName(MsgType msgType);
}
