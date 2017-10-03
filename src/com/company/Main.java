package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Tools
    static Scanner keyboard = new Scanner(System.in);

    //List
    static List<Movie> movieList = new ArrayList<Movie>();

    public static void main(String[] args) {


        //Movies
        Movie star_wars = new Movie("Star Wars", true, 0);
        Movie to_gun = new Movie("Top Gun", true, 0);
        Movie inception = new Movie("Inception", true, 0);
        Movie rocky = new Movie("Rocky", true, 0);

        //Add movie into movieList
        movieList.add(star_wars);
        movieList.add(to_gun);
        movieList.add(inception);
        movieList.add(rocky);


        //main loop - allways true
        while (true){


            //Coustomer get list over allowed actions
            System.out.println("Welcomme to the Movie rental store" + "\n" + "To rent press 'r'");
            String userCommand = keyboard.nextLine();
            if(userCommand.equals("r")){
                userInteraction();
            }else{
                System.out.println("Sorry, wrong command!");
            }

        }

    }

    public static void userInteraction(){

        System.out.println("To show all available moives, type 's'" + "\n" + "To return movie, type 'r'" + "\n" + "To search for a movie, type 'f'" + "\n");
        String userCommand = keyboard.nextLine();
        if(userCommand.equals("s")){
            showAll();
        }else if(userCommand.equals("r")){
            returnMovie();
        }else if(userCommand.equals("f")){
            searchMoive();
        }else{
            System.out.println("Sorry, unknown command!");
            return;
        }
    }


    private static void returnMovie() {
        System.out.println("What is the title of the movie?");
        String userCommand = keyboard.nextLine();
        boolean movieFound = false;

        for(Movie movie : movieList) {
            if(movie != null && movie.getTitle().toLowerCase().equals(userCommand.toLowerCase()) && movie.inStock == false) {
                movie.returned();
                movie.rentDate = 0;
                movieFound = true;
                System.out.println(movie.getTitle() + " is now returend.");
                return;
            }
        }
        if(!movieFound){
            System.out.println("No movie by that tittel was rented out!" + "\n");
            return;
        }

    }

    private static void showAll() {
        System.out.println("All movies!");
        for(Movie movie : movieList) {
            if(movie.inStock){
                System.out.println(movie.getTitle());
            }

        }
        System.out.println("\n");
        userInteraction();
    }

    private static void searchMoive() {

        System.out.println("Write down the tittel for the movie");
        String userCommand = keyboard.nextLine();
        boolean movieFound = false;

        for(Movie movie : movieList) {
            if(movie != null && movie.getTitle().toLowerCase().equals(userCommand.toLowerCase())) {
                movieFound = true;
                System.out.println(movie.getTitle() + " found! Do yot want to rent it? Yes : 'y', No: 'n'");
                String rentAnswer = keyboard.nextLine();
                if(rentAnswer.equals("y")){
                    rentMovie(movie);
                }else if(rentAnswer.equals("n")){
                    return;
                }else{
                    System.out.println("Sorry, unknown command!");
                    return;
                }

            }
        }
        if(!movieFound){
            System.out.println("No movie by that tittel was found!" + "\n");
            return;
        }
    }

    private static void rentMovie(Movie moive) {
        moive.rentedOut();
        moive.setRentDate(20);
        System.out.println(moive.getTitle() + " is now rented. Must be returned within " + moive.getRentDate() + " days!");

    }


}
