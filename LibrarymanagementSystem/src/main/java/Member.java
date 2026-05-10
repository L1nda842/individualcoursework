import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<Loan> loans;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.loans = new ArrayList<>();
    }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Loan> getLoans() { return loans; }

    public void addLoan(Loan loan) { loans.add(loan); }
    public void removeLoan(Loan loan) { loans.remove(loan); }

    @Override
    public String toString() {
        return "Member[ID=" + memberId + ", Name=" + name + ", Loans=" + loans.size() + "]";
    }
}