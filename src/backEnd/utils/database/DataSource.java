package backEnd.utils.database;

import java.sql.Connection;
import java.sql.DriverManager;

abstract  public class DataSource {

	protected String driver;
    protected String bridge ;
    protected String host ;
    protected String source ;
    protected String user ;
    protected String password ;
    protected Connection db ;

	public DataSource() {
	}

	public DataSource(String driver, String bridge, String host, String source, String user, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.host = host;
		this.source = source;
		this.user = user;
		this.password = password;
	
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getDb() {
		return db;
	}

	public void setDb(Connection db) {
		this.db = db;
	}

	public Connection getConnection() {
		try {
			// 1 chargement du driver 	 
				Class.forName(driver);
			// 2 connexion
				Connection db=DriverManager.getConnection(getURL(),user,password);
                    System.out.println("*** Driver : "+driver);
                    System.out.println("*** BRIDGE: "+bridge);
                    System.out.println("*** HOST : "+host);
                    System.out.println("*** SOURCE : "+source);
                    System.out.println("*** USER : "+user);
                    System.out.println("*** PASSWORD : "+password);
                    System.out.println("*****************************");
                    System.out.println("***Connexion bien etablie***");
                    System.out.println("*****************************");
				return db ;
			} catch (Exception e) {
				System.out.println("erreur  : "+e.getMessage());
				return null;
			}
	}
	abstract public String getURL();
	abstract public String startDelimiter();
	abstract public String endDelimiter();
}
