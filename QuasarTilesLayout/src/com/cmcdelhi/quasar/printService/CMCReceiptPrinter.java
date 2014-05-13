package com.cmcdelhi.quasar.printService;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Date;
import java.util.List;

import com.cmcdelhi.quasar.paymentDetails.FullFeePayment;
import com.cmcdelhi.quasar.paymentDetails.InstallmentPayment;
import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.paymentDetails.RegistrationPayment;

public class CMCReceiptPrinter implements Printable {

	private CMCReceiptBlock cmcRecieptBlock;
	private List<Payment> paymentList;

	public CMCReceiptPrinter(CMCReceiptBlock cmcRecieptBlock,
			List<Payment> paymentList) {
		super();
		this.cmcRecieptBlock = cmcRecieptBlock;
		this.paymentList = paymentList;
	}

	@Override
	public int print(Graphics gx, PageFormat pf, int page)
			throws PrinterException {
		if (page > 0) {
			return NO_SUCH_PAGE;
		} // Only one page

		Graphics2D g = (Graphics2D) gx; // Cast to Graphics2D object

		// g.rotate(90);

		g.translate(pf.getImageableX(), pf.getImageableY()); // Match origins to
																// imageable
																// area

		g.drawImage((Image) cmcRecieptBlock.getToBePrintedImageMap()
				.get("logo"), 20, 20, 50, 37, null);

		Font f = new Font("Calibri", Font.PLAIN, 14);
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString(cmcRecieptBlock.getToBePrintedDataMap().get("cmcTitle"),
				80, 35);

		f = new Font("Calibri", Font.PLAIN, 10);
		g.setFont(f);
		g.setColor(Color.gray);
		g.drawString(cmcRecieptBlock.getToBePrintedDataMap().get("cmcAddress"),
				80, 50);

		// f = new Font("Calibri", Font.PLAIN, 10);
		// g.setFont(f);
		g.setColor(Color.lightGray);
		g.drawString(new Date().toString() + "  cmcdelhi.com ", 400, 35);

		// first section start line
		g.setColor(Color.lightGray);
		g.drawLine(20, 60, 600, 60);

		// f = new Font("Calibri", Font.PLAIN, 10);
		// g.setFont(f);
		g.setColor(Color.gray);
		g.drawString(
				cmcRecieptBlock.getToBePrintedDataMap().get(
						"serviceTaxRedgNumber"), 20, 73);

		g.drawString(cmcRecieptBlock.getToBePrintedDataMap().get("STCNo"), 20,
				87);

		// f = new Font("Calibri", Font.PLAIN, 10);
		// g.setFont(f);
		g.setColor(Color.black);
		g.drawString(
				cmcRecieptBlock.getToBePrintedDataMap().get("recieptNumber"),
				500, 73);

		// first section end line
		g.setColor(Color.lightGray);
		g.drawLine(20, 92, 600, 92);

		f = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString("Student Name : "
				+ cmcRecieptBlock.getToBePrintedDataMap().get("studentName"),
				20, 110);
		// f = new Font("Calibri", Font.PLAIN, 10);
		// g.setFont(f);
		g.setColor(Color.black);
		g.drawString("Course Name : "
				+ cmcRecieptBlock.getToBePrintedDataMap().get("courseName"),
				20, 125);

		g.setColor(Color.black);
		g.drawString("Contact Number : "
				+ cmcRecieptBlock.getToBePrintedDataMap().get("contactNumber"),
				20, 140);

		// f = new Font("Calibri", Font.PLAIN, 10);
		// g.setFont(f);
		g.setColor(Color.black);
		g.drawString("Email ID : "
				+ cmcRecieptBlock.getToBePrintedDataMap().get("emailId"), 20,
				155);

		// second section start line for fee details
		g.setColor(Color.lightGray);
		g.drawLine(20, 167, 600, 167);

		g.setColor(Color.lightGray);
		g.drawString("Fee Details ", 20, 180);

		// second section end line for fee details
		g.setColor(Color.lightGray);
		g.drawLine(20, 187, 600, 187);

		g.setColor(Color.gray);
		g.drawString(
				"Course Fee                                                                                                                                                                 Rs." + 12000,
				20, 200);
		g.drawString(
				"Discount"
						+ "(5%) "
						+ "                                                                                                                                                             Rs."
						+ 421, 20, 220);
		g.drawString(
				"Service Tax"
						+ "(12.34%) "
						+ "                                                                                                                                                           Rs."
						+ 1200, 20, 240);
		g.drawString(
				"Fine                                                                                                                                                                              Rs." + 0,
				20, 260);

		// second section start line for fee details
		g.setColor(Color.lightGray);
		g.drawLine(20, 270, 600, 270);

		f = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString(
				"Grand Total                                                                                                                  Rs." + 13431,
				20, 288);

		// second section end line for fee details
		g.setColor(Color.lightGray);
		g.drawLine(20, 295, 600, 295);

		g.drawString(
				"Loc " + pf.getImageableWidth() + "  "
						+ pf.getImageableHeight(), 20, 305);

		drawTableHeaderForPaymentDetails(g, (int) pf.getImageableWidth(),
				(int) pf.getImageableHeight());

		drawPopulatedTableForPaymentDetails(g, (int) pf.getImageableWidth(),
				(int) pf.getImageableHeight(), paymentList);

		// g.drawImage(null, page, page, page, page, null);

		return PAGE_EXISTS; // Page exists (offsets start at zero!)

	}

