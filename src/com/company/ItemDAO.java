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

    public ArrayList<Music> searchbyKeyWord () throws SQLException {

        ResultSet resultSet = null;
        ArrayList<Music> music = new ArrayList<> ();

        try {
            con = DriverManager.getConnection (connectioncl.getUrl (), connectioncl.getUsername (), connectioncl.getPass ());
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        try {
            statement = con.createStatement ();
            resultSet = statement.executeQuery ("SELECT *" +
                    "FROM `Item` " +
                    "WHERE `Title` LIKE '%in%' ");
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        while (resultSet.next ()) {
            music.add (new Music (resultSet.getString (2), resultSet.getString (3), resultSet.getString (4), resultSet.getInt (5), resultSet.getInt (6), resultSet.getInt (7)));
        }
        statement.close ();
        return music;

    }

    public void insertJDBC (Music music) throws SQLException {

        try {
            Class.forName ("java.sql.DriverManager");
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
            return;
        }

        try {
            con = DriverManager.getConnection (connectioncl.getUrl (), connectioncl.getUsername (), connectioncl.getPass ());
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        try {
            statement = con.createStatement ();
            statement.executeUpdate ("INSERT INTO Item VALUES (DEFAULT, '" + music.getTitle () + "', '" + music.getArtist () + "', date '" + music.getDate () + "'," + music.getListPrice () + "," + music.getPrice () + ",1);\n");
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        statement.close ();

    }

    public void deleteDB (String name) throws SQLException {

        try {
            Class.forName ("java.sql.DriverManager");
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
            return;
        }

        try {
            con = DriverManager.getConnection (connectioncl.getUrl (), connectioncl.getUsername (), connectioncl.getPass ());
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        try {
            statement = con.createStatement ();
            statement.executeUpdate ("DELETE FROM Item WHERE id > 2 OR Title LIKE '" + name + "'");
        } catch (SQLException e) {
            e.printStackTrace ();
            return;
        }
        statement.close ();

    }
}
