import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IMDbDatabase imdbDatabase = new IMDbDatabase();

        System.out.println("Hi!\nWelcome to IMDB");
        while (true) {
            System.out.println("Please Choose the Type of User that You are:\n1)Member<>\n2)Editor<>\n3)Admin<>");
            int EnterOption1 = input.nextInt();
            switch (EnterOption1) {
                case 1:
                    System.out.println("What Do you Want to do?\n1)Sign in\n2)Sign Up");
                    int EnterOption2 = input.nextInt();
                    if (EnterOption2 == 1) {
                    } else if (EnterOption2 == 2) {
                        System.out.println("Please Enter you information(In such order):");
                        System.out.println("Your Name,\nEmail,\nPassWord,\nYour birth year.");
                        String Name = input.nextLine();
                        String Email = input.nextLine();
                        String Pass = input.nextLine();
                        int BirthYear = input.nextInt();
                        Member NewMember = new Member(Name, Email, Pass, BirthYear);
                        imdbDatabase.addMember(NewMember);
                        while (true) {
                            System.out.println("List of movies:");
                            imdbDatabase.getMovies().forEach(System.out::println);

                        }
                    } else {
                        System.out.println("Invalid Input Try this Shit Again!");
                        break;
                    }
                case 2:
                    break;
            }
        }
    }
}
