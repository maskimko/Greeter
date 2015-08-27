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
public interface JMetter {

    String getError();

    String getOutput();

    void run();
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
