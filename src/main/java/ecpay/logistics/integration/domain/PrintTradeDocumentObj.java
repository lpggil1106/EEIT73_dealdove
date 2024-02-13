package ecpay.logistics.integration.domain;

/**
 * ���ͦ��B��(�v�t)/�@�q��(�W�Ө��f)�榡(B2C)����
 * @author mark.chiu
 *
 */
public class PrintTradeDocumentObj {
	
	/**
	 * MerchantID
	 *  �t�ӽs��
	 */
	private String MerchantID = "";
	
	/**
	 * AllPayLogisticsID
	 * ��ɬ�ު� ���y����s��
	 */
	private String AllPayLogisticsID = "";
	
	/**
	 * PlatformID
	 * �S���X�@�� �x�ӥN�� 
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
	 * ���oAllPayLogisticsID ��ɬ�ު� ���y����s��
	 * 1. �i�䴩�C�L�浧���B��/�@�q�Ф� (B2C)�妸�C�L�h���@�q�СC
	 * 2. �v�t���䴩�妸�C�L�h���U�B��/�@�q�СC
	 * 3. �Y���妸�C�L�h���@�q��(B2C)�A���H(,)�b���r���[�H���j�C�Ҧp�G10011,10012
	 * ��: �ܺ��I�@�q�Ф��i�P��L�W�Ӥ@�q�вV�X�C�L�ϥΡC
	 * @return AllPayLogisticsID
	 */
	public String getAllPayLogisticsID() {
		return AllPayLogisticsID;
	}
	/**
	 * �]�wAllPayLogisticsID ��ɬ�ު� ���y����s��
	 * 1. �i�䴩�C�L�浧���B��/�@�q�Ф� (B2C)�妸�C�L�h���@�q�СC
	 * 2. �v�t���䴩�妸�C�L�h���U�B��/�@�q�СC
	 * 3. �Y���妸�C�L�h���@�q��(B2C)�A���H(,)�b���r���[�H���j�C�Ҧp�G10011,10012
	 * ��: �ܺ��I�@�q�Ф��i�P��L�W�Ӥ@�q�вV�X�C�L�ϥΡC
	 * @param allPayLogisticsID
	 */
	public void setAllPayLogisticsID(String allPayLogisticsID) {
		AllPayLogisticsID = allPayLogisticsID;
	}
	/**
	 * ���oPlatformID �S���X�@�� �x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID�бa��a�Ҹj�w�� MerchantID�C
	 * @return PlatformID
	 */
	public String getPlatformID() {
		return PlatformID;
	}
	/**
	 * �]�wPlatformID �S���X�@�� �x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID�бa��a�Ҹj�w�� MerchantID�C
	 * @param platformID
	 */
	public void setPlatformID(String platformID) {
		PlatformID = platformID;
	}
	@Override
	public String toString() {
		return "PrintTradeDocumentObj [MerchantID=" + MerchantID + ", AllPayLogisticsID=" + AllPayLogisticsID
				+ ", PlatformID=" + PlatformID + "]";
	}
}
