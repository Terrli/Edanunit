package com.example.lilinghua.edanunit;

import android.provider.DocumentsContract;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.binary.Token;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Objects;

/**
 * Created by lilinghua on 2018/7/25.
 */

public class XML {
    private  final static String XML_DECLARTION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n";
    public static String toXML(Object obj)
    {
        XStream stream = new XStream();
        //stream.processAnnotations(obj.getClass());
        return  new StringBuffer(XML_DECLARTION).append(stream.toXML(obj)).toString();
    }


    public static String getNodeValue(String xpath,String dataStr){
        try{
            Document document = DocumentHelper.parseText(dataStr);
            Element element = (Element)document.selectSingleNode(xpath);
            if(element !=null){
                return  element.getStringValue();
            }
        }catch (DocumentException e)
        {
            e.printStackTrace();
            return "error";
        }
        return "";
    }

    public static String getNodeAttribute(String xpath,String dataStr){
        try{
            Document document = DocumentHelper.parseText(dataStr);
            Attribute attribute  = (Attribute)document.selectObject(xpath);
            return attribute.getValue();
        }catch (DocumentException e){
            e.printStackTrace();
        }
        return "";
    }

}
