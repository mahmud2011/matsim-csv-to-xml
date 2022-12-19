package me.mahmudulhaque;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;


public class RoadPriceXML {
    public Document docBuilder(List<String[]> XMLElements) throws ParserConfigurationException {
            DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
            Document xmlDoc = xmlBuilder.newDocument();

            Element roadpricing = xmlDoc.createElement("roadpricing");
            xmlDoc.appendChild(roadpricing);

            roadpricing.setAttribute("type", "distance");
            roadpricing.setAttribute("name", "distance toll");

            Element links = xmlDoc.createElement("links");
            roadpricing.appendChild(links);

            Element cost = xmlDoc.createElement("cost");
            cost.setAttribute("start_time", "distance");
            cost.setAttribute("end_time", "distance toll");
            cost.setAttribute("amount", "distance toll");
            roadpricing.appendChild(cost);

            boolean isFirstLine = true;
            for (String[] node : XMLElements) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                Element link = xmlDoc.createElement("link");

                String[] attrMap = node[0].split("=");

                link.setAttribute(attrMap[0], attrMap[1]);

                links.appendChild(link);
            }

            return xmlDoc;
        }
}
