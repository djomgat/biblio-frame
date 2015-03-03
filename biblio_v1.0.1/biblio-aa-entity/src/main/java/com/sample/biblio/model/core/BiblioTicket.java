package com.sample.biblio.model.core;

public class BiblioTicket {

    String userName;
    String hostname;
    String hostIpAdress;

    public String getUserName() {
            return userName;
    }
    public void setUserName(String userName) {
            this.userName = userName;
    }
    public String getHostname() {
            return hostname;
    }
    public void setHostname(String hostname) {
            this.hostname = hostname;
    }
    public String getHostIpAdress() {
            return hostIpAdress;
    }
    public void setHostIpAdress(String hostIpAdress) {
            this.hostIpAdress = hostIpAdress;
    }
	
}