package ru.discomfortDeliverer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("App Started");

        File jsonFile = new File("src/main/resources/city.json");
        File jsonErrorFile = new File("src/main/resources/city-error.json");

        Location location;
        try {
            location = Locations.readLocationFromJson(jsonFile);
        } catch (IOException e) {
            logger.warn("Json file reading exception");
            throw new RuntimeException(e);
        }

        String xml = Locations.toXml(location);
        Locations.writeToXmlFile(xml);

        try {
            location = Locations.readLocationFromJson(jsonErrorFile);

            xml = Locations.toXml(location);
            Locations.writeToXmlFile(xml);
        } catch (IOException e) {
            logger.warn("Json file reading exception");
        }

        logger.info("App Finished");
    }
}