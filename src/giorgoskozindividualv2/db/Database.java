
package giorgoskozindividualv2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giorgoskoz
 */
public class Database {
    
    private static Class dbClass;
    private static String server = "localhost:3306";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String database ="giorgoskozindividualv2";
    private static String username = "giorgoskozindividualv2Admin";
    private static String password = "giorgoskozindividualv2Admin";
    private String options = "?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";

    public Database() {
        this.Database();
    }
    
    public Database Database() {
        this.registerDriver();
        return this;
    }
    
    // executeUpdate
    public int Database(String query, byte type) {
//        this.setServer(server);
//        this.setDatabase(database);
//        this.setUsername(username);
//        this.setPassword(password);
        
        try {
            return executeStatement(this.connectToDB(this.getServer()).createStatement(), query, type);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return -1;
    }
    
    
    // executeQuery
    public ResultSet Database(String query) {
//        this.setServer(server);
//        this.setDatabase(database);
//        this.setUsername(username);
//        this.setPassword(password);
        
        try {
            return this.executeStatement(this.connectToDB(this.getServer()).createStatement(), query, (byte)0);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }

    public String getOptions() {
        return this.options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
    
    public String getServer() {
        return this.server;
    }

    public void setServer(String aServer) {
        this.server = aServer;
    }

    public String getDatabase() {
        return this.database;
    }

    public void setDatabase(String aDatabase) {
        this.database = aDatabase;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String aUsername) {
        this.username = aUsername;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String aPassword) {
        this.password = aPassword;
    }
    
    public void registerDriver() {
        try {
          dbClass = Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    public String getJDBCURL() {
        return "jdbc:mysql://";
    }
    
    public String getConnectionURL() {
        return this.getJDBCURL() + this.getServer() + "/" + this.getDatabase() + this.getOptions() + "," + this.getUsername() + "," + this.getPassword();
    }
    
    public String getFULLConnectionURL() {
        return this.getJDBCURL() + this.getServer() + "/" + this.getDatabase() + this.getOptions() + "," + this.getUsername() + "," + this.getPassword();
    }
    
    /**
     *
     * @return a Connection Object
     */
    public Connection connectToDB() {
        Connection connection = null; 
        try {
            connection = DriverManager.getConnection(this.getConnectionURL(), this.getUsername(), this.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return connection;
    }
    
    /**
     *
     * @param URL = server, e.g. localhost:3306
     * @return a Connection Object
     */
    public Connection connectToDB(String URL) {
        Connection connection = null; 
        try {
            connection = DriverManager.getConnection(this.getConnectionURL(), this.getUsername(), this.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return connection;
    }
    
    /**
     *
     * @return a Statement Object
     */
    public Statement createStatement() {
        try {
            return connectToDB().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    public <T> T executeStatement(Statement statement, String query, byte type) {
        switch(type) {
            case 0:
                return (T) executeQuery(statement,query);
            case 1:
                return (T) executeUpdate(statement,query);
        }
        return null;
    }
    
    private ResultSet executeQuery(Statement statement, String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    private Integer executeUpdate(Statement statement, String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return -1;
        }
    }
    
}
