/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalfrio.ms.dalagger2;

/**
 *
 * @author ferreiral
 */
public class Config {

    /* host */
    private String ip;
    private String hostname;

    /* coletor */
    private int intevalo;

    /* database */
    private String server;
    private String database;
    private String user;
    private String pass;
    private String porta;
    private int taxa;

    public Config() {
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname the hostname to set
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return the intevalo
     */
    public int getIntevalo() {
        return intevalo;
    }

    /**
     * @param intevalo the intevalo to set
     */
    public void setIntevalo(int intevalo) {
        this.intevalo = intevalo;
    }
    
     public void setIntevalo(String intevalo) {
        this.intevalo = Integer.parseInt(intevalo);
    }

    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    void setPorta(String porta) {
        this.porta = porta;
    }

    void setTaxa(String taxa) {
        this.taxa = Integer.parseInt(taxa);
    }
    void setTaxa(int taxa) {
        this.taxa = taxa;
    }

    /**
     * @return the porta
     */
    public String getPorta() {
        return porta;
    }

    /**
     * @return the taxa
     */
    public int getTaxa() {
        return taxa;
    }

}
