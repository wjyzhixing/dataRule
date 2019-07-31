package com.tauk.datarule.exception;

public enum DataExceptionMessage {

	DATA_NOTNULL_RULE(60001, "数据为必填项，但值为空"),
	DATA_NUMBER_TOTAL_BIT_RULE(60002, "数据超过总位数"),
	DATA_NUMBER_TOTAL_FORMATTED_RULE(60003, "数据不符合格式要求"),
	DATA_VARCHAR_TOTAL_BIT_RULE(60004, "数据超过总位数"),
	DATA_SELECT_VALUE_RULE(60005, "选择框没有选择指定范围的值"),
	DATA_DATE_VALUE_RULE(60006, "日期格式不正确"),
	DATA_DATARANGE_RULE(60007,"数据不在历史数据最大最小值范围内"),
	DATA_COMPLETE_RULE(60008,"录入的数据不完整"),
	DATA_RANGE_RULE(60009,"数据不在历史数据最大值最小值范围内"),
	BUSSINESS_ZBYQ_JYJZ(10001,"设备型号中含G、C,绝缘介质应为干式"),
	BUSSINESS_ZBYQ_DYB(10003,"电压比与绕组形式相关，双绕组电压比中有一个‘/’，三绕组电压比中有两个‘/’"),
	BUSSINESS_ZBYQ_TYRQ(10004,"投运日期 大于出场日期"),
	BUSSINESS_ZBYQ_SF6QTBJYL(10007,"SF6变压器按照铭牌填写,绝缘介质非SF6 填0或不填"),
	BUSSINESS_ZBYQ_EDDL(10008,"额定电流在: (额定容量)*1000/(电压段*1.732)范围内。（电压段：750(765)、330(或363)、110(或126)、63(或76.5)、35(或38.5)、10(或11)）"),
	BUSSINESS_ZBYQ_DLZKGYDY(10009,"双绕组：不能为空。三绕组、自耦：短路阻抗（高压-低压）>短路阻抗（高压-中压）"),
	BUSSINESS_ZBYQ_EDRL(10010,"额定容量的等于型号 中-与/ 之间的数除1000"),
	BUSSINESS_ZBYQ_KZSH(10011,"查变压器出厂资料，只填写数字,取值范围:电压等级越低、主变额定容量越小，该值越小；35kV主变，该值一般在1~20；110kV主变，该值一般在10~75；330kV主变，该值一般在30~260(负载损耗>空载损耗≠0)"),
	BUSSINESS_ZBYQ_XS(10012,"设备型号中含字母‘D’的为单相"),
	BUSSINESS_ZBYQ_EDPL(10016,"默认值50"),
	BUSSINESS_ZBYQ_DLZKGYZY(10017,"双绕组：X=0或无或/或\\或空格； 三绕组、自耦：取值范围:20≥X>0。短路阻抗（高压-低压）>短路阻抗（高压-中压）"),
	BUSSINESS_ZBYQ_ZZ(10018,"330kV 100-400T;110kV 20-120T"),
	BUSSINESS_ZBYQ_SF6QTEDYL(10019,"SF6变压器按照铭牌填写,绝缘介质非SF6 填0或不填"),
	BUSSINESS_ZBYQ_YCD(10020,"油浸变压器填写新疆克拉玛依、兰炼，非油浸填写无或/"),
	BUSSINESS_ZBYQ_ZSSP(10021,"取值范围：50到80,风冷应选大一点，只填写数字而不填写字符“dB”"),
	BUSSINESS_ZBYQ_YH(10022,"油浸式变压器全部填写：25或45，数字代表变压器油的凝固点，45为零下45度凝固、25为零下25度凝固。陕西多为25号;非油浸式变压器填写为无"),
	BUSSINESS_ZBYQ_ZLQRL(10023,"冷却方式=OFAF填0，ONAN填“100”；ONAF且铭牌无参数的填“66”，取值范围:50≤ZLQRL≤100"),
	BUSSINESS_ZBYQ_RZXS(10024,"双绕组(型号中仅有1个S)、三绕组(型号中有2个S)、自耦(型号首字母为O) (O开头并且有双S的为三绕组)"),
	BUSSINESS_ZBYQ_LQFS(10025,"对于油浸式变压器，型号中包含“F”和“P”的，选择“强迫油循环(导向)风冷”；型号中仅有“F”没有“P”，选择“自然油循环风冷”；型号中既无“F”又无“P”的，选择“自然冷却”"),
	BUSSINESS_ZBYQ_DYFS(10026,"型号中含“Z”的为有载调压，无“Z”为无励磁调压或无调压，据实填写。型号中喊有'±'一定不为无跳压,无调压在设备型号中不能喊有'±'"),
	BUSSINESS_ZBYQ_DLZKZYDY(10027,"双绕组:X=0或无或/或\\或空格; 三绕组、自耦:40≥X>0,小于高压-低压"),
	BUSSINESS_ZBYQ_FZSHMZ(10028,"查变压器出厂资料，只填写数字，取值范围:电压等级越低、主变额定容量越小，该值越小，且该值均低于10倍的空载损耗值，一般在空载损耗值的7倍以下。35kV主变，该值一般在10~90；110kV主变，该值一般在35~450；330kV主变，该值一般在230~950(负载损耗>空载损耗≠0)"),

