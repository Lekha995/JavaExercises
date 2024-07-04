package JavaExercises;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Q14CreateXMLDocument {

    public static void main(String[] args){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("EmployeeRecords");
            document.appendChild(root);
            Element employee1 = createEmployeeElement(document,"ABC","Role1","30");
            root.appendChild(employee1);
            Element employee2 = createEmployeeElement(document,"DEF", "Role2","25");
            root.appendChild(employee2);
            saveXML(document,"EmployeeRecords");
            System.out.println("XML document created successfully");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Element createEmployeeElement(Document document,String name,String role,String age)
    {
        Element employee = document.createElement("Employee");

        Element nameElement = document.createElement("Name");
        nameElement.appendChild(document.createTextNode(name));
        employee.appendChild(nameElement);

        Element roleElement = document.createElement("Role");
        roleElement.appendChild(document.createTextNode(role));
        employee.appendChild(roleElement);

        Element ageElement = document.createElement("Age");
        ageElement.appendChild(document.createTextNode(age));
        employee.appendChild(ageElement);

        return employee;
    }

    public static void saveXML(Document document,String filename) throws Exception{
        javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
        javax.xml.transform.dom.DOMSource domSource = new javax.xml.transform.dom.DOMSource(document);
        javax.xml.transform.stream.StreamResult streamResult = new javax.xml.transform.stream.StreamResult(new java.io.File(filename));
        transformer.transform(domSource,streamResult);
    }
}
