/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalfrio.ms.dalagger2;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author ferreiral
 */
class SerialWriter implements Runnable {

    private final OutputStream out;

    public SerialWriter(OutputStream envia) {

        this.out = envia;
    }

    @Override
    public void run() {
        try {
            int c = 0;
            while ((c = System.in.read()) > -1) {
                Dalogger2.mensagem("write:: "+c);
                this.out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


