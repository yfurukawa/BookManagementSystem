package domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author vagrant
 *
 */
public class SQLStatementMakerTest {
    SQLStatementMaker sut = null;
    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        sut = new SQLStatementMaker();
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * 
     */
    @Test
    public void testMakeStatement_isbnのみ() {
        List<String> fields = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        fields.add("isbn");
        values.add("987");
        
        assertThat(sut.makeStatement("book", fields, values), is("SELECT * FROM book WHERE isbn LIKE '987%'"));
    }

    /**
     * 
     */
    @Test
    public void testMakeStatement_nameのみ() {
        List<String> fields = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        fields.add("name");
        values.add("CSS");
        
        assertThat(sut.makeStatement("book", fields, values), is("SELECT * FROM book WHERE name LIKE '%CSS%'"));
    }
    
    /**
     * 
     */
    @Test
    public void testMakeStatement_authorのみ() {
        List<String> fields = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        fields.add("author");
        values.add("宮本");
        
        assertThat(sut.makeStatement("book", fields, values), is("SELECT * FROM book WHERE author LIKE '%宮本%'"));
    }
    
    /**
     * 
     */
    @Test
    public void testMakeStatement_isbnとname() {
        List<String> fields = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        fields.add("isbn");
        values.add("978");
        fields.add("name");
        values.add("CSS");
        
        assertThat(sut.makeStatement("book", fields, values), is("SELECT * FROM book WHERE isbn LIKE '978%' AND name LIKE '%CSS%'"));
    }
    
    /**
     * 
     */
    @Test
    public void testMakeStatement_isbnとauthor() {
        List<String> fields = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        fields.add("isbn");
        values.add("978");
        fields.add("author");
        values.add("宮本");
        
        assertThat(sut.makeStatement("book", fields, values), is("SELECT * FROM book WHERE isbn LIKE '978%' AND author LIKE '%宮本%'"));
    }
    
    /**
     * 
     */
    @Test
    public void testMakeStatement_isbnとnameとauthor() {
        List<String> fields = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        fields.add("isbn");
        values.add("978");
        fields.add("name");
        values.add("CSS");
        fields.add("author");
        values.add("宮本");
        
        assertThat(sut.makeStatement("book", fields, values), is("SELECT * FROM book WHERE isbn LIKE '978%' AND name LIKE '%CSS%' AND author LIKE '%宮本%'"));
    }
}
