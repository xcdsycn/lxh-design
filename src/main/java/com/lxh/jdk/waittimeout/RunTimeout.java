package com.lxh.jdk.waittimeout;

import lombok.SneakyThrows;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/8/6 11:51
 **/
public class RunTimeout {
    private List synchedList;

    public RunTimeout() {
        synchedList = Collections.synchronizedList(new LinkedList<>());
    }

    public String removeElement() throws InterruptedException {
        synchronized (synchedList) {
            while(synchedList.isEmpty()) {
                System.out.println("List is isEmpty...");
                synchedList.wait(10000);
                System.out.println("waiting ...");
            }
            String element = (String) synchedList.remove(0);
            return element;
        }
    }

    public void addElement(String element) {
        System.out.println("Opening...");
        synchronized (synchedList) {
            synchedList.add(element);
            System.out.println("new element:" + element );
            synchedList.notifyAll();
            System.out.println("notifyAll called!");
        }
        System.out.println("Closing...");
    }

    @SneakyThrows
    public static void main(String[] args) {
        final RunTimeout runTimeout = new RunTimeout();

        Runnable runA = new Runnable() {
            @Override
            public void run() {
                try {
                    String item = runTimeout.removeElement();
                    System.out.println("" + item);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException ");
                    e.printStackTrace();
                } catch (Exception ex) {
                    System.out.println("Exception throws.");
                }
            }
        };

        Runnable runB = new Runnable() {
            @Override
            public void run() {
                runTimeout.addElement("hello!");
            }
        };

        Thread threadA1 = new Thread(runA,"Google");
        threadA1.start();

        Thread.sleep(500);

        Thread threadA2 = new Thread(runA,"RunTimeout");
        threadA2.start();

        Thread.sleep(500);

        Thread threadB = new Thread(runB,"Taobao");
        threadB.start();

        Thread.sleep(1000);

        threadA1.interrupt();
        threadA2.interrupt();
    }
}
