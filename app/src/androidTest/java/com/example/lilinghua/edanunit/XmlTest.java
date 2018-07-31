package com.example.lilinghua.edanunit;

import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.util.Xml;

import com.thoughtworks.xstream.XStream;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;
/**
 * Created by lilinghua on 2018/7/24.
 */



public class XmlTest {
    private XML xml;
    private Person person;
    private static final String TAG = "XMLTest";
    String str = "";

    public static String getRandomTest(){
        //想要保留的数据量
        String[] edan = {"zz","aa","Edan01","Edan02","DSA","SDF"};
        Set<String> set = new HashSet<String>();
        Random random = new Random();
        int i = 0;
        while (true) {
            i = random.nextInt(edan.length);
            set.add(edan[i]);
            if(set.size()>= (edan.length)){
                break;
            }
        }
        for (String ran: set) {
            Log.v(TAG,ran);
        }
        Iterator<String> it = set.iterator();
        return it.next();
    }

    @Before
    public void setUp() throws Exception {
        xml = new XML();
        person = new Person();
    }

    @Test
    public void toXMLTest() {
        Log.v(TAG, "Start");
        long time1 = System.currentTimeMillis();
        person.setAge(25);
        person.setName("Edan");
        str = xml.toXML(person);
        long time2 = System.currentTimeMillis();
        long time3 = time2 - time1;
        String time = Long.toString(time3);
        Log.v(TAG,str);
    }

    @Test    //获取结
    public void getNodeValueTest() {
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
                "<person>" + "<name>Edan</name>" +
                "<sex></sex>" + "<age>25</age>" + "</person>";
        String value = xml.getNodeValue("kk", str);
        Log.v(TAG,value);
        assertEquals("xx", value);
    }

    @Test   //获取结点属性值
    public void getNodeAttributeTest() {
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
                "<person>" + "<name>Edan</name>" +
                "<sex>man</sex>" + "<age>100</age>"  + "</person>";
        String value1 = xml.getNodeAttribute("/person/age", str);
        assertEquals("Edan", value1);
    }

    @Test
    public void getRandom_Test(){
        String getrandom = getRandomTest();
//        Log.v(TAG,getrandom);
    }


    @Test
    public void filetest(){
        File file = new File(Environment.getExternalStorageDirectory()+"/data/test.xml");
        try {
            InputStream in = new FileInputStream(file);
            byte b[] = new byte[1024];
            in.read(b) ;
            in.close();
            String str = new String(b);
            Log.v(TAG,str);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
//        assertEquals(Environment.getDataDirectory()+File.separator+"test.xml","aas");  //  /data

    }
}

