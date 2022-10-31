package tamara.homework4;
import java.util.*;
import java.lang.*;

public class Reader {
    String FIO, faculty, phoneNumber, dateOfBirth;
    int idOfReaderTicket;

    Reader (String FIO, int idOfReaderTicket, String faculty, String phoneNumber, String dateOfBirth) {
        this.FIO = FIO;
        this.idOfReaderTicket = idOfReaderTicket;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int numberOfTakenBooks) {
        System.out.println(this.FIO + " взял " + numberOfTakenBooks + " книги");
    }

    public void takeBook(String... namesOfTakenBooks) {
        System.out.print("\n" + this.FIO + " взял книги: ");
        for (String book: namesOfTakenBooks) {
            System.out.print(book + ", ");
        }
    }

    public void takeBook(Book... books) {
        System.out.print("\n" + this.FIO + " взял книги: ");
        for (Book book: books) {
            System.out.print(book.bookTitle + ", ");
        }
        System.out.println();
    }

    public void returnBook(int numberOfReturnedBooks) {
        System.out.println(this.FIO + " вернул " + numberOfReturnedBooks + " книг");
    }

    public void returnBook (String... namesOfReturnedBooks) {
        System.out.println("\n" + this.FIO + " вернул книги: ");
        for (String book: namesOfReturnedBooks) {
            System.out.print(book + ", ");
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.print("\n" + this.FIO + " вернул книги: ");
        for (Book book: books) {
            System.out.print(book.bookTitle + ", ");
        }
        System.out.println();
    }

    public String getFIO() {return this.FIO;}

    public int getIdOfReaderTicket() {return this.idOfReaderTicket;}

    public String getFaculty() {return this.faculty;}

    public String getPhoneNumber() {return this.phoneNumber;}

    public String getDateOfBirth() {return this.dateOfBirth;}
}
