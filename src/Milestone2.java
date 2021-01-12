/*
 * Milestone 2
 * Description: translate a map into a 2D array and explore it
 * Name: Mohammad Abdelrahman
 * ID: 920158652
 * Class: CSC 211-02
 * Semester: fall 2020
 */
import java.util.Scanner;
public class Milestone2 {
    // array represents the map that can be access any where in class
    public static final String[][] MAP = {  {"  Wall  "," Hall.2 "," Room.1 ","lonHall1"},
                                            {"Entrance"," Room.7 "," Room.8 ","lonHall2"},
                                            {" Room.9 "," Hall.1 ","  Exit  ","lonHall3"},
                                            {"  Wall  "," Room.4 "," Hall.3 ","  Wall  "} };
    // two variables to hold the indices for our array or map
    public static int row = 1,col = 0;

    public static void main(String[] args) {
        System.out.println("****************************\n" +
                           "*Welcome to the Big castle!*\n" +
                           "*you have to find your way *\n" +
                           "*out of this castle to meet*\n" +
                           "*       your princess      *\n" +
                           "****************************");

        String currLoc = "Entrance"; // a string variable to keep track of the player position
        while(currLoc != "Exit"){ // keep the game on till the player get to the end of the map Exit
            currLoc = roomDescription(row, col); // print the player location and the surroundings and keep track of the player location
            if(currLoc == "Exit"){
                break;
            }
            while(!move(currLoc)){ // keep prompting the user to enter the right direction
                move(currLoc);
            }

        }

        System.out.println("****************************\n" +
                           "*        Game over!        *\n" +
                           "*you have found the way out*\n" +
                           "*  of this castle to meet  *\n" +
                           "*       your princess      *\n" +
                           "*     Congratulations !!!  *\n" +
                           "****************************");
    }

    public static void printMap(String loc){ // method to print the map and the player current location in the map
        for (int i = 0; i < MAP.length; i++){
            for (int j = 0; j < MAP[i].length; j++){
                System.out.print("|"+MAP[i][j]+"|");
            }
            System.out.println("\n+--------++--------++--------++--------+");
        }
        System.out.println("Your current location is: " + loc);
    }

    public static String roomDescription(int row, int col){ // method that prints out the details and surroundings in each room/hallway

        switch (MAP[row][col].trim()) {
            case "Wall":
                System.out.println("cant move to that direction there's a wall blocking you!");
                return "Wall";
            case "Hall.2":
                System.out.println("You find yourself in a hallway with a nice old piano at the end of it, To your south is" +
                        " another room with number 7 on it's door, and to your east is a another room with number" +
                        " 1 on it's door .Which way would you like to go?");
                return "Hall.2";
            case "Room.1":
                System.out.println("You find yourself in a kids play room full of toys and dolls, To your west is" +
                        " the hallway with the nice old piano at the end of it , and to your east is a very long hallway. " +
                        "Which way would you like to go?");
                return "Room.1";
            case "lonHall1":
                System.out.println("You find yourself in the beginning of a long hallway full of very expensive paintings" +
                        ", To your south is continuing the long hallway, and to your east is a another room with number 1 " +
                        "on it's door. Which way would you like to go?");
                return "lonHall1";
            case "Entrance":
                System.out.println("You are at The entrance to the Castle is big and glory. To your south is " +
                        "a room with number 9 on it's door, and to your east is a hallway full of nice and fancy" +
                        " furniture. Which way would you like to go?");
                return "Entrance";
            case "Room.7":
                System.out.println("You find yourself in an office with a big brown book shelf and a l shaped desk," +
                        " To your south is hallway, and to your east is a another room with number 8, and to your north is " +
                        "a hallway. Which way would you like to go?");
                return "Room.7";
            case "Room.8":
                System.out.println("You find yourself in a master bed room with luxurious bed and furniture," +
                        " To your west is hallway. Which way would you like to go?");
                return "Room.8";
            case "lonHall2":
                System.out.println("You find yourself in a the long hallway with different paintings, To your south is" +
                        " continuing the long hallway, and to your east is a another room with number 8 on it's door." +
                        " Which way would you like to go?");
                return "lonHall2";
            case "Room.9":
                System.out.println("You find yourself in the guards' room it's full of swords and arrows and other stuff" +
                        ", To your north is The entrance to the Castle and to your east is a hallway. Which way would " +
                        "you like to go?");
                return "Room.9";
            case "Hall.1":
                System.out.println("You find yourself in a hallway with a nice long red carpet, To your south is" +
                        " another room with number 4, and to your east is a another room with number 6, and " +
                        " To your west is another room with number 9. Which way would you like to go?");
                return "Hall.1";
            case "Exit":
                System.out.println("You have reached the Exit congratulations!!");
                return "Exit";
            case "lonHall3":
                System.out.println("You find yourself in the long hallway with different paintings on the walls, To your " +
                        "west is another room with number 6. Which way would you like to go?");
                return "lonHall3";
            case "Room.4":
                System.out.println("You find yourself in a bathroom with a huge bath tub, To your north is" +
                        " hallway with the red carpet, and to your east is hallway. Which way would you like to go?");
                return "Room.4";
            case "Hall.3":
                System.out.println("You find yourself in a hallway with three monkeys playing around, To your north is" +
                        " another room with number 6, and to your west is a another room with number 4." +
                        " Which way would you like to go?");
                return "Hall.3";

        }
        return null;
    }

    public static boolean move(String loc){ // method to move the player
        boolean pass = false; // boolean variable to check if the move is valid or not
        Scanner input = new Scanner(System.in); // scanner to get input from user
        System.out.println("(direction N: North, S: South, W: West, E: East) Or (Help) to show your location ");
        String move = input.next();
        move = move.toUpperCase(); // store the user input and change it to uppercase
        // keep prompting the user to enter a valid direction
        while(!move.equalsIgnoreCase("N") && !move.equalsIgnoreCase("S") &&
                !move.equalsIgnoreCase("W") && !move.equalsIgnoreCase("E") &&
                !move.equalsIgnoreCase("Help")){
            System.out.println("Please enter a valid direction (N: North, S: South, W: West, E: East)" +
                                                                " Or (Help) to show your location ");
            move = input.next();
            move = move.toUpperCase();
        }
        // creat a temp indices to make sure the movement is not out of bound
        int r = row;
        int c = col;
        // check to see if the player wants to go North, South, East, or West and also check if the move is valid
        switch (move){
            case "N":
                r--;
                if(checkIndex(r,c)){
                    row--;
                    pass = true;
                }
                 else {
                     return pass;
                }
                break;
            case "S":
                r++;
                if(checkIndex(r,c)){
                    row++;
                    pass = true;
                }
                else {
                    return pass;
                }
                break;
            case "W":
                c--;
                if(checkIndex(r,c)){
                    col--;
                    pass = true;
                }
                else{
                    return pass;
                }
                break;
            case "E":
                c++;
                if(checkIndex(r,c)){
                    col++;
                    pass = true;
                }
                else{
                    return pass;
                }
                break;
            case "HELP":
                printMap(loc);
                pass = true;
                break;
        }
        return pass;
    }

    public static boolean checkIndex(int row, int col){ // method to make sure the player's next move is valid
        boolean pass = false; // boolean variable to check if the move is valid or not
        if(col < 0 || col > 3){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else if (row < 0 || row > 3){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else if (row == 0 && col == 0){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else if(row == 3 && col == 0){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else if(row == 3 && col == 3){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else{
            pass = true;
        }
        return pass;

    }


}
