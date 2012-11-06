
package se.nctrl.jenkins.plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//=result        ok: UNKNOWN MHz, 40226 ESTONES
//=hosts         nohosts
//=group_props   [{suite,mymodule_SUITE}]

/**
 *
 * @author karl
 */
public class CTLogParser {

    private enum Fields {

        CASES,
        USER,
        HOST,
        HOSTS,
        LAN,
        EMULATOR_VSN,
        EMULATOR,
        OTP_RELEASE,
        STARTED,
        CASE,
        LOGFILE,
        ENDED,
        RESULT,
        ELAPSED,
        GROUP_TIME,
        FINISHED,
        FAILED,
        SUCCESSFUL,
        USER_SKIPPED,
        AUTO_SKIPPED,
        GROUP_PROPS
    }
    
    private static Pattern field_pattern = Pattern.compile("^=(\\w+)\\s+(.+)$");
    private static Pattern comment_pattern = Pattern.compile("^===.+$");
    
    private BufferedReader br;
    
    private CTResult tr_root = null;
    private CTResult tr_current_child = null;
    
    public void parse(File f) throws FileNotFoundException, IOException {
        
        this.tr_root = new CTResult();
        
        
        FileInputStream fs = new FileInputStream(f);
        
        this.br = new BufferedReader(new InputStreamReader(fs, "UTF-8"));
        
        
        try {
            while (true) {
                String l = br.readLine();

                if (l == null) {
                    break;
                }

                Matcher f_m = field_pattern.matcher(l);
                
                if (f_m.matches()) {
                    String fieldname = f_m.group(1);
                    String value = f_m.group(2);
                    parseField(fieldname,value);
                }
                
                               
            }
        } finally {
            br.close();
        }
    }

    private void parseField(String fieldname, String value) throws IOException
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        System.out.println("Field = " + fieldname + ", value = " + value);
        
        Fields f = Fields.valueOf(fieldname.toUpperCase());
        
        switch (f) {
            case CASES:
                int cases = Integer.parseInt(value);
                System.out.println("* Set cases to " + cases);
                this.tr_root.setCases(cases);
                break;
            case USER:
                System.out.println("* Set user to " + value);
                this.tr_root.setUser(value);
                break;
            case HOST:
                System.out.println("* Set host to " + value);
                this.tr_root.setHost(value);
                break;
            case HOSTS:
                System.out.println("* Set hosts to " + value);
                this.tr_root.setHosts(value);
                break;
            case LAN:
                System.out.println("* Set lan to " + value);
                this.tr_root.setLan(value);

                break;
            case EMULATOR_VSN:
                System.out.println("* Set emulator_vsn to " + value);
                this.tr_root.setEmulator_vsn(value);

                break;
            case EMULATOR:
                System.out.println("* Set emulator to " + value);
                this.tr_root.setEmulator(value);

                break;
            case OTP_RELEASE:
                System.out.println("* Set otp_release to " + value);
                this.tr_root.setOtp_release(value);

                break;
            case STARTED:
                
                Date started_date;
                try {
                    started_date = df.parse(value);
                    System.out.println("* Set date to " + started_date.toString());    
                } catch (ParseException ex) {
                    started_date = null;
                    System.out.println("# Error while parsing date.");
                }
                this.tr_root.setStarted(started_date);
                break;
            case CASE:
                System.out.println("* Set case to " + value);
                this.tr_root.setCase_name(value);

                break;
            case LOGFILE:
                System.out.println("* Set logfile to " + value);
                this.tr_root.setLog_file(value);

                break;
            case ENDED:
                
                Date ended_date;
                try {
                    ended_date = df.parse(value);
                    System.out.println("* Set date to " + ended_date.toString());    
                } catch (ParseException ex) {
                    ended_date = null;
                    System.out.println("# Error while parsing date.");
                }
                this.tr_root.setEnded(ended_date);
                break;

            case RESULT:
                int res = -1;

                String value2 = this.readMultiLine();
                String value3 = value + value2;

                
                if (value3 != null) {
                    if (value3.substring(0, 2).toUpperCase().equals("OK"))
                    {
                       System.out.println("* Set result to OK");
                       res = 1;
                    } else if (value3.substring(0, 6).toUpperCase().equals("FAILED")) {
                       System.out.println("* Set result to FAILED"); 
                       res = 0; 
                    } else if (value3.substring(0, 7).toUpperCase().equals("SKIPPED")) {
                       System.out.println("* Set result to SKIPPED"); 
                       res = 2; 
                    }
                }
                this.tr_root.setResult(res);
                this.tr_root.setResult_msg(value3);
                break;
            case ELAPSED:
                float elapsed = Float.parseFloat(value);
                System.out.println("* Set elapsed to " + elapsed);
                this.tr_root.setElapsed(elapsed);                
                break;
            case GROUP_TIME:
                System.out.println("* Set group time to " + value);
                this.tr_root.setGroup_time(value);

                break;
            case FINISHED:
                Date finished_date;
                try {
                    finished_date = df.parse(value);
                    System.out.println("* Set finished date to " + finished_date.toString());    
                } catch (ParseException ex) {
                    finished_date = null;
                    System.out.println("# Error while parsing date.");
                }
                this.tr_root.setEnded(finished_date);
                break;

            case SUCCESSFUL:
                int successful = Integer.parseInt(value);
                System.out.println("* Set successful to " + successful);
                this.tr_root.setSuccessful(successful);

                break;
            case USER_SKIPPED:
                int user_skipped = Integer.parseInt(value);
                System.out.println("* Set user_skipped to " + user_skipped);
                this.tr_root.setUser_skipped(user_skipped);

                break;
            case AUTO_SKIPPED:
                int auto_skipped = Integer.parseInt(value);
                System.out.println("* Set auto_skipped to " + auto_skipped);
                this.tr_root.setAuto_skipped(auto_skipped);


                break;
            case GROUP_PROPS:
                String gp_value2 = this.readMultiLine();
                String gp_value3 = value + gp_value2;
                
                this.tr_root.setGroup_props(gp_value3);

                break;
            default:
        }
        
        
        if (fieldname.equals("result")) {
            String val2 = readMultiLine();
            System.out.println("value_2 = " + value+val2);
        }
    }
    
    private String readMultiLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean done = false;

        while (!done) {
            br.mark(1024); 
            String l = br.readLine();
            if (l != null)
            {
              Matcher f_m = field_pattern.matcher(l); 
              Matcher c_m = comment_pattern.matcher(l);
              if (f_m.matches() || c_m.matches()) {
                  br.reset(); // we've read past the multiline value
                  done = true;
              } else {
                  sb.append(l);                 
              }
            } else { done = true; }
            
        }
        
        
        return sb.toString();
    }
    
}
