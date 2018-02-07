package com.ezshop.action.documenttracking;

public class AddDocumentTrackingSubmitAction extends DocumentTrackingAction {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		setSessionLinkOnSubmit();
	}
}
