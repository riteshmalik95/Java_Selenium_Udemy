package LEARNTESTNG.TestNG_Basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderBasics {

    @DataProvider(name="user data")
    Object [][] testData(){
        return new Object[][]{
                {"user1","Password1"},
                {"user2","Passwoed2"}
        };
    }
    @DataProvider()
    Object [][] withoutNameTestData(){
        return new Object[][]{
                {1,2},
                {3,4}
        };
    }
    @Test(dataProvider = "user data")
    void testdata(String user ,String password){
        System.out.println(user+" "+password);
    }
    @Test(dataProvider = "withoutNameTestData")
    void testwithoutdataname(int a,int b){
        System.out.println(a+" "+b);
    }
}
