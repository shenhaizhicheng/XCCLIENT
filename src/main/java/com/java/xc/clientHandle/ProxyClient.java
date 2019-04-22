package com.java.xc.clientHandle;

import java.lang.reflect.Proxy;

public class ProxyClient {
	@SuppressWarnings("unchecked")
	public static <T> T getClient(Class<T> clazz, String ip, int port) {
		return (T) Proxy.newProxyInstance(ProxyClient.class.getClassLoader(),
				new Class[] { clazz }, new ClientHandle(ip, port));
	}
}