	BUSSINESS_SYB_YH(20002,"变压器油的油号，数字代表变压器油的凝固点，45为零下45度凝固、25为零下25度凝固。陕西多为25号，非油浸式变压器不填油号"),
	BUSSINESS_SYB_DYFS(20003,"变压器高压侧绕组调压方式，型号中含“Z”的为有载调压，无“Z”为无励磁调压或无调压，据实填写。"),
	BUSSINESS_SYB_EDPL(20005,"默认 50"),
	BUSSINESS_SYB_TYRQ(20009,"设备投入电网运行的日期，晚于出厂日期"),

	BUSSINESS_JDB_EDPL(30001,"默认 50"),
	BUSSINESS_JDB_TYRQ(30002,"设备投入电网运行的日期，晚于出厂日期"),

	BUSSINESS_ZHDQ_EDPL(50002,"默认值50"),
	BUSSINESS_ZHDQ_TYRQ(50003,"投运日期 大于 出厂日期"),
	BUSSINESS_ZHDQ_ZZGJ(50004,"中国,代码为156"),

	BUSSINESS_GLKG_JDDZPZ(80001,"类型为隔离开关且设备型号中有1个D或2D、2T D2  或 Ⅱ的,根据实际情况填写单侧或双侧。无D的选择“无” ，类型为接地开关的选择“无”"),
	BUSSINESS_GLKG_ZHDQKGGMC(80005,"当“组合设备类型”选择“开关柜”或“组合电器”时，此项填写其所属开关 柜或组合电器的名称。若“组合设备类型”选“否”，此项不填写。"),
	BUSSINESS_GLKG_JDKGKHGYDLNL(80006,"根据标准规范，填写具体的数，不能填写A类、B类"),
	BUSSINESS_GLKG_EDDSNSSJ(80007,"750为2；330为3；110为3或者4；35及以下为4；"),
	BUSSINESS_GLKG_XB(80010,"如果“相数”选择“三相设备”，则相别自动设置为“ABC”"),
	BUSSINESS_GLKG_EDPL(80015,"默认值为50"),
	BUSSINESS_GLKG_TYRQ(80016,"投运日期 大于 出厂日期"),

