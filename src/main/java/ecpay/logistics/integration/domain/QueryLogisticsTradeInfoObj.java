package ecpay.logistics.integration.domain;

/**
 * ���y�q��d�ߪ���
 * @author mark.chiu
 *
 */
public class QueryLogisticsTradeInfoObj {
	
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
	 * TimeStamp
	 * ���Үɶ�
	 */
	private String TimeStamp = "";
	
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
	 * ���oAllPayLogisticsID ��ɬ�ު����y����s��
	 * @return AllPayLogisticsID
	 */
	public String getAllPayLogisticsID() {
		return AllPayLogisticsID;
	}
	/**
	 * �]�wAllPayLogisticsID ��ɬ�ު����y����s��
	 * @param allPayLogisticsID
	 */
	public void setAllPayLogisticsID(String allPayLogisticsID) {
		AllPayLogisticsID = allPayLogisticsID;
	}
	/**
	 * ���oTimeStamp ���Үɶ� �N��U���ɶ��ର UnixTimeStamp �Ω����Ҧ����������ɶ��϶��C��ɬ�����Үɶ��϶��ȭq�� 3 ���������ġA�W�L�h���������L�ġC
	 * @return TimeStamp
	 */
	public String getTimeStamp() {
		return TimeStamp;
	}
	/**
	 * �]�wTimeStamp ���Үɶ� �N��U���ɶ��ର UnixTimeStamp �Ω����Ҧ����������ɶ��϶��C��ɬ�����Үɶ��϶��ȭq�� 3 ���������ġA�W�L�h���������L�ġC
	 * @param timeStamp
	 */
	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}
	/**
	 * ���ogetPlatformID �S���X�@���x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID �бa��a�Ҹj�w��MerchantID�C
	 * @return getPlatformID
	 */
	public String getPlatformID() {
		return PlatformID;
	}
	/**
	 * �]�wgetPlatformID �S���X�@���x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID �бa��a�Ҹj�w��MerchantID�C
	 * @param platformID
	 */
	public void setPlatformID(String platformID) {
		PlatformID = platformID;
	}
	@Override
	public String toString() {
		return "QueryLogisticsTradeInfoObj [MerchantID=" + MerchantID + ", AllPayLogisticsID=" + AllPayLogisticsID
				+ ", TimeStamp=" + TimeStamp + ", PlatformID=" + PlatformID + "]";
	}
}
