package se.nctrl.jenkins.plugin;

import hudson.model.AbstractBuild;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author karl
 */
public class CTSurefireLogParser extends CTLogParser {

    private CTResult tr_root = null;
    private static final Logger logger = Logger.getLogger(CTSurefireLogParser.class.getName());
    
    public CTSurefireLogParser(AbstractBuild build)
    {
        super(build);
    }
    
    
    private void process_element(String el, XMLStreamReader sr)
    {
        
    }
    
    @Override
    public CTResult parse(File f) throws FileNotFoundException, IOException {


        XMLInputFactory factory = XMLInputFactory.newInstance();

        try {

            XMLStreamReader sr =
                    factory.createXMLStreamReader(new FileReader(f));

            while (sr.hasNext()) {

                sr.next();
                if (sr.getEventType() == XMLStreamReader.START_ELEMENT) {
                    String el = sr.getLocalName().toUpperCase();
                    
                    if (el.equals("TESTSUITES")) {} // TODO: Implement
                    if (el.equals("TESTSUITE")) {} // TODO: Implement
                    if (el.equals("PROPERTIES")) {} // TODO: Implement
                    if (el.equals("TESTCASE")) {} // TODO: Implement
                    if (el.equals("SKIPPED")) {} // TODO: Implement
                    
                    
                }
            }

        } catch (XMLStreamException e) {

            logger.log(Level.SEVERE, "Got XMLStreamException when parsing {0}", f.getName());
            return null;
        }

        return tr_root;

    }
    
}
