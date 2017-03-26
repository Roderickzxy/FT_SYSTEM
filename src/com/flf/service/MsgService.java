package com.flf.service;

import java.util.List;
import com.flf.entity.Msg;

public interface MsgService {
	Msg getMsgById(Integer msgId);
	List<Msg> listAllMsg();
	List<Msg> listPageMsg(Msg msg);
	List<Msg> listMsgJoinMsgType(Msg msg);
	boolean insertMsg(Msg msg);
	boolean updateMsg(Msg msg);
	void deleteMsgById(Integer msgId);
}
