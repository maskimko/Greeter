/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.forfin.greeter;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@SessionScoped
public class JMetterProducer implements Serializable {

    private static JMetter j;

    @PostConstruct
    private void init() {
        LoggerFactory.getLogger(this.getClass()).debug(this.getClass().toString() + " has been initialized");
    }

    @Produces
    public JMetter produceJMetter(InjectionPoint injectionPoint) {
        if (j == null) {
            synchronized (JMetterProducer.class) {
                if (j == null) {
                    j = new JMetterImpl();
                }
            }
        }
        return j;
    }
}
