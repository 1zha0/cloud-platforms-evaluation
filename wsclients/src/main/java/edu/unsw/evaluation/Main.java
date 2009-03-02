package edu.unsw.evaluation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author shrimpy
 */
public class Main {

    private static ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});

    public static void main(String[] args) {
        Test test = (Test) context.getBean("testPojo");
        System.out.println("===>>>>>> starting... " + test.goodDay("Clay"));
    }
}
