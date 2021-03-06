/**
 * Copyright (c) 1998-2012 TENCENT Inc. All Rights Reserved.
 * 
 * FileName: Network.java
 * 
 * Description: 网络检测器包装类文件
 * 
 * History:
 * 1.0	devilxie	2012-09-07	Create
 */
package com.app.framework.network.http;

import java.net.InetSocketAddress;

import com.app.framework.network.NetworkHelper;

/**
 *  网络检测器封装类，采用代理与单立模式设计，为上层提供便捷的网络检测扩展功能
 * @author devilxie
 * @version 1.0
 */
public final class Network implements NetworkSensor
{

	private NetworkSensor networkSensor = null;
	
	private static class Holder {
		private static Network instance = new Network();
	}	
	
	public static synchronized Network getInstance()
	{
		return Holder.instance;
	}
	
	private Network()
	{		
	}
	
	public boolean isWifiActive() {
		if (networkSensor == null) {
			return NetworkHelper.sharedHelper().isWifiActive();
		}
		
		String ap = networkSensor.getAccessPoint();
		return "WIFI".equalsIgnoreCase(ap);
	}
	
	public void registerNetworkSensor(NetworkSensor sensor) {
		networkSensor = sensor;
	}
	
	@Override
	public boolean hasAvailableNetwork()
	{
		if (networkSensor == null) {
			return NetworkHelper.sharedHelper().isNetworkAvailable();
		}
		
		return networkSensor.hasAvailableNetwork();
	}

	@Override
	public String getAccessPoint()
	{
		return networkSensor == null ? INVALID_ACCESS_POINT : networkSensor.getAccessPoint();
	}

	@Override
	public InetSocketAddress getProxy()
	{
		return networkSensor == null ? null : networkSensor.getProxy();
	}

	@Override
	public String getNetworkType()
	{
		return networkSensor == null ? null :networkSensor.getNetworkType();
	}
}
