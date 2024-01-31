package ecpay.logistics.integration.domain;

/**
 * �v�t���y�q�沣�ͪ���
 * @author mark.chiu
 *
 */
public class CreateHomeObj {
	
	/**
	 * MerchantID
	 * �t�ӽs��
	 */
	private String MerchantID = "";
	
	/**
	 * MerchantTradeNo
	 * �t�ӥ���s��
	 */
	private String MerchantTradeNo = "";
	
	/**
	 * MerchantTradeDate
	 * �t�ӥ���ɶ�
	 */
	private String MerchantTradeDate = "";
	
	/**
	 * LogisticsType
	 * ���y����
	 */
	private String LogisticsType = "Home";
	
	/**
	 * LogisticsSubType
	 * ���y�l����
	 */
	private String LogisticsSubType = "";
	
	/**
	 * GoodsAmount
	 * �ӫ~���B
	 */
	private String GoodsAmount = "";
	
	/**
	 * CollectionAmount
	 * �N�����B
	 */
	private String CollectionAmount = "";
	
	/**
	 * IsCollection
	 * �O�_�N���f��
	 */
	private String IsCollection = "";
	
	/**
	 * GoodsName
	 * �ӫ~�W��
	 */
	private String GoodsName = "";
	
	/**
	 * SenderName
	 * �H��H�m�W
	 */
	private String SenderName = "";
	
	/**
	 * SenderPhone
	 * �H��H�q��
	 */
	private String SenderPhone = "";
	
	/**
	 * SenderCellPhone
	 * �H��H���
	 */
	private String SenderCellPhone = "";
	
	/**
	 * ReceiverName
	 * ����H�m�W
	 */
	private String ReceiverName = "";
	
	/**
	 * ReceiverPhone
	 * ����H�q��
	 */
	private String ReceiverPhone = "";
	
	/**
	 * ReceiverCellPhone
	 *  ����H���
	 */
	private String ReceiverCellPhone = "";
	
	/**
	 * ReceiverEmail
	 * ����H email
	 */
	private String ReceiverEmail = "";
	
	/**
	 * TradeDesc
	 * ����y�z
	 */
	private String TradeDesc = "";
	
	/**
	 * ServerReplyURL
	 * Server �ݦ^�к��}
	 */
	private String ServerReplyURL = "";
	
	/**
	 * ClientReplyURL
	 * Client �ݦ^�к��}
	 */
	private String ClientReplyURL = "";
	
	/**
	 * LogisticsC2CReplyURL
	 * Server �ݪ��y�^�Ǻ��}
	 */
	private String LogisticsC2CReplyURL = "";
	
	/**
	 * Remark
	 * �Ƶ�
	 */
	private String Remark = "";
	
	/**
	 * PlatformID
	 * �S���X�@���x�ӥN��
	 */
	private String PlatformID = "";
	
	/**
	 * SenderZipCode
	 * �H��H�l���ϸ�
	 */
	private String SenderZipCode = "";
	
	/**
	 * SenderAddress
	 * �H��H�a�}
	 */
	private String SenderAddress = "";
	
	/**
	 * ReceiverZipCode
	 * ����H�l���ϸ�
	 */
	private String ReceiverZipCode = "";
	
	/**
	 * ReceiverAddress
	 * ����H�a�}
	 */
	private String ReceiverAddress = "";
	
	/**
	 * Temperature
	 * �żh
	 */
	private String Temperature = "";
	
	/**
	 * Distance
	 * �Z��
	 */
	private String Distance = "";
	
	/**
	 * Specification
	 * �W��
	 */
	private String Specification = "";
	
	/**
	 * ScheduledPickupTime
	 * �w�w����ɬq
	 */
	private String ScheduledPickupTime = "";
	
	/**
	 * ScheduledDeliveryTime
	 * �w�w�e�F�ɬq
	 */
	private String ScheduledDeliveryTime = "";
	
	/**
	 * ScheduledDeliveryDate
	 * ���w�e�F��
	 */
	private String ScheduledDeliveryDate = "";
	
