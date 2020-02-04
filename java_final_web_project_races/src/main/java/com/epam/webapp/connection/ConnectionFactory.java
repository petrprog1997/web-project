package com.epam.webapp.connection;

import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    //private static final URL _PROPERTY_FILE = ConnectionFactory.class.getClassLoader().getResource(".\\src\\main\\java\\com\\epam\\webapp\\connection\\database.properties");
    private static final String FILE_PATH = ".\\src\\main\\java\\com\\epam\\webapp\\connection\\database.properties";
    private static final String DRIVER = "db.driver";
    private static final String URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";
    private static final String POOL_SIZE = "db.poolSize";


    public static ProxyConnection create(ConnectionPool connectionPool) throws ServiceException {
        Properties properties = new Properties();
        String url = null;
        String user = null;
        String password = null;
        Connection connection = null;

        try(InputStream in = Files.newInputStream(Paths.get(FILE_PATH))){
            properties.load(in);
            String driver = properties.getProperty(DRIVER);
            Class.forName(driver);
            url = properties.getProperty(URL);
            user = properties.getProperty(USER);
            password = properties.getProperty(PASSWORD);
            connection = DriverManager.getConnection(url,user,password);
        } catch (IOException  | ClassNotFoundException e) {
            throw new ServiceException(e);
        }  catch (SQLException e) {
            throw new DaoException(e);
        }
        return new ProxyConnection(connection,connectionPool);
    }
}
