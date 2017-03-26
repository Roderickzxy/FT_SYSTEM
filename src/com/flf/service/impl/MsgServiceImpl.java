package com.flf.service.impl;

import java.util.List;

import com.flf.entity.Msg;
import com.flf.mapper.MsgMapper;
import com.flf.service.MsgService;

public class MsgServiceImpl implements MsgService {

	private MsgMapper msgMapper;

	// 删除一条记录
	public void deleteMsgById(Integer msgId) {
		msgMapper.deleteMsgById(msgId);
	}

	// 获取单条记录
	public Msg getMsgById(Integer msgId) {
		return msgMapper.getMsgById(msgId);
	}

	// 修改记录
	public boolean updateMsg(Msg msg) {
		if (msgMapper.getCountByTitle(msg) > 0)
			return false;
		else {
			msgMapper.updateMsg(msg);
			return true;
		}
	}

	// 插入一条记录
	public boolean insertMsg(Msg msg) {
		if (msgMapper.getCountByTitle(msg) > 0)
			return false;
		else {
			msgMapper.insertMsg(msg);
			return true;
		}
	}

	// 获取所有有记录
	public List<Msg> listAllMsg() {
		return msgMapper.listAllMsg();
	}

	public List<Msg> listMsgJoinMsgType(Msg msg) {
		return msgMapper.listMsgJoinMsgType(msg);
	}

	public List<Msg> listPageMsg(Msg msg) {
		return msgMapper.listPageMsg(msg);
	}

	public MsgMapper getMsgMapper() {
		return msgMapper;
	}

	public void setMsgMapper(MsgMapper msgMapper) {
		this.msgMapper = msgMapper;
	}
}
