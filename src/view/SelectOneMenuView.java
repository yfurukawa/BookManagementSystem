/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 * @author vagrant
 *
 */
@ManagedBean
public class SelectOneMenuView {
    private String selectedField;
    private List<SelectItem> fields;
    private List<String> logicalOperatorFields;
    private String selectedOperator;
    private List<SelectItem> logicalOperator;
    private List<SelectItem> stringOperator;
    private boolean isLogicalOperator = true;
    
    /**
     * 
     */
    @PostConstruct
    public void init(){
        fields = new ArrayList<SelectItem>();
        fields.add(new SelectItem("PN", "PartsNumber"));
        fields.add(new SelectItem("Description", "Description"));
        fields.add(new SelectItem("Weight", "Weight"));
        fields.add(new SelectItem("Height", "Height"));
        fields.add(new SelectItem("Width", "Width"));
        
        logicalOperatorFields = new ArrayList<String>();
        logicalOperatorFields.add("Weight");
        logicalOperatorFields.add("Height");
        logicalOperatorFields.add("Width");
        
        logicalOperator = new ArrayList<SelectItem>();
        logicalOperator.add(new SelectItem("eq", "="));
        logicalOperator.add(new SelectItem("lt", "<"));
        logicalOperator.add(new SelectItem("le", "<="));
        logicalOperator.add(new SelectItem("gt", ">"));
        logicalOperator.add(new SelectItem("ge", ">="));
        
        stringOperator = new ArrayList<SelectItem>();
        stringOperator.add(new SelectItem("contain", "を含む"));
        stringOperator.add(new SelectItem("NotContain", "を含まない"));
        stringOperator.add(new SelectItem("startWith", "で始まる"));
        stringOperator.add(new SelectItem("endWith", "で終わる"));
    }

    /**
     * 
     */
    public void changeOperator() {
        if(logicalOperatorFields.contains(selectedField)) {
            setLogicalOperator(true);
        }
        else {
            setLogicalOperator(false);
        }
    }

    /**
     * @return selectedField
     */
    public String getSelectedField() {
        return selectedField;
    }

    /**
     * @param selectedField セットする selectedField
     */
    public void setSelectedField(String selectedField) {
        this.selectedField = selectedField;
    }

    /**
     * @return fields
     */
    public List<SelectItem> getFields() {
        return fields;
    }

    /**
     * @param fields セットする fields
     */
    public void setFields(List<SelectItem> fields) {
        this.fields = fields;
    }

    /**
     * @return selectedOperator
     */
    public String getSelectedOperator() {
        return selectedOperator;
    }

    /**
     * @param selectedOperator セットする selectedOperator
     */
    public void setSelectedOperator(String selectedOperator) {
        this.selectedOperator = selectedOperator;
    }

    /**
     * @return logicalOperator
     */
    public List<SelectItem> getLogicalOperator() {
        return logicalOperator;
    }

    /**
     * @param logicalOperator セットする logicalOperator
     */
    public void setLogicalOperator(List<SelectItem> logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    /**
     * @return stringOperator
     */
    public List<SelectItem> getStringOperator() {
        return stringOperator;
    }

    /**
     * @param stringOperator セットする stringOperator
     */
    public void setStringOperator(List<SelectItem> stringOperator) {
        this.stringOperator = stringOperator;
    }
    
    /**
     * @return operator
     */
    public List<SelectItem> getOperator() {
        if(isLogicalOperator) {
            return getLogicalOperator();
        }
        else {
            return getStringOperator();
        }
    }

    /**
     * @return isLogicalOperator
     */
    public boolean isLogicalOperator() {
        return isLogicalOperator;
    }

    /**
     * @param isLogicalOperator セットする isLogicalOperator
     */
    public void setLogicalOperator(boolean isLogicalOperator) {
        this.isLogicalOperator = isLogicalOperator;
    }
}
