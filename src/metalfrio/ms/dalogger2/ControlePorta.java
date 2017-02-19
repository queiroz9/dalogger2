/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalfrio.ms.dalogger2;

/**
 *
 * @author ferreiral
 */
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlePorta {

    private OutputStream serialOut;//envia dados
    private InputStream serialIn;//recebe dados;

    private final int taxa;
    private final String portaCOM;
    private boolean Escrita;
    private boolean Leitura;

    private OutputStream envia;
    private InputStream recebe;

    /**
     * Construtor da classe ControlePorta
     *
     * @param portaCOM - Porta COM que será utilizada para enviar os dados
     * @param taxa - Taxa de transferência da porta serial geralmente é 9600
     */
    public ControlePorta(String portaCOM, int taxa) {
        this.portaCOM = portaCOM;
        this.taxa = taxa;

        mensagem("Porta:: " + portaCOM);
        mensagem("Taxa:: " + taxa);
        mensagem("Conectando...");
        this.initialize();

        mensagem("Conectado...");

    }

    /**
     * Médoto que verifica se a comunicação com a porta serial está ok
     */
    private void initialize() {
        try {
            //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
            CommPortIdentifier portId = null;
            try {
                //Tenta verificar se a porta COM informada existe
                portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
            } catch (NoSuchPortException npe) {
                //Caso a porta COM não exista será exibido um erro 
                JOptionPane.showMessageDialog(null, "Porta " + this.portaCOM + " não encontrada.",
                        "Porta COM", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            //Abre a porta COM 
            SerialPort port = (SerialPort) portId.open("Comunicação serial", this.taxa);

            envia = port.getOutputStream();//envia dados
            recebe = port.getInputStream();//recebe dados

            (new Thread(new SerialReader(recebe))).start();
            (new Thread(new SerialWriter(envia))).start();

            port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial 
                    SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                    SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                    SerialPort.PARITY_NONE); //receber e enviar dados
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro na inicialização da porta COM",
                    "Porta COM", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Método que fecha a comunicação com a porta serial
     */
    public void close() {
        try {
            serialOut.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar porta " + this.portaCOM,
                    "Fechar porta COM", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param msg - Valor a ser enviado pela porta serial
     */
    public void enviaDados(String msg) {

        try {

            mensagem("Enviando Mensagem :: " + msg);
            envia.write(msg.getBytes());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ",
                    "Enviar dados", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ControlePorta.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            envia.flush();
        } catch (IOException ex) {
            Logger.getLogger(ControlePorta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String recebeDados() {
//        StringBuffer bufferLeitura = new StringBuffer();
//        try {
//            int str = recebe.read();
//
//            if (x == -1) {
//                break;
//            }
//
//            if ('\r' == (char) x) {
//                bufferLeitura.append('\n');
//            } else {
//                bufferLeitura.append((char) novoDado);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ControlePorta.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;

    }

    private void mensagem(String msg) {
        System.out.println(">> " + msg);
    }

}
