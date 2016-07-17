/**
 * 
 */
package view;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

/**
 * @author vagrant
 *
 */
@ManagedBean
@SessionScoped
public class CalendarView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Timestamp dateBeginSql;
    private Timestamp dateEndSql;
    private Date dateBegin;
    private Date dateEnd;
    
    /**
     * 
     */
    public void check() {
        System.out.println(new SimpleDateFormat("yyyy/mm/dd").format(dateBegin));
        System.out.println(new SimpleDateFormat("yyyy/mm/dd").format(dateEnd));
    }

    /**
     * @param event
     */
    public void limitBeginDate(SelectEvent event) {
        dateBegin = (Date)event.getObject();
        System.out.println(new SimpleDateFormat("yyyy/mm/dd").format(event.getObject()));
    }
    
    /**
     * @param event
     */
    public void limitEndDate(SelectEvent event) {
        dateEnd = (Date)event.getObject();
        System.out.println(new SimpleDateFormat("yyyy/mm/dd").format(event.getObject()));
    }
    /**
     * @return h
     */
    public Timestamp getDateBeginSql() {
        return dateBeginSql;
    }
    /**
     * @param dateBeginSql
     */
    public void setDateBeginSql(Timestamp dateBeginSql) {
        this.dateBeginSql = dateBeginSql;
    }
    /**
     * @return j
     */
    public Timestamp getDateEndSql() {
        return dateEndSql;
    }
    /**
     * @param dateEndSql
     */
    public void setDateEndSql(Timestamp dateEndSql) {
        this.dateEndSql = dateEndSql;
    }
    /**
     * @param dateBegin
     */
    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }
    /**
     * @param dateEnd
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    /**
     * @return hj
     */
    public Date getDateBegin() {
        return dateBegin;
    }
    /**
     * @return kj
     */
    public Date getDateEnd() {
        return dateEnd;
    }

}
