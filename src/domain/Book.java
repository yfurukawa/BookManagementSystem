/**
 * 
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author vagrant
 *
 */
@ManagedBean
@ViewScoped
public class Book implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String isbn;
    private String name;
    private String author;
    private Integer price;
    private Date buyDate;
    private List<String> bookTypes;
    private String bookType;
    private String status;
    
    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status セットする status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 
     */
    @PostConstruct
    public void init() {
        bookTypes = new ArrayList<String>();
        bookTypes.add("単行本");
        bookTypes.add("プログラミング");
        bookTypes.add("開発プロセス");
        bookTypes.add("小説");
        bookTypes.add("ビジネス");
        
        setStatus("/resources/images/led_green.png");
    }
    /**
     * @return bookTypes
     */
    public List<String> getBookTypes() {
        return bookTypes;
    }
    /**
     * @return buyDate
     */
    public Date getBuyDate() {
        return buyDate;
    }
    /**
     * @param buyDate セットする buyDate
     */
    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
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
        return name+"Hoge";
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
    public Integer getPrice() {
        return price;
    }
    /**
     * @param price セットする price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * @return bookType
     */
    public String getBookType() {
        return bookType;
    }
    /**
     * @param bookType セットする bookType
     */
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
