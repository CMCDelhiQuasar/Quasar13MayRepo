package com.cmcdelhi.quasar.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.cmcdelhi.quasar.paymentDetails.InstallmentPayment;
import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.paymentDetails.RegistrationPayment;
import com.cmcdelhi.quasar.service.StudentService;
import com.cmcdelhi.quasar.student.Student;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.opensymphony.xwork2.ActionSupport;

public class ReceiptAction extends ActionSupport implements ServletRequestAware {
	private InputStream inputStream;

	HttpServletRequest request;
	String emailid;

	@Override
	public String execute() throws Exception {

		// /Base Font
		Font f = new Font(FontFamily.UNDEFINED, 11, Font.NORMAL, new BaseColor(
				169, 169, 169));

		// Fetch the Details of the Student
		StudentService ss = new StudentService();
		List<Student> studentList = ss.getStudent(null, 0, emailid, 0, null, 0,
				null, 0);

		Student s = studentList.get(0);

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		Document doc = new Document(PageSize.LETTER);

		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(doc, buffer);
			pdfWriter.setPdfVersion(PdfWriter.PDF_VERSION_1_7);

			doc.open();

			// ////////////////adding a faint line
			// //////////////////////////////////////
			// under title line seprator
			LineSeparator line1 = new LineSeparator(1, 100, new BaseColor(242,
					242, 242), LineSeparator.ALIGN_CENTER, -2);

			doc.add(line1);

			// /Recipt Number Addition
			// Receipt # INV-768479
			Date d = new Date();
			Paragraph receiptNumber = new Paragraph("Receipt  #  INV-"
					+ d.getYear() + "/" + d.getMonth() + "/" + d.getDate()
					+ "/" + d.getHours() + "/" + d.getMinutes() + "/"
					+ d.getSeconds());
			receiptNumber.setAlignment(Paragraph.ALIGN_RIGHT);
			doc.add(receiptNumber);

			// header table
			// ///////////////////////////////////////////////////////
			float[] columnWidths = { 1f, 5f };
			PdfPTable headerTable = new PdfPTable(2);
			headerTable.setWidths(columnWidths);

			// Adding the CMC logo
			String relativeWebPath = "/images/logo.png";
			String absoluteDiskPath = request.getServletContext().getRealPath(
					relativeWebPath);
			Image imghead = Image.getInstance(absoluteDiskPath);
			imghead.setAlignment(Image.RIGHT);

			PdfPCell cell1 = new PdfPCell(imghead);
			cell1.setBorder(Rectangle.NO_BORDER);

			Paragraph cmctitle = new Paragraph("  CMC Delhi", f);
			cmctitle.add(new Chunk(
					"\n  8,Vaishali Enclave,Main Metro Road,\n  Pitam Pura,(Opp. Metro Pillar No. 351), New Delhi-110034,India \n  Service Tax Registration No.: Consult/Engr/383/CMC LTD/97 dated 23/12/97 \n  STCNo : AAACC2030KST003 "));
			cmctitle.setAlignment(Paragraph.ALIGN_RIGHT);

			PdfPCell cell2 = new PdfPCell(cmctitle);
			cell2.setBorder(Rectangle.NO_BORDER);

			headerTable.setWidthPercentage(100.0f);
			headerTable.addCell(cell1);
			headerTable.addCell(cell2);
			doc.add(headerTable);

			doc.add(line1);

			// /Default Font for Label
			Font labelFont = new Font(FontFamily.UNDEFINED, 11, Font.NORMAL,
					new BaseColor(105, 105, 105));

			// //////////////////Student DEtails Paragrap
			Paragraph studentDetailTitle = new Paragraph("Student Detail \n",
					new Font(FontFamily.UNDEFINED, 15, Font.NORMAL,
							new BaseColor(105, 105, 105)));
			doc.add(studentDetailTitle);
			// adding line to the system
			doc.add(new Paragraph(" "));

			// StudentDetails
			// Table//////////////////////////////////////////////////////////
			float[] columnWidthsStuDetails = { 2.5f, 2.3f, 1f };
			PdfPTable stuDetTable = new PdfPTable(3);
			stuDetTable.setWidths(columnWidthsStuDetails);

			// Nested Table of Student Basic Details
			// Table Configuration
			float[] columnWidthsStuBasicDetails = { 1f, 3f };

			PdfPTable nestedTableStudentBasicDetails = new PdfPTable(2);
			nestedTableStudentBasicDetails.getDefaultCell().setBorder(0);// setting
																			// border
																			// to
																			// be
																			// zero
			nestedTableStudentBasicDetails
					.setHorizontalAlignment(Element.ALIGN_LEFT);
			nestedTableStudentBasicDetails.setWidthPercentage(90.00f);
			nestedTableStudentBasicDetails.addCell(new Paragraph("Name ",
					labelFont));
			nestedTableStudentBasicDetails.addCell(new Paragraph(s.getName()));
			nestedTableStudentBasicDetails.addCell(new Paragraph("ID ",
					labelFont));
			nestedTableStudentBasicDetails.addCell(new Paragraph(s
					.getStudentId() + ""));
			nestedTableStudentBasicDetails.addCell(new Paragraph("Course ",
					labelFont));
			nestedTableStudentBasicDetails.addCell(new Paragraph(s
					.getCourseName()));
			nestedTableStudentBasicDetails.addCell(new Paragraph("Email ",
					labelFont));
			nestedTableStudentBasicDetails
					.addCell(new Paragraph(s.getEmailId()));
			nestedTableStudentBasicDetails.addCell(new Paragraph("Contact ",
					labelFont));
			nestedTableStudentBasicDetails.addCell(new Paragraph(s
					.getContactNumber() + ""));

			nestedTableStudentBasicDetails
					.setWidths(columnWidthsStuBasicDetails);

			// coloumn for Studnet Basic Details
			PdfPCell cellstuDet1 = new PdfPCell();
			cellstuDet1.addElement(nestedTableStudentBasicDetails);
			cellstuDet1.setBorder(Rectangle.NO_BORDER);

			// Nested Table of Student Payment Details
			PdfPTable nestedTableStudentPaymentDetails = new PdfPTable(2);
			nestedTableStudentPaymentDetails.getDefaultCell().setBorder(0);// setting
																			// the
																			// payment
																			// config
																			// table
																			// border
																			// to
																			// be
																			// zero
			nestedTableStudentPaymentDetails
					.setHorizontalAlignment(Element.ALIGN_LEFT);
			nestedTableStudentPaymentDetails.addCell(new Paragraph(
					"Course Fee", labelFont));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getCourseFees() + ""));
			nestedTableStudentPaymentDetails.addCell(new Paragraph("Discount",
					labelFont));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getDiscountAvailable() + ""));

			nestedTableStudentPaymentDetails.addCell(new Paragraph("S.Tax",
					labelFont));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getServiceTax() + ""));
			nestedTableStudentPaymentDetails.addCell(new Paragraph("Fine(%)",
					labelFont));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getFine() + ""));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(
					"Total Fees Rs", labelFont));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getTotalFee() + ""));

			// coloumn for Payment Details
			PdfPCell cellstuDet2 = new PdfPCell();
			cellstuDet2.addElement(nestedTableStudentPaymentDetails);
			cellstuDet2.setBorder(Rectangle.NO_BORDER);

			// coloumn for Studnet QR Code
			BarcodeQRCode qrcode = new BarcodeQRCode(
					"Bismillah Hirrahma Nirrahim", 100, 100, null);
			Image qrImg = qrcode.getImage();

			PdfPCell cellstuDet3 = new PdfPCell(qrImg);
			cellstuDet3.setBorder(Rectangle.NO_BORDER);

			stuDetTable.setWidthPercentage(100.0f);
			stuDetTable.addCell(cellstuDet1);
			stuDetTable.addCell(cellstuDet2);
			stuDetTable.addCell(cellstuDet3);

			doc.add(stuDetTable);

			// ////////////////adding a faint line
			// //////////////////////////////////////
			// under title line seprator
			LineSeparator line2 = new LineSeparator(1, 100, new BaseColor(242,
					242, 242), LineSeparator.ALIGN_CENTER, -2);
			doc.add(line2);

			// //////////////////Payment Paragrap
			Paragraph paymentDetailTitle = new Paragraph("Payment Detail",
					new Font(FontFamily.UNDEFINED, 15, Font.NORMAL,
							new BaseColor(105, 105, 105)));
			doc.add(paymentDetailTitle);
			// adding line to the system
			doc.add(new Paragraph(" "));

			// under address line seprator
			// Table//////////////////////////////////////////////////////////
			// float[] columnWidthsStuDetails = { 1f, 1f,1f };
			PdfPTable payDetTable = new PdfPTable(5);
			// stuDetTable.setWidths(columnWidthsStuDetails);

			payDetTable.getDefaultCell().setBorder(0);// setting
			// border
			// to
			// be
			// zero

			// coloumn for Payment Type
			PdfPCell cellpayDet1 = new PdfPCell(new Paragraph("Type", new Font(
					FontFamily.UNDEFINED, 10, Font.NORMAL, new BaseColor(105,
							105, 105))));
			cellpayDet1.setBorderColor(new BaseColor(242, 242, 242));
			// coloumn for Payment Status
			PdfPCell cellpayDet2 = new PdfPCell(new Paragraph("Status",
					new Font(FontFamily.UNDEFINED, 10, Font.NORMAL,
							new BaseColor(105, 105, 105))));
			cellpayDet2.setBorderColor(new BaseColor(242, 242, 242));
			// coloumn for Payment ID
			PdfPCell cellpayDet3 = new PdfPCell(new Paragraph("Payment ID",
					new Font(FontFamily.UNDEFINED, 10, Font.NORMAL,
							new BaseColor(105, 105, 105))));
			cellpayDet3.setBorderColor(new BaseColor(242, 242, 242));
			// coloumn for Depostin Date
			PdfPCell cellpayDet4 = new PdfPCell(new Paragraph(
					"Deposition Date", new Font(FontFamily.UNDEFINED, 10,
							Font.NORMAL, new BaseColor(105, 105, 105))));
			cellpayDet4.setBorderColor(new BaseColor(242, 242, 242));
			// coloumn for Amount
			PdfPCell cellpayDet5 = new PdfPCell(new Paragraph("Amount",
					new Font(FontFamily.UNDEFINED, 10, Font.NORMAL,
							new BaseColor(105, 105, 105))));
			cellpayDet5.setBorderColor(new BaseColor(242, 242, 242));

			payDetTable.setWidthPercentage(100.0f);
			payDetTable.addCell(cellpayDet1);
			payDetTable.addCell(cellpayDet2);
			payDetTable.addCell(cellpayDet3);
			payDetTable.addCell(cellpayDet4);
			payDetTable.addCell(cellpayDet5);

			double totalAmount = 0;

			// ///////////////////populating table Data
			for (Payment p : s.getPaymentsList()) {

				if (p instanceof RegistrationPayment) {
					payDetTable.addCell("Redg. Payment");
				} else if (p instanceof InstallmentPayment) {
					InstallmentPayment inp = (InstallmentPayment) p;
					payDetTable.addCell(inp.getInstallmentType()
							+ " Inst. Payment ");
				}

				payDetTable.addCell(p.getPaymentStatus() + "");
				payDetTable.addCell(p.getPaymentID() + "");

				if (p.getPaymentDetails().getPaymentDate() == null) {
					payDetTable.addCell("---");
				} else {
					payDetTable.addCell(""
							+ p.getPaymentDetails().getPaymentDate());
				}

				totalAmount = totalAmount
						+ p.getPaymentDetails().getDepositedAmount();

				payDetTable.addCell(p.getPaymentDetails().getDepositedAmount()
						+ "");

			}

			doc.add(payDetTable);

			// /////////////////////////////////////////////////////////
			// grand total bar
			LineSeparator line6 = new LineSeparator(1, 100, new BaseColor(105,
					105, 105), LineSeparator.ALIGN_CENTER, -2);

			// /craeeting grand total
			Paragraph grandTotal = new Paragraph(" Grand Total  Rs. "
					+ totalAmount, new Font(FontFamily.UNDEFINED, 15,
					Font.NORMAL, new BaseColor(105, 105, 105)));
			grandTotal.setAlignment(Paragraph.ALIGN_RIGHT);

			// /craeeting grand total line
			Paragraph grandTotalLine = new Paragraph("Till " + new Date()
					+ " Total Amount Deposited  : Rs." + totalAmount);
			grandTotal.setAlignment(Paragraph.ALIGN_LEFT);

			// adding line to the system
			doc.add(new Paragraph(" "));
			doc.add(line6);
			doc.add(grandTotal);
			doc.add(grandTotalLine);

			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));

			// cell1.setBorder(Rectangle.NO_BORDER);

			// table.addCell(cell1);
			// table.addCell(cell2);
			// table.addCell(cell3);
			//
			// table.setWidthPercentage(100.0f);
			//
			// doc.add(table);

			// LineSeparator line2 = new LineSeparator(1, 100, new
			// BaseColor(218,
			// 218, 218), LineSeparator.ALIGN_CENTER, -2);

			// terms and conditions bar
			LineSeparator line7 = new LineSeparator(1, 100, new BaseColor(242,
					242, 242), LineSeparator.ALIGN_CENTER, -2);

			// footer terms and conditions

			Paragraph termscondition = new Paragraph(
					"Information collected through this site is kept confidential and is not passed to third party organizations for marketing or promotional purposes.Information collected through this site is kept Information collected through this site is kept confidential and is not passed to third party organizations for marketing or promotional purposes.Information collected through this site is kept confidential and is not passed to third party organizations for marketing or promotional purposes.Information collected through this site is kept confidential and is not passed to third party organizations for marketing or promotional purposes.Information collected through this site is kept confidential and is not passed to third party organizations for marketing or promotional purposes.",
					new Font(FontFamily.UNDEFINED, 8, Font.NORMAL,
							new BaseColor(169, 169, 169)));

			doc.add(termscondition);

			Paragraph cmcurl = new Paragraph("cmcdelhi.com");
			cmcurl.setAlignment(Paragraph.ALIGN_RIGHT);

			doc.add(cmcurl);
			doc.add(line7);

			doc.close();

			inputStream = new ByteArrayInputStream(buffer.toByteArray());

		} catch (DocumentException e) {

			e.printStackTrace();
		}

		return SUCCESS;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

}
