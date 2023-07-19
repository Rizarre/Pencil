import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class pencil {
    public static void main(String args[]){
        ArrayList <String> text = new ArrayList<String>();
        pencil pencil = new pencil();
        Scanner console = new Scanner(System.in);

        String choice;

        do{
            System.out.print("Choose an option:\n[ A ] Add\n[ B ] Read \n[ C ] Update \n[ D ] Delete \n[ E ] Exit\nEnter Choice: ");
            choice = console.nextLine();
            String write="";

            switch(choice){

            //Add
            case "a":
            case "A":
                int size = text.size();
                if(size<5){
                    System.out.print("Pick a pencil:\n[ A ] Graphite\n[ B ] Colored\nEnter Choice: ");
                    String choice2 = console.nextLine();

                    switch(choice2){

                        //Graphite
                        case "a":
                        case "A":
                        System.out.print("Write your message: ");
                        write = console.nextLine();
                        if(write.length() < 50){ 
                            text.add(write);
                        }
                        else{
                            System.out.println("You cannot write more than 50 characters.");
                        }
                        break;

                        //Colored
                        case "b":
                        case "B":
                        System.out.print("Write your message: ");
                        write = console.nextLine();
                        if(write.length() < 30){ 
                            text.add(write);
                        }
                        else{
                            System.out.println("You cannot write more than 30 characters.");
                        }
                        break;
                    }
                }
                else{
                    System.out.println("You cannot write more than 5 messages. Delete a message first.");
                }
            break;

            //Read
            case "b":
            case "B":
            System.out.println("Messages:\n" + text);
            break;

            //Update
            case "c":
            case "C":
            System.out.println("Which message would you like to update?");
            System.out.print(text + "\n[ Pick from 1 - 5]\nEnter choice: ");
            int i = console.nextInt();
                    console.nextLine();
            if (i >= 1 && i <= text.size()) {
                System.out.print("Enter new message: ");
                String newMessage = console.nextLine();
                text.set(i - 1, newMessage);
            } else {
                System.out.println("Please enter a valid index from 1 to " + text.size());
            }
            break;

            //Delete
            case "d":
            case "D":
            System.out.println("Which message would you like to delete?");
            System.out.print(text + "\n[ Pick from 1 - 5]\nEnter choice: ");
            int n = console.nextInt();
            if(n<5 && n>0){
                n--;
                text.remove(n);
            }
            else{
                System.out.println("Please enter from 1 - 5");
            }
            break;
            //Exit
            case "e":
            case "E":
            System.out.println("Input again:\n[ Y / N ]");
            choice = console.nextLine();
            }
        }
        while(!choice.equals("N")&& !choice.equals("n"));
        System.out.println("Thank you for using the system. Have a nice day!");
        
    }
     
}
