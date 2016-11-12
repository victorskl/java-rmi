package warehouse.one;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

public class WarehouseClient {
    
    public static void main(String[] args) throws NamingException, RemoteException {
        Context namingContext = new InitialContext();
        
        System.out.print("RMI registry binding: ");
        Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
        while(e.hasMoreElements()) {
            System.out.println(e.nextElement().getName());
        }
        
        String url = "rmi://localhost/central_warehouse";
        Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);
        
        String description = "Blackwall Toaster";
        double price = centralWarehouse.getPrice(description);
        System.out.println(description + ": " + price);
    }
}
