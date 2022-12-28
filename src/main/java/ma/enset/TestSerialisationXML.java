package ma.enset;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.Date;

public class TestSerialisationXML {
    public static void main(String[] args) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Banque.class);
    Banque banque = new Banque();
    banque.comptes.add(new Compte(1,4500,new Date(),TypeCompte.COURANT));
    banque.comptes.add(new Compte(2,8500,new Date(),TypeCompte.EPARGNE));
    banque.comptes.add(new Compte(3,9500,new Date(),TypeCompte.COURANT));


       Marshaller marshaller =jaxbContext.createMarshaller();
       marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
       marshaller.marshal(banque,new File("comptes.xml"));
    }
}
