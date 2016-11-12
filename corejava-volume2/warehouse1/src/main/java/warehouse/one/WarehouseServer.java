package warehouse.one;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class WarehouseServer {
	
	public static void main(String[] args) throws RemoteException, NamingException {
	    
	    System.setSecurityManager(new SecurityManager());
	    //System.setProperty("java.security.policy","file:./server.policy");
	    
		System.out.println("Constructing server implementation...");
		WarehouseImpl centralWarehouse = new WarehouseImpl();
		
		System.out.println("Binding server implementation to registry...");
		Context namingContext = new InitialContext();
		namingContext.bind("rmi:central_warehouse", centralWarehouse); // default rmi://localhost:1099
		//namingContext.bind("rmi://localhost:80/central_warehouse", centralWarehouse);
		
		System.out.println("Waiting for invocations from clients...");
	}
}