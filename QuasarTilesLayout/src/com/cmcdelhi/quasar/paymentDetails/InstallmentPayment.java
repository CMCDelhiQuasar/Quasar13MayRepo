package com.cmcdelhi.quasar.paymentDetails;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class InstallmentPayment extends Payment {

	@Enumerated(EnumType.STRING)
	private InstallmentType installmentType;

	public InstallmentType getInstallmentType() {
		return installmentType;
	}

	public void setInstallmentType(InstallmentType installmentType) {
		this.installmentType = installmentType;
	}

}
