package com.dihaitech.wxshop.util;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.dihaitech.wxshop.common.Property;
import com.dihaitech.tserver.managercenter.ManagerCenterService;

/**
 * Thrift工具类
 * @author qiusen
 *
 */
public class TServerUtil {

	private static ManagerCenterService.Client client = null;
	
	private static TTransport transport = null;
	
	/**
	 * 获取连接
	 * @return
	 */
	public static ManagerCenterService.Client getClient(){
		try {
			//client为空，或transport 已关闭
			if(client == null || !transport.isOpen()){	
				transport = new TFramedTransport(new TSocket(Property.MANAGERCENTER_HOST, Property.MANAGERCENTER_PORT));
				   
				   TBinaryProtocol protocol = new TBinaryProtocol(transport);
				   //TCompactProtocol protocol = new TCompactProtocol(transport);
				   
				   client = new ManagerCenterService.Client(protocol);
				   transport.open();
				   
			}
		} catch (TException x) {
			   x.printStackTrace();
		}
		
		return client;
		
	}
	
	/**
	 * 关闭连接
	 */
	public static void closeClient(){
		try {
			if(client == null || !transport.isOpen()){	
				transport.close();
			}
			
		} catch (Exception x) {
			   x.printStackTrace();
		}
	}
}
