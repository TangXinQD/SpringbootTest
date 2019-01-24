package com.demo.demo.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Auther: TX
 * @Date: 2019/1/16 17:53
 * @Description:
 */
public interface RMIServer extends Remote {

    public Long getCurrentTime() throws RemoteException;

}
