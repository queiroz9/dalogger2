/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalfrio.ms.dalagger2;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author ferreiral
 */
class SerialReader implements Runnable {

    InputStream in;

    public SerialReader(InputStream in) {
        this.in = in;

    }

    @Override
    public void run() {
        //System.out.print(">> "+in);
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
           //Dalogger2.mensagem("Recebendo mensagem :: ");
            while ((len = this.in.read(buffer)) > -1) {
                System.out.print(new String(buffer, 0, len));
                //System.out.print(" - ");
            }
            //Dalogger2.mensagem("Mensagem Enviada...");
            //System.out.print("3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
