/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.forfin.greeter;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
//import org.apache.jmeter.engine.StandardJMeterEngine;
//import org.apache.jmeter.save.SaveService;
//import org.apache.jmeter.util.JMeterUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.enterprise.inject.Default;
import org.slf4j.LoggerFactory;

@Default
public class JMetterImpl implements JMetter {

    StringBuilder out = null;
    StringBuilder err = null;
    
    public JMetterImpl(){}

    @Override
    public String getOutput() {
        if (out != null) {
            return out.toString();
        } else {
            return "";
        }
    }

    @Override
    public String getError() {
        if (err != null) {
            return err.toString();
        } else {
            return "";
        }
    }

    @Override
    public void run() {
        out = new StringBuilder();
        err = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        InputStream ist = null, est = null;
        try {
            ResourceBundle jmb = ResourceBundle.getBundle("jmetter");
            String cmd = jmb.getString("jmetter.cmd");
            LoggerFactory.getLogger(this.getClass()).debug("Executing command: " + cmd);
            Process p = runtime.exec(cmd);
            ist = p.getInputStream();
            est = p.getErrorStream();
            Scanner os = new Scanner(ist);
            Scanner es = new Scanner(est);

            while (os.hasNext() || es.hasNext()) {
                if (os.hasNextLine()) {
                    out.append(os.nextLine());
                }
                if (es.hasNextLine()) {
                    err.append(es.nextLine());
                }
            }
            LoggerFactory.getLogger(this.getClass()).debug("Standard output " + out.toString());
            LoggerFactory.getLogger(this.getClass()).debug("Standard error " + err.toString());
            LoggerFactory.getLogger(this.getClass()).debug("Process finished");
        } catch (IOException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot run JMetter " + ex.getMessage(), ex);
        } finally {
            if (ist != null) {
                try {
                    ist.close();
                } catch (IOException ex) {
                    LoggerFactory.getLogger(this.getClass()).error("Cannot close output stream " + ex.getMessage(), ex);
                }
            }
            if (est != null) {
                try {
                    est.close();
                } catch (IOException ex) {
                    LoggerFactory.getLogger(this.getClass()).error("Cannot close error stream " + ex.getMessage(), ex);
                }
            }
        }

    }
//    public void run() {
//        FileInputStream in = null;
//        try {
//// JMeter Engine
//            StandardJMeterEngine jmeter = new StandardJMeterEngine();
//
//            //Load properties
//            ResourceBundle jmetterBundle = ResourceBundle.getBundle("jmetter");
//            String jp = jmetterBundle.getString("jmetter.props");
//            String jh = jmetterBundle.getString("jmetter.home");
//            String jj = jmetterBundle.getString("jmetter.jmx");
//
//            // Initialize Properties, logging, locale, etc.
//            LoggerFactory.getLogger(this.getClass()).debug("JMetter properties: " + jp);
//            JMeterUtils.loadJMeterProperties(jp);
//               LoggerFactory.getLogger(this.getClass()).debug("JMetter home: " + jp);
//            JMeterUtils.setJMeterHome(jh);
//            JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
//            JMeterUtils.initLocale();
//
//            // Initialize JMeter SaveService
//            SaveService.loadProperties();
//
//            // Load existing .jmx Test Plan
//            LoggerFactory.getLogger(this.getClass()).info("Getting jmx file from " + in);
//            in = new FileInputStream(jj);
//            HashTree testPlanTree = SaveService.loadTree(in);
//            in.close();
//
//            // Run JMeter Test
//            jmeter.configure(testPlanTree);
//            jmeter.run();
//        } catch (IOException ex) {
//            LoggerFactory.getLogger(this.getClass()).error("Cannot run JMetter " + ex.getMessage(), ex);
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException ex) {
//                    LoggerFactory.getLogger(this.getClass()).error("Cannot close the file reader  " + ex.getMessage(), ex);
//                }
//            }
//        }
//    }
}
