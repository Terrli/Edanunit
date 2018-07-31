package com.example.lilinghua.edanunit;

import android.util.Log;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.dom4j.io.STAXEventReader;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.assertEquals;

/**
 * Created by lilinghua on 2018/7/25.
 */
//public class TXmlTest {
//    private XML xml;
//    //private Person person;
//    private static final String TAG = "XMLTest";
//    String str = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
//            "<person>" + "<name>Edan</name>" +
//            "<sex>man</sex>" + "<age>25</age>" + "</person>";
//    @Before
//    public void setUp() throws Exception {
//        //person = new Person();
//    }
//    @Test
//    public void testThreadJunit() throws Throwable {
//
//        TestRunnable[] trs = new TestRunnable[10];//产生线程
//        for(int i=0;i<4;i++){
//            trs[i]=new ThreadA();
//             }
//        // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
//        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
//        // 开发并发执行数组里定义的内容
//        mttr.runTestRunnables();
//    }
//    private class ThreadA extends TestRunnable {
//        @Override
//        // 测试内容
//        public void runTest() throws Throwable {
//            xml = new XML();
//            String value = xml.getNodeValue("/person/name", str);
//            assertEquals("Edan00", value);
//        }
//    }
//}
//
public class TXmlTest {
    private static final String TAG = "XMLTest";
    private XML xml;
    private Person person;
    private Lock _mutexlock = new ReentrantLock();
    String str = "";
    @Before
    public void setUp() throws Exception {
        xml = new XML();
        person = new Person();
    }


    @Test
    public void  TtoXMLTest() {
        long time1 = System.currentTimeMillis();
        // 构造一个Runner
        TestRunnable runner = new TestRunnable() {
            @Override
            public void runTest() throws Throwable {  //测试插入buffer代码
//                  _mutexlock.lock();
//                  str = str+"d";
//                 _mutexlock.unlock();
//                Log.v(TAG,str);
                long time1 = System.currentTimeMillis();
                _mutexlock.lock();
                person.setAge(22);
                person.setName("Edan");
                str += xml.toXML(person);
                _mutexlock.unlock();
                long time2 = System.currentTimeMillis();
                Log.v(TAG,(Long.toString(time2-time1))+"ms");
                Log.v(TAG,str);
            }
        };
        int rowcount = 3;
        TestRunnable[] trs = new TestRunnable[rowcount];
        for (int i = 0; i < rowcount; i++) {
            trs[i] = runner;
        }
        // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
        try {
            mttr.runTestRunnables();// 并发执行数组里定义的内容

        } catch (Throwable e) {
            assertEquals("Eception", "error");
            e.printStackTrace();
        }
    }

    @Test
    public void TgetNodeValueTest() {
        long time1 = System.currentTimeMillis();
        // 构造一个Runner
        TestRunnable runner = new TestRunnable() {
            @Override
            public void runTest() throws Throwable {  //测试插入buffer代码
                String dataStr = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
                        "<person>" + "<name>Edan</name>" +
                        "<sex>man</sex>" + "<age>25</age>" + "</person>";
                long time1 = System.currentTimeMillis();
                _mutexlock.lock();
                String value = xml.getNodeValue("/person/name", dataStr);
                _mutexlock.unlock();
                long time2 = System.currentTimeMillis();
                Log.v(TAG,(Long.toString(time2-time1))+"ms");
                Log.v(TAG,value);
                assertEquals("Edan",value);
            }
        };
        int rowcount = 3;
        TestRunnable[] trs = new TestRunnable[rowcount];
        for (int i = 0; i < rowcount; i++) {
            trs[i] = runner;
        }
        // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
        try {
            mttr.runTestRunnables();// 并发执行数组里定义的内容

        } catch (Throwable e) {
            assertEquals("Eception", "error");
            e.printStackTrace();
        }
    }

}