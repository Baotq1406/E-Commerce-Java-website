package com.BookShop.model;

public class PaymentDetails {
	
	private String paymentMethod;
	private String status;
	
	private String paymentId;
	private String ZalopayPaymentLinkId;
	private String ZalopayPaymentLinkReferenceId;
	private String ZalopayPaymentLinkStatus;
	private String ZalopayPaymentId;
	
	public PaymentDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getZalopayPaymentLinkId() {
		return ZalopayPaymentLinkId;
	}
	public void setZalopayPaymentLinkId(String zalopayPaymentLinkId) {
		ZalopayPaymentLinkId = zalopayPaymentLinkId;
	}
	public String getZalopayPaymentLinkReferenceId() {
		return ZalopayPaymentLinkReferenceId;
	}
	public void setZalopayPaymentLinkReferenceId(String zalopayPaymentLinkReferenceId) {
		ZalopayPaymentLinkReferenceId = zalopayPaymentLinkReferenceId;
	}
	public String getZalopayPaymentLinkStatus() {
		return ZalopayPaymentLinkStatus;
	}
	public void setZalopayPaymentLinkStatus(String zalopayPaymentLinkStatus) {
		ZalopayPaymentLinkStatus = zalopayPaymentLinkStatus;
	}
	public String getZalopayPaymentId() {
		return ZalopayPaymentId;
	}
	public void setZalopayPaymentId(String zalopayPaymentId) {
		ZalopayPaymentId = zalopayPaymentId;
	}
	
	
}
