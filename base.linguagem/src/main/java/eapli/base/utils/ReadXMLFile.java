/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Inspirado em https://www.javatpoint.com/how-to-read-xml-file-in-java
 *
 * @author Guilherme
 */
public class ReadXMLFile {

    public String[] xmlElementsFromFieldClientes(String idCliente) {
        String ret[] = new String[4];
        try {
            File file = new File("clientes.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Cliente");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String idAtual = eElement.getElementsByTagName("ID").item(0).getTextContent();
                    if (idAtual.equals(idCliente)) {
                        ret[0] = idAtual;
                        ret[1] = eElement.getElementsByTagName("Nome").item(0).getTextContent();
                        ret[2] = eElement.getElementsByTagName("AnosVinculado").item(0).getTextContent();
                        ret[3] = eElement.getElementsByTagName("Email").item(0).getTextContent();
                        return ret;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public String[] xmlElementsFromFieldProdutos(String idProduto) {
        String ret[] = new String[5];
        try {
            File file = new File("produtos.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Produto");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String idAtual = eElement.getElementsByTagName("IDProduto").item(0).getTextContent();
                    if (idAtual.equals(idProduto)) {
                        ret[0] = idAtual;
                        ret[1] = eElement.getElementsByTagName("NomeProduto").item(0).getTextContent();
                        ret[2] = eElement.getElementsByTagName("QuantidadeMinima").item(0).getTextContent();
                        ret[3] = eElement.getElementsByTagName("Preco").item(0).getTextContent();
                        ret[4] = eElement.getElementsByTagName("Categoria").item(0).getTextContent();
                        return ret;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
