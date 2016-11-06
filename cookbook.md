## RMI (vía directa)

Definir la interface `X` mediante la cual el cliente ejecutará métodos en el servidor y obtendrá los resultados.

~~~java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface X extends Remote {
  void foo() throws RemoteException;
  void bar() throws RemoteException;
}
~~~

Implementar la interfaz `X` en la clse `CX`.

~~~java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CX extends UnicastRemoteObject implements X {

    public CX() throws RemoteException {
        super();
    }
    
    @Override
    public void foo() throws RemoteException {
        // TODO: Código
    }

    @Override
    public void bar() throws RemoteException {
        // TODO: Código
    }
    
}
~~~

Crear el servidor

~~~java
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

//...

public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException  {
  LocateRegistry.createRegistry(1099); // port = 1099
  
  CX x = new CX();
  
  Naming.bind("nombre", x);
}
~~~

Crear al cliente

~~~java
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

//...

public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException  {
  Registry registry = LocateRegistry.getRegistry("192.168.0.1", 1099); // host = 192.168.0.1, port = 1099

  X x = (X)registry.lookup("nombre");
  
  x.foo();
  x.bar();
}
~~~
