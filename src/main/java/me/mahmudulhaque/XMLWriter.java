package me.mahmudulhaque;

import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter {
    public void writeXML(String fileName, Document xmlDoc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.matsim.org/files/dtd/transitSchedule_v1.dtd");
        xmlDoc.setXmlStandalone(true);
        DOMSource source = new DOMSource(xmlDoc);

        File myFile = new File("src/main/resources/" + fileName);

        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(myFile);

        transformer.transform(source, console);
        transformer.transform(source, file);
    }
}
