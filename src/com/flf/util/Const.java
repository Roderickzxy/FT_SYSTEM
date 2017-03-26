package com.flf.util;

import org.springframework.context.ApplicationContext;

public class Const {
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_HIRER = "sessionHirer";
	public static final String SESSION_OWNER = "sessionOwner";
	public static final String SESSION_USER_RIGHTS = "sessionUserRights";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";

	public static final Float Fee = 1f;// 手续费取值范围:1f~2f , 1.03f代表收3%的手续费
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)).*"; // 不对匹配该值的访问路径拦截（正则）
	// 匹配/upload/html/下的静态资源。
	public static final String NO_INTERCEPTOR_PATH2 = "(/upload/html/)(.*?)(.html)";
	// 匹配微信回返路径。
	public static final String NO_INTERCEPTOR_PATH3 = ".*/wxOrder/getPayResult.html";
	// 收发信息后台。
	public static final String NO_INTERCEPTOR_PATH4 = ".*/weChat.html";
	// 匹配/web/index/下的静态资源
	public static final String NO_INTERCEPTOR_PATH5 = "(/web/index)(.*?)(.*?)";
	public static final String NO_INTERCEPTOR_PATH51 = "(/zk/index)(.*?)(.*?)";
	public static final String NO_INTERCEPTOR_PATH52 = "(/fd/index)(.*?)(.*?)";
	// 匹配/web/下的静态资源。
	public static final String NO_INTERCEPTOR_PATH6 = "(/web)(.*?)(.*?)";
	public static final String NO_INTERCEPTOR_PATH7 = ".*/(web/zk/zk_index).*"; // 不对匹配该值的访问路径拦截（正则）
	public static final String NO_INTERCEPTOR_PATH8 = ".*/(web/fd/fd_index).*"; // 不对匹配该值的访问路径拦截（正则）
	// 匹配访问/web/zk下的资源,进行限制操作,设置跳转租客页面
	public static final String NO_INTERCEPTOR_PATH9 = "(/web/zk)(.*?)(.*?)";
	// 匹配访问/web/fd下的资源,进行限制操作,设置跳转房东页面
	public static final String NO_INTERCEPTOR_PATH10 = "(/web/fd)(.*?)(.*?)";
	public static ApplicationContext WEB_APP_CONTEXT = null; // 该值会在web容器启动时由WebAppContextListener初始化
	// /upload/html/20151110/40eb427b-b972-4ec7-bff1-c6041c64ae7f.html
	/*------------------------------------微信参数----------------------------------------*/
	/*------------------------------------素材管理----------------------------------------*/
	// 图文添加
	public static final String MATERIAL_NEWS_ADD = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	// 图片添加
	public static final String MATERIAL_IMG_ADD = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	// 其他资源添加
	public static final String MATERIAL_RES_ADD = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";

	// 素材删除
	public static final String MATERIAL_DEL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";

	// 列表查询
	public static final String MATERIAL_LIST = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	// 按ID查询,图片则直接获取图片，图文则回复json数据
	public static final String MATERIAL_GET = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	// 查询素材总数
	public static final String MATERIAL_COUNT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";

	// 素材修改
	public static final String MATERIAL_UPDATE = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
	/*------------------------------------素材管理----------------------------------------*/
	/*------------------------------------分组管理----------------------------------------*/
	// 创建分组
	public static final String GROUPS_ADD = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";

	// 分组删除
	public static final String GROUPS_DEL = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=ACCESS_TOKEN";

	// 查询所有分组
	public static final String GROUPS_LIST = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	// 查询用户所在分组
	public static final String GROUPS_GET = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";

	// 分组修改
	public static final String GROUPS_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	// 移动用户分组
	public static final String MEMBER_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	// 批量移动用户分组
	public static final String MEMBERS_BATCHUPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";
	/*------------------------------------分组管理----------------------------------------*/
	/*------------------------------------用户管理----------------------------------------*/

	// 批量查询用户信息(UnionID机制)
	public static final String USERINFO_LIST = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	// 单个查询用户信息(UnionID机制)
	public static final String USERINFO_GET = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 批量查询用户open_id
	// 用户量少于10000时
	public static final String USER_LIST = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
	// 用户量多于10000时
	public static final String USER_LIST_NEXT = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=OPENID";

	// 用户同意授权，获取code
	public static final String USER_AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize";
	// 通过code换取网页授权access_token
	public static final String USER_ACCESSTOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
	// 获取详细用户信息,scope = "snsapi_userinfo"时
	public static final String USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	/*------------------------------------用户管理----------------------------------------*/
	/*------------------------------------消息管理----------------------------------------*/

	// 消息图片上传
	public static final String MESSAGE_UPLOAD_IMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	// 消息图文上传
	public static final String MESSAGE_UPLOAD_NEWS = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";

	// 分组群发
	public static final String MESSAGE_SEND_GROUP = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	// 按指定open_id列表群发
	public static final String MESSAGE_SEND_OPENID = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
	// 删除群发消息
	public static final String MESSAGE_DEL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";

	// 调试预览接口
	public static final String MESSAGE_PREVIEW = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
	// 查看群发状态
	public static final String MESSAGE_STATUS = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";

	/*------------------------------------消息管理----------------------------------------*/
	/*------------------------------------菜单管理----------------------------------------*/
	// 菜单创建
	public static final String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	// 菜单删除
	public static final String MENU_DEL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	// 菜单查询
	public static final String MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	// 菜单自定义查询
	public static final String MENU_GETINFO = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

	/*------------------------------------菜单管理----------------------------------------*/
	/*------------------------------------微信支付----------------------------------------*/
	// 下单地址
	public static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	// 订单关闭
	public static final String CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";
	// 订单查询
	public static final String QUERY_ORDER_URL = "https://api.mch.weixin.qq.com/pay/orderquery";

	// 申请退款
	public static final String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	// 查询退款
	public static final String QUERY_REFUND_URL = "https://api.mch.weixin.qq.com/pay/refundquery";
	// 下载对账单（微信在次日9点启动生成前一天的对账单，建议商户10点后再获取；）
	public static final String DOWNLOAD_BILL_URL = "https://api.mch.weixin.qq.com/pay/downloadbill";

	// 企业付款
	public static final String TRANSFERS_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	// 查询企业付款
	public static final String TRANSFERS_INFO_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";
	/*------------------------------------微信支付----------------------------------------*/
	/*------------------------------------微信摇一摇设备----------------------------------------*/
	// 申请
	public static final String DEVICE_APPLY = "https://api.weixin.qq.com/shakearound/device/applyid?access_token=ACCESS_TOKEN";
	// 查询设备ID申请审核状态
	public static final String DEVICE_STATUS = "https://api.weixin.qq.com/shakearound/device/applystatus?access_token=ACCESS_TOKEN";
	// 查询设备列表
	public static final String DEVICE_SEARCH = "https://api.weixin.qq.com/shakearound/device/search?access_token=ACCESS_TOKEN";

	// 编辑设备信息
	public static final String DEVICE_UPDATE = "https://api.weixin.qq.com/shakearound/device/update?access_token=ACCESS_TOKEN";

	// 配置设备与门店的关联关系
	public static final String DEVICE_BINDLOCATION = "https://api.weixin.qq.com/shakearound/device/bindlocation?access_token=ACCESS_TOKEN";
	/*------------------------------------微信摇一摇设备----------------------------------------*/
	/*------------------------------------微信摇一摇页面----------------------------------------*/
	// 上传摇一摇图片素材
	public static final String PAGE_UPLOADIMG = "https://api.weixin.qq.com/shakearound/material/add?access_token=ACCESS_TOKEN&type=TYPE";
	// 新增页面
	public static final String PAGE_ADD = "https://api.weixin.qq.com/shakearound/page/add?access_token=ACCESS_TOKEN";
	// 删除页面
	public static final String PAGE_DELETE = "https://api.weixin.qq.com/shakearound/page/delete?access_token=ACCESS_TOKEN";
	// 查询页面列表
	public static final String PAGE_SEARCH = "https://api.weixin.qq.com/shakearound/page/search?access_token=ACCESS_TOKEN";
	// 编辑页面信息
	public static final String PAGE_UPDATE = "https://api.weixin.qq.com/shakearound/page/update?access_token=ACCESS_TOKEN";
	/*------------------------------------微信摇一摇页面----------------------------------------*/
	/*------------------------------------微信摇一摇设备关联页面----------------------------------------*/
	// 新增/修改关联
	public static final String DEVICE_BIND_PAGE = "https://api.weixin.qq.com/shakearound/device/bindpage?access_token=ACCESS_TOKEN";
	// 查询关联
	public static final String RELATION_SEARCH = "https://api.weixin.qq.com/shakearound/relation/search?access_token=ACCESS_TOKEN";
	/*------------------------------------微信摇一摇设备关联页面----------------------------------------*/

	/*------------------------------------资源参数----------------------------------------*/
	// 上传资源参数
	public static final String RESOURCE_UP_IMG = "image";
	public static final String RESOURCE_UP_NEWS = "news";
	public static final String RESOURCE_UP_VOICE = "voice";
	public static final String RESOURCE_UP_VIDEO = "video";
	public static final String RESOURCE_UP_THUMB = "thumb";

	// 微信摇一摇页面图片资源参数
	public static final String PAGE_UP_ICON = "icon";
	public static final String PAGE_UP_LICENSE = "license";
	// 群发资源参数
	public static final String RESOURCE_MP_IMG = "image";
	public static final String RESOURCE_MP_NEWS = "mpnews";
	public static final String RESOURCE_MP_TEXT = "text";
	public static final String RESOURCE_MP_VOICE = "voice";
	public static final String RESOURCE_MP_VIDEO = "mpvideo";
	public static final String RESOURCE_MP_CARD = "wxcard";// 卡券
	public static final String RESOURCE_MP_MUSIC = "music";
	// 菜单按钮种类
	public static final String BUTTON_VIEW = "view";// 跳转URL
	public static final String BUTTON_CLICK = "click";// 点击推事件
	public static final String BUTTON_SCANCODE_PUSH = "scancode_push";// 扫码推事件
	public static final String BUTTON_SCANCODE_WAITMSG = "scancode_waitmsg";// 扫码推事件且弹出“消息接收中”提示框
	public static final String BUTTON_PIC_SYSPHOTO = "pic_sysphoto";// 弹出系统拍照发图
	public static final String BUTTON_PHOTO_OR_ALBUM = "pic_photo_or_album";// 弹出拍照或者相册发图
	public static final String BUTTON_PIC_WX = "pic_weixin";// 弹出微信相册发图器
	public static final String BUTTON_SELECT = "location_select";// 弹出地理位置选择器
	public static final String BUTTON_MEDIA_ID = "media_id";// 下发消息（除文本消息）
	public static final String BUTTON_VIEW_LIMITED = "view_limited";// 跳转图文消息URL
	/*------------------------------------资源参数----------------------------------------*/
	/*------------------------------------链接参数----------------------------------------*/
	public static final String LINK_BASIC = "basic";
	public static final String LINK_IMG = "image";
	/*------------------------------------链接参数----------------------------------------*/
	/*------------------------------------用户授权参数----------------------------------------*/
	public static final String GRANT_TYPE = "authorization_code";
	// 不弹出授权页面，直接跳转，只能获取用户openid
	public static final String SCOPE_BASE = "snsapi_base";
	// 弹出授权页面，可通过openid拿到昵称、性别、所在地。
	public static final String SCOPE_INFO = "snsapi_userinfo";
	/*------------------------------------用户授权参数----------------------------------------*/
	/*------------------------------------微信支付参数----------------------------------------*/
	public static final String TRADE_TYPE_JSAPI = "JSAPI";// 公众号支付
	public static final String TRADE_TYPE_NATIVE = "NATIVE";// 原生扫码支付
	public static final String TRADE_TYPE_APP = "APP";// app支付
	public static final String TRADE_TYPE_MICROPAY = "MICROPAY";// 刷卡支付

	// 签名生成方式
	public static final String SIGN_TYPE = "sha1";

	// 订单交易状态
	public static final String TRATESTATE_SUCCESS = "SUCCESS";// 支付成功
	public static final String TRATESTATE_REFUND = "REFUND";// 转入退款
	public static final String TRATESTATE_NOTPAY = "NOTPAY";// 未支付
	public static final String TRATESTATE_CLOSED = "CLOSED";// 已关闭
	public static final String TRATESTATE_REVOKED = "REVOKED";// 已撤销（刷卡支付）
	public static final String TRATESTATE_USERPAYING = "USERPAYING";// 用户支付中
	public static final String TRATESTATE_PAYERROR = "PAYERROR";// 支付失败(其他原因，如银行返回失败)

	// 企业支付，运用证书所需要的参数
	public static final String TLSv1 = "TLSv1";
	public static final String PKCS12 = "PKCS12";

	// 企业付款，付款状态
	// SUCCESS:转账成功 FAILED:转账失败 PROCESSING:处理中
	public static final String TRANSFER_STATUS_SUCCESS = "SUCCESS";
	public static final String TRANSFER_STATUS_FAILED = "FAILED";
	public static final String TRANSFER_STATUS_PROCESSING = "PROCESSING";
	// 企业付款，检验真实姓名
	// 不校验真实姓名
	public static final String TRANSFER_CHECKNAME_NO = "NO_CHECK";
	// 强校验真实姓名（未实名认证的用户会校验失败，无法转账）
	public static final String TRANSFER_CHECKNAME_FORCE = "FORCE_CHECK";
	// 针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
	public static final String TRANSFER_CHECKNAME_OPTION = "OPTION_CHECK";

	/*------------------------------------微信支付参数----------------------------------------*/
	/*------------------------------------微信参数----------------------------------------*/

	/*------------------------------------百度地图----------------------------------------*/
	public static final String BAIDU_MAP_AK = "97ab3eb1f34fb6d2b920e30247badfc1";// 百度地图AK
	public static final String BAIDU_MAP_CITY = "东莞";// 初始化城市
	public static final Integer BAIDU_MAP_LEVEL = 15;// 地图级别
	public static final Double BAIDU_MAP_LNG = 113.758231;// 经度
	public static final Double BAIDU_MAP_LAT = 23.027064;// 纬度

	/*------------------------------------短信接口----------------------------------------*/
	public static final String SMS_UID = "yanqiuping_lw";
	public static final String SMS_PSW = "Tch123456";
	public static final String SMS_URL = "http://222.73.117.158/msg/";
	/*------------------------------------系统参数----------------------------------------*/
	public static final String DELETEFLAG_YES = "Y";
	public static final String DELETEFLAG_NO = "N";
	/*------------------------------------收益发放参数----------------------------------------*/
	// sql查询排组种类
	public static final String QUERY_GROUPTYPE_YEAR = "year";
	public static final String QUERY_GROUPTYPE_QUARTER = "quarter";
	public static final String QUERY_GROUPTYPE_MONTH = "month";
	public static final String QUERY_GROUPTYPE_YEAR_QUARTER = "year_quarter";
	public static final String QUERY_GROUPTYPE_YEAR_MONTH = "year_month";

	public static final String INCOME_DELETEFLAG_YES = "1";
	public static final String INCOME_DELETEFLAG_NO = "0";
}
