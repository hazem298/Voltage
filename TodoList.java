/*
 It's a code for a protected TodoList application */
package newpackage;
import java.util.Scanner;


public class ToDoList1 {

  //Variables
  private String[] Todo; 
  private int count;     //how many tasks have been added to todo


  
  public ToDoList1() {
    this.Todo = new String[50];
    this.count = 0;         //the start of the empty list ready to be used 
  }

 
  public boolean add(String item) {
    if (this.count == this.Todo.length) {
      return false;          //when it reached the limit it return false to prevent user from adding more than 50 tasks 
     
    }else {
      this.Todo[count] = item;
      this.count++;
      return true;          //if the tasks less than 50 the user can add more tasks
    }
  }

  
  public int getlength() {
    return count;           // to count how many tasks in the list
  }

  
  public String remove(int index) {
    if (index < 1 || index > this.count) {
      return null;  // to remove a precise task in the list by writing the index of it, it fails when the user enters invalid index
     
    }else {
      index--;              // to convert it the a zero based array and use shifting to delete the unwanted task
      String deleted = this.Todo[index];
    
      for (int i = index; i < this.count - 1; i++) {
        this.Todo[i] = this.Todo[i + 1];
      }
      this.count--;             //removing the unwanted task
      return deleted;
    }
  }

  
  public String toString() {
    String output = "           --------------> TODO: \n                                 ";
    for (int i = 0; i < this.count; i++) {
      output += (i + 1) + ". " + this.Todo[i] + "      \n";       //to call toString and show the tasks after "TODO:"
    }
    return output;
  }

//to protect the privacy of the user we made a login with precise username and password if the user enter the wrong information the code fails
  
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);
    ToDoList1 list = new ToDoList1();
   
    String Username;
    String Password;
    
    
    Username = "Admin";
    Password = "P@ssword";
    

    
    Scanner input1 = new Scanner(System.in);
    System.out.println("Enter The Username Please: ");
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.println("and now enter your password: ");
    String password = input2.next();

    if (username.equals(Username) && password.equals(Password)) {

        System.out.println("Access Granted! Welcome to your ToDolist (^_^)!");
    }

    else if (username.equals(Username)) {
        System.out.println("Invalid Password!"
                + "*Access Denied!");
        System.exit(0);
    } else if (password.equals(Password)) {
        System.out.println("Invalid Username!"
                + "Access Denied!");
           System.exit(0);
    } else {
        
        System.out.println("Invalid Username & Password!"
                + "Access Denied!");
           System.exit(0);
    }

    int option = 1;
    while (option != 0) {
                                                                // to start showing the menu after the user enters the right username and password
      
      System.out.println(list);  //calls toString()and shows the options 

                                                        //print menu options
      System.out.println("***   MENU:  ***");
      System.out.println("1 - Add Tasks");
      System.out.println("2 - Remove last Task");
      System.out.println("3 - Remove specific Task");
      System.out.println("0 - Exit");
      System.out.print("Enter your menu choice: (using index)");

                                            //process user's menu options
      try {
        option = input.nextInt();
        input.nextLine();                                           //clears input field 
        switch (option) {
          case 1:                                           //for adding tasks  
            System.out.print("Enter the thing you want to do: ");
            String task = input.nextLine();
            boolean added = list.add(task);
            System.out.println("Added Successfully!");
            if (!added) {
              System.out.println("Sorry, YOU HAVE ALREADY 50 TASKS DO SOME OF IT!!");
            }
            break;

           case 2:  //to remove the last task the user entered
            String removed = list.remove(list.getlength());
            if (removed != null) {
              System.out.println("           Removed: " + removed);
            }else {
              System.out.println("The List is already Clear!!.");
            }
            
            
            break;

          case 3:                   //to remove precise task the don't want anymore
            System.out.print("Enter the index of the task to remove: ");
            int index = input.nextInt();
            removed = list.remove(index);
            if (removed != null) {
              System.out.println("YOU DELETED!: " + removed);
            }else {
              System.out.println("Please make sure that you entered the right index " +
                  index + ".");
            }
            break;

          case 0:
            System.out.println("See you later!");
            break;

          default:
            System.out.println("Sorry, but " + option + " is not one of " +
                "the menu choices. Make sure that you are entering the right index!.");
            break;
        }
      }catch (java.util.InputMismatchException ime) {
        System.out.println("Sorry, but you must enter a number.");
        input.nextLine();  //clear bad input from stream
      }
    }                                                   // end of the cases
  }
}
    
   

