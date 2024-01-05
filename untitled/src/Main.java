import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IMDbDatabase imdbDatabase = new IMDbDatabase();

        System.out.println("Hi!\nWelcome to IMDB");
        while (true) {
            System.out.println("Please Choose the Type of User that You are:\n1)Member<>\n2)Editor<>\n3)Admin<>");
            int UserType = input.nextInt();
            switch (UserType) {
                case 1:
                    System.out.println("What Do you Want to do?\n1)Sign in\n2)Sign Up");
                    int memberOption = input.nextInt();

                    if (memberOption == 1) {
                        System.out.println("Enter your name and password to sign in:");
                        String nameToSignIn = input.next();
                        String passwordToSignIn = input.next();

                        // Assuming you have a method to check member sign-in in your IMDbDatabase
                        Member signedInMember = imdbDatabase.memberSignIn(nameToSignIn, passwordToSignIn);

                        if (signedInMember != null) {
                            System.out.println("Sign in successful. Welcome, " + signedInMember.getName() + "!");
                            handleMemberActions(signedInMember, imdbDatabase, input);
                        } else {
                            System.out.println("Sign in failed. Invalid credentials.");
                        }
                    } else if (memberOption == 2) {
                        System.out.println("Please Enter you information(In such order):");
                        System.out.println("Your Name,\nEmail,\nPassWord,\nYour birth year.");
                        String Name = input.nextLine();
                        String Email = input.nextLine();
                        String Pass = input.nextLine();
                        int BirthYear = input.nextInt();
                        Member NewMember = new Member(Name, Email, Pass, BirthYear);
                        imdbDatabase.addMember(NewMember);
                        handleMemberActions(NewMember, imdbDatabase, input);
                    }
                case 2:
                    break;
            }
        }
    }

    private static void handleMemberActions(Member member, IMDbDatabase imdbDatabase, Scanner input) {
        while (true) {
            System.out.println("1)Rate a movie\n2)Add to Watchlist\n3)Add to Favorites\n4)Add to Classics to See\n5)View Lists\n6)Exit");
            int memberAction = input.nextInt();

            switch (memberAction) {
                case 1:
                    System.out.println("Enter the title of the movie to rate:");
                    String movieTitleToRate = input.next();
                    Movie movieToRate = imdbDatabase.getMovieByTitle(movieTitleToRate);
                    if (movieToRate != null) {
                        System.out.println("Enter your rating (out of 5 or 10):");
                        int rating = input.nextInt();
                        member.rateMovie(movieToRate, rating);
                        System.out.println("Rating submitted!");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the title of the movie to add to your Watchlist:");
                    String watchlistTitle = input.next();
                    Movie watchlistMovie = imdbDatabase.getMovieByTitle(watchlistTitle);
                    if (watchlistMovie != null) {
                        member.addToWatchlist(watchlistMovie);
                        System.out.println("Movie added to Watchlist!");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the title of the movie to add to your Favorites:");
                    String favoritesTitle = input.next();
                    Movie favoritesMovie = imdbDatabase.getMovieByTitle(favoritesTitle);

                    if (favoritesMovie != null) {
                        member.addToFavorites(favoritesMovie);
                        System.out.println("Movie added to Favorites!");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the title of the movie to add to Classics to See:");
                    String classicsTitle = input.next();
                    Movie classicsMovie = imdbDatabase.getMovieByTitle(classicsTitle);

                    if (classicsMovie != null) {
                        member.addToClassicsToSee(classicsMovie);
                        System.out.println("Movie added to Classics to See!");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 5:
                    System.out.println("Your Lists:");
                    System.out.println("Watchlist: " + member.getWatchlist());
                    System.out.println("Favorites: " + member.getFavorites());
                    System.out.println("Classics to See: " + member.getClassicsToSee());
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
