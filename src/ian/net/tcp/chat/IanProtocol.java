package ian.net.tcp.chat;

public interface IanProtocol{

	int PROTOCOL_LEN = 7;
	String MSG_ROUND = "msg_ian";
	String USER_ROUND = "usr_ian";
	String LOGIN_SUCCESS = "1";
	String NAME_REP = "-1";
	String PRIVATE_ROUND = "prv_ian";
	String SPLIT_SIGN = "`";
}