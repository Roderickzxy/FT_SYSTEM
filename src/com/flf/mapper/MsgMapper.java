package com.flf.mapper;

import java.util.List;
import com.flf.entity.Msg;

public interface MsgMapper {
	Msg getMsgById(Integer msgId);
	List<Msg> listAllMsg();
	List<Msg> listPageMsg(Msg msg);
	List<Msg> listMsgJoinMsgType(Msg msg);
	void insertMsg(Msg msg);
	void updateMsg(Msg msg);
	void deleteMsgById(Integer msgId);
	int getCountByTitle(Msg msg);
}
