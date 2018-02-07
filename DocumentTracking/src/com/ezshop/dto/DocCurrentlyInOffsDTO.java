package com.ezshop.dto;

import java.util.ArrayList;
import java.util.List;

import com.ezshop.util.StaffUtil;
import com.mytechnopal.DTOBase;

public class DocCurrentlyInOffsDTO extends DTOBase{

	private static final long serialVersionUID = 1L;

	public static final String SESSION_DOC_CURRENTLY_IN_OFFS = "SESSION_DOC_CURRENTLY_IN_OFFS";
	public static final String SESSION_DOC_CURRENTLY_IN_OFFS_LIST = "SESSION_DOC_CURRENTLY_IN_OFFS_LIST";
	public static final String SESSION_DOC_CURRENTLY_IN_OFFS_PAGINATION = "SESSION_DOC_CURRENTLY_IN_OFFS_PAGINATION";
	
	public static String[] FORWARD_LIST = {"NO", "YES"};

	
	private String name;
	private String description;
	private DocumentTypeDTO document_type;
	private String requesting_person;
	private Double amount;
	private String barcode;
	private OfficeDTO office;
	private String forward;
	private String pic;
	private List<DTOBase> documentLogList;
	private List<DTOBase> documentStaffList;
	private String carrier;
	
	public DocCurrentlyInOffsDTO(){
		super();
		name = "";
		description ="";
		document_type = new DocumentTypeDTO();
		requesting_person = "";
		amount = (double) 0;
		barcode = "";
		office = new OfficeDTO();
		forward = "";
		pic = "";
		documentLogList = new ArrayList<DTOBase>();
		documentStaffList = new ArrayList<DTOBase>();
		carrier = "";
	}
	
	public DocCurrentlyInOffsDTO getDocCurrentInOffs() {
		DocCurrentlyInOffsDTO dcio = new DocCurrentlyInOffsDTO();
		dcio.setCode(super.getCode());
		dcio.setId(this.getId());
		dcio.setName(name);
		dcio.setDescription(description);
		dcio.setDocument_type(document_type);
		dcio.setRequesting_person(requesting_person);
		dcio.setAmount(amount);
		dcio.setBarcode(barcode);
		dcio.setOffice(office);
		dcio.setForward(forward);
		dcio.setPic(pic);
		dcio.setDocumentLogList(documentLogList);
		dcio.setDocumentStaffList(documentStaffList);
		dcio.setCarrier(carrier);
		return dcio;
	}
	
	public List<DTOBase> getDocumentLogListByStatus(String status) {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase documentLogObj: documentLogList) {
			DocumentTrackingLogDTO documentLog = (DocumentTrackingLogDTO) documentLogObj;
			//documentLog.setStaff(StaffUtil.getStaff(documentLog.getStaff()));
			if(documentLog.getStatus().equalsIgnoreCase(status)) {
				list.add(documentLog);
			}
		}
		return list;
	}
	
/*still working for this********* so dumb promise dunno how to get the list because cannot cast @ 2 diff dto's
 * public List<DTOBase> getNewDocumentLogList(String documentCode) {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase newDocumentLogListObj: documentLogList) {
			DocCurrentlyInOffsDTO documentLog = (DocCurrentlyInOffsDTO) newDocumentLogListObj;
			if(documentLog.getDocumentLogList() != null) {
				documentLog.getDocumentLogList();
				if(documentLog.getCode().equalsIgnoreCase(documentCode)) {
					documentLog.getDocumentLogList();
					list.add(documentLog);
				}
			}
		}
		return list;
	}*/

	public String[] getTableData() {
		//String updateButtons = "<a href='#' onclick=\"openLink('"+  getCode() +"','U276')\"><i class='fa fa-pencil-square-o' aria-hidden='true'></i>Edit</a>";
		String updateButton = "<a href='#' onclick=\"openLink('"+  getCode() +"','U276')\"><i class=''fa fa-fw fa-search'' aria-hidden='false'></i>VIEW</a>";
		//make last column an code for table data that needs to be updated or deleted
		return new String[] {getCode(), getName(), getDescription(), getCode(),};
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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public List<DTOBase> getDocumentLogList() {
		return documentLogList;
	}

	public void setDocumentLogList(List<DTOBase> documentLogList) {
		this.documentLogList = documentLogList;
	}

	public List<DTOBase> getDocumentStaffList() {
		return documentStaffList;
	}

	public void setDocumentStaffList(List<DTOBase> documentStaffList) {
		this.documentStaffList = documentStaffList;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
}
