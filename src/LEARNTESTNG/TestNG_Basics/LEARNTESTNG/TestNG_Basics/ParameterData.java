package LEARNTESTNG.TestNG_Basics;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterData {

    @Test
    @Parameters({"browsername","studentname"})
    public void testParameterValue(String bName,String Sname){
        System.out.println(bName+" "+Sname);
    }
}
