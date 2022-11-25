package com.company;

public class Stos <Element>
{
    public ObiektStosu pierwszy = null;
    private int N;


    public class ObiektStosu
    {
        Element element;
        ObiektStosu elPoniżej;
    }

    public boolean czyPusty() {return N==0;}
    public int rozmiar() {return N;}

    public void połóżNaStosie(Element el)
    {
        ObiektStosu sPierwszy=pierwszy;
        pierwszy=new ObiektStosu();
        pierwszy.element=el;
        pierwszy.elPoniżej=sPierwszy;
        N++;
    }

    public Element zdejmijZeStosu()
    {
        Element pobrany=pierwszy.element;
        pierwszy=pierwszy.elPoniżej;
        N--;
        return pobrany;
    }}
