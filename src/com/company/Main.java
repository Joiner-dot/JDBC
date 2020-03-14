package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main ( String[] args ) throws SQLException {
        Connectioncl connectioncl = new Connectioncl ( "root", "8951fdsa", "localhost", "Lab5", "3306" );
        ItemDAO dao = new ItemDAO ( connectioncl );
        Music music = dao.searchbyID ( );
        ArrayList<Music> music1 = dao.searchbyKeyWord ( );
        System.out.println ( music1.get ( 0 ).getTitle ( ) );
        System.out.println ( music.getTitle ( ) );
        dao.deleteDB ( "%Rock%" );
        Scanner scanner = new Scanner ( System.in );
        Music music2 = new Music ( "Firestone", "Kygo", "2010-10-02", 15, 10, 1 );
        dao.insertJDBC ( music2 );
    }
}
