package ua.pp.msk.forfin.greeter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author maskimko
 */
@Named(value = "greeter")
@Dependent
public class Greeter {

    /**
     * Creates a new instance of Greeter
     */
    public Greeter() {
    }
    
}
