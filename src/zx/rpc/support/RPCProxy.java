package zx.rpc.support;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import zx.rpc.protocal.Invocation;


public class RPCProxy {
	public static <T> T getProxy(final Class<T> clazz,String host,int port) {
		
		final Client client = new Client(host,port);
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Invocation invo = new Invocation();
				invo.setInterfaces(clazz);
				invo.setMethod(new zx.rpc.protocal.Method(method.getName(),method.getParameterTypes()));
				invo.setParams(args);
				client.invoke(invo);
				return invo.getResult();
			}
		};
		T t = (T) Proxy.newProxyInstance(RPCProxy.class.getClassLoader(), new Class[] {clazz}, handler);
		return t;
	}
}
	



	
	
	

