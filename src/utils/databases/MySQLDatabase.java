package utils.databases;

public class MySQLDatabase extends DataSource{

	public static final String MYSQL_DRIVER ="com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE ="jdbc:mysql:";

	public MySQLDatabase() {
		// TODO Auto-generated constructor stub
	}
	
	public MySQLDatabase(String host , String source , String user , String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, password);
	}
	
	public MySQLDatabase(String host , String source , String user ) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, "");
	}
	public MySQLDatabase(String host , String source  ) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, "root", "");
	}
	
	public MySQLDatabase( String source ) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, "root", "");
	}
	
	
	public String getURL() {
		
		return getBridge()+"//"+getHost()+"/"+getSource()+ "?useUnicode=yes&characterEncoding=UTF-8";
	}

	public String startDelimiter() {
	
		return "'";
	}


	public String endDelimiter() {
	
		return "'";
	}

}
