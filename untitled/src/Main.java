import java.util.List;
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
                        String Name = input.next();
                        String Email = input.next();
                        String Pass = input.next();
                        int BirthYear = input.nextInt();
                        System.out.println("Please Choose a gender: \n1)MALE 2)FEMALE 3)OTHER(BullShit)");
                        Gender userGender;
                        int GenderOption = input.nextInt();
                        if(GenderOption == 1){
                            userGender = Gender.MALE;
                        }else if(GenderOption == 2){
                            userGender = Gender.FEMALE;
                        }else if(GenderOption == 3){
                            userGender = Gender.OTHER;
                        }else{
                            System.out.println("Invalid input");
                            break;
                        }
                        Member NewMember = new Member(Name, Email, Pass, BirthYear,userGender);
                        imdbDatabase.addMember(NewMember);
                        System.out.println("Sign Up successful. Welcome, " + NewMember.getName() + "!");
                        handleMemberActions(NewMember, imdbDatabase, input);
                    }
                case 2:
                    System.out.println("Enter your name and password to sign in as an Editor:");
                    String editorName = input.next();
                    String editorPassword = input.next();

                    Editor signedInEditor = imdbDatabase.editorSignIn(editorName, editorPassword);

                    if (signedInEditor != null) {
                        System.out.println("Sign in successful. Welcome, " + signedInEditor.getName() + " (Editor)!");
                        handleEditorActions(signedInEditor, imdbDatabase, input);
                    } else {
                        System.out.println("Sign in failed. Invalid credentials.");
                    }
                    break;
                case 3:
                    System.out.println("Please Enter User and Password:");
                    String username = input.next();
                    String Pass = input.next();
                    if (username.equals("Admin") && Pass.equals("Admin")){
                        Admin admin = imdbDatabase.getAdmin();
                        handleAdminActions(admin,imdbDatabase,input);
                    }
                    break;
            }
        }
    }

    private static void handleMemberActions(Member member, IMDbDatabase imdbDatabase, Scanner input) {
        while (true) {
            List<Movie> Movies = imdbDatabase.getMovies();
            for (int i = 0; i < Movies.size(); i++) {
                System.out.print(i + "_" + Movies.get(i).getTitle() + " ");
            }
            System.out.println("1)Rate a movie\n2)Add to Watchlist\n3)Add to Favorites\n4)Add to Classics to See\n5)View Lists\n6)Edit information\n7)Change Password\n8)Exit");
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
                    System.out.println("Please Enter Your New information(In such order):");
                    System.out.println("Your New Name,\nNew Email,\nNew birth year.");
                    String NewName = input.next();
                    String NewEmail = input.next();
                    int NewBirthYear = input.nextInt();
                    member.UpdateProfile(NewName, NewEmail, NewBirthYear);
                    break;
                case 7:
                    while (true) {
                        System.out.println("Please Enter Your Current Password:");
                        String currentPass = input.next();

                        if (member.getPassword().equals(currentPass)) {
                            System.out.println("Please Enter Your New Password:");
                            String newPass = input.next();

                            // Password confirmation
                            System.out.println("Please Confirm Your New Password:");
                            String confirmPass = input.next();

                            if (newPass.equals(confirmPass)) {
                                // Password validation (add more conditions as needed)
                                if (newPass.length() >= 8) {
                                    member.ResetPassword(newPass);
                                    System.out.println("Your Password Updated Successfully!");
                                    break;
                                } else {
                                    System.out.println("Password must be at least 8 characters long. Please try again.");
                                }
                            } else {
                                System.out.println("Passwords do not match. Please try again.");
                            }
                        } else {
                            System.out.println("Please Enter Your Current Password Correctly!");
                        }
                    }
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void handleAdminActions(Admin admin, IMDbDatabase imdbDatabase, Scanner input) {
        while (true) {
            System.out.println("1)Add/Edit/Delete Movie \n2)Add/Edit/Delete Person \n3)Add/Edit/Delete User \n" +
                    "4)Add/Edit/Delete Review\n5)Review and Approve/Reject Edits\n" +
                    "6)Add/Edit/Delete User\n7)Exit");
            int editorAction = input.nextInt();

            switch (editorAction) {
                case 1:
                    while (true) {
                        System.out.println("1) Add Movie\n2) Edit Movie\n3) Delete Movie\n4) Exit");
                        int movieAction = input.nextInt();

                        switch (movieAction) {
                            case 1:
                                // Add Movie
                                System.out.println("Enter movie details:");
                                System.out.print("Title: ");
                                String title = input.next();
                                System.out.print("Plot Summary: ");
                                String plotSummary = input.next();
                                System.out.print("Poster URL: ");
                                String PosterUrl = input.next();
                                Movie newMovie = new Movie(title, plotSummary, PosterUrl);
                                imdbDatabase.addMovie(newMovie);
                                System.out.println("Movie added successfully!");
                                break;
                            case 2:
                                // Edit Movie
                                System.out.println("Enter the title of the movie to edit:");
                                String editTitle = input.next();
                                Movie movieToEdit = imdbDatabase.getMovieByTitle(editTitle);

                                if (movieToEdit != null) {
                                    // Allow editing of movie details
                                    System.out.println("Enter new details for the movie:");
                                    System.out.print("New Title: ");
                                    movieToEdit.setTitle(input.next());
                                    System.out.print("New Plot Summary: ");
                                    movieToEdit.setPlotSummary(input.next());

                                    System.out.println("Movie edited successfully!");
                                } else {
                                    System.out.println("Movie not found.");
                                }
                                break;
                            case 3:
                                // Delete Movie
                                System.out.println("Enter the title of the movie to delete:");
                                String deleteTitle = input.next();
                                Movie movieToDelete = imdbDatabase.getMovieByTitle(deleteTitle);

                                if (movieToDelete != null) {
                                    imdbDatabase.deleteMovie(movieToDelete);
                                    System.out.println("Movie deleted successfully!");
                                } else {
                                    System.out.println("Movie not found.");
                                }
                                break;
                            case 4:
                                System.out.println("Exiting movie actions.");
                                return;
                            default:
                                System.out.println("Invalid input. Please try again.");
                        }
                        break;
                    }

                case 2:
                    while (true) {
                        System.out.println("1) Add Person\n2) Edit Person\n3) Delete Person\n4) Exit");
                        int personAction = input.nextInt();

                        switch (personAction) {
                            case 1:
                                // Add Person
                                System.out.println("Enter person details:");
                                System.out.print("Name: ");
                                String name = input.next();
                                System.out.print("Bio: ");
                                String bio = input.next();
                                Person newPerson = new Person(name, bio);
                                imdbDatabase.addPerson(newPerson);
                                System.out.println("Person added successfully!");
                                break;
                            case 2:
                                // Edit Person
                                System.out.println("Enter the name of the person to edit:");
                                String editName = input.next();
                                Person personToEdit = imdbDatabase.getPersonByName(editName);

                                if (personToEdit != null) {
                                    // Allow editing of person details
                                    System.out.println("Enter new details for the person:");
                                    System.out.print("New Name: ");
                                    personToEdit.setName(input.next());
                                    System.out.print("New Bio: ");
                                    personToEdit.setBio(input.next());
                                    System.out.println("Person edited successfully!");
                                } else {
                                    System.out.println("Person not found.");
                                }
                                break;
                            case 3:
                                // Delete Person
                                System.out.println("Enter the name of the person to delete:");
                                String deleteName = input.next();
                                Person personToDelete = imdbDatabase.getPersonByName(deleteName);

                                if (personToDelete != null) {
                                    imdbDatabase.deletePerson(personToDelete);
                                    System.out.println("Person deleted successfully!");
                                } else {
                                    System.out.println("Person not found.");
                                }
                                break;
                            case 4:
                                System.out.println("Exiting person actions.");
                                return;
                            default:
                                System.out.println("Invalid input. Please try again.");
                        }
                        break;
                    }

                case 3:
                    System.out.println("1)Ban User\n2)Delete User\n3)Exit");
                    int userManagementAction = input.nextInt();

                    switch (userManagementAction) {
                        case 1:
                            System.out.println("Enter the name of the user to ban:");
                            String userToBan = input.next();
                            User user = imdbDatabase.getUserByName(userToBan);

                            if (user != null) {
                                admin.setBanned(user);
                                String newPass = input.next();
                                user.ResetPassword(newPass);
                                System.out.println("User banned successfully!");
                            } else {
                                System.out.println("User not found.");
                            }
                            break;
                        case 2:
                            System.out.println("Enter the name of the user to Delete:");
                            String userToDelete = input.next();
                            User User = imdbDatabase.getUserByName(userToDelete);

                            if (User != null) {
                                admin.setBanned(User);
                                imdbDatabase.deleteUser(User);
                                System.out.println("User Deleted successfully!");
                            } else {
                                System.out.println("User not found.");
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid input. Please try again.");
                    }
                    break;
                case 5:
                    while (true) {
                        System.out.println("1) Review and Approve/Reject Edits\n2) Exit");
                        int reviewAction = input.nextInt();

                        switch (reviewAction) {
                            case 1:
                                // Review and Approve/Reject Edits
                                System.out.println("Enter the title of the movie for which edits are suggested:");
                                String movieTitle = input.next();
                                Movie movieToReview = imdbDatabase.getMovieByTitle(movieTitle);

                                if (movieToReview != null) {
                                    // Display edit suggestions and prompt for approval/rejection
                                    List<EditSuggestionEntry> editSuggestions = movieToReview.getEditSuggestions();

                                    if (!editSuggestions.isEmpty()) {
                                        System.out.println("Edit Suggestions for " + movieTitle + ":");
                                        for (EditSuggestionEntry suggestion : editSuggestions) {
                                            System.out.println(suggestion);
                                        }

                                        System.out.println("Do you want to approve or reject these edits?");
                                        System.out.println("1) Approve\n2) Reject");
                                        int approvalDecision = input.nextInt();

                                        if (approvalDecision == 1) {
                                            // Approve edits
                                            movieToReview.applyEdits(editSuggestions);
                                            System.out.println("Edits approved and applied successfully!");
                                        } else if (approvalDecision == 2) {
                                            // Reject edits
                                            movieToReview.clearEditSuggestions();
                                            System.out.println("Edits rejected successfully!");
                                        } else {
                                            System.out.println("Invalid input. Please try again.");
                                        }
                                    } else {
                                        System.out.println("No edit suggestions found for " + movieTitle);
                                    }
                                } else {
                                    System.out.println("Movie not found.");
                                }
                                break;
                            case 2:
                                System.out.println("Exiting review actions.");
                                return;
                            default:
                                System.out.println("Invalid input. Please try again.");
                        }
                        break;
                    }

                case 6:
                    while (true) {
                        System.out.println("1) Add User\n2) Edit User\n3) Delete User\n4) Exit");
                        int userAction = input.nextInt();

                        switch (userAction) {
                            case 1:
                                // Add User
                                System.out.println("Enter user details:");
                                System.out.print("Name: ");
                                String name = input.next();
                                System.out.print("Email: ");
                                String email = input.next();
                                System.out.print("Password: ");
                                String password = input.next();
                                System.out.println("What Role You want to give him\\her: \n1)Editor 2)Member");
                                int roleOption = input.nextInt();
                                UserRole userRole;
                                if(roleOption == 1){
                                    userRole = UserRole.EDITOR;
                                }
                                else if(roleOption == 2){
                                    userRole = UserRole.MEMBER;
                                }
                                else {
                                    System.out.println("invalid input");
                                    break;
                                }
                                System.out.println("Please Choose a gender: \n1)MALE 2)FEMALE 3)OTHER(BullShit)");
                                Gender userGender;
                                int genderOption = input.nextInt();
                                if(genderOption == 1){
                                    userGender = Gender.MALE;
                                }else if(genderOption == 2){
                                    userGender = Gender.FEMALE;
                                }else if(genderOption == 3){
                                    userGender = Gender.OTHER;
                                }else{
                                    System.out.println("Invalid input");
                                    break;
                                }
                                System.out.println("Please Enter Users Birth Year and I'm Done after that:");
                                int userBirth = input.nextInt();

                                User newUser = new User(name, email, password,userBirth,userGender,userRole);
                                imdbDatabase.addUser(newUser);
                                System.out.println("User added successfully!");
                                break;
                            case 2:
                                // Edit User
                                System.out.println("Enter the name of the user to edit:");
                                String editUserName = input.next();
                                User userToEdit = imdbDatabase.getUserByName(editUserName);

                                if (userToEdit != null) {
                                    // Allow editing of user details
                                    System.out.println("Enter new details for the user:");
                                    System.out.print("New Name: ");
                                    userToEdit.setName(input.next());
                                    System.out.print("New Email: ");
                                    userToEdit.setEmail(input.next());
                                    System.out.print("New Password: ");
                                    userToEdit.setPassword(input.next());

                                    System.out.println("User edited successfully!");
                                } else {
                                    System.out.println("User not found.");
                                }
                                break;
                            case 3:
                                // Delete User
                                System.out.println("Enter the name of the user to delete:");
                                String deleteUserName = input.next();
                                User userToDelete = imdbDatabase.getUserByName(deleteUserName);

                                if (userToDelete != null) {
                                    imdbDatabase.deleteUser(userToDelete);
                                    System.out.println("User deleted successfully!");
                                } else {
                                    System.out.println("User not found.");
                                }
                                break;
                            case 4:
                                System.out.println("Exiting user actions.");
                                return;
                            default:
                                System.out.println("Invalid input. Please try again.");
                        }
                        break;
                    }
                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
    private static void handleEditorActions(Editor editor, IMDbDatabase imdbDatabase, Scanner input) {
        while (true) {
            System.out.println("1) Suggest Edits\n2) Flag Inappropriate Content\n3) Exit");
            int editorAction = input.nextInt();

            switch (editorAction) {
                case 1:
                    // Suggest Edits
                    System.out.println("Enter the title of the movie you want to suggest edits for:");
                    String movieTitle = input.next();
                    Movie movieToEdit = imdbDatabase.getMovieByTitle(movieTitle);

                    if (movieToEdit != null) {
                        System.out.println("Enter details for the suggested edits:");
                        String editDetails = input.next();
                        movieToEdit.suggestEdit(editor, editDetails);
                        System.out.println("Edits suggested successfully!");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 2:
                    // Flag Inappropriate Content
                    System.out.println("Enter the title of the movie with inappropriate content:");
                    String inappropriateMovieTitle = input.next();
                    Movie movieToFlag = imdbDatabase.getMovieByTitle(inappropriateMovieTitle);

                    if (movieToFlag != null) {
                        movieToFlag.flagInappropriateContent(editor);
                        System.out.println("Content flagged successfully!");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
