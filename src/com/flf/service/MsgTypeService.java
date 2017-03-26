package com.flf.service;

import java.util.List;
import com.flf.entity.MsgType;

public interface MsgTypeService {
	List<MsgType> listAllMsgType();
	List<MsgType> listAllParentMsgType();
	List<MsgType> listSubMsgTypeByParentId(Integer parentId);
	MsgType getMsgTypeById(Integer id);
	void saveMsgType(MsgType msgType);
	void deleteMsgTypeById(Integer id);
	List<MsgType> listAllSubMsgType();
}
