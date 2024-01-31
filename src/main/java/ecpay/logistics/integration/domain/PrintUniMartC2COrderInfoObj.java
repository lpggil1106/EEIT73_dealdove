package ecpay.logistics.integration.domain;

/**
 * �C�Lú�ڳ�(�Τ@�W�� C2C)����
 * @author mark.chiu
 *
 */
public class PrintUniMartC2COrderInfoObj {
	
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
	 * CVSValidationNo
	 * ���ҽX
	 */
	private String CVSValidationNo = "";
	
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
	 * ���oCVSPaymentNo �H�f�s�� �Y���Τ@�W�ӮɡA�H�f�s�����t�Ӻ޲z��x-���y�޲z��������쬰�u��f�K�N�X/���쩱�s���v��h��|�X�C�Ҧp�GG65445297175�A�Τ@�W�ӥ��T�H�f�s���� G6544529�C
	 * @return CVSPaymentNo
	 */
	public String getCVSPaymentNo() {
		return CVSPaymentNo;
	}
	/**
	 * �]�wCVSPaymentNo �H�f�s�� �Y���Τ@�W�ӮɡA�H�f�s�����t�Ӻ޲z��x-���y�޲z��������쬰�u��f�K�N�X/���쩱�s���v��h��|�X�C�Ҧp�GG65445297175�A�Τ@�W�ӥ��T�H�f�s���� G6544529�C
	 * @param cVSPaymentNo
	 */
	public void setCVSPaymentNo(String cVSPaymentNo) {
		CVSPaymentNo = cVSPaymentNo;
	}
	/**
	 * ���oCVSValidationNo ���ҽX �Y���Τ@�W�ӮɡA���t�Ӻ޲z��x-���y�޲z��������쬰�u��f�K�N�X/���쩱�s���v��|�X�C�Ҧp�GG65445297175�A�Τ@�W�ӥ��T���ҽX���� 7175�C
	 * @return CVSValidationNo
	 */
	public String getCVSValidationNo() {
		return CVSValidationNo;
	}
	/**
	 * �]�wCVSValidationNo ���ҽX �Y���Τ@�W�ӮɡA���t�Ӻ޲z��x-���y�޲z��������쬰�u��f�K�N�X/���쩱�s���v��|�X�C�Ҧp�GG65445297175�A�Τ@�W�ӥ��T���ҽX���� 7175�C
	 * @param cVSValidationNo
	 */
	public void setCVSValidationNo(String cVSValidationNo) {
		CVSValidationNo = cVSValidationNo;
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
		return "PrintUniMartC2COrderInfoObj [MerchantID=" + MerchantID + ", AllPayLogisticsID=" + AllPayLogisticsID
				+ ", CVSPaymentNo=" + CVSPaymentNo + ", CVSValidationNo=" + CVSValidationNo + ", PlatformID="
				+ PlatformID + "]";
	}
}
