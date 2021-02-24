package com.homework_lesson_16.parser.sax;

import com.homework_lesson_16.parser.user.User;
import com.homework_lesson_16.parser.intetface.IntetfaceParser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.File;


public class SaxParser implements IntetfaceParser{
    @Override
    public List<User> parse(String location){
        List<User> userList = new ArrayList<>();
        try {
            File input = new File(location);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            Handler handler = new Handler();
            saxParser.parse(input, handler);

            userList = handler.getUserList();
        }catch (SAXException e){
            e.printStackTrace();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return userList;
    }
}
