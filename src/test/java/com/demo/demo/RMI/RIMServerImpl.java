package com.demo.demo.RMI;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Auther: TX
 * @Date: 2019/1/16 17:55
 * @Description:
 */
public class RIMServerImpl extends UnicastRemoteObject implements RMIServer {
    protected RIMServerImpl() throws RemoteException {
    }

    protected RIMServerImpl(int port) throws RemoteException {
        super(port);
    }

    protected RIMServerImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public Long getCurrentTime() throws RemoteException {
        return System.currentTimeMillis();
    }
}
