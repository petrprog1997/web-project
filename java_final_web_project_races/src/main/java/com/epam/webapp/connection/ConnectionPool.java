package com.epam.webapp.connection;

import com.epam.webapp.exception.ServiceException;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private Queue<ProxyConnection> availableConnections;
    private Queue<ProxyConnection> connectionsInUse;
    private static Lock instanceLock = new ReentrantLock();
    private static Lock returnConnectionLock = new ReentrantLock();
    private static Lock getConnectionLock = new ReentrantLock();
    private static ConnectionPool instance;
    private static final int INITIAL_POOL_SIZE = 12;
    private final Semaphore semaphore = new Semaphore(INITIAL_POOL_SIZE, true);
    private final static long TIMEOUT = 1;

    private ConnectionPool() throws IOException, ServiceException {
        availableConnections = new ArrayDeque<>();
        connectionsInUse = new ArrayDeque<>();
        createPool();
    }

    public void createPool() throws IOException, ServiceException {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            availableConnections.offer(getConnection());
        }
    }

    public static ConnectionPool getInstance() throws IOException, ServiceException {
        if (instance == null) {
            instanceLock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            } finally {
                instanceLock.unlock();
            }
        }
        return instance;
    }

    public void returnConnection(ProxyConnection proxyConnection) {
        returnConnectionLock.lock();
        try {
            if(connectionsInUse.contains(proxyConnection)){
                availableConnections.offer(proxyConnection);
            }
        } finally {
            returnConnectionLock.unlock();
        }
    }

    public ProxyConnection getConnectionFromPool() {
        getConnectionLock.lock();
        ProxyConnection proxyConnection = null;
        try {
            semaphore.tryAcquire(TIMEOUT, TimeUnit.HOURS);
            proxyConnection = availableConnections.poll();
            connectionsInUse.offer(proxyConnection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getConnectionLock.unlock();
        }
        return proxyConnection;
    }



    public ProxyConnection getConnection() throws IOException, ServiceException {return ConnectionFactory.create(this);}

}
