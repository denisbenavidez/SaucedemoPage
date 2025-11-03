package Util;

import org.testng.annotations.DataProvider;

public class DataProviderLogin {

    String password = "secret_sauce";

    @DataProvider(name = "dataLogin")
    public Object[][] getDataLogin(){
        return new Object[][]{
                {"standard_user", password, 1},
                {"locked_out_user", password, 0},
                {"problem_user", password, 1},
                {"performance_glitch_user", password, 1},
                {"error_user", password, 1},
                {"visual_user", password, 1}
        };
    }
}
