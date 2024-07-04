package JavaExercises;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class Q14XMLParser {
    public static void main(String[] args) throws IOException, SAXException {

        try {
            File xmlfile = new File("EmployeeRecords.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlfile);
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            System.out.println("Root Element:" + root.getNodeName());
            NodeList nodeList = document.getElementsByTagName("Employee");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element employee = (Element) node;
                    System.out.println("Employee:");

                    String name = employee.getElementsByTagName("Name").item(0).getTextContent();
                    String role = employee.getElementsByTagName("Role").item(0).getTextContent();
                    String age = employee.getElementsByTagName("Age").item(0).getTextContent();

                    System.out.println("Name:" + name);
                    System.out.println("Role:" + role);
                    System.out.println("Age:" + age);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}