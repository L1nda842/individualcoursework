import java.time.LocalDate;

public class LibraryDemo {
    public static void main(String[] args) {
        Library lib = new Library();

        // Create members
        Member m1 = new Member("M001", "Linda");
        Member m2 = new Member("M002", "Cynthia");
        lib.registerMember(m1);
        lib.registerMember(m2);

        // Create books
        Book b1 = new Book("ISBN001", "Book One", "Author A");
        Book b2 = new Book("ISBN002", "Book Two", "Author B");
        Book b3 = new Book("ISBN003", "Book Three", "Author C");
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        System.out.println("Initial Library State:");
        lib.printLibraryStatus();

        // Lend books
        lib.lendBook("ISBN001", "M001", LocalDate.now(), LocalDate.now().plusWeeks(2));
        lib.lendBook("ISBN002", "M002", LocalDate.now(), LocalDate.now().plusWeeks(2));
        // Attempt to lend an already loaned book
        boolean success = lib.lendBook("ISBN001", "M002", LocalDate.now(), LocalDate.now().plusWeeks(2));
        if (!success) {
            System.out.println("Cannot lend ISBN001 again: already on loan");
        }

        System.out.println("\nAfter loans:");
        lib.printLibraryStatus();

        // Return a book
        lib.returnBook("ISBN001");
        System.out.println("\nAfter returning ISBN001:");
        lib.printLibraryStatus();
    }
}