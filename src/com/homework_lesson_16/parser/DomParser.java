package com.homework_lesson_16.parser;

import com.homework_lesson_16.parser.user.User;
import com.homework_lesson_16.parser.intetface.IntetfaceParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DomParser implements IntetfaceParser{
    @Override
    public List<User> parse(String location){
        ArrayList<User> list =new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory =DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        Document document = null;
        {
            try {
                documentBuilder =documentBuilderFactory.newDocumentBuilder();
                document =documentBuilder.parse(new File(location));
                document.getDocumentElement().normalize();
            }catch (ParserConfigurationException e){
                e.printStackTrace();
            }catch (SAXException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        NodeList users = document.getElementsByTagName("user");
        for (int i=0; i<users.getLength(); i++){
            Node user = users.item(i);
            if (user.getNodeType()==Node.ELEMENT_NODE){
                Element element =(Element) user;
                String firstname = element.getAttribute("firstname");
                String lastname = element.getAttribute("lastname");
                int id = Integer.parseInt(element.getAttribute("id"));
                String city = element.getAttribute("city");
                list.add(new User(id,firstname,lastname, city));
            }
        }

        return list;
    }
}