	/**
	 * PackageCount
	 * �]�q���
	 */
	private String PackageCount = "";
	
	/********************* getters and setters *********************/
	
	/**
	 * ���oMerchantID �t�ӽs�� �Ѻ�ɬ�޴���
	 * @return MerchantID
	 */
	public String getMerchantID() {
		return MerchantID;
	}
	/**
	 * �]�wMerchantID �t�ӽs�� �Ѻ�ɬ�޴���
	 * @param merchantID
	 */
	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}
	/**
	 * ���oMerchantTradeNo �t�ӥ���s�� 1.�t�ӥ���s�������ߤ@�ȡA���i���ƨϥ�(�^�Ʀr�j�p�g�V�M) 2.�t�ӥ���s���i���šA�t�η|�۰ʲ��ͤ@�ռt�ӭq��s���C 
	 * @return MerchantTradeNo
	 */
	public String getMerchantTradeNo() {
		return MerchantTradeNo;
	}
	/**
	 * �]�wMerchantTradeNo �t�ӥ���s�� 1.�t�ӥ���s�������ߤ@�ȡA���i���ƨϥ�(�^�Ʀr�j�p�g�V�M) 2.�t�ӥ���s���i���šA�t�η|�۰ʲ��ͤ@�ռt�ӭq��s���C 
	 * @param merchantTradeNo
	 */
	public void setMerchantTradeNo(String merchantTradeNo) {
		MerchantTradeNo = merchantTradeNo;
	}
	/**
	 * ���oMerchantTradeDate �t�ӥ���ɶ� �榡���Gyyyy/MM/dd HH:mm:ss
	 * @return MerchantTradeDate
	 */
	public String getMerchantTradeDate() {
		return MerchantTradeDate;
	}
	/**
	 * �]�wMerchantTradeDate �t�ӥ���ɶ� �榡���Gyyyy/MM/dd HH:mm:ss
	 * @param merchantTradeDate
	 */
	public void setMerchantTradeDate(String merchantTradeDate) {
		MerchantTradeDate = merchantTradeDate;
	}
	/**
	 * ���oLogisticsType ���y���� CVS:�W�Ө��f  Home:�v�t 
	 * @return LogisticsType
	 */
	public String getLogisticsType() {
		return LogisticsType;
	}
