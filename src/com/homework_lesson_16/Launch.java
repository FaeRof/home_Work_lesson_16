package com.homework_lesson_16;

import com.homework_lesson_16.parser.user.User;
import com.homework_lesson_16.parser.DomParser;
import com.homework_lesson_16.parser.sax.SaxParser;

import java.util.List;

public class Launch {

    public static void main(String[] args) {

        DomParser domParser =new DomParser();
        System.out.println("DOMParser: ");

        List<User> list = domParser.parse("F:\\Новая папка\\Customer\\customer.xml");
        list.stream().forEach((user -> System.out.println("user > id:"+user.getId()+
                " firstname: "+user.getFirstname()+" lastname: "+user.getLastname()+
                " city: "+user.getCity())));

        System.out.println(" ");
        System.out.println("SAXParser: ");
        SaxParser saxParser = new SaxParser();
        List<User> list1 =saxParser.parse("F:\\Новая папка\\Customer\\customer.xml");
        list1.stream().forEach((user ->  System.out.println("user > id:"+user.getId()+
                " firstname: "+user.getFirstname()+" lastname: "+user.getLastname()+
                " city: "+user.getCity())));
    }
}
