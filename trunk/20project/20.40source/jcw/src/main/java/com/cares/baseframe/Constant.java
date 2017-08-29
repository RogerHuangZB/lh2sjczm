package com.cares.baseframe;

@SuppressWarnings("all")
public class Constant {
	
	public static String WEB_ROOT_PATH = null;
	public static String SUPER_ADMIN = "ADMIN";
	public static String VALIDITY_CONTANT = "1";
	public static String UNVALIDITY_CONTANT = "0";
	public static String UNIT_ADMIN = "UNIT_ADMIN";
	
	public static String FIRST_LEVEL_CONTANT = "1";
	public static String SECORD_LEVEL_CONTANT = "2";
	public static String THREE_LEVEL_CONTANT = "3";
	
	public static String AIRPORT_PROPERTY_DOM = "DOM";//国内
	public static String AIRPORT_PROPERTY_INT = "INT";//国际
	public static String AIRPORT_PROPERTY_REG = "REG";//地区
	
	public static String CAMERATRUE="1";//能拍照
	public static String CAMERAFALSE="0";//不能拍照
	
	public static String READERSTATUS_Y="Y";//读卡器状态正常
	public static String READERSTATUS_N="N";//读卡器状态异常
	
	public static String READERTYPE_M="M";//移动
	public static String READERTYPE_F="F";//固定
	
	public static String SCAN_MODEL_M="1";//扫描模式为monitor
	public static String SCAN_MODEL_P="2";//扫描模式为poll
	
	public static String VALIDITY="1";//有效
	public static String INVALIDITY="0";//无效
	
	public static String DEFAULT_AIRPORT = "PVG";//默认
	
	public static String AIRPORT_LEVEL_1 = "1";//一类机场
	public static String AIRPORT_LEVEL_2 = "2";//二类机场
	public static String AIRPORT_LEVEL_3 = "3";//三类机场
	
	public static String AIRPORT_STATUS_GREEN="GREEN";//设备修复
	public static String AIRPORT_STATUS_YELLOW="YELLOW";//读卡器或者天线故障
	public static String AIRPORT_STATUS_RED="RED";//服务器故障
	
	public static int READER_STATUS_TYPE_READER_ERROR=1;//读卡器故障
	public static int READER_STATUS_TYPE_ANTENNA_ERROR=2;//天线故障
	public static int READER_STATUS_TYPE_SERVER_ERROR=3;//服务器故障
	
	public static String READER_ERROR="READER_ERROR";//读卡器故障
	public static String ANTENNA_ERROR="ANTENNA_ERROR";//天线故障
	public static String SERVER_ERROR="SERVER_ERROR";//服务器故障
	
	public static int READER_STATUS_ERROR=0;//设备故障未恢复
	public static int READER_STATUS_RENEW=1;//设备故障已恢复
	
	public static String  FLT_STATUS_DELAY="延误";//航班状态延误
	public static String  FLT_STATUS_ONTIME="正点";//航班状态正点
	public static String  FLT_STATUS_CANCLE="取消";//航班状态取消
	
	/**
	 * IPC信息通知
	 */
	public static String IPC_INFO_NOTIFY="IPC_INFO_NOTIFY";
	/**
	 * 信息表更
	 */
	public static String IPC_INFO_NOTIFY_INFOCHANGE="INFO_CHG";
	/**
	 * 获取视频
	 */
	public static String IPC_INFO_NOTIFY_GETVIDO="GETVIDO";
	public static String IPC_INFO_NOTIVY_GETVIDO_BEGIN="GETVIDO_BEGIN";
	public static String IPC_INFO_NOTIFY_GETVIDO_END="GETVIDO_END";
	
	public static String YES="Y";
	public static String NO = "N";
	/**
	 * 节点类型：进港
	 */
	public static String NODE_TYPE_ARR="1";
	/**
	 * 节点类型：出港
	 */
	public static String NODE_TYPE_DEP ="2";
	
	/**放入缓存的工控机版本号命名空间**/
	public static String CACHE_NAMESPACE_IPC_HEATH_VERSION = "ipcHeathVersion";
	
	static{
		try {
			String path = System.getProperty("user.dir");
			System.out.println("path1="+path);
			path = path.replace("bin", "webapps/vidos/");
			System.out.println("path2="+path);
			WEB_ROOT_PATH = path;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static String LOCAL_BATH_STATIC_FILE_PATH = "LOCAL_BATH_STATIC_FILE_PATH";
	
	//进港模块
	public static String MODULE_ARR="module_arr";
	//离港模块
	public static String MODULE_DEP="module_dep";
	//服务模块
	public static String MODULE_SERVICE="module_service";
	//行李退回标识 Y 是
	public static String BAG_BACK_FLAG_Y="Y";
	//行李退回标识 N 否
	public static String BAG_BACK_FLAG_N="N";
	
	public static String DEP_SIGN="dep"; //起飞
	public static String ARR_SIGN="arr"; //到达
	public static String VIA_SIGN="via"; //中转
	
}