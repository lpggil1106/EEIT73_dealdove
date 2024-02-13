package ecpay.logistics.integration.domain;

/**
 * ���a�f���y�ֱb(���a�W��B2C)����
 * @author mark.chiu
 *
 */
public class LogisticsCheckAccountsObj {
	
	/**
	 * MerchantID
	 * �t�ӽs��
	 */
	private String MerchantID = "";
	
	/**
	 * RtnMerchantTradeNo
	 * ���y�h�f�q��s��
	 */
	private String RtnMerchantTradeNo = "";
	
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
	 * ���oRtnMerchantTradeNo ���y�h�f�q��s��
	 * @return RtnMerchantTradeNo
	 */
	public String getRtnMerchantTradeNo() {
		return RtnMerchantTradeNo;
	}
	/**
	 * �]�wRtnMerchantTradeNo ���y�h�f�q��s��
	 * @param rtnMerchantTradeNo
	 */
	public void setRtnMerchantTradeNo(String rtnMerchantTradeNo) {
		RtnMerchantTradeNo = rtnMerchantTradeNo;
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
		return "LogisticsCheckAccountsObj [MerchantID=" + MerchantID + ", RtnMerchantTradeNo=" + RtnMerchantTradeNo
				+ ", PlatformID=" + PlatformID + "]";
	}
}
