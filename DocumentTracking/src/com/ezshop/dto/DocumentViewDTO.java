package com.ezshop.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ezshop.dao.OfficeDAO;
import com.ezshop.util.DocumentTrackingOfficeLogUtil;
import com.ezshop.util.DocumentViewUtil;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.DateTimeUtil;
import com.mytechnopal.util.StringUtil;

public class DocumentViewDTO extends DTOBase{

	private static final long serialVersionUID = 1L;

	public static final String SESSION_DOCUMENT_VIEW = "SESSION_DOCUMENT_VIEW";
	public static final String SESSION_DOCUMENT_VIEW_LIST = "SESSION_DOCUMENT_VIEW_LIST";
	public static final String SESSION_DOCUMENT_VIEW_PAGINATION = "SESSION_DOCUMENT_VIEW_PAGINATION";
	
	public static String[] FORWARD_LIST = {"NO", "YES"};
	public static String[] COMPLETE_TRACKING_LIST = {"NO", "YES"};
	
	private String name;
	private String description;
	private DocumentTypeDTO document_type;
	private String requesting_person;
	private Double amount;
	private String barcode;
	private OfficeDTO office;
	private String forward;
	private String trackingComplete;
	private Date trackingCompleteDate;
	private List<DTOBase> documentOfficeLogList;
	
	
	
	public DocumentViewDTO(){
		super();
		name = "";
		description ="";
		document_type = new DocumentTypeDTO();
		requesting_person = "";
		amount = (double) 0;
		barcode = "";
		office = new OfficeDTO();
		forward = "";
		trackingComplete = "";
		trackingCompleteDate = DateTimeUtil.getCurrentTimestamp();
		documentOfficeLogList = new ArrayList<DTOBase>();
		
	}

	public DocumentViewDTO getDocumentView() {
		DocumentViewDTO dv = new DocumentViewDTO();
		dv.setCode(super.getCode());
		dv.setId(this.getId());
		dv.setName(name);
		dv.setDescription(description);
		dv.setDocument_type(document_type);
		dv.setRequesting_person(requesting_person);
		dv.setAmount(amount);
		dv.setBarcode(barcode);
		dv.setOffice(office);
		dv.setForward(forward);
		dv.setTrackingComplete(trackingComplete);
		dv.setTrackingCompleteDate(trackingCompleteDate);
		dv.setDocumentOfficeLogList(documentOfficeLogList);
		return dv;
	}

	//List<DTOBase> newDocumentTrackingOfficeLogList = DocumentTrackingOfficeLogUtil.getDocumentTrackingOfficeLogListFilterByCode(code);
	public String[] getTableData(List<DTOBase> documentTrackingOfficeLogList) {//this thing has a list
		String code = getCode();
		//String status = DocumentViewUtil.getIndividualDocumentStatus(documentTrackingOfficeLogList, code); //format the status in here as a string. 
		//should have the doucmenttrackingofficeloglist filter by code mehtod here. but still thinking on how to loop and get just one by one.. 
		String status = DocumentViewUtil.getnewDocumentOfficeLogList(code);
		//DocumentTrackingOfficeLogUtil documentTrackingOfficeLog = new DocumentTrackingOfficeLogUtil();
		//make last column an code for table data that needs to be updated or deleted
		/*
		 * double totalRemoved = 0d;
		 * for(int i=0; i<merchandiseTransactionTypeRemovedList.size(); i++) {
			MerchandiseTransactionTypeDTO mtt = (MerchandiseTransactionTypeDTO) merchandiseTransactionTypeRemovedList.get(i);
			double qty = MerchandiseUtil.getTotalQtyByMerchandiseTransactionTypeCode(merchandiseTransactionList, mtt.getCode());
			totalRemoved += qty;
		}
		 */
		/*List<DTOBase> newDocumentTrackingOfficeLogList = new ArrayList<DTOBase>();
		for(int i=0; i<documentTrackingOfficeLogList.size(); i++){
			DocumentTrackingOfficeLogDTO dtol = (DocumentTrackingOfficeLogDTO) documentTrackingOfficeLogList.get(i);
			DocumentTrackingOfficeLogUtil dtolu = new DocumentTrackingOfficeLogUtil();
			if(dtol.getCode().equalsIgnoreCase(getCode())){
				newDocumentTrackingOfficeLogList.add(dtolu);
			}
			//newDocumentTrackingOfficeLogList.add(dtolu.getDocumentTrackingOfficeLogListFilterByCode(documentTrackingOfficeLogList, getCode())); //this thing has a list. what the .....
		}*/
		
		/*
		 * List<DTOBase> officeList = new OfficeDAO().getOfficeList();  //all the office list
			List<DTOBase> officeListnew = new ArrayList<DTOBase>();		//office list remove current office
			for(DTOBase Officeobj : officeList) {
				OfficeDTO office = (OfficeDTO) Officeobj;
				if(!staff.getOffice().getCode().equalsIgnoreCase(office.getCode())) {//if NOT == current office, display all list aside the current office
					officeListnew.add(office);
				}
			}
		 */
		
		/*List<DTOBase> documentTrackingOfficeListNew = new ArrayList<DTOBase>();
		for(DTOBase documentTrackingOfficeListObj: documentTrackingOfficeLogList) {
			DocumentTrackingOfficeLogDTO dtol = (DocumentTrackingOfficeLogDTO) documentTrackingOfficeListObj;
			if(dtol.getCode().equalsIgnoreCase(code)){//this is wrong
				documentTrackingOfficeListNew.add(dtol);
			}
		}
		//status = newDocumentTrackingOfficeLogList.get(newDocumentTrackingOfficeLogList.size()-1);
				//games.get(games.size() -1);
			int i = documentTrackingOfficeListNew.size();
			DocumentTrackingOfficeLogDTO ndtol = (DocumentTrackingOfficeLogDTO) documentTrackingOfficeListNew.get(0);
			status = ndtol.getStatus();
			int statuses = documentTrackingOfficeListNew.size();*/
			//status = "" + statuses;
		
		
		return new String[] {getCode(), getName(), getDescription(), status ,getCode()};
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DocumentTypeDTO getDocument_type() {
		return document_type;
	}

	public void setDocument_type(DocumentTypeDTO document_type) {
		this.document_type = document_type;
	}

	public String getRequesting_person() {
		return requesting_person;
	}

	public void setRequesting_person(String requesting_person) {
		this.requesting_person = requesting_person;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public OfficeDTO getOffice() {
		return office;
	}

	public void setOffice(OfficeDTO office) {
		this.office = office;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getTrackingComplete() {
		return trackingComplete;
	}

	public void setTrackingComplete(String trackingComplete) {
		this.trackingComplete = trackingComplete;
	}

	public Date getTrackingCompleteDate() {
		return trackingCompleteDate;
	}

	public void setTrackingCompleteDate(Date trackingCompleteDate) {
		this.trackingCompleteDate = trackingCompleteDate;
	}

	public List<DTOBase> getDocumentOfficeLogList() {
		return documentOfficeLogList;
	}

	public void setDocumentOfficeLogList(List<DTOBase> documentOfficeLogList) {
		this.documentOfficeLogList = documentOfficeLogList;
	}
}