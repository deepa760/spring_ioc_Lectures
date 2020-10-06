package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        System.out.println( "Welcome Spring!" );


        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        System.out.println("Name a new student:");
        studentManagement.save(studentManagement.create());
        System.out.println("and one more student:");
        studentManagement.save(studentManagement.create());

        System.out.println("Searching for student with id 1002");
        System.out.println(studentManagement.find(1002));

        System.out.println("And here is all students:");
        studentManagement.findAll().forEach(s-> System.out.println(s));


    }
