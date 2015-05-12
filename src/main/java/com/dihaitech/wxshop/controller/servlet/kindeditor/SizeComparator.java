package com.dihaitech.wxshop.controller.servlet.kindeditor;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Hashtable;

@SuppressWarnings("rawtypes")
public class SizeComparator implements Comparator, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4857454257719830883L;

	@Override
	public int compare(Object a, Object b) {
		Hashtable hashA = (Hashtable) a;
		Hashtable hashB = (Hashtable) b;
		if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
			return -1;
		} else if (!((Boolean) hashA.get("is_dir"))
				&& ((Boolean) hashB.get("is_dir"))) {
			return 1;
		} else {
			if (((Long) hashA.get("filesize")) > ((Long) hashB.get("filesize"))) {
				return 1;
			} else if (((Long) hashA.get("filesize")) < ((Long) hashB
					.get("filesize"))) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
