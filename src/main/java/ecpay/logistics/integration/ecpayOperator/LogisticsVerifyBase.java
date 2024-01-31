package ecpay.logistics.integration.ecpayOperator;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ecpay.logistics.integration.domain.CreateCVSObj;
import ecpay.logistics.integration.domain.CreateHomeObj;
import ecpay.logistics.integration.domain.ReturnCVSObj;
import ecpay.logistics.integration.domain.ReturnHiLifeCVSObj;
import ecpay.logistics.integration.domain.ReturnHomeObj;
import ecpay.logistics.integration.domain.ReturnUniMartCVSObj;
import ecpay.logistics.integration.domain.UpdateShipmentInfoObj;
import ecpay.logistics.integration.domain.UpdateStoreInfoObj;
import ecpay.logistics.integration.errorMsg.ErrorMessage;
import ecpay.logistics.integration.exception.EcpayException;

public class LogisticsVerifyBase {
	protected String confPath = "/ecpay/logistics/integration/config/ECpayLogistics.xml";
	protected Document doc;
	public LogisticsVerifyBase(){
		URL fileURL = this.getClass().getResource(confPath);
		doc = EcpayFunction.xmlParser(fileURL.toString());
		doc.getDocumentElement().normalize();
	}
	
	protected void requireCheck(String FieldName, String objValue, String require){
		if(require.equals("1") && objValue.isEmpty())
			throw new EcpayException(FieldName+"������");
	}
	
	protected void valueCheck(String type, String objValue, Element ele){
		if(objValue.isEmpty())
			return;
		if(type.equals("String")){
			if(ele.getElementsByTagName("pattern") != null){
				Pattern r = Pattern.compile(ele.getElementsByTagName("pattern").item(0).getTextContent().toString());
				Matcher m = r.matcher(objValue);
				if(!m.find()){
					throw new EcpayException(ele.getAttribute("name")+ErrorMessage.COLUMN_RULE_ERROR);
				}
			}
		} else if(type.equals("Opt")){
			List<String> opt = new ArrayList<String>();
			NodeList n = ele.getElementsByTagName("option");
			for(int i=0; i < n.getLength(); i++){
				opt.add(n.item(i).getTextContent().toString());
			}
			if(!opt.contains(objValue)){
				throw new EcpayException(ele.getAttribute("name")+ErrorMessage.COLUMN_RULE_ERROR);
			}
		} else if(type.equals("Int")){
			String mode = ele.getElementsByTagName("mode").item(0).getTextContent();
			String minimum = ele.getElementsByTagName("minimal").item(0).getTextContent();
			String maximum = ele.getElementsByTagName("maximum").item(0).getTextContent();
			if(objValue.isEmpty()){
				throw new EcpayException(ele.getAttribute("name")+ErrorMessage.CANNOT_BE_EMPTY);
			}
			int value = Integer.valueOf(objValue);
			if(mode.equals("GE") && value < Integer.valueOf(minimum)){
				throw new EcpayException(ele.getAttribute("name")+"����p��"+minimum);
			} else if(mode.equals("LE") && value > Integer.valueOf(maximum)){
				throw new EcpayException(ele.getAttribute("name")+"����j��"+maximum);
			} else if(mode.equals("BETWEEN") && value < Integer.valueOf(minimum) && value > Integer.valueOf(maximum)){
				throw new EcpayException(ele.getAttribute("name")+"��������"+minimum+"�M"+maximum+"����");
			} else if(mode.equals("EXCLUDE") && value >= Integer.valueOf(minimum) && value <= Integer.valueOf(maximum)){
				throw new EcpayException(ele.getAttribute("name")+"�����p��"+minimum+"�Τj��"+maximum);
			}
		} else if(type.equals("DepOpt")){
			// TODO
		}
	}
	
