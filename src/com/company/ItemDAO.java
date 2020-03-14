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
    
}
