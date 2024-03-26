package TC_409;

import Utilities.BaseDriver;
import org.testng.annotations.Test;

public class TC_409 extends BaseDriver {
    @Test
    public void Test409(){
        TC_409_Elements elems=new TC_409_Elements();
        elems.registerPatient.click();

    }
}
