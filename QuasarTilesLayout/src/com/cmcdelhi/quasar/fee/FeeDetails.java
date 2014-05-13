package com.cmcdelhi.quasar.fee;

import javax.persistence.Embeddable;

@Embeddable
public class FeeDetails {
	private double courseFees;
	private double discountAvailable;
	private double serviceTax;
	private double fine;
	private int totalFee;

	public double getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(double courseFees) throws Exception {

		if (courseFees > 0) {
			this.courseFees = courseFees;
			setTotalFee();
		} else {
			throw new Exception("The course fee cannot be less than ZERO");
		}
	}

	public double getDiscountAvailable() {
		return discountAvailable;
	}

	public void setDiscountAvailable(double discountAvailable) throws Exception {

		if (discountAvailable >= 0) {
			this.discountAvailable = discountAvailable;
			setTotalFee();
		} else {
			throw new Exception(
					"The entered Discount cannot be less than zero ");
		}

	}

	public double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(double serviceTax) throws Exception {

		if ((serviceTax >= 0) && (serviceTax <= 100)) {
			this.serviceTax = serviceTax;
			setTotalFee();
		} else {
			throw new Exception(
					"The service tax is Invalid.Please put it in % ");
		}

	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) throws Exception {

		if ((fine >= 0)) {
			if (fine < courseFees) {
				this.fine = fine;
				setTotalFee();
			} else {
				throw new Exception(
						"The fine cannot be greater the course fees ");
			}
		} else {
			throw new Exception("The entered fine cannt be less than zero ");
		}
	}

	public double getTotalFee() {
		return totalFee;
	}

	private void setTotalFee() {

		this.totalFee = (int) (courseFees - discountAvailable
				+ ((serviceTax * courseFees) / 100) + fine);
	}

}
