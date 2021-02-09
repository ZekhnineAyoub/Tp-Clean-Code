import java.io.*;
import java.util.Scanner;

public class Main {

    static String fileName = null;
    static Library library = new Library();
    static Scanner in = new Scanner(System.in);
    static Boolean running = true;

    public static void main(String[] arg){
        //exemple d'un livre
        //Book book = new Book("potter","Jack");
        //System.out.println(book.toString());
        while (running){

           System.out.println("\n Enter 0 To add and reference a new book in the library"
                   + "\n Enter 1 To see the content of the library"
                   + "\n Enter 2 for save and quit"
                   + "\n Enter 3 for load a library");

           int answer = in.nextInt();
           switch (answer){

               case 0:
                   addBook();
                   break;

               case 1:
                   System.out.println(library.toString());

                   break;

               case 2:
                   try {
                       saveAndQuite();
                   } catch (FileNotFoundException e) {
                       e.printStackTrace();
                   }
                   break;

               case 3 :
                   System.out.println("Enter the file name to load");
                   loadScript(in.next());
                   break;
           }

        }
         System.exit(0);
    }

    private static void addBook() {
          String title;
          String author;
          System.out.println("\nEnter title: ");
          title = in.next();
          System.out.println("\nEnter Author: ");
          author= in.next();

          Book b = new Book(title,author);
          library.addBook(b);

    }

    private static void saveAndQuite() throws FileNotFoundException {
        System.out.println("enter file name : ");
        fileName = in.next()+ ".ser";
        running = false;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream  = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(library);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadScript(String name) {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        File file = new File(name + ".ser");
        if(file.exists()) {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                library = (Library) in.readObject();
                fis.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {

            System.out.println("\n the file does not exist ");

        }
    }

}
