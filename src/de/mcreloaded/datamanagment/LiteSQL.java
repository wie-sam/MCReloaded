package de.mcreloaded.datamanagment;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.mcreloaded.core.Constants;
import de.mcreloaded.core.Core;
import de.mcreloaded.tools.ConsoleLogger;
import de.mcreloaded.tools.ConsoleLogger.ConsoleLoggerNames;

public class LiteSQL {

	private final Connection conn;
	private final Statement stmt;

	public LiteSQL() throws SQLException, IOException {
		final String path = Core.getPlugin().getDataFolder().getAbsolutePath() + "/database.db";
		final File database = new File(path);
		if (!database.exists()) {
			ConsoleLogger.debug(ConsoleLoggerNames.LITESQL.getDisplayName(), "Creating "+Constants.NAME+" database in " + path);
			database.createNewFile();
		}

		String url = "jdbc:sqlite:" + path;
		conn = DriverManager.getConnection(url);
		stmt = conn.createStatement();
		
		onUpdate("CREATE TABLE IF NOT EXISTs playerdata(PK_Playerdata_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, uuid VARCHAR, ipadresse VARCHAR)");
		onUpdate("CREATE TABLE IF NOT EXISTs achievements(FK_Playerdata_ID INTEGER NOT NULL, achievementid INTEGER NOT NULL, timeclaimed INTEGER NOT NULL)");
		ConsoleLogger.info(ConsoleLoggerNames.LITESQL.getDisplayName(), "The connection to the database was established successfully.");

	}

	public void disconnect() {
		try {
			if (isConnected()) {
				conn.close();
				ConsoleLogger.info(ConsoleLoggerNames.LITESQL.getDisplayName(), "The connection to the database was successfully terminated.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isConnected() {
		return (conn == null ? false : true);
	}

	public Connection getConnection() {
		return conn;
	}

	public void onUpdate(String sql) {
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet onQuery(String sql) {
		try {
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}