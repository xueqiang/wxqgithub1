package de.wxq.ws.service;

import de.wxq.ws.client.HelloWeb;
import de.wxq.ws.client.HelloWebService;

public class Client {

    /**
     * TODO Bitte Kommentar ergänzen.
     * @param args
     */
    public static void main(String[] args) {
        HelloWebService service = new HelloWebService();
        HelloWeb helloWeb = service.getHelloWebPort();
        String response = helloWeb.sayGreeting("John Wang");
        System.out.println(response);
    }

}
