import java.util.*;

import javax.print.attribute.standard.DateTimeAtCompleted;

import java.io.*;
import java.sql.Ref;
public class p7 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i ++) {
            // circumfrence = pi * d
            // Power(watts) = I - Current(amps) * V - Voltage (volts);
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int diameter = Integer.parseInt(tokens[0]); // in cm
            int motorRevs = Integer.parseInt(tokens[1]); // for one rotation of wheel
            int powerReq = Integer.parseInt(tokens[2]); // watts
            int speedOfMotor = Integer.parseInt(tokens[3]); // rev / min
            int amps = Integer.parseInt(tokens[4]); // ampere hours
            int voltageReq = Integer.parseInt(tokens[5]);
            int distTravel = Integer.parseInt(tokens[6]) * 100;

            double circumfrence = Math.PI * diameter; 
            if(circumfrence == 0){
                 pw.println("Fail");
                 continue;
            }
            double neededRotations = distTravel / circumfrence; //total rotations of wheel

            
            double totalRevolutions = neededRotations * motorRevs; // total revolutions of wheel 

            double totalWatts = totalRevolutions * powerReq; 
            if(voltageReq == 0) {
                pw.println("Fail");
                continue;
            }
            double totalNeededAmps = totalWatts / voltageReq;   
            if(speedOfMotor == 0) {
                pw.println("Fail");
                continue;
            }
            double timeNeeded = totalRevolutions / speedOfMotor;

            double totalNeededAmpsMinutes = timeNeeded*totalNeededAmps; 

            double totalNeededAmpsHours = totalNeededAmpsMinutes / 60;

            String reFormat = String.format("%.4f", timeNeeded);
            if(totalNeededAmpsHours <= amps) pw.println("Success " + reFormat);
            else pw.println("Fail");
        }

        pw.close();
    }
}