	private void drawTableHeaderForPaymentDetails(Graphics2D g, int pageHeight,
			int pageWidth) {

		// second section start line for fee details
		g.setColor(Color.lightGray);
		g.drawLine(20, 320, 600, 320);

		int tableWidth = pageWidth - 40;
		Font f = new Font("Calibri", Font.PLAIN, 10);
		g.setFont(f);
		g.setColor(Color.black);
		String title = "";

		// printing the table header
		for (int i = 0; i <= 6; i++) {
			switch (i) {
			case 0:
				title = "Payment Type";
				break;
			case 1:
				title = "Payment Mode";
				break;
			case 2:
				title = "Payment ID";
				break;
			case 3:
				title = "Deposited Date";
				break;
			case 4:
				title = "Amount Deposited";
				break;

			}
			g.drawString(title, 20 + (i * (tableWidth / 6)), 340);
		}

		// second section end line for fee details
		g.setColor(Color.lightGray);
		g.drawLine(20, 350, 600, 350);

	}

	private void drawPopulatedTableForPaymentDetails(Graphics2D g,
			int pageHeight, int pageWidth, List<Payment> paymentList) {

		int tableWidth = pageWidth - 40;
		Font f = new Font(Font.MONOSPACED, Font.PLAIN, 10);
		g.setFont(f);
		g.setColor(Color.gray);
		String title = "";
		int y = 0;

		for (Payment payment : paymentList) {

			// printing the table data
			for (int i = 0; i <= 6; i++) {
				switch (i) {
				case 0:
					if (payment instanceof FullFeePayment) {
						title = "Full Payment";
					} else if (payment instanceof InstallmentPayment) {
						title = ((InstallmentPayment) payment)
								.getInstallmentType() + " Installment";
					} else if (payment instanceof RegistrationPayment) {
						title = " Registration Payment ";
					}
					break;
				// case 1:
				// // title = payment.getPaymentMode().getClass().getName();
				// break;
				case 2:
					title = payment.getPaymentID() + "";
					break;
				case 3:

					Date paymentDate = payment.getPaymentDetails()
							.getPaymentDate();
					if (paymentDate != null) {
						title = paymentDate.toString() + "";
					} else {
						title = "--";
					}

					break;
				case 4:
					title = payment.getPaymentDetails().getDepositedAmount()
							+ "";
					break;
				default:
					title = "--";
				}
				g.drawString(title, 20 + (i * (tableWidth / 6)), 370 + y);
			}

			y = y + 20;

		}

	}
}
