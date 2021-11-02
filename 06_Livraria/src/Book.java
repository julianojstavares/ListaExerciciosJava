public class Book {
    private String title;
    private Author author;
    private Publisher publisher;

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @return Author return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return Publisher return the publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

}
