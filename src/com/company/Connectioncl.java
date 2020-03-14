package com.company;

public class Connectioncl {

    Connectioncl (String username, String pass, String loc, String dbname, String port) {
        this.username = username;
        this.pass = pass;
        this.url = "jdbc:mysql://" + loc + ":" + port + "/" + dbname + "?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    }

    public String getUsername () {
        return username;
    }

    public String getPass () {
        return pass;
    }

    public String getUrl () {
        return url;
    }

    private String username, pass, url;

}
