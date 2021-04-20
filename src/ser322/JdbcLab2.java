package src.ser322;
import javax.xml.xpath.*;

import java.io.File;

import javax.xml.parsers.*;
import org.w3c.dom.Document;

public class JdbcLab2 {

     public static void main(String[] args) throws Exception {
        
        String File = args[0];
        String DeptNo = args[1];

        Document document = getDocument(File);

        String xpath = "/" + File + "/DEPT/" + DeptNo;
    }

    private static Document getDocument(String fileName) throws Exception //Credit here to a Stack Overflow Page
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        return doc;
    }
    
}
