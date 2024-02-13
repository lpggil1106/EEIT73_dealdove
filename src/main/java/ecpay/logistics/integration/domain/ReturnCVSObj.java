package ecpay.logistics.integration.domain;

/**
 * �W�Ө��f�f���y�q�檫��
 * @author mark.chiu
 *
 */
public class ReturnCVSObj {
	
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
	 * ServerReplyURL
	 * Server �ݦ^�к��}
	 */
	private String ServerReplyURL = "";
	
	/**
	 * GoodsName
	 * �ӫ~�W��
	 */
	private String GoodsName = "";
	
	/**
	 * GoodsAmount
	 * �ӫ~���B
	 */
	private String GoodsAmount = "";
	
	/**
	 * CollectionAmount
	 * �N�����B
	 */
	private String CollectionAmount = "0";
	
	/**
	 * ServiceType
	 * �A�ȫ��A�N�X
	 */
	private String ServiceType = "4";
	
	/**
	 * SenderName
	 * �H��H�m�W
	 */
	private String SenderName = "";
	
	/**
	 * SenderPhone
	 * �h�f�H�q��
	 */
	private String SenderPhone = "";
	
	/**
	 * Remark
	 * �Ƶ�
	 */
	private String Remark = "";
	
	/**
	 * Quantity
	 * �ƶq
	 */
	private String Quantity = "";
	
	/**
	 * Cost
	 * ����
	 */
	private String Cost = "";
	
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
	 * ���oAllPayLogisticsID ��ɬ�ު����y����s�� �ȭ��Ʀr�A���i�ϥίS��Ÿ��B�^��
	 * @return AllPayLogisticsID
	 */
	public String getAllPayLogisticsID() {
		return AllPayLogisticsID;
	}
	/**
	 * �]�wAllPayLogisticsID ��ɬ�ު����y����s�� �ȭ��Ʀr�A���i�ϥίS��Ÿ��B�^��
	 * @param allPayLogisticsID
	 */
	public void setAllPayLogisticsID(String allPayLogisticsID) {
		AllPayLogisticsID = allPayLogisticsID;
	}
	/**
	 * ���oServerReplyURL Server �ݦ^�к��} �f���y���A���|�z�L�� URL �q���C
	 * @return ServerReplyURL
	 */
	public String getServerReplyURL() {
		return ServerReplyURL;
	}
	/**
	 * �]�wServerReplyURL Server �ݦ^�к��}  �f���y���A���|�z�L�� URL �q���C
	 * @param serverReplyURL
	 */
	public void setServerReplyURL(String serverReplyURL) {
		ServerReplyURL = serverReplyURL;
	}
	/**
	 * ���oGoodsName �ӫ~�W�� �Y���h�Ӱӫ~�Х�#���j�A���i����޸������޸��C
	 * @return GoodsName
	 */
	public String getGoodsName() {
		return GoodsName;
	}
	/**
	 * �]�wGoodsName �ӫ~�W�� �Y���h�Ӱӫ~�Х�#���j�A���i����޸������޸��C
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	/**
	 * ���oGoodsAmount �ӫ~���B ���B�d�� 1~20,000 �� �ӫ~�򥢽��v�̾ڡA�ȥi�ϥμƦr
	 * @return GoodsAmount
	 */
	public String getGoodsAmount() {
		return GoodsAmount;
	}
	/**
	 * �]�wGoodsAmount �ӫ~���B ���B�d�� 1~20,000 �� �ӫ~�򥢽��v�̾ڡA�ȥi�ϥμƦr
	 * @param goodsAmount
	 */
	public void setGoodsAmount(String goodsAmount) {
		GoodsAmount = goodsAmount;
	}
	/**
	 * ���oCollectionAmount �N�����B
	 * @return CollectionAmount
	 */
	public String getCollectionAmount() {
		return CollectionAmount;
	}
//	/**
//	 * �]�wCollectionAmount �N�����B
//	 * @param collectionAmount
//	 */
//	public void setCollectionAmount(String collectionAmount) {
//		CollectionAmount = collectionAmount;
//	}
	/**
	 * ���oServiceType �A�ȫ��A�N�X
	 * @return ServiceType
	 */
	public String getServiceType() {
		return ServiceType;
	}
//	/**
//	 * �]�wServiceType
//	 * @param serviceType
//	 */
//	public void setServiceType(String serviceType) {
//		ServiceType = serviceType;
//	}
	/**
	 * ���oSenderName �H��H�m�W
	 * @return SenderName
	 */
	public String getSenderName() {
		return SenderName;
	}
	/**
	 * �]�wSenderName �H��H�m�W
	 * @param senderName
	 */
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	/**
	 * ���oSenderPhone �h�f�H�q��
	 * @return SenderPhone
	 */
	public String getSenderPhone() {
		return SenderPhone;
	}
	/**
	 * �]�wSenderPhone �h�f�H�q��
	 * @param senderPhone
	 */
	public void setSenderPhone(String senderPhone) {
		SenderPhone = senderPhone;
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
	 * ���oQuantity �ƶq �Y���h�Ӱӫ~�Х�#���j
	 * @return Quantity
	 */
	public String getQuantity() {
		return Quantity;
	}
	/**
	 * �]�wQuantity �ƶq �Y���h�Ӱӫ~�Х�#���j
	 * @param quantity
	 */
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	/**
	 * ���oCost ����  �Y���h�Ӱӫ~�Х�#���j
	 * @return Cost
	 */
	public String getCost() {
		return Cost;
	}
	/**
	 * �]�wCost ����  �Y���h�Ӱӫ~�Х�#���j
	 * @param cost
	 */
	public void setCost(String cost) {
		Cost = cost;
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
		return "ReturnCVSObj [MerchantID=" + MerchantID + ", AllPayLogisticsID=" + AllPayLogisticsID
				+ ", ServerReplyURL=" + ServerReplyURL + ", GoodsName=" + GoodsName + ", GoodsAmount=" + GoodsAmount
				+ ", CollectionAmount=" + CollectionAmount + ", ServiceType=" + ServiceType + ", SenderName="
				+ SenderName + ", SenderPhone=" + SenderPhone + ", Remark=" + Remark + ", Quantity=" + Quantity
				+ ", Cost=" + Cost + ", PlatformID=" + PlatformID + "]";
	}
}