	public void verifyCreate(Object obj){
		if(obj instanceof CreateCVSObj){
			// ���S�����Ȭ̻ۨݨD-ServerReplyURL���i����
			if(((CreateCVSObj) obj).getServerReplyURL().isEmpty())
				throw new EcpayException("ServerReplyURL cannot be empty.");
			// LogisticsSubType ���ର HOME
			if(((CreateCVSObj) obj).getLogisticsSubType().equals("TCAT") || ((CreateCVSObj) obj).getLogisticsSubType().equals("ECAN"))
				throw new EcpayException("LogisticsSubType cannot be "+((CreateCVSObj) obj).getLogisticsSubType()+" when LogisticsType is CVS.");
			//[LogisticsSubType]��UNIMART => UNIMART�����W�h
			else if(((CreateCVSObj) obj).getLogisticsSubType().equals("UNIMART")){
				// [LogisticsSubType]��UNIMART => ReceiverCellPhone Can Not be empty
				if(((CreateCVSObj) obj).getReceiverCellPhone().isEmpty())
					throw new EcpayException("ReceiverCellPhone cannot be empty when LogisticsSubType is UNIMART.");
				// [LogisticsSubType]��UNIMART => ReceiverStoreID Can Not be empty
				if(((CreateCVSObj) obj).getReceiverStoreID().isEmpty())
					throw new EcpayException("ReceiverStoreID cannot be empty when LogisticsSubType is UNIMART.");
				// [LogisticsSubType]��UNIMART => ReturnStoreID Must be empty
				if(!((CreateCVSObj) obj).getReturnStoreID().isEmpty())
					throw new EcpayException("ReturnStoreID must be empty when LogisticsSubType is UNIMART.");
			// [LogisticsSubType]��FAMI => FAMI�����W�h
			} else if(((CreateCVSObj) obj).getLogisticsSubType().equals("FAMI")){
				// [LogisticsSubType]��FAMI => ReceiverCellPhone Can Not be empty
				if(((CreateCVSObj) obj).getReceiverCellPhone().isEmpty())
					throw new EcpayException("ReceiverCellPhone cannot be empty when LogisticsSubType is FAMI.");
				// [LogisticsSubType]��FAMI => ReturnStoreID Can Not be empty
				if(((CreateCVSObj) obj).getReceiverStoreID().isEmpty())
					throw new EcpayException("ReceiverStoreID cannot be empty when LogisticsSubType is FAMI.");
				// [LogisticsSubType]��FAMI => ReturnStoreID Must be empty
				if(!((CreateCVSObj) obj).getReturnStoreID().isEmpty())
					throw new EcpayException("ReturnStoreID must be empty when LogisticsSubType is FAMI.");
			// [LogisticsSubType]��HILIFE => HILIFE�����W�h
			} else if(((CreateCVSObj) obj).getLogisticsSubType().equals("HILIFE")){
				// [LogisticsSubType]��HILIFE => ReceiverStoreID Can Not be empty
				if(((CreateCVSObj) obj).getReceiverStoreID().isEmpty())
					throw new EcpayException("ReceiverStoreID cannot be empty when LogisticsSubType is HILIFE.");
				// [LogisticsSubType]��HILIFE => ReturnStoreID Must be empty
				if(!((CreateCVSObj) obj).getReturnStoreID().isEmpty())
					throw new EcpayException("ReturnStoreID must be empty when LogisticsSubType is HILIFE.");
			// [LogisticsSubType]��UNIMARTC2C => UNIMARTC2C�����W�h
			} else if(((CreateCVSObj) obj).getLogisticsSubType().equals("UNIMARTC2C")){
				// [LogisticsSubType]��UNIMARTC2C => GoodsAmount must be equal CollectionAmount
				if(!((CreateCVSObj) obj).getCollectionAmount().isEmpty())
					if(!((CreateCVSObj) obj).getGoodsAmount().equals(((CreateCVSObj) obj).getCollectionAmount()))
						throw new EcpayException("GoodsAmount("+((CreateCVSObj) obj).getGoodsAmount()+") cannot be equal to CollectionAmount("+((CreateCVSObj) obj).getCollectionAmount()+") when LogisticsSubType is UNIMARTC2C.");
				// [LogisticsSubType]��UNIMARTC2C => SenderCellPhone Can Not be empty
				if(((CreateCVSObj) obj).getSenderCellPhone().isEmpty())
					throw new EcpayException("SenderCellPhone cannot be empty when LogisticsSubType is UNIMARTC2C.");
				// [LogisticsSubType]��UNIMARTC2C => ReceiverCellPhone Can Not be empty
				if(((CreateCVSObj) obj).getReceiverCellPhone().isEmpty())
					throw new EcpayException("ReceiverCellPhone cannot be empty when LogisticsSubType is UNIMARTC2C.");
				// [LogisticsSubType]��UNIMARTC2C => GoodsName Can Not be empty
				if(((CreateCVSObj) obj).getGoodsName().isEmpty())
					throw new EcpayException("GoodsName cannot be empty when LogisticsSubType is UNIMARTC2C.");
				// [LogisticsSubType]��UNIMARTC2C => LogisticsC2CReplyURL Can Not be empty
				if(((CreateCVSObj) obj).getLogisticsC2CReplyURL().isEmpty())
					throw new EcpayException("LogisticsC2CReplyURL cannot be empty when LogisticsSubType is UNIMARTC2C.");
				// [LogisticsSubType]��UNIMARTC2C => ReturnStoreID Can Not be empty
				if(((CreateCVSObj) obj).getReceiverStoreID().isEmpty())
					throw new EcpayException("ReceiverStoreID cannot be empty when LogisticsSubType is UNIMARTC2C.");
			// [LogisticsSubType]��FAMIC2C => FAMIC2C�����W�h
			} else if(((CreateCVSObj) obj).getLogisticsSubType().equals("FAMIC2C")){
				// [LogisticsSubType]��FAMIC2C => ReceiverCellPhone Cannot be empty
				if(((CreateCVSObj) obj).getReceiverCellPhone().isEmpty())
					throw new EcpayException("ReceiverCellPhone cannot be empty when LogisticsSubType is FAMIC2C.");
				// [LogisticsSubType]��FAMIC2C => ReturnStoreID Can Not be empty
				if(((CreateCVSObj) obj).getReceiverStoreID().isEmpty())
					throw new EcpayException("ReceiverStoreID cannot be empty when LogisticsSubType is FAMIC2C.");
			// [LogisticsSubType]��HILIFEC2C => HILIFEC2C�����W�h
			} else if(((CreateCVSObj) obj).getLogisticsSubType().equals("HILIFEC2C")){
				// [LogisticsSubType]��HILIFEC2C => GoodsName Can Not be empty
				if(((CreateCVSObj) obj).getGoodsName().isEmpty())
					throw new EcpayException("GoodsName cannot be empty when LogisticsSubType is HILIFEC2C.");
				// [LogisticsSubType]��HILIFEC2C => SenderCellPhone Can Not be empty
				if(((CreateCVSObj) obj).getSenderCellPhone().isEmpty())
					throw new EcpayException("SenderCellPhone cannot be empty when LogisticsSubType is HILIFEC2C.");
				// [LogisticsSubType]��HILIFEC2C => ReceiverCellPhone Can Not be empty
				if(((CreateCVSObj) obj).getReceiverCellPhone().isEmpty())
					throw new EcpayException("ReceiverCellPhone cannot be empty when LogisticsSubType is HILIFEC2C.");
				// [LogisticsSubType]��HILIFEC2C => ReturnStoreID Can Not be empty
				if(((CreateCVSObj) obj).getReceiverStoreID().isEmpty())
					throw new EcpayException("ReceiverStoreID cannot be empty when LogisticsSubType is HILIFEC2C.");
			}
			if(((CreateCVSObj) obj).getReceiverStoreID().isEmpty() && ((CreateCVSObj) obj).getReturnStoreID().isEmpty())
				throw new EcpayException("ReceiverStoreID and ReturnStoreID cannot both be empty.");
		} else if(obj instanceof CreateHomeObj){
			// ���S�����Ȭ̻ۨݨD-ServerReplyURL���i����
			if(((CreateHomeObj) obj).getServerReplyURL().isEmpty())
				throw new EcpayException("ServerReplyURL cannot be empty.");
			// LogisticsSubType���ण��TCAT and ECAN
			if(!((CreateHomeObj) obj).getLogisticsSubType().equals("TCAT") && !((CreateHomeObj) obj).getLogisticsSubType().equals("ECAN"))
				throw new EcpayException("LogisticsSubType cannot be "+((CreateHomeObj) obj).getLogisticsSubType()+" when LogisticsType is Home.");
			// IsCollection ���ରY
			if(((CreateHomeObj) obj).getIsCollection().equals("Y"))
				throw new EcpayException("IsCollection cannot be Y when LogisticsType is Home.");
			// SenderPhone and SenderCellPhone cannot both be empty
			if(((CreateHomeObj) obj).getSenderPhone().isEmpty() && ((CreateHomeObj) obj).getSenderCellPhone().isEmpty())
				throw new EcpayException("SenderPhone and SenderCellPhone cannot both be empty when LogisticsType is Home.");
			// ReceiverPhone and ReceiverCellPhone Can Not Both be empty
			if(((CreateHomeObj) obj).getReceiverPhone().isEmpty() && ((CreateHomeObj) obj).getReceiverCellPhone().isEmpty())
				throw new EcpayException("ReceiverPhone and ReceiverCellPhone cannot both be empty when LogisticsType is Home.");
			// [LogisticsType]��Home�B[LogisticsSubType]��ECAN
			if(((CreateHomeObj) obj).getLogisticsSubType().equals("ECAN")){
				// [LogisticsSubType]��ECAN => Temperature �u�ର0001�`��
				if(!((CreateHomeObj) obj).getTemperature().equals("0001"))
					throw new EcpayException("Temperature cannot be "+((CreateHomeObj) obj).getTemperature()+" when LogisticsSubType is ECAN.");
				// [LogisticsSubType]��ECAN => ScheduledDeliveryTime ���ର5:20~21
				if(((CreateHomeObj) obj).getScheduledDeliveryTime().equals("5"))
					throw new EcpayException("ScheduledDeliveryTime cannot be 5 when LogisticsSubType is ECAN.");
				// [LogisticsSubType]��ECAN => PackageCount �d��1��999
				System.out.println(((CreateHomeObj) obj).getPackageCount());
				if(Integer.parseInt(((CreateHomeObj) obj).getPackageCount()) < 1 || Integer.parseInt(((CreateHomeObj) obj).getPackageCount()) > 999)
					throw new EcpayException("PackageCount should be between 1 and 999 when LogisticsSubType is ECAN.");
			// [LogisticsType]��Home�B[LogisticsSubType]��TCAT
			} else if(((CreateHomeObj) obj).getLogisticsSubType().equals("TCAT")){
				// [LogisticsSubType]��TCAT => ScheduledDeliveryTime ���ର12:9~17, 13:9~12&17~20, 23:13~20
				if(!((CreateHomeObj) obj).getScheduledDeliveryTime().isEmpty())
					if(Integer.parseInt(((CreateHomeObj) obj).getScheduledDeliveryTime()) <= 1 && Integer.parseInt(((CreateHomeObj) obj).getScheduledDeliveryTime()) >= 23)
						throw new EcpayException("ScheduledDeliveryTime cannot be "+((CreateHomeObj) obj).getScheduledDeliveryTime()+" when LogisticsSubType is TCAT.");
				// [LogisticsSubType]��TCAT => ScheduledPickupTime ���i����
				if(((CreateHomeObj) obj).getScheduledPickupTime().isEmpty())
					throw new EcpayException("ScheduledPickupTime cannot be empty when LogisticsSubType is TCAT.");
			}
			// [Temperature]��0003�N�� => Specification ���ର 0004:150cm
			if(((CreateHomeObj) obj).getTemperature().equals("0003"))
				if(((CreateHomeObj) obj).getSpecification().equals("0004"))
					throw new EcpayException("Specification cannot be 0004 when Temperature is 0003");
		} else{
			throw new EcpayException("�ǤJ���~������!");
		}
	}
	
