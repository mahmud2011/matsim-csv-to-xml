package me.mahmudulhaque;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;
import org.w3c.dom.Document;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        CSVReader csvReader = new CSVReader();
        csvReader.readCSV("input.csv");
        List<String[]> csvList = csvReader.getCSVAsList();

        CottbusXML xmlDom = new CottbusXML();
        Document doc = xmlDom.docBuilder(csvList);

        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.writeXML("output.xml", doc);
    }
}
