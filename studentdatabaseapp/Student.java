package studentdatabaseapp;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String cources = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = scanner.nextLine();

        System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior \nEnter student class level: ");
        this.gradeYear = scanner.nextInt();

        setStudentID();

        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
    }

    // Generate an ID
    private void setStudentID() {

        // Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course to enroll (Q to quit): ");
        String course = scanner.nextLine();
        while (!"Q".equals(course)) {
            System.out.print("Enter course to enroll (Q to quit): ");
            this.cources = this.cources + " " + course;
            tuitionBalance = tuitionBalance + costOfCourse;
            course = scanner.nextLine();
        }
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your Balance is: $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {
        viewBalance();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your payment: $");
        int payment = scanner.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }
    // Show status
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCoursed Enrolled: " + cources +
                "\nBalance: $" + tuitionBalance;
    }

}