	BUSSINESS_DKQ_XS(90002,"330kV及以上设备分相，单相，三相，其他电压等级不分相。"),
	BUSSINESS_DKQ_EDDG(90003,"x>0"),
	BUSSINESS_DKQ_YCD(90007,"绝缘介质=油浸:不为空；否则为0、无、/"),
	BUSSINESS_DKQ_EDPL(90008,"50"),
	BUSSINESS_DKQ_ZJYRQ(90009,"投运日期≤最近投运日期"),
	BUSSINESS_DKQ_JRFS(90014,"型号中首字母为CK的均为串抗，首字母为BK的均为并抗。"),
	BUSSINESS_DKQ_EDDKL(90015,"x>0"),
	BUSSINESS_DKQ_YH(90016,"按照铭牌填写，如不确定的统一填写“45或25”，只有绝缘介质为油浸的才填。"),
	BUSSINESS_DKQ_ZZ(90018,"x>0"),
	BUSSINESS_DKQ_EDDK(90019,"x>0"),
	BUSSINESS_DKQ_EDRL(90020,"X>0。500kV电抗器：额定容量（10-100Mvar）额定电感（1-16H）总重：（30-90t）"),
	BUSSINESS_DKQ_TYRQ(90022,"投运日期 大于 出厂日期"),

	BUSSINESS_DLDRQ_JYJZ(120001,"绝缘介质：油浸、干式，型号中含BAM为油浸 "),
	BUSSINESS_DLDRQ_TYRQ(120002,"投运日期 大于出厂日期"),

	BUSSINESS_BLQ_MXJS(130001,"取值说明：1~5"),
	BUSSINESS_BLQ_EDPL(130004,"默认值50"),
	BUSSINESS_BLQ_ZHDQKGGMC(130007,"如果组合设备类型选择“否”,不填写此项，如果是开关柜或组合电器，按要求填写"),
	BUSSINESS_BLQ_EDDY(130010,"根据设备铭牌或出厂试验报告等资料填写，对于氧化锌避雷器，设备型号后两位数字分别表示额定电压和雷电冲击残压，例如型号为HY5WZ-51/134Q，额定电压即51kV"),

	BUSSINESS_MX_RWDDLSJ(140004,"根据设备铭牌或出厂资料填写（大于等于2，小于等于4）"),
	BUSSINESS_MX_MXCZ(140008,"选择TMY为铜,LMY为铝,LGJ-规格为钢芯铝绞线,LF为铝锰合金,合金（组合电器和开关柜不能填写钢芯铝绞线）"),
	BUSSINESS_MX_RWDDL(140009,"根据设备铭牌或出厂资料填写；无资料的，参照所连接断路器的最大额定短路开断电流填写。（大于等于12.5，小于等于50)"),
	BUSSINESS_MX_DWDDL(140010,"动稳定电流等于2.5倍热稳定电流（大于等于31.5，小于等于135)"),
	BUSSINESS_MX_EDPL(140011,"默认值50"),
	BUSSINESS_MX_TYRQ(140012,"投运日期 大于出厂日期"),
	BUSSINESS_MX_YXBH(140016,"运行编号不应含kv书写不规范，正确kV"),
	BUSSINESS_MX_SBMC(140019,"设备名称不应含kv书写不规范，正确kV"),

	BUSSINESS_PDBYQ_CCRQ(150005,"出厂日期<投运日期"),
	BUSSINESS_PDBYQ_EDRL(150006,"与型号字段中最后一个'-'到'/'之间的数值判定；如果只有'-'取'-'到字符串最后的数值。如：容量为315，型号中需出现'315'字样所有数值，则在下列序列值中选择：10,20,30,50,80,100,160,200,250,315,320,500,630,800,1000，1250,1600,2000"),
	BUSSINESS_PDBYQ_JDDZ(150008,"额定容量100KVA及以上接地电阻不大于4欧姆，100KVA以下不大于10欧姆"),
	BUSSINESS_PDBYQ_KZSH(150009,"1、范围3600≥X≥10   2、不等于0"),
	BUSSINESS_PDBYQ_DLSH(150010,"1、范围21330≥X≥10   2、不等于0  3、短路损耗在空载损耗的1-10倍之间"),
	BUSSINESS_PDBYQ_KZDL(150017,"2.1%*高压侧额定电流≥X≥0.6%*高压侧额定电流"),
	BUSSINESS_PDBYQ_ZKDY(150018,"0-10之间"),
	BUSSINESS_PDBYQ_YH(150019,"1、'绝缘介质'字段=油浸式，字符中可包含25、45    2、其它绝缘介质，可填写空格、/、\\、无"),
	BUSSINESS_PDBYQ_ZZ(150020,"1、260~2200   2、油浸：'油重'<'总重'"),
	BUSSINESS_PDBYQ_JXZB(150021,"一般为Dyn11或Yyn0"),
	BUSSINESS_PDBYQ_YZ(150022,"绝缘介质=油浸式,50~500kg(参考）;绝缘介质=干式:空；'油重'字段不能大于'总重'"),
	BUSSINESS_PDBYQ_TYRQ(150027,"投运日期 大于 出厂日期"),

