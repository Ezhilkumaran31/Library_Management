package demo;
import java.util.*;

class Book {
    int bookId;
    String title, author;
    int price;
    boolean isAvailable;

    public Book(int bookId, String title, String author, int price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId + " Title: " + title + " Author: " + author + " Price: " + price + " Available: " + isAvailable);
    }

    public void updateAvailability(boolean status) {
        this.isAvailable = status;
    }
}

class Member {
    int memberId;
    String name, membershipType;
    
    // Default constructor
    public Member() {}
    
    public void displayMember() {
        System.out.println("Member ID: " + memberId + " Name: " + name + " Membership: " + membershipType);
    }
}

class RegularMember extends Member {
    public RegularMember(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = "Regular";
    }
}

class PremiumMember extends Member {
    public PremiumMember(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = "Premium";
    }
}

class Transaction {
    int transactionId, bookId, memberId;
    String borrowDate;

    public Transaction(int transactionId, int bookId, int memberId, String borrowDate) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
    }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId + " Book ID: " + bookId + " Member ID: " + memberId + " Borrow Date: " + borrowDate);
    }
}

public class library_management {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Price: ");
        int price = sc.nextInt();
        books.add(new Book(id, title, author, price));
        System.out.println("Book Added Successfully!");
    }

    public static void displayBooks() {
        for (Book b : books) {
            b.displayBook();
        }
    }

    public static void addMember() {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Membership Type (Regular/Premium): ");
        String type = sc.nextLine();
        if (type.equalsIgnoreCase("Regular")) {
            members.add(new RegularMember(id, name));
        } else {
            members.add(new PremiumMember(id, name));
        }
        System.out.println("Member Added Successfully!");
    }

    public static void displayMembers() {
        for (Member member : members) {
            member.displayMember();
        }
    }

    public static void borrowBook() {
        System.out.print("Enter Transaction ID: ");
        int tid = sc.nextInt();
        System.out.print("Enter Book ID: ");
        int bid = sc.nextInt();
        System.out.print("Enter Member ID: ");
        int mid = sc.nextInt();
        System.out.print("Enter Borrow Date : ");
        String date = sc.nextLine();
        
        for (Book b : books) {
            if (b.bookId == bid) { 
                b.updateAvailability(false);
                transactions.add(new Transaction(tid, bid, mid, date));
                System.out.println("Book Borrowed Successfully!");
                return;
            }
        }
    }

    public static void displayTransactions() {
        for (Transaction t : transactions) {
            t.displayTransaction();
        }
    }

    public static void main(String[] args) {
    	Book b1 = new Book(101, "HARRY POTTER", "J K ROWLING", 400);
        Book b2 = new Book(102, "JAVA", "JAMES GOSLING", 350);
        Book b3 = new Book(103, "13 REASONS WHY", "CLAY", 500);

        books.add(b1);
        books.add(b2);
        books.add(b3);

       
        Member m1 = new RegularMember(201, "RAM");
        Member m2 = new PremiumMember(202, "RAJESH");
        Member m3 = new RegularMember(203, "KUMAR");

        members.add(m1);
        members.add(m2);
        members.add(m3);

    	
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book\n2. Display Books\n3. Add Member\n4. Display Members\n5. Borrow Book\n6. Display Transactions");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: addBook(); 
                        break;
                case 2: displayBooks(); 
                        break;
                case 3: addMember(); 
                        break;
                case 4: displayMembers();
                        break;
                case 5: borrowBook(); 
                       break;
                case 6: displayTransactions(); 
                        break;
                default:
                	System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
