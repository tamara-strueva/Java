package tamara.homework4;

public class Test {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Петров В.В.", 1, "Социология",
                "89999999999", "01.04.2001");
        Reader reader2 = new Reader("Иванов И.К.", 2, "Экономика",
                "89777777777", "08.07.2006");
        Reader reader3 = new Reader("Андриянова А.Г.", 3, "Юриспруденция",
                "89357642741", "31.12.2000");

        Book book1 = new Book("Толстой Л.Н.", "Анна Каренина");
        Book book2 = new Book("Чехов А.П.", "Вишневый сад");
        Book book3 = new Book("Булгаков М.А.", "Мастер и Маргарита");

        reader1.takeBook(3);
        reader1.takeBook(book1, book2, book3);
        reader1.returnBook(book2, book1);
    }
}
