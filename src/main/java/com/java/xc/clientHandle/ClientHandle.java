package com.java.xc.clientHandle;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

public class ClientHandle implements InvocationHandler{
	private String ip;
	private int port;

	public ClientHandle(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Socket client =new Socket(ip,port);
		
		ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
		
		oos.writeUTF(method.getName());
		oos.flush();
		
		oos.writeObject(method.getParameterTypes());
		oos.flush();
		
		oos.writeObject(args);
		oos.flush();
		
		ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
		
		
		return ois.readObject();
		
	}
	
	
}
