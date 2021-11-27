package com.lxh.jdk.waittimeout;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 殷圣鸽
 * 
 *  ssm 的依赖模块
 *  
 * 2018/3/16.
 */
public class SSMDependency implements Serializable {

    protected String name;
    protected String url;
    protected String method = "GET";
    protected String question;
    protected Object lock;
    protected boolean done = false;
    protected boolean formData = true;
    protected Object result;
    protected int order  = 0;
    protected Object parameters;
    protected boolean enabled = true;
    protected int timeout = 500;
    protected int candidate = 1;

    protected Map<String,Object> config;

    public Object getResult() {
		return result;
	}

    public boolean isDone() {
        return done;
    }

    public int getTimeout() {
        return timeout;
    }

    public boolean isEnabled() {
        return enabled;
    }

    protected void notifyDone() {
        if (lock != null) {
            synchronized (lock) {
                done = true;
                if (((MapTimeout.DependencyList) lock).isDone()) {
                    lock.notify();
                }
            }
        }
    }

    SafeThread t = new SafeThread(new SafeThread.SafeRunnable() {
        @Override
        public void safeRun() throws Throwable {
            Thread.currentThread().setName(name);
            call();
            notifyDone();
        }
    });

    public SSMDependency() {
    }



    public void  start() throws IllegalAccessException {

        t.start();
    }


    public void call() throws Throwable {

        Thread.sleep(100000);

    }






    public int getOrder() {
		// TODO Auto-generated method stub
		return order;
	}

    public void setConfig(Map<String,Object> config) {
        this.config = config;
    }
}
