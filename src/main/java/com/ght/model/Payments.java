package com.ght.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PaymentDetails")
public class Payments {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String invoices;
	    private String dates;
	    private String status;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getInvoices() {
			return invoices;
		}
		public void setInvoices(String invoices) {
			this.invoices = invoices;
		}
		public String getDates() {
			return dates;
		}
		public void setDates(String dates) {
			this.dates = dates;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	    
	    
	
}
