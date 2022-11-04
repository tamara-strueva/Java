package tamara.homework4;
import java.lang.*;

public class Reader {
    String FIO, faculty, phoneNumber, dateOfBirth;
    int idOfReaderTicket;

    // конструктор класса
    Reader (String FIO, int idOfReaderTicket, String faculty, String phoneNumber, String dateOfBirth) {
        this.FIO = FIO;
        this.idOfReaderTicket = idOfReaderTicket;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
    }

    // метод, выводящий, сколько книг взял читатель
    public void takeBook(int numberOfTakenBooks) {
        System.out.println(this.FIO + " взял " + numberOfTakenBooks + " книги");
    }

    // метод, выводящий названия книг, которые взял читатель
    public void takeBook(String... namesOfTakenBooks) {
        System.out.print("\n" + this.FIO + " взял книги: ");
        for (String book: namesOfTakenBooks) {
            System.out.print(book + ", ");
        }
    }

    // метод, выводящий названия книг, которые взял читатель
    public void takeBook(Book... books) {
        System.out.print("\n" + this.FIO + " взял книги: ");
        for (Book book: books) {
            System.out.print(book.bookTitle + ", ");
        }
        System.out.println();
    }

    // метод, выводящий количество книг, которые вернул читатель
    public void returnBook(int numberOfReturnedBooks) {
        System.out.println(this.FIO + " вернул " + numberOfReturnedBooks + " книг");
    }

    // метод, выводящий названия книг, которые вернул читатель
    public void returnBook (String... namesOfReturnedBooks) {
        System.out.println("\n" + this.FIO + " вернул книги: ");
        for (String book: namesOfReturnedBooks) {
            System.out.print(book + ", ");
        }
        System.out.println();
    }

    // метод, выводящий названия книг, которые вернул читатель
    public void returnBook(Book... books) {
        System.out.print("\n" + this.FIO + " вернул книги: ");
        for (Book book: books) {
            System.out.print(book.bookTitle + ", ");
        }
        System.out.println();
    }

    // метод, возвращающий ФИО читателя
    public String getFIO() {return this.FIO;}

    // метод, возвращающий номер читательского билета
    public int getIdOfReaderTicket() {return this.idOfReaderTicket;}

    // метод, возвращающий факультет, на котором читатель учится
    public String getFaculty() {return this.faculty;}

    // метод, возращающий телефонный номер читателя
    public String getPhoneNumber() {return this.phoneNumber;}

    // метод, возвращающий дату рождения читателя
    public String getDateOfBirth() {return this.dateOfBirth;}
}
