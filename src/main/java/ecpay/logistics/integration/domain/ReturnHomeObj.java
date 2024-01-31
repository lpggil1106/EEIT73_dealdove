package ecpay.logistics.integration.domain;

/**
 * �v�t�f���y�q�檫��
 * @author mark.chiu
 *
 */
public class ReturnHomeObj {
	
	/**
	 * MerchantID
	 * �t�ӽs��
	 */
	private String MerchantID = "";
	
	/**
	 * AllPayLogisticsID
	 * ��ɬ�ު����y����s��
	 */
	private String AllPayLogisticsID = "";
	
	/**
	 * LogisticsSubType
	 * ���y�l����
	 */
	private String LogisticsSubType = "";
	
	/**
	 * ServerReplyURL
	 * Server �ݦ^�к��}
	 */
	private String ServerReplyURL = "";
	
	/**
	 * SenderName
	 * �h�f�H�m�W
	 */
	private String SenderName = "";
	
	/**
	 * SenderPhone
	 * �h�f�H�q�� 
	 */
	private String SenderPhone = "";
	
	/**
	 * SenderCellPhone
	 * �h�f�H���
	 */
	private String SenderCellPhone = "";
	
	/**
	 * SenderZipCode
	 * �h�f�H�l���ϸ� 
	 */
	private String SenderZipCode = "";
	
	/**
	 * SenderAddress
	 * �h�f�H�a�}
	 */
	private String SenderAddress = "";
	
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
	 * ����H���
	 */
	private String ReceiverCellPhone = "";
	
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
	 * GoodsAmount
	 * �ӫ~���B
	 */
	private String GoodsAmount = "";
	
