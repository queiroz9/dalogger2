/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalfrio.ms.dalogger2;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ferreiral
 * @email ferreiral@metalfrio.com.br
 */
public class Dalogger2 {

    private ControlePorta porta;

    private static String fileConfig = "config.properties";

    //porta com5 para teste
    private static int COM5 = 1;
    private String COMANDO = "*trg";
    private final Config c;

    /**
     * Construtor da classe Dalogger2
     */
    public Dalogger2() {
         c = abreConfig();
        porta = new ControlePorta(c.getPorta(), c.getTaxa());//windows - porta e taxa de transmissão
        //porta = new ControlePorta("/dev/ttyUSB0", 9600);//linux - porta e taxa de transmissão

        leFluke();
        
        //porta.enviaDados(COMANDO);

        //porta.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dalogger2 x = new Dalogger2();

        //porta.enviaDados("*TRG");
    }

    private static Config abreConfig() {
        Config config = new Config();
        try {
            Properties prop = new Properties();
            InputStream input = null;

            input = new FileInputStream(fileConfig);
            //carrega as propriedade do arquivo
            prop.load(input);

            config.setIp(prop.getProperty("ip"));
            config.setHostname(prop.getProperty("hostname"));
            config.setIntevalo(prop.getProperty("intervalo", "60"));
            config.setServer(prop.getProperty("server"));
            config.setUser(prop.getProperty("user"));
            config.setPass(prop.getProperty("pass"));
            config.setPorta(prop.getProperty("porta"));
            config.setTaxa(prop.getProperty("taxa", "9600"));

        } catch (IOException ex) {
            mensagem("Problema ao abrir o arquivo: " + fileConfig);
            Logger.getLogger(Dalogger2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return config;

    }

    private void leFluke() {
       // while (true) {
            porta.enviaDados(COMANDO);
            try {
                Thread.sleep(c.getIntevalo()*1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Dalogger2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //porta.recebeDados();
        //}

    }

    public static void mensagem(String msg) {
        System.out.println(":: " + msg);
    }

   

    private static void initSerialPort() {

    }

}
