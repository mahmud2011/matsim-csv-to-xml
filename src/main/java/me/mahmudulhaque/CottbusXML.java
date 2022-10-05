package me.mahmudulhaque;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Arrays;
import java.util.List;


public class CottbusXML {

    // https://github.com/matsim-org/matsim-maas/blob/master/scenarios/cottbus/drtstops.xml
    public Document docBuilder(List<String[]> XMLElements) throws ParserConfigurationException {
            DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
            Document xmlDoc = xmlBuilder.newDocument();

            Element transitSchedule = xmlDoc.createElement("transitSchedule");
            xmlDoc.appendChild(transitSchedule);

            Element transitStops = xmlDoc.createElement("transitStops");
            transitSchedule.appendChild(transitStops);

            boolean isFirstLine = true;
            for (String[] node : XMLElements) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                Element stopFacility = xmlDoc.createElement("stopFacility");

                for (int j = 0; j < node.length; j++) {
                    stopFacility.setAttribute((String) Arrays.stream(XMLElements.get(0)).toArray()[j], node[j]);
                }

                transitStops.appendChild(stopFacility);
            }

            return xmlDoc;
        }
}
