package g.y.v.anew.Other;

import java.util.Calendar;

/**
 * Created by galqayeva on 02.11.2017.
 */

public class Methd {


    public String  getDate(){

        Calendar c = Calendar.getInstance();
        String sDate = c.get(Calendar.YEAR) + "-"
                + (c.get(Calendar.MONTH)+1)
                + "-" + c.get(Calendar.DAY_OF_MONTH);

        return sDate;
    }

}
