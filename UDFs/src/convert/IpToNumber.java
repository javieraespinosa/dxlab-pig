
package convert;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.WrappedIOException;
import java.io.IOException;

public class IpToNumber extends EvalFunc<Long> {

    public Long exec(Tuple input) throws IOException {

        if (input == null || input.size() == 0)
            return null;

        try{
            String ipAddress = (String) input.get(0);
            ipAddress = ipAddress.replaceAll("\"", "");

            String[] ipAddressInArray = ipAddress.split("\\.");

            long result = 0;
            for (int i = 0; i < ipAddressInArray.length; i++) {

                int power = 3 - i;
                int ip = Integer.parseInt(ipAddressInArray[i]);
                result += ip * Math.pow(256, power);

            }

            return new Long(result);

        }catch(Exception e){
            throw WrappedIOException.wrap("Caught exception processing input row ", e);
        }

    } // method


    public static void main(String[] args) {
        String ipAddress = "2.44.192.0";
        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {

            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }
        System.out.println(result);
    }

} // class