	INVALID_RANGE_LENGTH_SIZE(60019, "数据规则中不包含minvalue或者maxvalue属性,无法进行VarcharTypeRule验证"),
	//开关柜
	BUSSINESS_KGG_GMKD(40001,"电压等级10kV  柜面宽度(mm)在300~1300 35kV 柜面宽度(mm)在 600~1860"),
	BUSSINESS_KGG_EDDL(40003,"额定电流应从下列数值中选取：0.5,2,5,6.3,8,10,12.5,16,20,25,31.5,40,50,63,100,125,150,160,200,315,400,500,630，800,1000,1250，1500,1600,2000,2500,3150,4000,5000。按实际填写，按铭牌填写。"),
	BUSSINESS_KGG_EDPL(40004,"默认值50"),
	BUSSINESS_KGG_EDDY(40006,"额定电压应从下列数值中选取： 6、7.2、10、12、20、24、35、40.5。"),
	BUSSINESS_KGG_ZZGJ(40007,"选择设备的制造国家。默认值为“中国“ 代码 156"),
	BUSSINESS_KGG_TYRQ(40021,"投运日期 大于 出厂日期"),
	BUSSINESS_KGG_KD(40022,"320~1300"),
	BUSSINESS_KGG_SD(40024,"320~2000),西安局存在深度320mm，规则由400mm加大到320mm"),
	BUSSINESS_KGG_CCRQ(40025,"出厂日期<投运日期"),
	BUSSINESS_KGG_GD(40026,"800~2500"),
	//电压互感器
	BUSSINESS_DYHGQ_EDDYB(110001,"二次绕组总数量为几  就有几个0.1"),
	BUSSINESS_DYHGQ_EDPL(110002,"默认值50"),
	BUSSINESS_DYHGQ_TYRQ(110003,"投运日期>出厂日期"),
	BUSSINESS_DYHGQ_PDBJ(110007,"范围12.7至60.6"),
	BUSSINESS_DYHGQ_SF6QTBJYL(110008,"SF6按照铭牌填写 绝缘介质非SF6 填0或不填"),
	BUSSINESS_DYHGQ_ZHDQKGGMC(110009,"当“组合设备类型 ”选择“开关柜”或“组合电器”时，此项填写其所属开关 柜或组合电器的名称。若“组合设备类型”选“否”，此项不填写。"),
	BUSSINESS_DYHGQ_XJC1DRL(110011,"结构型式=电容型，X>0;"),
	BUSSINESS_DYHGQ_SF6QTEDYL(110012,"SF6按照铭牌填写 绝缘介质非SF6 填0或不填"),
	BUSSINESS_DYHGQ_ECRZZSL(110013,"小于或等于4，额定电压比中‘0.1’数量=二次绕组总数量"),
	BUSSINESS_DYHGQ_EDDY(110016,"按设备铭牌填写。不分相（ABC相）或中性点不带√3。分相（'A相', 'B相', 'C相', 'O相'）设备必须带√3。"),
	BUSSINESS_DYHGQ_ZZGJ(110017,"选择设备的制造国家。默认值为“中国”"),
	BUSSINESS_DYHGQ_DRQJS(110019,"750kV:4节；330kV:3节；110kV、35kV：1节（电容式电压互感器填写）"),
	BUSSINESS_DYHGQ_SJDRL(110020,"结构型式=电容型，电压等级>=220kV:X>0  电压等级小于220kV的填  0   ，无  ， /  ，\\  或空格 或 不填"),
	BUSSINESS_DYHGQ_XJC2DRL(110021,"结构型式=电容型，X>0;"),
	//电流互感器
	BUSSINESS_DLHGQ_EDDL(100002,"额定电流等于额定电流比中一次电流值，可选用：'5','6','40','50','100','150','200','300','500','600','1200', '1500', '400', '630', '800', '1000', '1250','1600', '2000', '2500', '3000','3150', '4000', '5000'"),
	BUSSINESS_DLHGQ_RWDDL(100003,"额定短时热电流通常为6.3、8、10、12.5、16、20、25、31.5、40、45、50、63、80、100（kA）"),
	BUSSINESS_DLHGQ_ECRZZSL(100004,"电压等级≤35：6≥X>0;否则9≥X>0"),
	BUSSINESS_DLHGQ_SF6QTBJYL(100007,"根据设备铭牌或出厂资料填写，单位：Mpa，绝缘介质不是SF6的，应不填写。"),
	BUSSINESS_DLHGQ_SF6QTEDYL(100010,"根据设备铭牌或出厂资料填写，单位：Mpa，绝缘介质不是SF6的，应不填写。"),
	BUSSINESS_DLHGQ_EDPL(100012,"默认 50"),
	BUSSINESS_DLHGQ_TYRQ(100013,"选择最早投运日期,投运日期>出厂日期;投运日期不为空。"),
	BUSSINESS_DLHGQ_EDDY(100003,"电压 10,12， 110，126 ，330，363 ，35，40.5， 20,24，6亦可"),
	BUSSINESS_DLHGQ_ZZGJ(100015,"默认中国  代码 156"),
	BUSSINESS_DLHGQ_DWDDL(100019,"动稳定电流等于热稳定电流的2.5倍，根据铭牌或说明书抄录"),
	BUSSINESS_DLHGQ_ZHDQKGGMC(100020,"选“否”，此项不填写；选“组合电器”，组合设备名称中因包含“组合电器”；选“开关柜”，组合设备名称中因包含“开关柜”；"),
	BUSSINESS_DLHGQ_SF6QTZXYXYL(100021,"根据设备铭牌或出厂资料填写，单位：Mpa，绝缘介质不是SF6的，应不填写。"),
	BUSSINESS_DLHGQ_ZDCXDY(100022,"本省可能为750、500kV直流、330、110、66、35、20、10、6；要求电压等级小于等于变电站运行电压"),
	//断路器
	BUSSINESS_DLQ_EDJYSP(70001,"750kV包含“960\"和\"1550\"和\"2100”；330kV包含\"510\"和\"950\"和\"1175\"；110kV包含\"230\"和\"550\"两个值；66kV为\"160\"和\"350\"两个值；35kV包含\"95\"和\"185\"两个值；10kV包含\"42\"和\"75\"两个值；6kV为\"30\",\"60\",\"42\"及\"75\"四个值。 额定电压145 包含 275 和 650"),
	BUSSINESS_DLQ_EDDL(70002,"额定电流应从下列数值中选取：400、630、800、1000、1250、1600、2000、2500、3150、4000、5000。根据电压等级不同，按实际填写。（以铭牌为准）型号以s开头,可以为1200,1500;以D开头的可以为600"),
	BUSSINESS_DLQ_FZSJ(70003,"10~100"),
	BUSSINESS_DLQ_JXSM(70004,"1000,2000,3000,5000,6000,10000,20000,30000；110kV不能上10000"),
	BUSSINESS_DLQ_ZHDQKGGMC(70005,"当\"组合设备类型\"选择\"开关柜\"或\"组合电器\"时，此项填写其所属开关柜或组合电器的名称。若\"组合设备类型\"选\"否\"，此项不填写。"),
	BUSSINESS_DLQ_HZDZ(70008,"110kV及以下电压等级没有合闸电阻，不涉及此参数填写，填写为0"),
	BUSSINESS_DLQ_RWDCXSJ(70009,"750kV为2；330kV为3；110kV及以下为4。根据制造厂说明书按实际填写。"),
	BUSSINESS_DLQ_EDDLGHDL(70010,"数值等于额定短路开断电流的2.5倍"),
	BUSSINESS_DLQ_EDDLKDDL(70011,"额定短路开断电流的交流分量有效值应从下列数值中选取：6.3、8、10、12.5、16、20、25、31.5、40、50、63、80、100。根据电压等级，按实际填写。按铭牌上填写。"),
	BUSSINESS_DLQ_DWDDL(70012,"数值等于额定短路关合电流，为热稳定电流的2.5倍。"),
	BUSSINESS_DLQ_TGPDJL(70015,"750kV  10161~25404 330kV  4611~11527 110kV  1600~4605 66kV  1600~11527 35kV 489~1286 10kV 140~381 6kV 140~381组合设备类型为开关柜，套管爬电距离为0 或结构型式为GIS，套管爬电距离为0"),
	BUSSINESS_DLQ_DKSL(70016,"断口类型只有1、2，按断路器说明书或制造厂产品技术条件填写"),
	BUSSINESS_DLQ_DDXLBJ(70017,"1.8~6(根据铜川局实测反馈将范围由1.8~3.2调整为1.8~6)"),
	BUSSINESS_DLQ_GYHZSJ(70018,"0~20"),
	BUSSINESS_DLQ_HZSJ(70020,"30~200"),
	BUSSINESS_DLQ_SF6QTBSYL(70021,"800kV断路器的SF6气体闭锁压力0.5Mpa。其它电压等级的断路器根据产品说明书或制造厂产品技术条件填写（制造厂不同，压力值也不同）"),
	BUSSINESS_DLQ_GYFZSJ(70022,"0~20"),
	BUSSINESS_DLQ_EDPL(70023,"默认50"),
	BUSSINESS_DLQ_TYRQ(70024,"选择最早投运日期，要大于出厂日期"),
	BUSSINESS_DLQ_EDDY(70026,"按设备铭牌填写。一般电压等级为6kV、10kV、20kV、35kV、66kV、110kV、330kV、750kV对应的额定电压分别为：(6,7.2)、(10,12)、(20,24)、(40.5、72.5)、(110,126,145)、(330,363,420)、800。"),
	BUSSINESS_DLQ_ZZGJ(70027,"选择设备的制造国家。默认值为\"中国\""),
	BUSSINESS_DLQ_SYHJ(70028,"型号中含“N”不能为户外式"),
	BUSSINESS_DLQ_EDDLDLKDCS(70032,"一、对于40.5kV及以下的真空断路器的电寿命也可按以下规定选取：a） 额定短路开断电流为31.5kA及以下时，其电寿命（额定短路电流的开断次数）由下列数值中选取：10，30，50次。b）额定短路开断电流为40～63kA时，其电寿命（额定短路电流的开断次数）由下列数值中选取： 16，20，30次。                                              二、对于40.5kV以上的SF6高压断路器，需进行额定短路开断电流下的连续开断能力试验（电寿命试验）。断路器在其主回路中开断用的零件不需要维修的情况下，可连续开断额定短路开断电流的次数应由下列数值中选取：16，20，25次");
	
	private final int code;
    private String message;


	DataExceptionMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static DataExceptionMessage valueOf(int code) {
    	DataExceptionMessage[] messages = values();
        int len = values().length;
        for (int i = 0; i < len; i++) {
        	DataExceptionMessage message = messages[i];
            if (message.code == code) {
                return message;
            }
        }
        throw new IllegalArgumentException("不存在的常量值 ["
                + code + "]");
    }



    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
		this.message = message;
	}

    public String getMessage() {
        return message;
    }

}
