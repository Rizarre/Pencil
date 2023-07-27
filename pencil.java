import java.util.Scanner;
import java.util.ArrayList;

public class pencil {
    ArrayList <String> text = new ArrayList<String>();
    Scanner console = new Scanner(System.in);
    String pencilChoice = "";
    int messageSize = 0;
    int graphiteLimit = 50;
    int colorLimit = 30;

    public static void main(String args[]){
        pencil pencil = new pencil();
        pencil.run();
    }

    public void run(){
        String choice;

        do{
            System.out.print("Choose an option:\n[ A ] Add\n[ B ] Read \n[ C ] Update \n[ D ] Delete \n[ E ] Exit\nEnter Choice: ");
            choice = console.nextLine();

            switch(choice.toUpperCase()){

            //Add
            case "A":
                int size = text.size();
                
                if(size<=5){
                        if(pencilChoice.isEmpty()){
                        System.out.print("Pick a pencil:\n[ A ] Graphite\n[ B ] Colored\nEnter Choice: ");
                        pencilChoice = console.nextLine().toUpperCase();
                        }

                        if(pencilChoice.equals("A")){
                            graphite();
                        }
                        else if(pencilChoice.equals("B")){
                            color();
                        } else{
                            System.out.println("Please choose again.");
                            pencilChoice = "";
                        }
                }
                else{
                    System.out.println("You cannot write more than 5 messages. Delete a message first.");
                }
            break;

            //Read
            case "B":
            System.out.println("Messages:\n" + text);
            break;

            //Update
            case "C":
                update();
            break;

            //Delete
            case "D":
                delete();
            break;
            //Exit
            case "E":
            System.out.println("Input again:\n[ Y / N ]");
            choice = console.nextLine().toUpperCase();
            if(choice.equals("N")){
                console.close();
                System.out.println("Thank you for using the system. Have a nice day!");
                return;
            }
            continue;

            default:
            System.out.println("Please choose again.");
            }
        }
        while(!choice.equals("N"));
    }
     
    public void graphite(){
        System.out.print("Write your message: ");
        String write = console.nextLine();
        String replace = write.replaceAll(" ", "");
        int length = replace.length();

        messageSize = messageSize + length;
        int limit = graphiteLimit - messageSize;
        
        if(length<=limit){
            text.add(write);
            System.out.println("Remaining characters available: " + limit);
        }
        else{
            System.out.println("You cannot write more than 50 characters.");
        }
        pencilChoice = "A";
    }

    public void color(){
        System.out.print("Write your message: ");
        String write = console.nextLine();
        String replace = write.replaceAll(" ", "");
        int length = replace.length();

        messageSize = messageSize + length;
        int limit = colorLimit - messageSize;
        
        if(length<=limit){
            text.add(write);
            System.out.println("Remaining characters available: " + limit);
        }
        else{
            System.out.println("You cannot write more than 50 characters.");
        }
        pencilChoice = "B";
    }

    public void update(){
        System.out.println("Which message would you like to update?");
            System.out.print(text + "\n[ Pick from 1 - 5]\nEnter choice: ");
            int i = console.nextInt();
                    console.nextLine();
            
            System.out.println("Chosen message: " + text.get(2));

            if(i<=text.size()){
                if (i >= 1 && i <= text.size()) {
                System.out.print("Enter new message: ");
                String newMessage = console.nextLine();
                text.set(i - 1, newMessage);
                } 
                else {
                System.out.println("Please enter a valid index from 1 to " + text.size());
                }
            }
            else if(i<0){
                System.out.println("Please enter a number above 0.");
            }
            else{
                System.out.println("Sorry, there are only " + text.size() + " message/s available for update.");
            }
    }

    public void delete(){
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
    }

}