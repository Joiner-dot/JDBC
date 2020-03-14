package com.company;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDAO {

    ItemDAO (Connectioncl connectioncl) {
        this.connectioncl = connectioncl;
    }

    Connectioncl connectioncl;
    Connection con;
    Statement statement;
    public Music searchbyID () throws SQLException {

        ResultSet resultSet = null;
        Music music = null;

        try {
            Class.forName ("java.sql.DriverManager");
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();

        }

        try {
            con = DriverManager.getConnection (connectioncl.getUrl (), connectioncl.getUsername (), connectioncl.getPass ());
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        try {
            statement = con.createStatement ();
            resultSet = statement.executeQuery ("SELECT *" +
                    "FROM `Item` " +
                    "WHERE `id`=1");
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        while (resultSet.next ()) {
            music = new Music (resultSet.getString (2), resultSet.getString (3), resultSet.getString (4), resultSet.getInt (5), resultSet.getInt (6), resultSet.getInt (7));
        }
        statement.close ();
        return music;

    }

}