	public void verifyUpdateShipmentInfo(UpdateShipmentInfoObj obj){
		// [ShipmentDate] and [ReceiverStoreID] can not both be empty.
		if(obj.getShipmentDate().isEmpty() && obj.getReceiverStoreID().isEmpty())
			throw new EcpayException("ShipmentDate and ReceiverStoreID cannot both be empty.");
	}
	
	public void verifyReturnHome(ReturnHomeObj obj){
		// [AllPayLogisticsID] and [LogisitcsSubType] can not both be empty.
		if(obj.getAllPayLogisticsID().isEmpty() && obj.getLogisticsSubType().isEmpty())
			throw new EcpayException("AllPayLogisticsID and LogisticsSubType cannot both be empty.");
		// if [LogisticsSubType] isn't empty, it will check info_params values not empty.
		String[] infoParams = {"SenderName", "SenderZipCode", "SenderAddress", "ReceiverName", "ReceiverZipCode", "ReceiverAddress"};
		if(obj.getLogisticsSubType().equals("TCAT") || obj.getLogisticsSubType().equals("ECAN")){
			for(String tmp: infoParams){
				// Check if there's empty value.
				try {
					Method method = obj.getClass().getMethod("get"+tmp, null);
					if(method.invoke(obj).toString().isEmpty())
						throw new EcpayException(tmp+" contains empty value.");
				} catch (Exception e) {
					throw new EcpayException(e.getMessage());
				}
			}
			if(Pattern.matches("[\'\"]+", obj.getGoodsName()))
				throw new EcpayException("GoodsName cannot contain quotation marks.");
			if(!Pattern.matches("^([\u4e00-\u9fa5]{1,5}|[a-zA-Z]{1,10})$", obj.getSenderName()) || !Pattern.matches("^([\u4e00-\u9fa5]{1,5}|[a-zA-Z]{1,10})$", obj.getReceiverName()))
				throw new EcpayException("SenderName or ReceiverName must be at most 5 Chinese or 10 alphabets.");
			if(!Pattern.matches("^.{7,61}$", obj.getSenderAddress()) || !Pattern.matches("^.{7,61}$", obj.getReceiverAddress()))
				throw new EcpayException("SenderAddress or ReceiverAddress must be 7-61 alphabets.");
			if(!Pattern.matches("^\\d{3,5}$", obj.getSenderZipCode()) || !Pattern.matches("^\\d{3,5}$", obj.getReceiverZipCode()))
				throw new EcpayException("SenderZipCode or ReceiverZipCode must be 3-5 numbers.");
			// [LogisitcsSubType]��TCAT or ECAN => SenderPhone and SenderCellPhone Can Not Both be empty
			if(obj.getSenderPhone().isEmpty() && obj.getSenderCellPhone().isEmpty())
				throw new EcpayException("SenderPhone and SenderCellPhone cannot both be empty when LogisticsType is Home.");
			// [LogisitcsSubType]��TCAT or ECAN => ReceiverPhone and ReceiverCellPhone Can Not Both be empty
			if(obj.getReceiverPhone().isEmpty() && obj.getReceiverCellPhone().isEmpty())
				throw new EcpayException("ReceiverPhone and ReceiverCellPhone cannot both be empty when LogisticsType is Home.");
			// [LogisticsSubType]��ECAN
			if(obj.getLogisticsSubType().equals("ECAN")){
				// [LogisticsSubType]��ECAN => Temperature �u�ର0001�`��
				if(!obj.getTemperature().equals("0001"))
					throw new EcpayException("Temperature cannot be "+obj.getTemperature()+" when LogisticsSubType is ECAN.");
				// [LogisticsSubType]��ECAN => ScheduledDeliveryTime ���ର5:20~21
				if(obj.getScheduledDeliveryTime().equals("5"))
					throw new EcpayException("ScheduledDeliveryTime cannot be 5 when LogisticsSubType is ECAN.");
				// [LogisticsSubType]��ECAN => PackageCount �d��1��999
				if(Integer.parseInt(obj.getPackageCount()) < 1 || Integer.parseInt(obj.getPackageCount()) > 999)
					throw new EcpayException("PackageCount should be between 1 and 999 when LogisticsSubType is ECAN.");
			// [LogisticsSubType]��TCAT
			} else if(obj.getLogisticsSubType().equals("TCAT")){
				// [LogisticsSubType]��TCAT => ScheduledDeliveryTime ���ର12:9~17, 13:9~12&17~20, 23:13~20
				if(!obj.getScheduledDeliveryTime().isEmpty())
					if(Integer.parseInt(obj.getScheduledDeliveryTime()) <= 1 && Integer.parseInt(obj.getScheduledDeliveryTime()) >= 23)
						throw new EcpayException("ScheduledDeliveryTime cannot be "+obj.getScheduledDeliveryTime()+" when LogisticsSubType is TCAT.");
				// [LogisticsSubType]��TCAT => ScheduledPickupTime ���i����
				if(obj.getScheduledPickupTime().isEmpty())
					throw new EcpayException("ScheduledPickupTime cannot be empty when LogisticsSubType is TCAT.");
			}
			// [Temperature]��0003�N�� => Specification ���ର 0004:150cm
			if(obj.getTemperature().equals("0003"))
				if(obj.getSpecification().equals("0004"))
					throw new EcpayException("Specifications cannot be 0004 when Temperature is 0003.");
		}
	}
	
