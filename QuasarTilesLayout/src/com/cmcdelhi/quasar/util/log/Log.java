package com.cmcdelhi.quasar.util.log;

import java.util.Date;

public class Log {

	public static void d(String msg) {
		System.out.println(" QUASAR (DEBUG) ::: " + new Date() + "Nano Time ("
				+ (System.nanoTime()) + ") :::: " + msg);
	}

	public static void e(String msg) {
		System.out.println(" QUASAR (ERROR) ::: " + new Date() + "Nano Time ("
				+ (System.nanoTime()) + ") :::: " + msg);

	}

	public static void w(String msg) {
		System.out.println(" QUASAR (WARNING) ::: " + new Date()
				+ "Nano Time (" + (System.nanoTime()) + ") :::: " + msg);

	}

	public static void i(String msg) {
		System.out.println(" QUASAR (INFO) ::: " + new Date() + "Nano Time ("
				+ (System.nanoTime()) + ") :::: " + msg);
	}
}
