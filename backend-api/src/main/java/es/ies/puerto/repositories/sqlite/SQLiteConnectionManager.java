package es.ies.puerto.repositories.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQLiteConnectionManager {

    private final String databaseUrl;

    protected SQLiteConnectionManager(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    protected Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(databaseUrl);

        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON;");
        }

        return connection;
    }
}