	public void verifyReturnCVS(ReturnCVSObj obj){
		// �ӫ~�W�٤��i�H����޸������޸�
		if(Pattern.matches("[\'\"]+", obj.getGoodsName()))
			throw new EcpayException("GoodsName cannot contain quotation marks.");
		// �ӫ~�W�٧t�����r => �{���O�h�˰ӫ~ *GoodsName�A *Quantity �A*Cost�v�@�Τ��r���ΡA�p��ƶq��P�Ĥ@�Ӥ��
		String[] itemParams = {"GoodsName", "Quantity", "Cost"};
		if(obj.getGoodsName().contains("#")){
			int itemCount = obj.getGoodsName().split("#").length;
			for(String tmp: itemParams){
				// Check if there's empty value.
				Method method;
				try {
					method = obj.getClass().getMethod("get"+tmp, null);
					String param = method.invoke(obj).toString();
					if(Pattern.matches("(\\#\\#|^\\#|\\#$)", param))
						throw new EcpayException(tmp+" contains empty value.");
					int paramCount = param.split("#").length;
					if(itemCount != paramCount)
						throw new EcpayException("Count of "+tmp+" is not equal to the count of GoodsName.");
				} catch (Exception e) {
					throw new EcpayException(e.getMessage());
				}
			}
		} else{
			// �S���޽u => �v�@�ˬd@item_params_list����즳�L�޽u
			for(String tmp : itemParams){
				Method method;
				try {
					method = obj.getClass().getMethod("get"+tmp, null);
					String paramValue = method.invoke(obj).toString();
					if(paramValue.contains("#"))
						throw new EcpayException("Item info "+tmp+" contains # delimiter but there's only one item in GoodsName.");
				} catch(Exception e){
					throw new EcpayException(e.getMessage());
				}
			}
		}	
	}
	
	public void verifyReturnHiLifeCVS(ReturnHiLifeCVSObj obj){
		// �ӫ~�W�٤��i�H����޸������޸�
		if(Pattern.matches("[\'\"]+", obj.getGoodsName()))
			throw new EcpayException("GoodsName cannot contain quotation marks.");
		if(!Pattern.matches("^([\\u4e00-\\u9fa5\\w]{0,30}|[\\w]{0,60})$", obj.getGoodsName()))
			throw new EcpayException("GoodsName must be at most 30 Chinese words or 60 alphabets.");
	}
	
	public void verifyReturnUniMartCVS(ReturnUniMartCVSObj obj){
		// �ӫ~�W�٤��i�H����޸������޸�
		if(Pattern.matches("[\'\"]+", obj.getGoodsName()))
			throw new EcpayException("GoodsName cannot contain quotation marks.");
	}
	
	public void verifyUpdateStoreInfo(UpdateStoreInfoObj obj){
		// [ReceiverStoreID] and [ReturneStoreID] can not both be empty.
		if(obj.getReceiverStoreID().isEmpty() && obj.getReturnStoreID().isEmpty())
			throw new EcpayException("ReceiverStoreID and ReturnStoreID cannot both be empty.");
	}
}
