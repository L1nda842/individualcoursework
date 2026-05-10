import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public boolean lendBook(String isbn, String memberId, LocalDate borrowDate, LocalDate dueDate) {
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);
        if (book == null || member == null || !book.isAvailable()) {
            return false; // Cannot lend
        }
        Loan loan = new Loan(member, book, borrowDate, dueDate);
        loans.add(loan);
        book.setAvailable(false);
        member.addLoan(loan);
        return true;
    }

    public boolean returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book == null || book.isAvailable()) {
            return false; // Not on loan
        }
        Loan loanToRemove = null;
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                loanToRemove = loan;
                break;
            }
        }
        if (loanToRemove != null) {
            loans.remove(loanToRemove);
            loanToRemove.getMember().removeLoan(loanToRemove);
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    private Book findBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }

    private Member findMemberById(String id) {
        for (Member m : members) {
            if (m.getMemberId().equals(id)) return m;
        }
        return null;
    }

    public void printLibraryStatus() {
        System.out.println("Books:");
        for (Book b : books) System.out.println(b);
        System.out.println("Members:");
        for (Member m : members) System.out.println(m);
        System.out.println("Loans:");
        for (Loan l : loans) System.out.println(l);
    }
}