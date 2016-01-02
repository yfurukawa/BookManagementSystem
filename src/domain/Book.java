/**
 * 
 */
package domain;

/**
 * @author vagrant
 *
 */
public class Book {
    private String isbn;
    private String name;
    private String author;
    private int price;
    /**
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * @param isbn セットする isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name セットする name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }
    /**
     * @param author セットする author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * @return price
     */
    public int getPrice() {
        return price;
    }
    /**
     * @param price セットする price
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
