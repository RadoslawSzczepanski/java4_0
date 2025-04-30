import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);

    b.append(student.GetName())
     .append(" ")
     .append(student.GetSurname())
     .append(" ")
     .append(Integer.toString(student.GetAge()))
     .append(" ")
     .append(student.GetBirthDate());
    b.newLine();  

    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while ((line = reader.readLine()) != null) {
      ret.add(Student.Parse(line));
    }
    reader.close();
    return ret;
  }

  public Student findStudentByName(String name) throws IOException {
    Collection<Student> students = getStudents();

    for (Student student : students) {
      if (student.GetName().equalsIgnoreCase(name)) {
        return student;
      }
    }

    return null;
  }

  public void removeStudent(String name, String surname) throws IOException {
    
    Collection<Student> students = getStudents();
    Collection<Student> updatedStudents = new ArrayList<>();

    boolean found = false;

    for (Student student : students) {
      if (student.GetName().equalsIgnoreCase(name) &&
          student.GetSurname().equalsIgnoreCase(surname)) {
        found = true; 
      } else {
        updatedStudents.add(student); 
      }
    }

    if (found) {
      var writer = new BufferedWriter(new FileWriter("db.txt"));
      for (Student student : updatedStudents) {
        writer.append(student.GetName())
              .append(" ")
              .append(student.GetSurname())
              .append(" ")
              .append(Integer.toString(student.GetAge()))
              .append(" ")
              .append(student.GetBirthDate());
        writer.newLine(); 
      }
      writer.close();
      System.out.println("Student został usunięty.");
    } else {
      System.out.println("Nie znaleziono studenta o podanym imieniu i nazwisku.");
    }
  }
}


