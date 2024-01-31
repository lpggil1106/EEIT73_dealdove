package ecpay.logistics.integration.domain;

/**
 * �ܺ��I�C�L�p�ճ�(�ܺ��I�W�� C2C)����
 * @author mark.chiu
 *
 */
public class PrintOKMARTC2COrderInfoObj {
	
	/**
	 * MerchantID
	 * �t�ӽs��
	 */
	private String MerchantID = "";
	
	/**
	 * AllPayLogisticsID
	 * ���y����s��
	 */
	private String AllPayLogisticsID = "";
	
	/**
	 * CVSPaymentNo
	 * �H�f�s��
	 */
	private String CVSPaymentNo = "";
	
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
	 * ���oAllPayLogisticsID ���y����s��
	 * @return AllPayLogisticsID
	 */
	public String getAllPayLogisticsID() {
		return AllPayLogisticsID;
	}
	/**
	 * �]�wAllPayLogisticsID ���y����s��
	 * @param allPayLogisticsID
	 */
	public void setAllPayLogisticsID(String allPayLogisticsID) {
		AllPayLogisticsID = allPayLogisticsID;
	}
	/**
	 * ���oCVSPaymentNo �H�f�s��
	 * @return CVSPaymentNo
	 */
	public String getCVSPaymentNo() {
		return CVSPaymentNo;
	}
	/**
	 * �]�wCVSPaymentNo �H�f�s��
	 * @param cVSPaymentNo
	 */
	public void setCVSPaymentNo(String cVSPaymentNo) {
		CVSPaymentNo = cVSPaymentNo;
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
		return "PrintOKMARTC2COrderInfoObj [MerchantID=" + MerchantID + ", AllPayLogisticsID=" + AllPayLogisticsID
				+ ", CVSPaymentNo=" + CVSPaymentNo + ", PlatformID=" + PlatformID + "]";
	}
}
