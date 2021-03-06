package Homework;

/**
 * Created by hegyi on 2017-04-03.
 */
public class Student {

  String name;
  int age;
  String gender;
  String previousOrganization;
  int skippedDays;
  int skipDays;

  public void getGoal() {
    System.out.println("My goal: " + "Be a junior software developer.");
  }

  public void introduce() {
    System.out.println("Hi, I'm, " + name + " a " + age + " year old " +
        gender + " from " + previousOrganization + " who skipped " + skippedDays +
        " days from the course already.");
  }

  public void skipDays(int i) {
    this.skippedDays += skipDays;
  }

  public Student (String name, int age, String gender, String previousOrganization) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  public Student() {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = "female";
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }
}
