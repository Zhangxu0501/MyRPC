package test;

import zx.rpc.support.RPCServer;
import zx.rpc.support.Server;


public class StartServer {
	public static void main(String[] args) {
		Server server = new RPCServer();
		server.register(Sort.class, ArraySort.class);
		server.start();
	}

}
