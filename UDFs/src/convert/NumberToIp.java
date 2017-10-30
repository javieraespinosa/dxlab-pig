
package convert;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.WrappedIOException;
import java.io.IOException;

public class NumberToIp extends EvalFunc<String> {

    public String exec(Tuple input) throws IOException {

        if (input == null || input.size() == 0)
            return null;

        try{
            Long ip = (Long) input.get(0);

            StringBuilder result = new StringBuilder(15);
            for (int i = 0; i < 4; i++) {

                result.insert(0,Long.toString(ip & 0xff));

                if (i < 3) {
                    result.insert(0,'.');
                }

                ip = ip >> 8;
            }

            return result.toString();

        }catch(Exception e){
            throw WrappedIOException.wrap("Caught exception processing input row ", e);
        }

    } // method

} // class
