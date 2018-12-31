package utils.databases;

import java.sql.Connection;
import java.sql.DriverManager;

abstract  public class DataSource {

	private String driver;
	private String bridge ;
	private String host ;
	private String source ;
	private String user ;
	private String password ;
	private Connection db ;
	
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
				
				System.out.println("Connexion bien �tablie");
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