	/**
	 * GoodsName
	 * ���~�W��
	 */
	private String GoodsName = "";
	
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
	 * ���oAllPayLogisticsID ��ɬ�ު����y����s�� �P���y�l����[LogisticsSubType]�ܤ@���i���šC�ȭ��Ʀr�A���i�ϥίS��Ÿ��B�^��
	 * @return AllPayLogisticsID
	 */
	public String getAllPayLogisticsID() {
		return AllPayLogisticsID;
	}
	/**
	 * �]�wAllPayLogisticsID ��ɬ�ު����y����s�� �P���y�l����[LogisticsSubType]�ܤ@���i���šC�ȭ��Ʀr�A���i�ϥίS��Ÿ��B�^��
	 * @param allPayLogisticsID
	 */
	public void setAllPayLogisticsID(String allPayLogisticsID) {
		AllPayLogisticsID = allPayLogisticsID;
	}
	/**
	 * ���oLogisticsSubType ���y�l����
	 * ---HOME--- 
	 * TCAT:�¿�
	 * ECAN:�v�t�q
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC
	 * @return LogisticsSubType
	 */
	public String getLogisticsSubType() {
		return LogisticsSubType;
	}
	/**
	 * �]�wLogisticsSubType ���y�l����
	 * ---HOME--- 
	 * TCAT:�¿�
	 * ECAN:�v�t�q
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC
	 * @param logisticsSubType
	 */
	public void setLogisticsSubType(String logisticsSubType) {
		LogisticsSubType = logisticsSubType;
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
	 * ���oSenderName �h�f�H�m�W
	 * 1. �Y AllPayLogisticsID ���ȥB�ӭq�欰�ۦP���u���y�l�����v�ɡA�h�f����H�P�H��H��T�|�P��q��ۤϥB�۰ʱa�J�v�t�W��B�żh�B�Z���B�~�W�C 
	 * 2. �Y��T�P���s���y������P�ɡA�i�ۦ��J 
	 * ���`�N�ƶ�: 
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC 
	 * 4. ���׭���̦h 10 �Ӧr��(���� 5 �Ӧr, �^�� 10 �Ӧr)�C 
	 * @return SenderName
	 */
	public String getSenderName() {
		return SenderName;
	}
	/**
	 * �]�wSenderName �h�f�H�m�W
	 * 1. �Y AllPayLogisticsID ���ȥB�ӭq�欰�ۦP���u���y�l�����v�ɡA�h�f����H�P�H��H��T�|�P��q��ۤϥB�۰ʱa�J�v�t�W��B�żh�B�Z���B�~�W�C 
	 * 2. �Y��T�P���s���y������P�ɡA�i�ۦ��J 
	 * ���`�N�ƶ�: 
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC 
	 * 4. ���׭���̦h 10 �Ӧr��(���� 5 �Ӧr, �^�� 10 �Ӧr)�C 
	 * @param senderName
	 */
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	/**
	 * ���oSenderPhone �h�f�H�q��
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����P�h�f�H���[SenderCellPhone]�ܤ@���i����) 
	 * 4. ���\�Ʀr+�S��Ÿ��F�S��Ÿ��ȭ�()-#
	 * @return SenderPhone
	 */
	public String getSenderPhone() {
		return SenderPhone;
	}
	/**
	 * �]�wSenderPhone �h�f�H�q��
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����P�h�f�H���[SenderCellPhone]�ܤ@���i����) 
	 * 4. ���\�Ʀr+�S��Ÿ��F�S��Ÿ��ȭ�()-#
	 * @param senderPhone
	 */
	public void setSenderPhone(String senderPhone) {
		SenderPhone = senderPhone;
	}
	/**
	 * ���oSenderCellPhone �h�f�H���
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����P�h�f�H�q��[SenderPhone]�ܤ@���i����) 
	 * 4. �u���\�Ʀr�B10 �X�B09 �}�Y
	 * @return SenderCellPhone
	 */
	public String getSenderCellPhone() {
		return SenderCellPhone;
	}
	/**
	 * �]�wSenderCellPhone �h�f�H���
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����P�h�f�H�q��[SenderPhone]�ܤ@���i����) 
	 * 4. �u���\�Ʀr�B10 �X�B09 �}�Y
	 * @param senderCellPhone
	 */
	public void setSenderCellPhone(String senderCellPhone) {
		SenderCellPhone = senderCellPhone;
	}
	/**
	 * ���oSenderZipCode �h�f�H�l���ϸ�
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC 
	 * @return SenderZipCode
	 */
	public String getSenderZipCode() {
		return SenderZipCode;
	}
	/**
	 * �]�wSenderZipCode �h�f�H�l���ϸ�
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC 
	 * @param senderZipCode
	 */
	public void setSenderZipCode(String senderZipCode) {
		SenderZipCode = senderZipCode;
	}
	/**
	 * ���oSenderAddress �h�f�H�a�}
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A�����r������ݤj�� 6 �Ӧr���A�B���i�W�L 60 �Ӧr���C 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����r������ݤj�� 6 �Ӧr���A�B���i�W�L 60 �Ӧr���C
	 * @return SenderAddress
	 */
	public String getSenderAddress() {
		return SenderAddress;
	}
	/**
	 * �]�wSenderAddress �h�f�H�a�}
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A�����r������ݤj�� 6 �Ӧr���A�B���i�W�L 60 �Ӧr���C 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����r������ݤj�� 6 �Ӧr���A�B���i�W�L 60 �Ӧr���C
	 * @param senderAddress
	 */
	public void setSenderAddress(String senderAddress) {
		SenderAddress = senderAddress;
	}
	/**
	 * ���oReceiverName ����H�m�W
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC 
	 * 4. �r����� 10 �Ӧr��(�̦h 5 �Ӥ���r�B10 �ӭ^��r) �B���i���ťաA�Y�a���ťըt�Φ۰ʥh���C
	 * @return ReceiverName
	 */
	public String getReceiverName() {
		return ReceiverName;
	}
	/**
	 * �]�wReceiverName ����H�m�W
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC 
	 * 4. �r����� 10 �Ӧr��(�̦h 5 �Ӥ���r�B10 �ӭ^��r) �B���i���ťաA�Y�a���ťըt�Φ۰ʥh���C
	 * @param receiverName
	 */
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	/**
	 * ���oReceiverPhone ����H�q��
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����P����H���[ReceiverCellPhone]�ܤ@���i����) 
	 * 4. ���\�Ʀr+�S��Ÿ��F�S��Ÿ��ȭ�()-#
	 * @return ReceiverPhone
	 */
	public String getReceiverPhone() {
		return ReceiverPhone;
	}
	/**
	 * �]�wReceiverPhone ����H�q��
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����P����H���[ReceiverCellPhone]�ܤ@���i����) 
	 * 4. ���\�Ʀr+�S��Ÿ��F�S��Ÿ��ȭ�()-#
	 * @param receiverPhone
	 */
	public void setReceiverPhone(String receiverPhone) {
		ReceiverPhone = receiverPhone;
	}
	/**
	 * ���oReceiverCellPhone ����H���
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����P����H�q��[ReceiverPhone]�ܤ@���i����) 
	 * 4. �u���\�Ʀr�B10 �X�B09 �}�Y
	 * @return ReceiverCellPhone
	 */
	public String getReceiverCellPhone() {
		return ReceiverCellPhone;
	}
	/**
	 * �]�wReceiverCellPhone ����H���
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����P����H�q��[ReceiverPhone]�ܤ@���i����) 
	 * 4. �u���\�Ʀr�B10 �X�B09 �}�Y
	 * @param receiverCellPhone
	 */
	public void setReceiverCellPhone(String receiverCellPhone) {
		ReceiverCellPhone = receiverCellPhone;
	}
	/**
	 * ���oReceiverZipCode ����H�l���ϸ�
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC 
	 * @return ReceiverZipCode
	 */
	public String getReceiverZipCode() {
		return ReceiverZipCode;
	}
	/**
	 * �]�wReceiverZipCode ����H�l���ϸ�
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A����줣�i���ŭȡC 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA����줣�i���ŭȡC 
	 * @param receiverZipCode
	 */
	public void setReceiverZipCode(String receiverZipCode) {
		ReceiverZipCode = receiverZipCode;
	}
	/**
	 * ���oReceiverAddress ����H�a�}
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A�����r������ݤj�� 6 �Ӧr���A�B���i�W�L 60 �Ӧr���C 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����r������ݤj�� 6 �Ӧr���A�B���i�W�L 60 �Ӧr���C
	 * @return ReceiverAddress
	 */
	public String getReceiverAddress() {
		return ReceiverAddress;
	}
	/**
	 * �]�wReceiverAddress ����H�a�}
	 * 1. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]���v�t(Home)�����i���ŭȡC 
	 * 2. �Y���y����s��[AllPayLogisticsID]�����ŭȮɡA�B�쪫�y����[LogisticsType]�� CVS:�W�Ө��f�A�����r������ݤj�� 6 �Ӧr���A�B���i�W�L 60 �Ӧr���C 
	 * 3. �Y���y����s��[AllPayLogisticsID]���ŭȮɡA�����r������ݤj�� 6 �Ӧr���A�B���i�W�L 60 �Ӧr���C
	 * @param receiverAddress
	 */
	public void setReceiverAddress(String receiverAddress) {
		ReceiverAddress = receiverAddress;
	}
	/**
	 * ���oGoodsAmount �ӫ~���B ���B�d�� 1~20,000 �� �����ӫ~�򥢽��v�̾ڡA�ȥi�ϥμƦr
	 * @return GoodsAmount
	 */
	public String getGoodsAmount() {
		return GoodsAmount;
	}
	/**
	 * �]�wGoodsAmount �ӫ~���B ���B�d�� 1~20,000 �� �����ӫ~�򥢽��v�̾ڡA�ȥi�ϥμƦr
	 * @param goodsAmount
	 */
	public void setGoodsAmount(String goodsAmount) {
		GoodsAmount = goodsAmount;
	}
	/**
	 * ���oGoodsName ���~�W�� ���i����޸������޸��C
	 * @return GoodsName
	 */
	public String getGoodsName() {
		return GoodsName;
	}
	/**
	 * �]�wGoodsName ���~�W�� ���i����޸������޸��C
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	/**
	 * ���oTemperature �żh
	 * 0001:�`�� (�w�]��) 
	 * 0002:�N��
	 * 0003:�N��
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
	 * 4:������(�T�w 4 ������)
	 * (��l���y��ܦv�t�q�ɡA�ӰѼƥi����)
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
	 * 4:������(�T�w 4 ������)
	 * (��l���y��ܦv�t�q�ɡA�ӰѼƥi����)
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
	 * 5:20~21(�ݭ��w�ϰ�A�v�t�q�S�����ɬq) 
	 * ��l���y��ܦv�t�q�ɡA�i��ܥH�U�ɬq 
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
	 * 5:20~21(�ݭ��w�ϰ�A�v�t�q�S�����ɬq) 
	 * ��l���y��ܦv�t�q�ɡA�i��ܥH�U�ɬq 
	 * 12: (���� 9~17) 
	 * 13: (���� 9~12 & 17~20) 
	 * 23: (�ȱ� 13~20)
	 * @param scheduledDeliveryTime
	 */
	public void setScheduledDeliveryTime(String scheduledDeliveryTime) {
		ScheduledDeliveryTime = scheduledDeliveryTime;
	}
	/**
	 * ���oScheduledDeliveryDate ���w�e�F�� ��l���y��ܦv�t�q�ɡA���ѼƤ~���@��
	 * ������w���� D+3 (D:�ӭq��إ߮ɶ�)
	 * @return ScheduledDeliveryDate
	 */
	public String getScheduledDeliveryDate() {
		return ScheduledDeliveryDate;
	}
	/**
	 * �]�wScheduledDeliveryDate ���w�e�F�� ��l���y��ܦv�t�q�ɡA���ѼƤ~���@��
	 * ������w���� D+3 (D:�ӭq��إ߮ɶ�)
	 * @param scheduledDeliveryDate
	 */
	public void setScheduledDeliveryDate(String scheduledDeliveryDate) {
		ScheduledDeliveryDate = scheduledDeliveryDate;
	}
	/**
	 * ���oPackageCount �]�q��� ��l���y��ܦv�t�q�ɡA���ѼƤ~���@�ΡA�@�Ω�P�q��s���A�]�q��ơC
	 * @return PackageCount
	 */
	public String getPackageCount() {
		return PackageCount;
	}
	/**
	 * �]�wPackageCount �]�q��� ��l���y��ܦv�t�q�ɡA���ѼƤ~���@�ΡA�@�Ω�P�q��s���A�]�q��ơC
	 * @param packageCount
	 */
	public void setPackageCount(String packageCount) {
		PackageCount = packageCount;
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
	 * ���oPlatformID �S���X�@���x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID �бa��a�Ҹj�w��MerchantID�C
	 * @return PlatformID
	 */
	public String getPlatformID() {
		return PlatformID;
	}
	/**
	 * �]�wPlatformID �S���X�@���x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID �бa��a�Ҹj�w��MerchantID�C
	 * @param platformID
	 */
	public void setPlatformID(String platformID) {
		PlatformID = platformID;
	}
	@Override
	public String toString() {
		return "ReturnHomeObj [MerchantID=" + MerchantID + ", AllPayLogisticsID=" + AllPayLogisticsID
				+ ", LogisticsSubType=" + LogisticsSubType + ", ServerReplyURL=" + ServerReplyURL + ", SenderName="
				+ SenderName + ", SenderPhone=" + SenderPhone + ", SenderCellPhone=" + SenderCellPhone
				+ ", SenderZipCode=" + SenderZipCode + ", SenderAddress=" + SenderAddress + ", ReceiverName="
				+ ReceiverName + ", ReceiverPhone=" + ReceiverPhone + ", ReceiverCellPhone=" + ReceiverCellPhone
				+ ", ReceiverZipCode=" + ReceiverZipCode + ", ReceiverAddress=" + ReceiverAddress + ", GoodsAmount="
				+ GoodsAmount + ", GoodsName=" + GoodsName + ", Temperature=" + Temperature + ", Distance=" + Distance
				+ ", Specification=" + Specification + ", ScheduledPickupTime=" + ScheduledPickupTime
				+ ", ScheduledDeliveryTime=" + ScheduledDeliveryTime + ", ScheduledDeliveryDate="
				+ ScheduledDeliveryDate + ", PackageCount=" + PackageCount + ", Remark=" + Remark + ", PlatformID="
				+ PlatformID + "]";
	}
}
