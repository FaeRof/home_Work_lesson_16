package com.homework_lesson_16.parser.sax;

import com.homework_lesson_16.parser.user.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class Handler extends DefaultHandler{
    private List<User> userList =new ArrayList<>();

    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes) throws SAXException{

        if (qName.equals("user")){
            int id =Integer.parseInt(attributes.getValue("id"));
            String firstname = attributes.getValue("firstname");
            String lastname = attributes.getValue("lastname");
            String city = attributes.getValue("city");
            userList.add(new User(id, firstname, lastname,city));
        }
    }


    @Override
    public void endDocument() throws SAXException{
        System.out.println("Обработка документа завершена");
    }
    public List<User> getUserList(){return userList;}
}
