package Btjf_API.CAPI.Test;

import org.testng.annotations.*;
import org.testng.annotations.Test;

/**
 * Created by wl on 2017/5/23.
 */
public class TestDepend {

    @Test
    public void A(){
        System.out.println("A");
    }
    @Test(dependsOnMethods = {"A"})
    public void B(){
        System.out.println("B");
    }
    @Test(dependsOnMethods = {"B"})
    public void C(){
        System.out.println("C");
    }
}
