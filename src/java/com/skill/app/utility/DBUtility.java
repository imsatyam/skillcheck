/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill.app.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains the code to handle database connection and tx management
 *
 * @author Shubham Shandilya
 */
public class DBUtility {

    private static final Logger LOG = Logger.getLogger(DBUtility.class.getName());

    private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private static final String DEFAULT_USERNAME = "SYSTEM";
    private static final String DEFAULT_PASSWORD = "SHUBHAM";

    /**
     * This method return a connection with database
     *
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DEFAULT_DRIVER);
        Connection connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
        return connection;
    }

    /**
     * This method closes the connection
     *
     * @param connection
     */
    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "An error occurred while closing connection: ", e);
        }
    }

    /**
     * This method closes the statement
     *
     * @param statement
     */
    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "An error occurred while closing Statement: ", e);
        }
    }

    /**
     * This method closes the result set
     *
     * @param rs
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "An error occurred while closing Resultset: ", e);
        }
    }

    /**
     * This method rolls back any transaction
     *
     * @param connection
     */
    public static void rollback(Connection connection) {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "An error occurred during rollback: ", e);
        }
    }

    /**
     * This method sets auto commit as false. Hence modified data will not be
     * committed to database unless we commit.
     *
     * @param connection
     */
    public static void denyAutoCommit(Connection connection) {
        try {
            if (connection != null) {
                connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "An error occurred during rollback: ", e);
        }
    }

    /**
     * This method commits any transaction
     *
     * @param connection
     */
    public static void commit(Connection connection) {
        try {
            if (connection != null) {
                connection.commit();
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "An error occurred during rollback: ", e);
        }
    }

}
