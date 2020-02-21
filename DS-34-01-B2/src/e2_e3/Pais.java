/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_e3;

/**
 *
 * @author David
 */
public enum Pais {

    AUSTRIA("AT", "Austria"),
    BELGICA("BE","Belgica"),
    CHIPRE("CY","Chipre"),
    HOLANDA("NL","Holanda"),
    ESTONIA("EE","Estonia"),
    FINLANDIA("FI","Finlandia"),
    FRANCIA("FR","Francia"),
    ALEMANIA("DE","Alemania"),
    GRECIA("GR", "Grecia"),
    IRLANDA( "IE","Irlanda"),
    ITALIA( "IT","Italia"),
    LATVIA("LV","Latvia"),
    LITUANIA("LT","Lituania"),
    LUXEMBURGO("LU","Luxemburgo"),
    MALTA("MT","Malta"),
    MONACO("MC","Monaco"),
    PORTUGAL("PT","Portugal"),
    SANMARINO( "SM", "San Marino"),
    ESLOVAQUIA("SK","Eslovaquia"),
    ESLOVENIA("SI","Eslovenia"),
    ESPAÑA("ES","España"),
    CIUDADDELVATICANO("VA","Ciudad del Vaticano");
    
    
    private String paisLargo;
    private String paisIso;

    public String getpais() {

        return paisLargo;
    }

    public String getpaisIso() {
        return paisIso;
    }

    private Pais(String paisIso , String paisLargo) {
        this.paisLargo = paisLargo;
        this.paisIso = paisIso;
    }
}