//	/**
//	 * �]�wLogisticsType ���y���� CVS:�W�Ө��f  Home:�v�t 
//	 * @param logisticsType
//	 */
//	public void setLogisticsType(String logisticsType) {
//		LogisticsType = logisticsType;
//	}
	/**
	 * ���oLogisticsSubType ���y�l����
	 * ---B2C---
	 * FAMI:���a 
	 * UNIMART:�Τ@�W��
	 * HILIFE:�ܺ��I
	 * ---C2C---
	 * FAMIC2C:���a���쩱 
	 * UNIMARTC2C:�Τ@�W�ӥ�f�K HILIFEC2C:�ܺ��I���쩱
	 * ---HOME---
	 * TCAT:�¿� 
	 * ECAN:�v�t�q 
	 * @return LogisticsSubType
	 */
	public String getLogisticsSubType() {
		return LogisticsSubType;
	}
	/**
	 * �]�wLogisticsSubType ���y�l����
	 * ---B2C---
	 * FAMI:���a 
	 * UNIMART:�Τ@�W��
	 * HILIFE:�ܺ��I
	 * ---C2C---
	 * FAMIC2C:���a���쩱 
	 * UNIMARTC2C:�Τ@�W�ӥ�f�K HILIFEC2C:�ܺ��I���쩱
	 * ---HOME---
	 * TCAT:�¿� 
	 * ECAN:�v�t�q 
	 * @param logisticsSubType
	 */
	public void setLogisticsSubType(String logisticsSubType) {
		LogisticsSubType = logisticsSubType;
	}
	/**
	 * ���oGoodsAmount �ӫ~���B 
	 * @return GoodsAmount
	 */
	public String getGoodsAmount() {
		return GoodsAmount;
	}
	/**
	 * �]�wGoodsAmount �ӫ~���B 
	 * @param goodsAmount
	 */
	public void setGoodsAmount(String goodsAmount) {
		GoodsAmount = goodsAmount;
	}
	/**
	 * ���oCollectionAmount �N�����B ���y�l������ UNIMARTC2C(�Τ@�W�ӥ�f�K)�ɡA�N�����B�ݭn�P�ӫ~���B�@�P�C
	 * @return CollectionAmount
	 */
	public String getCollectionAmount() {
		return CollectionAmount;
	}
	/**
	 * �]�wCollectionAmount �N�����B ���y�l������ UNIMARTC2C(�Τ@�W�ӥ�f�K)�ɡA�N�����B�ݭn�P�ӫ~���B�@�P�C
	 * @param collectionAmount
	 */
	public void setCollectionAmount(String collectionAmount) {
		CollectionAmount = collectionAmount;
	}
	/**
	 * ���oIsCollection �O�_�N���f�� N:���N���f�ڡA���w�]�ȡC Y:�N���f�ڡA�h�N���f�ڪ��B���ӫ~���B�C 
	 * @return IsCollection
	 */
	public String getIsCollection() {
		return IsCollection;
	}
	/**
	 * �]�wIsCollection �O�_�N���f�� N:���N���f�ڡA���w�]�ȡC Y:�N���f�ڡA�h�N���f�ڪ��B���ӫ~���B�C 
	 * @param isCollection
	 */
	public void setIsCollection(String isCollection) {
		IsCollection = isCollection;
	}
	/**
	 * ���oGoodsName �ӫ~�W��
	 * ---B2C--- 
	 * FAMI�G���a(�i����)
	 * UNIMART�G�Τ@�W��(�i����)
	 * HILIFE�G�ܺ��I(�i����)
	 * ---C2C---
	 * FAMIC2C�G���a���쩱(�i����)
	 * UNIMARTC2C�G�Τ@�W�ӥ�f�K(���i����)
	 * HILIFEC2C�G�ܺ��I���쩱(���i����)
	 * ---HOME---
	 * �¿�(�i����) 
	 * @return GoodsName
	 */
	public String getGoodsName() {
		return GoodsName;
	}
	/**
	 * �]�wGoodsName �ӫ~�W��
	 * ---B2C--- 
	 * FAMI�G���a(�i����)
	 * UNIMART�G�Τ@�W��(�i����)
	 * HILIFE�G�ܺ��I(�i����)
	 * ---C2C---
	 * FAMIC2C�G���a���쩱(�i����)
	 * UNIMARTC2C�G�Τ@�W�ӥ�f�K(���i����)
	 * HILIFEC2C�G�ܺ��I���쩱(���i����)
	 * ---HOME---
	 * �¿�(�i����)
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	/**
	 * ���oSenderName �H��H�m�W 1. �r����� 10 �Ӧr��(�̦h 5 �Ӥ���r�B10 �ӭ^��r)�B���i���ťաA�Y�a���ťըt�Φ۰ʥh���C 2. C2C ���쩱�����h�^��H������A���X�ܨ����ҥ����A�ФŶ�g���q�W�١A�קK�L�k����h��C
	 * @return SenderName
	 */
	public String getSenderName() {
		return SenderName;
	}
	/**
	 * �]�wSenderName �H��H�m�W 1. �r����� 10 �Ӧr��(�̦h 5 �Ӥ���r�B10 �ӭ^��r)�B���i���ťաA�Y�a���ťըt�Φ۰ʥh���C 2. C2C ���쩱�����h�^��H������A���X�ܨ����ҥ����A�ФŶ�g���q�W�١A�קK�L�k����h��C
	 * @param senderName
	 */
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	/**
	 * ���oSenderPhone �H��H�q�� �Y���v�t�A�h�P����ܤ@���i����
	 * @return SenderPhone
	 */
	public String getSenderPhone() {
		return SenderPhone;
	}
	/**
	 * �]�wSenderPhone �H��H�q�� �Y���v�t�A�h�P����ܤ@���i����
	 * @param senderPhone
	 */
	public void setSenderPhone(String senderPhone) {
		SenderPhone = senderPhone;
	}
	/**
	 * ���oSenderCellPhone �H��H��� ���y�l���� UNIMARTC2C(�Τ@�W�ӥ�f�K) �BHILIFEC2C(�ܺ��I���쩱)�ɤ��i���� 
	 * @return SenderCellPhone
	 */
	public String getSenderCellPhone() {
		return SenderCellPhone;
	}
	/**
	 * �]�wSenderCellPhone �H��H��� ���y�l���� UNIMARTC2C(�Τ@�W�ӥ�f�K) �BHILIFEC2C(�ܺ��I���쩱)�ɤ��i��
	 * @param senderCellPhone
	 */
	public void setSenderCellPhone(String senderCellPhone) {
		SenderCellPhone = senderCellPhone;
	}
	/**
	 * ���oReceiverName ����H�m�W �r����� 10 �Ӧr��(�̦h 5 �Ӥ���r�B10 �ӭ^��r)�B���i���ťաA�Y�a���ťըt�Φ۰ʥh���C
	 * @return ReceiverName
	 */
	public String getReceiverName() {
		return ReceiverName;
	}
	/**
	 * �]�wReceiverName ����H�m�W �r����� 10 �Ӧr��(�̦h 5 �Ӥ���r�B10 �ӭ^��r)�B���i���ťաA�Y�a���ťըt�Φ۰ʥh���C
	 * @param receiverName
	 */
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	/**
	 * ���oReceiverPhone ����H�q�� �Y���v�t�ɡA�h�P����ܤ@���i����
	 * @return ReceiverPhone
	 */
	public String getReceiverPhone() {
		return ReceiverPhone;
	}
	/**
	 * �]�wReceiverPhone ����H�q�� �Y���v�t�ɡA�h�P����ܤ@���i����
	 * @param receiverPhone
	 */
	public void setReceiverPhone(String receiverPhone) {
		ReceiverPhone = receiverPhone;
	}
	/**
	 * ���oReceiverCellPhone ����H��� ���y�l���� UNIMART�BFAMI�BHILIFE �ɤ��i����UNIMARTC2C�BHILIFEC2C �ɤ��i���šC
	 * @return ReceiverCellPhone
	 */
	public String getReceiverCellPhone() {
		return ReceiverCellPhone;
	}
	/**
	 * �]�wReceiverCellPhone ����H��� ���y�l���� UNIMART�BFAMI�BHILIFE �ɤ��i����UNIMARTC2C�BHILIFEC2C �ɤ��i���šC
	 * @param receiverCellPhone
	 */
	public void setReceiverCellPhone(String receiverCellPhone) {
		ReceiverCellPhone = receiverCellPhone;
	}
	/**
	 * ���oReceiverEmail ����H email
	 * @return ReceiverEmail
	 */
	public String getReceiverEmail() {
		return ReceiverEmail;
	}
	/**
	 * �]�wReceiverEmail ����H email
	 * @param receiverEmail
	 */
	public void setReceiverEmail(String receiverEmail) {
		ReceiverEmail = receiverEmail;
	}
	/**
	 * ���oTradeDesc ����y�z
	 * @return TradeDesc
	 */
	public String getTradeDesc() {
		return TradeDesc;
	}
	/**
	 * �]�wTradeDesc ����y�z
	 * @param tradeDesc
	 */
	public void setTradeDesc(String tradeDesc) {
		TradeDesc = tradeDesc;
	}
	/**
	 * ���oServerReplyURL Server �ݦ^�к��} ���y���A���|�z�L�� URL �q��
	 * @return ServerReplyURL
	 */
	public String getServerReplyURL() {
		return ServerReplyURL;
	}
	/**
	 * �]�wServerReplyURL Server �ݦ^�к��} ���y���A���|�z�L�� URL �q��
	 * @param serverReplyURL
	 */
	public void setServerReplyURL(String serverReplyURL) {
		ServerReplyURL = serverReplyURL;
	}
	/**
	 * ���oClientReplyURL Client �ݦ^�к��} ���ѼƤ����ŮɡA���y�q��إ߫�|�N�����ɦܦ� URL
	 * @return ClientReplyURL
	 */
	public String getClientReplyURL() {
		return ClientReplyURL;
	}
	/**
	 * �]�wClientReplyURL Client �ݦ^�к��} ���ѼƤ����ŮɡA���y�q��إ߫�|�N�����ɦܦ� URL
	 * @param clientReplyURL
	 */
	public void setClientReplyURL(String clientReplyURL) {
		ClientReplyURL = clientReplyURL;
	}
	/**
	 * ���oLogisticsC2CReplyURL Server �ݪ��y�^�Ǻ��} �� User ��ܨ��f���������D�ɡA�|�z�L�� URL �q���S���A�ЯS���q�� User ���s��ܪ����C ���y�l������ UNIMARTC2C(�Τ@�W�ӥ�f�K)�ɡA����줣�i����
	 * @return LogisticsC2CReplyURL
	 */
	public String getLogisticsC2CReplyURL() {
		return LogisticsC2CReplyURL;
	}
	/**
	 * �]�wLogisticsC2CReplyURL Server �ݪ��y�^�Ǻ��} �� User ��ܨ��f���������D�ɡA�|�z�L�� URL �q���S���A�ЯS���q�� User ���s��ܪ����C ���y�l������ UNIMARTC2C(�Τ@�W�ӥ�f�K)�ɡA����줣�i����
	 * @param logisticsC2CReplyURL
	 */
	public void setLogisticsC2CReplyURL(String logisticsC2CReplyURL) {
		LogisticsC2CReplyURL = logisticsC2CReplyURL;
	}
	/**
	 * ���oRemark �Ƶ�
	 * @return Remark
	 */
	public String getRemark() {
		return Remark;
	}
	/**
	 * �]�wRemark �Ƶ�
	 * @param remark
	 */
	public void setRemark(String remark) {
		Remark = remark;
	}
	/**
	 * ���oPlatformID �S���X�@���x�ӥN��
	 * @return PlatformID
	 */
	public String getPlatformID() {
		return PlatformID;
	}
	/**
	 * �]�wPlatformID �S���X�@���x�ӥN��
	 * @param platformID
	 */
	public void setPlatformID(String platformID) {
		PlatformID = platformID;
	}
	/**
	 * ���oSenderZipCode �H��H�l���ϸ�
	 * @return SenderZipCode
	 */
	public String getSenderZipCode() {
		return SenderZipCode;
	}
	/**
	 * �]�wSenderZipCode �H��H�l���ϸ�
	 * @param senderZipCode
	 */
	public void setSenderZipCode(String senderZipCode) {
		SenderZipCode = senderZipCode;
	}
	/**
	 * ���oSenderAddress �H��H�a�} �r������ݤj�� 6 �Ӧr���A�B���i�W�L 60�Ӧr���C
	 * @return SenderAddress
	 */
	public String getSenderAddress() {
		return SenderAddress;
	}
	/**
	 * �]�wSenderAddress �H��H�a�} �r������ݤj�� 6 �Ӧr���A�B���i�W�L 60�Ӧr���C
	 * @param senderAddress
	 */
	public void setSenderAddress(String senderAddress) {
		SenderAddress = senderAddress;
	}
	/**
	 * ���oReceiverZipCode ����H�l���ϸ�
	 * @return ReceiverZipCode
	 */
	public String getReceiverZipCode() {
		return ReceiverZipCode;
	}
	/**
	 * �]�wReceiverZipCode ����H�l���ϸ�
	 * @param receiverZipCode
	 */
	public void setReceiverZipCode(String receiverZipCode) {
		ReceiverZipCode = receiverZipCode;
	}
	/**
	 * ���oReceiverAddress ����H�a�} �r������ݤj�� 6 �Ӧr���A�B���i�W�L 60�Ӧr���C
	 * @return ReceiverAddress
	 */
	public String getReceiverAddress() {
		return ReceiverAddress;
	}
	/**
	 * �]�wReceiverAddress ����H�a�} �r������ݤj�� 6 �Ӧr���A�B���i�W�L 60�Ӧr���C
	 * @param receiverAddress
	 */
	public void setReceiverAddress(String receiverAddress) {
		ReceiverAddress = receiverAddress;
	}
	/**
	 * ���oTemperature �żh 
	 * 0001:�`�� (�w�]��)
	 * 0002:�N��
	 * 0003:�N��
	 * ���y�l���� ECAN �v�t�q Temperature �żh�u��� 0001 �`��
	 * @return Temperature
	 */
	public String getTemperature() {
		return Temperature;
	}
	/**
	 * �]�wTemperature �żh
	 * 0001:�`�� (�w�]��)
	 * 0002:�N��
	 * 0003:�N��
	 * ���y�l���� ECAN �v�t�q Temperature �żh�u��� 0001 �`��
	 * @param temperature
	 */
	public void setTemperature(String temperature) {
		Temperature = temperature;
	}
	/**
	 * ���oDistance �Z��
	 * 00:�P���� (�w�]��) 
	 * 01:�~����
	 * 02:���q 
	 * @return Distance
	 */
	public String getDistance() {
		return Distance;
	}
	/**
	 * �]�wDistance �Z��
	 * 00:�P���� (�w�]��) 
	 * 01:�~����
	 * 02:���q 
	 * @param distance
	 */
	public void setDistance(String distance) {
		Distance = distance;
	}
	/**
	 * ���oSpecification �W��
	 * 0001: 60cm (�w�]��) 
	 * 0002: 90cm
	 * 0003: 120cm
	 * 0004: 150cm
	 * �żh��� 0003:�N��ɡA�W�椣�]�t0004:150cm �ﶵ
	 * @return Specification
	 */
	public String getSpecification() {
		return Specification;
	}
	/**
	 * �]�wSpecification �W��
	 * 0001: 60cm (�w�]��) 
	 * 0002: 90cm
	 * 0003: 120cm
	 * 0004: 150cm
	 * �żh��� 0003:�N��ɡA�W�椣�]�t0004:150cm �ﶵ
	 * @param specification
	 */
	public void setSpecification(String specification) {
		Specification = specification;
	}
	/**
	 * ���oScheduledPickupTime �w�w����ɬq
	 * 1: 9~12 
	 * 2: 12~17
	 * 3: 17~20
	 * 4: ������(�T�w 4 ������)
	 * ��l���y��ܦv�t�q�ɡA�ӰѼƥi����
	 * @return ScheduledPickupTime
	 */
	public String getScheduledPickupTime() {
		return ScheduledPickupTime;
	}
	/**
	 * �]�wScheduledPickupTime �w�w����ɬq
	 * 1: 9~12 
	 * 2: 12~17
	 * 3: 17~20
	 * 4: ������(�T�w 4 ������)
	 * ��l���y��ܦv�t�q�ɡA�ӰѼƥi����
	 * @param scheduledPickupTime
	 */
	public void setScheduledPickupTime(String scheduledPickupTime) {
		ScheduledPickupTime = scheduledPickupTime;
	}
	/**
	 * ���oScheduledDeliveryTime �w�w�e�F�ɬq 
	 * 1: 9~12
	 * 2: 12~17
	 * 3: 17~20
	 * 4:������
	 * 5:20~21(�ݭ��w�ϰ�A�v�t�q�S�����ɬq)��l���y��ܦv�t�q�ɡA�i��ܥH�U�ɬq
	 * 12: (���� 9~17)
	 * 13: (���� 9~12 & 17~20)
	 * 23: (�ȱ� 13~20) 
	 * @return ScheduledDeliveryTime
	 */
	public String getScheduledDeliveryTime() {
		return ScheduledDeliveryTime;
	}
	/**
	 * �]�wScheduledDeliveryTime �w�w�e�F�ɬq
	 * 1: 9~12
	 * 2: 12~17
	 * 3: 17~20
	 * 4:������
	 * 5:20~21(�ݭ��w�ϰ�A�v�t�q�S�����ɬq)��l���y��ܦv�t�q�ɡA�i��ܥH�U�ɬq
	 * 12: (���� 9~17)
	 * 13: (���� 9~12 & 17~20)
	 * 23: (�ȱ� 13~20) 
	 * @param scheduledDeliveryTime
	 */
	public void setScheduledDeliveryTime(String scheduledDeliveryTime) {
		ScheduledDeliveryTime = scheduledDeliveryTime;
	}
	/**
	 * ���oScheduledDeliveryDate ���w�e�F�� ��l���y��ܦv�t�q�ɡA���ѼƤ~���@�ΡC
	 * ������w���� D+3 (D:�ӭq��إ߮ɶ�) 
	 * @return ScheduledDeliveryDate
	 */
	public String getScheduledDeliveryDate() {
		return ScheduledDeliveryDate;
	}
	/**
	 * �]�wScheduledDeliveryDate ���w�e�F�� ��l���y��ܦv�t�q�ɡA���ѼƤ~���@�ΡC
	 * ������w���� D+3 (D:�ӭq��إ߮ɶ�)
	 * @param scheduledDeliveryDate
	 */
	public void setScheduledDeliveryDate(String scheduledDeliveryDate) {
		ScheduledDeliveryDate = scheduledDeliveryDate;
	}
	/**
	 * ���oPackageCount �]�q��� ��l���y��ܦv�t�q�ɡA���ѼƤ~���@�ΡA�@�Ω�P�q��s���A�]�q���
	 * @return PackageCount
	 */
	public String getPackageCount() {
		return PackageCount;
	}
	/**
	 * �]�wPackageCount �]�q��� ��l���y��ܦv�t�q�ɡA���ѼƤ~���@�ΡA�@�Ω�P�q��s���A�]�q���
	 * @param packageCount
	 */
	public void setPackageCount(String packageCount) {
		PackageCount = packageCount;
	}
	@Override
	public String toString() {
		return "CreateHomeObj [MerchantID=" + MerchantID + ", MerchantTradeNo=" + MerchantTradeNo
				+ ", MerchantTradeDate=" + MerchantTradeDate + ", LogisticsType=" + LogisticsType
				+ ", LogisticsSubType=" + LogisticsSubType + ", GoodsAmount=" + GoodsAmount + ", CollectionAmount="
				+ CollectionAmount + ", IsCollection=" + IsCollection + ", GoodsName=" + GoodsName + ", SenderName="
				+ SenderName + ", SenderPhone=" + SenderPhone + ", SenderCellPhone=" + SenderCellPhone
				+ ", ReceiverName=" + ReceiverName + ", ReceiverPhone=" + ReceiverPhone + ", ReceiverCellPhone="
				+ ReceiverCellPhone + ", ReceiverEmail=" + ReceiverEmail + ", TradeDesc=" + TradeDesc
				+ ", ServerReplyURL=" + ServerReplyURL + ", ClientReplyURL=" + ClientReplyURL
				+ ", LogisticsC2CReplyURL=" + LogisticsC2CReplyURL + ", Remark=" + Remark + ", PlatformID=" + PlatformID
				+ ", SenderZipCode=" + SenderZipCode + ", SenderAddress=" + SenderAddress + ", ReceiverZipCode="
				+ ReceiverZipCode + ", ReceiverAddress=" + ReceiverAddress + ", Temperature=" + Temperature
				+ ", Distance=" + Distance + ", Specification=" + Specification + ", ScheduledPickupTime="
				+ ScheduledPickupTime + ", ScheduledDeliveryTime=" + ScheduledDeliveryTime + ", ScheduledDeliveryDate="
				+ ScheduledDeliveryDate + ", PackageCount=" + PackageCount + "]";
	}
}
