package ecpay.logistics.integration.domain;

/**
 * ���Ѽt�ӭק�X�f����B���f����(�Τ@�W��B2C)����
 * @author mark.chiu
 *
 */
public class UpdateShipmentInfoObj {
	
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
	 * ShipmentDate
	 * ���y�q��X�f���
	 */
	private String ShipmentDate = "";
	
	/**
	 * ReceiverStoreID
	 * ���y�q����f����
	 */
	private String ReceiverStoreID = "";
	
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
	 * ���oShipmentDate ���y�q��X�f��� ���y�q��X�f����B���y�q����f�����ݾܤ@����
	 * @return ShipmentDate
	 */
	public String getShipmentDate() {
		return ShipmentDate;
	}
	/**
	 * �]�wShipmentDate ���y�q��X�f��� ���y�q��X�f����B���y�q����f�����ݾܤ@����
	 * @param shipmentDate
	 */
	public void setShipmentDate(String shipmentDate) {
		ShipmentDate = shipmentDate;
	}
	/**
	 * ���oReceiverStoreID ���y�q����f���� ���y�q��X�f����B���y�q����f�����ݾܤ@����
	 * @return ReceiverStoreID
	 */
	public String getReceiverStoreID() {
		return ReceiverStoreID;
	}
	/**
	 * �]�wReceiverStoreID ���y�q����f���� ���y�q��X�f����B���y�q����f�����ݾܤ@����
	 * @param receiverStoreID
	 */
	public void setReceiverStoreID(String receiverStoreID) {
		ReceiverStoreID = receiverStoreID;
	}
	/**
	 * ���oPlatformID �S���X�@���x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID �бa��a�Ҹj�w��MerchantID
	 * @return PlatformID
	 */
	public String getPlatformID() {
		return PlatformID;
	}
	/**
	 * �]�wPlatformID �S���X�@���x�ӥN�� �Ѻ�ɬ�޴��ѡA���ѼƬ��M�צX�@�����x�ӨϥΡA�@��t�Ӥ����Щ�ŭȡC�Y���M�צX�@�����x�ӨϥήɡAMerchantID �бa��a�Ҹj�w��MerchantID
	 * @param platformID
	 */
	public void setPlatformID(String platformID) {
		PlatformID = platformID;
	}
	@Override
	public String toString() {
		return "UpdateShipmentInfoObj [MerchantID=" + MerchantID + ", AllPayLogisticsID=" + AllPayLogisticsID
				+ ", ShipmentDate=" + ShipmentDate + ", ReceiverStoreID=" + ReceiverStoreID + ", PlatformID="
				+ PlatformID + "]";
	}
}
