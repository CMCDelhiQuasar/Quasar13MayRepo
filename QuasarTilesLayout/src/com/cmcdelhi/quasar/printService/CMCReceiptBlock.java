package com.cmcdelhi.quasar.printService;

import java.awt.Image;
import java.util.HashMap;

public class CMCReceiptBlock {
	private HashMap<String, String> toBePrintedDataMap = new HashMap<String, String>();
	private HashMap<String, Image> toBePrintedImageMap = new HashMap<String, Image>();

	/**
	 * @return the toBePrintedDataMap
	 */
	public HashMap<String, String> getToBePrintedDataMap() {
		return toBePrintedDataMap;
	}

	/**
	 * @param toBePrintedDataMap
	 *            the toBePrintedDataMap to set
	 */
	public void setToBePrintedDataMap(HashMap<String, String> toBePrintedDataMap) {
		this.toBePrintedDataMap = toBePrintedDataMap;
	}

	/**
	 * @return the toBePrintedImageMap
	 */
	public HashMap<String, Image> getToBePrintedImageMap() {
		return toBePrintedImageMap;
	}

	/**
	 * @param toBePrintedImageMap
	 *            the toBePrintedImageMap to set
	 */
	public void setToBePrintedImageMap(
			HashMap<String, Image> toBePrintedImageMap) {
		this.toBePrintedImageMap = toBePrintedImageMap;
	}

}
