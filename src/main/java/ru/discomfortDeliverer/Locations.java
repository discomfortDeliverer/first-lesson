package ru.discomfortDeliverer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Locations {
    private static final Logger logger = LoggerFactory.getLogger(Locations.class);
    public static Location readLocationFromJson(File jsonFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonFile, Location.class);
    }

    public static String toXml(Location location) {
        XmlMapper xmlMapper = new XmlMapper();
        DefaultXmlPrettyPrinter prettyPrinter = new DefaultXmlPrettyPrinter();

        try {
            return xmlMapper.writer(prettyPrinter).writeValueAsString(location);
        } catch (JsonProcessingException e) {
            logger.warn("JsonProcessingException in toXml method");
            throw new RuntimeException(e);
        }
    }

    public static void writeToXmlFile(String xmlString) {
        String filePath = "src/main/resources/city.xml";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(xmlString);
            logger.info("XML string successfully saved to file");
        } catch (IOException e) {
            logger.warn("IOException in writeToXmlFile method");
            throw new RuntimeException(e);
        }
    }
}
