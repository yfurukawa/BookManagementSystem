/**
 * 
 */
package view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import domain.Book;
import domain.Resister;

/**
 * @author vagrant
 *
 */
@ManagedBean(name="resistringView")
@ViewScoped
public class ResistringView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Resister resister;
    private Book book;
    
    /**
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book セットする book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 
     */
    @PostConstruct
    public void init() {
        setResister(new Resister());
        setBook(new Book());
    }

    /**
     * @return resister
     */
    public Resister getResister() {
        return resister;
    }

    /**
     * @param resister セットする resister
     */
    public void setResister(Resister resister) {
        this.resister = resister;
    }

}
