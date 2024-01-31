package ecpay.logistics.integration.domain;

/**
 * ���� B2C ���и�ƪ���
 * @author mark.chiu
 *
 */
public class CreateTestDataObj {
	
	/**
	 * MerchantID
	 * �t�ӽs��
	 */
	private String MerchantID = "";
	
	/**
	 * ClientReplyURL
	 * Client �ݦ^�к��}
	 */
	private String ClientReplyURL = "";
	
	/**
	 * PlatformID
	 * �S���X�@���x�ӥN��
	 */
	private String PlatformID = "";
	
	/**
	 * LogisticsSubType
	 * ���y�l����
	 */
	private String LogisticsSubType = "";
	
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
	 * ���oClientReplyURL Client �ݦ^�к��} ���ѼƤ����ŮɡA���y�q��إ߫�|�N�����ɦܦ� URL�C 
	 * @return ClientReplyURL
	 */
	public String getClientReplyURL() {
		return ClientReplyURL;
	}
	/**
	 * �]�wClientReplyURL Client �ݦ^�к��} ���ѼƤ����ŮɡA���y�q��إ߫�|�N�����ɦܦ� URL�C 
	 * @param clientReplyURL
	 */
	public void setClientReplyURL(String clientReplyURL) {
		ClientReplyURL = clientReplyURL;
	}
	/**
	 * ���oPlatformID �S���X�@���x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID �бa��a�Ҹj�w��MerchantID�C
	 * @return PlatformID
	 */
	public String getPlatformID() {
		return PlatformID;
	}
	/**
	 * �]�wPlatformID �S���X�@���x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�� ���x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID �бa��a�Ҹj�w��MerchantID�C
	 * @param platformID
	 */
	public void setPlatformID(String platformID) {
		PlatformID = platformID;
	}
	/**
	 * ���oLogisticsSubType ���y�l����
	 * ---B2C--- 
	 * FAMI�G���a
	 * UNIMART�G�Τ@�W��
	 * HILIFE�G�ܺ��I
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
	 * @param logisticsSubType
	 */
	public void setLogisticsSubType(String logisticsSubType) {
		LogisticsSubType = logisticsSubType;
	}
	@Override
	public String toString() {
		return "CreateTestDataObj [MerchantID=" + MerchantID + ", ClientReplyURL=" + ClientReplyURL + ", PlatformID="
				+ PlatformID + ", LogisticsSubType=" + LogisticsSubType + "]";
	}
}
