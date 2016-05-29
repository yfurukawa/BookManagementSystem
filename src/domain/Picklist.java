/**
 * 
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

/**
 * @author vagrant
 *
 */
@ManagedBean
@ViewScoped
public class Picklist implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<String> dataSource;
    private List<String> dataDist;
    private DualListModel<String> data;
    /**
     * 
     */
    @PostConstruct
    public void init() {
        dataSource = new ArrayList<String>();
        dataDist = new ArrayList<String>();
        dataSource.add("str1");
        dataSource.add("str2");
        dataSource.add("asdfghjkl");
        dataSource.add("qwertyui");

        setData(new DualListModel<String>(dataSource, dataDist));
    }
    
    /**
     * @return dataSource
     */
    public List<String> getDataSource() {
        return dataSource;
    }
    /**
     * @param dataSource セットする dataSource
     */
    public void setDataSource(List<String> dataSource) {
        this.dataSource = dataSource;
    }
    /**
     * @return dataDist
     */
    public List<String> getDataDist() {
        return dataDist;
    }
    /**
     * @param dataDist セットする dataDist
     */
    public void setDataDist(List<String> dataDist) {
        this.dataDist = dataDist;
    }

    /**
     * @return data
     */
    public DualListModel<String> getData() {
        return data;
    }

    /**
     * @param data セットする data
     */
    public void setData(DualListModel<String> data) {
        this.data = data;
    }
    
    
}
