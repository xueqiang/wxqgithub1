package de.wxq.ws.service;

import javax.xml.ws.Endpoint;

public class Server {

    /**
     * TODO Bitte Kommentar erg�nzen.
     * @param args
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9898/HelloWeb", new HelloWeb());

        System.out.println("HelloWeb service is ready");
    }

}
