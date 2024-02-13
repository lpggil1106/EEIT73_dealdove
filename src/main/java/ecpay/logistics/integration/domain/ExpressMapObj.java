package ecpay.logistics.integration.domain;

/**
 * �q�l�a�Ϧ걵����
 * @author mark.chiu
 *
 */
public class ExpressMapObj {
	
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
	 * LogisticsType
	 * ���y����
	 */
	private String LogisticsType = "CVS";
	
	/**
	 * LogisticsSubType
	 * ���y�l����
	 */
	private String LogisticsSubType = "";
	
	/**
	 * IsCollection
	 * �O�_�N���f��
	 */
	private String IsCollection = "";
	
	/**
	 * ServerReplyURL
	 * Server �ݦ^�к��}
	 */
	private String ServerReplyURL = "";
	
	/**
	 * ExtraData
	 * �B�~��T
	 */
	private String ExtraData = "";
	
	/**
	 * Device
	 * �ϥγ]��
	 */
	private String Device = "";
	
	/********************* getters and setters *********************/
	
	/**
	 * ���oMerchantID �t�ӽs���A�Ѻ�ɬ�޴���
	 * @return MerchantID
	 */
	public String getMerchantID() {
		return MerchantID;
	}
	/**
	 * �]�wMerchantID �t�ӽs���A�Ѻ�ɬ�޴���
	 * @param merchantID
	 */
	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}
	/**
	 * ���oMerchantTradeNo �t�ӥ���s�� 1. �t�ӥ���s�������ߤ@�ȡA���i���ƨϥΡC 2. �^�Ʀr�j�p�g�V�X�C
	 * @return MerchantTradeNo
	 */
	public String getMerchantTradeNo() {
		return MerchantTradeNo;
	}
	/**
	 * �]�wMerchantTradeNo �t�ӥ���s�� 1. �t�ӥ���s�������ߤ@�ȡA���i���ƨϥΡC 2. �^�Ʀr�j�p�g�V�X�C
	 * @param merchantTradeNo
	 */
	public void setMerchantTradeNo(String merchantTradeNo) {
		MerchantTradeNo = merchantTradeNo;
	}
	/**
	 * ���oLogisticsType ���y���� 
	 * @return LogisticsType
	 */
	public String getLogisticsType() {
		return LogisticsType;
	}
//	public void setLogisticsType(String logisticsType) {
//		LogisticsType = logisticsType;
//	}
	/**
	 * ���oLogisticsSubType ���y�l����
	 * ---B2C---
	 * FAMI�G���a 
	 * UNIMART�G�Τ@�W�� 
	 * HILIFE�G�ܺ��I
	 * ---C2C---
	 * FAMIC2C�G���a���쩱 
	 * UNIMARTC2C�G�Τ@�W�ӥ�f�K
	 * HILIFEC2C:�ܺ��I���쩱
	 * @return LogisticsSubType
	 */
	public String getLogisticsSubType() {
		return LogisticsSubType;
	}
	/**
	 * �]�wLogisticsSubType ���y�l����
	 * ---B2C---
	 * FAMI�G���a 
	 * UNIMART�G�Τ@�W�� 
	 * HILIFE�G�ܺ��I
	 * ---C2C---
	 * FAMIC2C�G���a���쩱 
	 * UNIMARTC2C�G�Τ@�W�ӥ�f�K
	 * HILIFEC2C:�ܺ��I���쩱
	 * @param logisticsSubType
	 */
	public void setLogisticsSubType(String logisticsSubType) {
		LogisticsSubType = logisticsSubType;
	}
	/**
	 * ���oIsCollection �O�_�N���f��  N�G���N���f�ڡC Y�G�N���f�ڡC
	 * @return IsCollection
	 */
	public String getIsCollection() {
		return IsCollection;
	}
	/**
	 * �]�wIsCollection �O�_�N���f��  N�G���N���f�ڡC Y�G�N���f�ڡC
	 * @param isCollection
	 */
	public void setIsCollection(String isCollection) {
		IsCollection = isCollection;
	}
	/**
	 * ���oServerReplyURL Server �ݦ^�к��} ���o�W�ө��Q�N������T��A�|�^�Ǩ즹���}�C
	 * @return ServerReplyURL
	 */
	public String getServerReplyURL() {
		return ServerReplyURL;
	}
	/**
	 * �]�wServerReplyURL �ݦ^�к��} ���o�W�ө��Q�N������T��A�|�^�Ǩ즹���}�C
	 * @param serverReplyURL
	 */
	public void setServerReplyURL(String serverReplyURL) {
		ServerReplyURL = serverReplyURL;
	}
	/**
	 * ���oExtraData �B�~��T �Ѽt�Ӷǻ��O�d����T�A�b�^�ǰѼƤ��A�|��Ȧ^��
	 * @return ExtraData
	 */
	public String getExtraData() {
		return ExtraData;
	}
	/**
	 * �]�wExtraData �B�~��T �Ѽt�Ӷǻ��O�d����T�A�b�^�ǰѼƤ��A�|��Ȧ^��
	 * @param extraData
	 */
	public void setExtraData(String extraData) {
		ExtraData = extraData;
	}
	/**
	 * ���oDevice �ϥγ]�� 0�GPC�]�w�]�ȡ^ 1�GMobile
	 * @return Device
	 */
	public String getDevice() {
		return Device;
	}
	/**
	 * �]�wDevice �ϥγ]�� 0�GPC�]�w�]�ȡ^ 1�GMobile
	 * @param device
	 */
	public void setDevice(String device) {
		Device = device;
	}
	@Override
	public String toString() {
		return "ExpressMapObj [MerchantID=" + MerchantID + ", MerchantTradeNo=" + MerchantTradeNo + ", LogisticsType="
				+ LogisticsType + ", LogisticsSubType=" + LogisticsSubType + ", IsCollection=" + IsCollection
				+ ", ServerReplyURL=" + ServerReplyURL + ", ExtraData=" + ExtraData + ", Device=" + Device + "]";
	}
}
