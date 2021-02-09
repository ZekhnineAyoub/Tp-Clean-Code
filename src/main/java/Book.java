public class Book {

    private  String title;
    private  String author;

    public Book(){

        title = null;
        author= null;

    }

    public Book(String title, String author){

        this.title = title;
        this.author = author;

    }

    @Override
    public String toString(){

        return "\nTitle: "+ title + "\nAuthor: " + author +"\n";
    }


}
