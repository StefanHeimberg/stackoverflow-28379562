package pl.piotrek;

import java.util.Date;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
public class AtNewAndProducerTest {
    
    @Produces
    public Date produceDate() {
        return new Date((long)(Math.random() * 2000000000000L));
    }
    
    @New @Inject
    private Date d1;
    
    @New @Inject
    private Date d2;
    
    @New @Inject
    private Date d3;
    
    @Inject
    private Date d4;
    
    @Inject
    private Date d5;
    
    @Test
    public void test() {
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        
        // will output something like this:
        // Sat Feb 07 13:16:05 CET 2015
        // Sat Feb 07 13:16:05 CET 2015
        // Sat Feb 07 13:16:05 CET 2015
        // Mon Sep 19 12:31:29 CEST 2005
        // Sat Aug 14 21:51:06 CEST 1999
    }
    
}
