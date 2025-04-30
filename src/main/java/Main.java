import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("\nWybierz opcję:");
        System.out.println("1 - Dodaj studenta");
        System.out.println("2 - Wyświetl wszystkich studentów");
        System.out.println("3 - Szukaj studenta po imieniu");
        System.out.println("4 - Zakończ program");

        String input = scanner.nextLine();

        switch (input) {
          case "1":
            // Dodawanie studenta
            System.out.print("Podaj imię studenta: ");
            String name = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta: ");
            String surname = scanner.nextLine();

            System.out.print("Podaj wiek studenta: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Podaj datę urodzenia studenta (YYYY-MM-DD): ");
            String birthDate = scanner.nextLine();

            Student newStudent = new Student(name, surname, age, birthDate);
            s.addStudent(newStudent);

            System.out.println("Dodany student:");
            System.out.println(newStudent.ToString());
            break;

          case "2":
            // Wyświetlanie wszystkich studentów
            var students = s.getStudents();
            System.out.println("Lista studentów:");
            for (Student student : students) {
              System.out.println(student.ToString());
            }
            break;

          case "3":
            // Szukanie studenta po imieniu
            System.out.print("Podaj imię studenta do wyszukania: ");
            String searchName = scanner.nextLine();

            Student foundStudent = s.findStudentByName(searchName);
            if (foundStudent != null) {
              System.out.println("Znaleziony student:");
              System.out.println(foundStudent.ToString());
            } else {
              System.out.println("Nie znaleziono studenta o imieniu: " + searchName);
            }
            break;

          case "4":
            // Zakończenie programu
            System.out.println("Program zakończony.");
            scanner.close();
            return;

          default:
            System.out.println("Nieznana opcja. Spróbuj ponownie.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}







