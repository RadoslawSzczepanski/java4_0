/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("Podaj imię studenta (lub wpisz 'stop', aby zakończyć):");
        String name = scanner.nextLine();

        if (name.equalsIgnoreCase("stop")) {
          System.out.println("Zakończono wprowadzanie studentów.");
          break;
        }

        System.out.println("Podaj wiek studenta:");
        int age = Integer.parseInt(scanner.nextLine());

        s.addStudent(new Student(name, age));
      }

      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}



