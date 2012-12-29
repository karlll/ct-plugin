package se.nctrl.jenkins.plugin;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CTResultTestData
 *
 * @author karl l <karl@ninjacontrol.com>
 */
public class CTResultTestData {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private static Date parse_date(String date_string) {

        
        Date parsed_date;

        try {
                    parsed_date = df.parse(date_string);
                    
                } catch (ParseException ex) {
                    parsed_date = null;
                }
        
        return parsed_date;
    }

    private static int parse_result(String result_string) {
        
        if (result_string.toUpperCase().equals("OK")) {
            return 1;
        } else if (result_string.toUpperCase().equals("FAILED")) {
            return 0;
        } else if (result_string.toUpperCase().equals("SKIPPED")) {
            return 2;
        }
        
        return -1;
    }

    private static float parse_float(String float_string) {
        return Float.parseFloat(float_string);
    }

    static CTResult getMockResultObject() {


        CTResult r = new CTResult(null);

        r.setCases(128);
        r.setUser("karl");
        r.setHost("devbox");
        r.setHosts("devbox ");
        r.setEmulator_vsn("5.9.3");
        r.setEmulator("beam");
        r.setOtp_release("R15B03");
        r.setStarted(parse_date("2012-11-19 16:37:20"));
        r.setFinished(parse_date("2012-11-19 17:07:56"));
        r.setFailed(0);
        r.setSuccessful(127);
        r.setUser_skipped(1);
        r.setAuto_skipped(0);

        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_suite");
                setLog_file("asn1_suite.init_per_suite.html");
                setStarted(parse_date("2012-11-19 16:37:20"));
                setEnded(parse_date("2012-11-19 16:37:20"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.59e-4"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.html");
                setGroup_props("[{name,parallel}]");
                setStarted(parse_date("2012-11-19 16:37:20"));
                setEnded(parse_date("2012-11-19 16:37:20"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339440.410.html");
                setGroup_props("[{name,compile}]");
                setStarted(parse_date("2012-11-19 16:37:20"));
                setEnded(parse_date("2012-11-19 16:37:20"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:c_syntax");
                setLog_file("asn1_suite.c_syntax.html");
                setStarted(parse_date("2012-11-19 16:37:20"));
                setEnded(parse_date("2012-11-19 16:37:20"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.168523"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:c_string");
                setLog_file("asn1_suite.c_string.html");
                setStarted(parse_date("2012-11-19 16:37:20"));
                setEnded(parse_date("2012-11-19 16:37:20"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.325744"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:c_implicit_before_choice");
                setLog_file("asn1_suite.c_implicit_before_choice.html");
                setStarted(parse_date("2012-11-19 16:37:20"));
                setEnded(parse_date("2012-11-19 16:37:21"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.059244"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.html");
                setGroup_props("[{name,compile}]");
                setStarted(parse_date("2012-11-19 16:37:21"));
                setEnded(parse_date("2012-11-19 16:37:21"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
                setGroup_time("0.663s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339441.99.html");
                setGroup_props("[{name,ber}]");
                setStarted(parse_date("2012-11-19 16:37:21"));
                setEnded(parse_date("2012-11-19 16:37:21"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:ber_choiceinseq");
                setLog_file("asn1_suite.ber_choiceinseq.html");
                setStarted(parse_date("2012-11-19 16:37:21"));
                setEnded(parse_date("2012-11-19 16:37:21"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.24876"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339441.405.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:37:21"));
                setEnded(parse_date("2012-11-19 16:37:21"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:ber_optional");
                setLog_file("asn1_suite.ber_optional.html");
                setStarted(parse_date("2012-11-19 16:37:21"));
                setEnded(parse_date("2012-11-19 16:37:21"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.318778"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:ber_optional_keyed_list");
                setLog_file("asn1_suite.ber_optional_keyed_list.html");
                setStarted(parse_date("2012-11-19 16:37:21"));
                setEnded(parse_date("2012-11-19 16:37:21"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.188609"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339441.993.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:37:21"));
                setEnded(parse_date("2012-11-19 16:37:22"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
                setGroup_time("0.589s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339442.18.html");
                setGroup_props("[{name,ber}]");
                setStarted(parse_date("2012-11-19 16:37:22"));
                setEnded(parse_date("2012-11-19 16:37:22"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("3.0e-6"));
                setGroup_time("0.920s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339442.45.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:37:22"));
                setEnded(parse_date("2012-11-19 16:37:22"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:parse");
                setLog_file("asn1_suite.parse.html");
                setStarted(parse_date("2012-11-19 16:37:22"));
                setEnded(parse_date("2012-11-19 16:37:23"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.011498"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_driver_load");
                setLog_file("asn1_suite.test_driver_load.html");
                setStarted(parse_date("2012-11-19 16:37:23"));
                setEnded(parse_date("2012-11-19 16:37:23"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.097611"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_undecoded_rest");
                setLog_file("asn1_suite.test_undecoded_rest.html");
                setStarted(parse_date("2012-11-19 16:37:23"));
                setEnded(parse_date("2012-11-19 16:37:24"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.279114"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_inline");
                setLog_file("asn1_suite.test_inline.html");
                setStarted(parse_date("2012-11-19 16:37:24"));
                setEnded(parse_date("2012-11-19 16:39:36"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("131.527725"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:specialized_decodes");
                setLog_file("asn1_suite.specialized_decodes.html");
                setStarted(parse_date("2012-11-19 16:39:36"));
                setEnded(parse_date("2012-11-19 16:39:38"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.242191"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:special_decode_performance");
                setLog_file("asn1_suite.special_decode_performance.html");
                setStarted(parse_date("2012-11-19 16:39:38"));
                setEnded(parse_date("2012-11-19 16:39:45"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("6.790573"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testMegaco");
                setLog_file("asn1_suite.testmegaco.html");
                setStarted(parse_date("2012-11-19 16:39:45"));
                setEnded(parse_date("2012-11-19 16:40:07"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("21.759825"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testConstraints");
                setLog_file("asn1_suite.testconstraints.html");
                setStarted(parse_date("2012-11-19 16:40:07"));
                setEnded(parse_date("2012-11-19 16:40:08"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.492838"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testCompactBitString");
                setLog_file("asn1_suite.testcompactbitstring.html");
                setStarted(parse_date("2012-11-19 16:40:08"));
                setEnded(parse_date("2012-11-19 16:40:10"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.453291"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339610.30.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:40:10"));
                setEnded(parse_date("2012-11-19 16:40:10"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("5.0e-6"));
                setGroup_time("167.984s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:default");
                setLog_file("asn1_suite.default.html");
                setStarted(parse_date("2012-11-19 16:40:10"));
                setEnded(parse_date("2012-11-19 16:40:10"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.602426"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339610.688.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:40:10"));
                setEnded(parse_date("2012-11-19 16:40:10"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testPrim");
                setLog_file("asn1_suite.testprim.html");
                setStarted(parse_date("2012-11-19 16:40:10"));
                setEnded(parse_date("2012-11-19 16:40:11"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.860138"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:rtUI");
                setLog_file("asn1_suite.rtui.html");
                setStarted(parse_date("2012-11-19 16:40:11"));
                setEnded(parse_date("2012-11-19 16:40:12"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.407612"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testPrimStrings");
                setLog_file("asn1_suite.testprimstrings.html");
                setStarted(parse_date("2012-11-19 16:40:12"));
                setEnded(parse_date("2012-11-19 16:40:13"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.663719"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testInvokeMod");
                setLog_file("asn1_suite.testinvokemod.html");
                setStarted(parse_date("2012-11-19 16:40:13"));
                setEnded(parse_date("2012-11-19 16:40:15"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.273196"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:per");
                setLog_file("asn1_suite.per.html");
                setStarted(parse_date("2012-11-19 16:40:15"));
                setEnded(parse_date("2012-11-19 16:40:46"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("31.205467"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:ber_other");
                setLog_file("asn1_suite.ber_other.html");
                setStarted(parse_date("2012-11-19 16:40:46"));
                setEnded(parse_date("2012-11-19 16:41:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("15.125298"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:h323test");
                setLog_file("asn1_suite.h323test.html");
                setStarted(parse_date("2012-11-19 16:41:01"));
                setEnded(parse_date("2012-11-19 16:42:23"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("82.11066"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:per_GeneralString");
                setLog_file("asn1_suite.per_generalstring.html");
                setStarted(parse_date("2012-11-19 16:42:23"));
                setEnded(parse_date("2012-11-19 16:42:32"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("8.919536"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339752.486.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:42:32"));
                setEnded(parse_date("2012-11-19 16:42:32"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
                setGroup_time("141.798s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoPrim");
                setLog_file("asn1_suite.testchoprim.html");
                setStarted(parse_date("2012-11-19 16:42:32"));
                setEnded(parse_date("2012-11-19 16:42:32"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.370767"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoExtension");
                setLog_file("asn1_suite.testchoextension.html");
                setStarted(parse_date("2012-11-19 16:42:32"));
                setEnded(parse_date("2012-11-19 16:42:33"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.569508"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoOptional");
                setLog_file("asn1_suite.testchooptional.html");
                setStarted(parse_date("2012-11-19 16:42:33"));
                setEnded(parse_date("2012-11-19 16:42:34"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.567762"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoOptionalImplicitTag");
                setLog_file("asn1_suite.testchooptionalimplicittag.html");
                setStarted(parse_date("2012-11-19 16:42:34"));
                setEnded(parse_date("2012-11-19 16:42:34"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.270062"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoRecursive");
                setLog_file("asn1_suite.testchorecursive.html");
                setStarted(parse_date("2012-11-19 16:42:34"));
                setEnded(parse_date("2012-11-19 16:42:34"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.421442"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoTypeRefCho");
                setLog_file("asn1_suite.testchotyperefcho.html");
                setStarted(parse_date("2012-11-19 16:42:34"));
                setEnded(parse_date("2012-11-19 16:42:35"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.565474"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoTypeRefPrim");
                setLog_file("asn1_suite.testchotyperefprim.html");
                setStarted(parse_date("2012-11-19 16:42:35"));
                setEnded(parse_date("2012-11-19 16:42:35"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.47209"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoTypeRefSeq");
                setLog_file("asn1_suite.testchotyperefseq.html");
                setStarted(parse_date("2012-11-19 16:42:35"));
                setEnded(parse_date("2012-11-19 16:42:36"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.512324"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoTypeRefSet");
                setLog_file("asn1_suite.testchotyperefset.html");
                setStarted(parse_date("2012-11-19 16:42:36"));
                setEnded(parse_date("2012-11-19 16:42:37"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.548801"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testDef");
                setLog_file("asn1_suite.testdef.html");
                setStarted(parse_date("2012-11-19 16:42:37"));
                setEnded(parse_date("2012-11-19 16:42:37"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.573548"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testOpt");
                setLog_file("asn1_suite.testopt.html");
                setStarted(parse_date("2012-11-19 16:42:37"));
                setEnded(parse_date("2012-11-19 16:42:38"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.573132"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqDefault");
                setLog_file("asn1_suite.testseqdefault.html");
                setStarted(parse_date("2012-11-19 16:42:38"));
                setEnded(parse_date("2012-11-19 16:42:39"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.330679"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339759.598.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:42:39"));
                setEnded(parse_date("2012-11-19 16:42:39"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoExternal");
                setLog_file("asn1_suite.testchoexternal.html");
                setStarted(parse_date("2012-11-19 16:42:39"));
                setEnded(parse_date("2012-11-19 16:42:41"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.03466"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testPrimExternal");
                setLog_file("asn1_suite.testprimexternal.html");
                setStarted(parse_date("2012-11-19 16:42:41"));
                setEnded(parse_date("2012-11-19 16:42:44"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.300119"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqExtension");
                setLog_file("asn1_suite.testseqextension.html");
                setStarted(parse_date("2012-11-19 16:42:44"));
                setEnded(parse_date("2012-11-19 16:42:45"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.888749"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqExternal");
                setLog_file("asn1_suite.testseqexternal.html");
                setStarted(parse_date("2012-11-19 16:42:45"));
                setEnded(parse_date("2012-11-19 16:42:48"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.405869"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqOfExternal");
                setLog_file("asn1_suite.testseqofexternal.html");
                setStarted(parse_date("2012-11-19 16:42:48"));
                setEnded(parse_date("2012-11-19 16:42:51"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.66739"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqOfTag");
                setLog_file("asn1_suite.testseqoftag.html");
                setStarted(parse_date("2012-11-19 16:42:51"));
                setEnded(parse_date("2012-11-19 16:42:54"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("3.420717"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqTag");
                setLog_file("asn1_suite.testseqtag.html");
                setStarted(parse_date("2012-11-19 16:42:54"));
                setEnded(parse_date("2012-11-19 16:42:56"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.278535"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetExtension");
                setLog_file("asn1_suite.testsetextension.html");
                setStarted(parse_date("2012-11-19 16:42:56"));
                setEnded(parse_date("2012-11-19 16:42:58"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.931976"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetExternal");
                setLog_file("asn1_suite.testsetexternal.html");
                setStarted(parse_date("2012-11-19 16:42:58"));
                setEnded(parse_date("2012-11-19 16:43:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.403893"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetOfExternal");
                setLog_file("asn1_suite.testsetofexternal.html");
                setStarted(parse_date("2012-11-19 16:43:01"));
                setEnded(parse_date("2012-11-19 16:43:03"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.779315"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetOfTag");
                setLog_file("asn1_suite.testsetoftag.html");
                setStarted(parse_date("2012-11-19 16:43:03"));
                setEnded(parse_date("2012-11-19 16:43:07"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("3.620528"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetTag");
                setLog_file("asn1_suite.testsettag.html");
                setStarted(parse_date("2012-11-19 16:43:07"));
                setEnded(parse_date("2012-11-19 16:43:10"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.407491"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339790.78.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:43:10"));
                setEnded(parse_date("2012-11-19 16:43:10"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
                setGroup_time("30.480s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqOptional");
                setLog_file("asn1_suite.testseqoptional.html");
                setStarted(parse_date("2012-11-19 16:43:10"));
                setEnded(parse_date("2012-11-19 16:43:11"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.314495"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqPrim");
                setLog_file("asn1_suite.testseqprim.html");
                setStarted(parse_date("2012-11-19 16:43:11"));
                setEnded(parse_date("2012-11-19 16:43:11"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.387987"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqTypeRefCho");
                setLog_file("asn1_suite.testseqtyperefcho.html");
                setStarted(parse_date("2012-11-19 16:43:11"));
                setEnded(parse_date("2012-11-19 16:43:12"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.409836"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339792.295.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:43:12"));
                setEnded(parse_date("2012-11-19 16:43:12"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqTypeRefPrim");
                setLog_file("asn1_suite.testseqtyperefprim.html");
                setStarted(parse_date("2012-11-19 16:43:12"));
                setEnded(parse_date("2012-11-19 16:43:13"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.711774"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTypeValueNotation");
                setLog_file("asn1_suite.testtypevaluenotation.html");
                setStarted(parse_date("2012-11-19 16:43:13"));
                setEnded(parse_date("2012-11-19 16:43:14"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.163447"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339794.246.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:43:14"));
                setEnded(parse_date("2012-11-19 16:43:14"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
                setGroup_time("1.951s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqTypeRefSeq");
                setLog_file("asn1_suite.testseqtyperefseq.html");
                setStarted(parse_date("2012-11-19 16:43:14"));
                setEnded(parse_date("2012-11-19 16:43:15"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.414641"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqTypeRefSet");
                setLog_file("asn1_suite.testseqtyperefset.html");
                setStarted(parse_date("2012-11-19 16:43:15"));
                setEnded(parse_date("2012-11-19 16:43:16"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.554791"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339796.290.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:43:16"));
                setEnded(parse_date("2012-11-19 16:43:16"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqOf");
                setLog_file("asn1_suite.testseqof.html");
                setStarted(parse_date("2012-11-19 16:43:16"));
                setEnded(parse_date("2012-11-19 16:43:18"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.105249"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqOfIndefinite");
                setLog_file("asn1_suite.testseqofindefinite.html");
                setStarted(parse_date("2012-11-19 16:43:18"));
                setEnded(parse_date("2012-11-19 16:43:27"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("8.646708"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339807.120.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:43:27"));
                setEnded(parse_date("2012-11-19 16:43:27"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
                setGroup_time("10.830s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqOfCho");
                setLog_file("asn1_suite.testseqofcho.html");
                setStarted(parse_date("2012-11-19 16:43:27"));
                setEnded(parse_date("2012-11-19 16:43:28"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.309213"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetDefault");
                setLog_file("asn1_suite.testsetdefault.html");
                setStarted(parse_date("2012-11-19 16:43:28"));
                setEnded(parse_date("2012-11-19 16:43:29"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.617894"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testExtensionAdditionGroup");
                setLog_file("asn1_suite.testextensionadditiongroup.html");
                setStarted(parse_date("2012-11-19 16:43:29"));
                setEnded(parse_date("2012-11-19 16:43:50"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("20.907178"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetOptional");
                setLog_file("asn1_suite.testsetoptional.html");
                setStarted(parse_date("2012-11-19 16:43:50"));
                setEnded(parse_date("2012-11-19 16:43:51"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.191268"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetPrim");
                setLog_file("asn1_suite.testsetprim.html");
                setStarted(parse_date("2012-11-19 16:43:51"));
                setEnded(parse_date("2012-11-19 16:43:51"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.341903"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetTypeRefCho");
                setLog_file("asn1_suite.testsettyperefcho.html");
                setStarted(parse_date("2012-11-19 16:43:51"));
                setEnded(parse_date("2012-11-19 16:43:52"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.443185"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetTypeRefPrim");
                setLog_file("asn1_suite.testsettyperefprim.html");
                setStarted(parse_date("2012-11-19 16:43:52"));
                setEnded(parse_date("2012-11-19 16:43:52"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.435385"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetTypeRefSeq");
                setLog_file("asn1_suite.testsettyperefseq.html");
                setStarted(parse_date("2012-11-19 16:43:52"));
                setEnded(parse_date("2012-11-19 16:43:53"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.576335"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetTypeRefSet");
                setLog_file("asn1_suite.testsettyperefset.html");
                setStarted(parse_date("2012-11-19 16:43:53"));
                setEnded(parse_date("2012-11-19 16:43:54"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.753968"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetOf");
                setLog_file("asn1_suite.testsetof.html");
                setStarted(parse_date("2012-11-19 16:43:54"));
                setEnded(parse_date("2012-11-19 16:43:56"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.397339"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetOfCho");
                setLog_file("asn1_suite.testsetofcho.html");
                setStarted(parse_date("2012-11-19 16:43:56"));
                setEnded(parse_date("2012-11-19 16:43:57"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.533805"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testEnumExt");
                setLog_file("asn1_suite.testenumext.html");
                setStarted(parse_date("2012-11-19 16:43:57"));
                setEnded(parse_date("2012-11-19 16:43:58"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.315627"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:value_test");
                setLog_file("asn1_suite.value_test.html");
                setStarted(parse_date("2012-11-19 16:43:58"));
                setEnded(parse_date("2012-11-19 16:43:58"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.528537"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:value_bad_enum_test");
                setLog_file("asn1_suite.value_bad_enum_test.html");
                setStarted(parse_date("2012-11-19 16:43:58"));
                setEnded(parse_date("2012-11-19 16:43:58"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.010522"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeq2738");
                setLog_file("asn1_suite.testseq2738.html");
                setStarted(parse_date("2012-11-19 16:43:58"));
                setEnded(parse_date("2012-11-19 16:43:59"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.399933"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339839.308.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:43:59"));
                setEnded(parse_date("2012-11-19 16:43:59"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:constructed");
                setLog_file("asn1_suite.constructed.html");
                setStarted(parse_date("2012-11-19 16:43:59"));
                setEnded(parse_date("2012-11-19 16:43:59"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.211527"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:ber_decode_error");
                setLog_file("asn1_suite.ber_decode_error.html");
                setStarted(parse_date("2012-11-19 16:43:59"));
                setEnded(parse_date("2012-11-19 16:43:59"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.183874"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339839.784.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:43:59"));
                setEnded(parse_date("2012-11-19 16:43:59"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
                setGroup_time("0.476s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.339839.811.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:43:59"));
                setEnded(parse_date("2012-11-19 16:43:59"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSeqIndefinite");
                setLog_file("asn1_suite.testseqindefinite.html");
                setStarted(parse_date("2012-11-19 16:43:59"));
                setEnded(parse_date("2012-11-19 16:44:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.474358"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSetIndefinite");
                setLog_file("asn1_suite.testsetindefinite.html");
                setStarted(parse_date("2012-11-19 16:44:00"));
                setEnded(parse_date("2012-11-19 16:44:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.49315"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.339840.862.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:44:00"));
                setEnded(parse_date("2012-11-19 16:44:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
                setGroup_time("1.050s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testChoiceIndefinite");
                setLog_file("asn1_suite.testchoiceindefinite.html");
                setStarted(parse_date("2012-11-19 16:44:00"));
                setEnded(parse_date("2012-11-19 16:44:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.175578"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:per_open_type");
                setLog_file("asn1_suite.per_open_type.html");
                setStarted(parse_date("2012-11-19 16:44:01"));
                setEnded(parse_date("2012-11-19 16:44:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.052379"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testInfObjectClass");
                setLog_file("asn1_suite.testinfobjectclass.html");
                setStarted(parse_date("2012-11-19 16:44:01"));
                setEnded(parse_date("2012-11-19 16:46:18"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("137.357469"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testParameterizedInfObj");
                setLog_file("asn1_suite.testparameterizedinfobj.html");
                setStarted(parse_date("2012-11-19 16:46:18"));
                setEnded(parse_date("2012-11-19 16:46:19"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.67499"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testMergeCompile");
                setLog_file("asn1_suite.testmergecompile.html");
                setStarted(parse_date("2012-11-19 16:46:19"));
                setEnded(parse_date("2012-11-19 16:49:25"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("186.244348"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testobj");
                setLog_file("asn1_suite.testobj.html");
                setStarted(parse_date("2012-11-19 16:49:25"));
                setEnded(parse_date("2012-11-19 16:50:31"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("65.539456"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testDeepTConstr");
                setLog_file("asn1_suite.testdeeptconstr.html");
                setStarted(parse_date("2012-11-19 16:50:31"));
                setEnded(parse_date("2012-11-19 16:50:33"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.689109"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testExport");
                setLog_file("asn1_suite.testexport.html");
                setStarted(parse_date("2012-11-19 16:50:33"));
                setEnded(parse_date("2012-11-19 16:50:33"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.015524"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testImport");
                setLog_file("asn1_suite.testimport.html");
                setStarted(parse_date("2012-11-19 16:50:33"));
                setEnded(parse_date("2012-11-19 16:50:33"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.029942"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.340233.904.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:50:33"));
                setEnded(parse_date("2012-11-19 16:50:33"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.3e-5"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testParamBasic");
                setLog_file("asn1_suite.testparambasic.html");
                setStarted(parse_date("2012-11-19 16:50:33"));
                setEnded(parse_date("2012-11-19 16:50:34"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.457138"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testDER");
                setLog_file("asn1_suite.testder.html");
                setStarted(parse_date("2012-11-19 16:50:34"));
                setEnded(parse_date("2012-11-19 16:50:36"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.435239"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.340236.877.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:50:36"));
                setEnded(parse_date("2012-11-19 16:50:36"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
                setGroup_time("2.973s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testMvrasn6");
                setLog_file("asn1_suite.testmvrasn6.html");
                setStarted(parse_date("2012-11-19 16:50:36"));
                setEnded(parse_date("2012-11-19 16:51:10"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("33.344807"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testContextSwitchingTypes");
                setLog_file("asn1_suite.testcontextswitchingtypes.html");
                setStarted(parse_date("2012-11-19 16:51:10"));
                setEnded(parse_date("2012-11-19 16:51:11"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.146326"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testOpenTypeImplicitTag");
                setLog_file("asn1_suite.testopentypeimplicittag.html");
                setStarted(parse_date("2012-11-19 16:51:11"));
                setEnded(parse_date("2012-11-19 16:51:11"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.382565"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:duplicate_tags");
                setLog_file("asn1_suite.duplicate_tags.html");
                setStarted(parse_date("2012-11-19 16:51:11"));
                setEnded(parse_date("2012-11-19 16:51:11"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.023122"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testROSE");
                setLog_file("asn1_suite.testrose.html");
                setStarted(parse_date("2012-11-19 16:51:11"));
                setEnded(parse_date("2012-11-19 16:51:13"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.293384"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testINSTANCE_OF");
                setLog_file("asn1_suite.testinstance_of.html");
                setStarted(parse_date("2012-11-19 16:51:13"));
                setEnded(parse_date("2012-11-19 16:51:14"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.77847"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTCAP");
                setLog_file("asn1_suite.testtcap.html");
                setStarted(parse_date("2012-11-19 16:51:14"));
                setEnded(parse_date("2012-11-19 16:51:18"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.628473"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_ParamTypeInfObj");
                setLog_file("asn1_suite.test_paramtypeinfobj.html");
                setStarted(parse_date("2012-11-19 16:51:18"));
                setEnded(parse_date("2012-11-19 16:51:23"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.90093"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_WS_ParamClass");
                setLog_file("asn1_suite.test_ws_paramclass.html");
                setStarted(parse_date("2012-11-19 16:51:23"));
                setEnded(parse_date("2012-11-19 16:51:26"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.521289"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_Defed_ObjectIdentifier");
                setLog_file("asn1_suite.test_defed_objectidentifier.html");
                setStarted(parse_date("2012-11-19 16:51:26"));
                setEnded(parse_date("2012-11-19 16:51:26"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.166826"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSelectionType");
                setLog_file("asn1_suite.testselectiontype.html");
                setStarted(parse_date("2012-11-19 16:51:26"));
                setEnded(parse_date("2012-11-19 16:51:27"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.441951"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testSSLspecs");
                setLog_file("asn1_suite.testsslspecs.html");
                setStarted(parse_date("2012-11-19 16:51:27"));
                setEnded(parse_date("2012-11-19 16:52:38"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("70.827242"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testNortel");
                setLog_file("asn1_suite.testnortel.html");
                setStarted(parse_date("2012-11-19 16:52:38"));
                setEnded(parse_date("2012-11-19 16:52:42"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.079327"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.340362.789.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 16:52:42"));
                setEnded(parse_date("2012-11-19 16:52:42"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_modified_x420");
                setLog_file("asn1_suite.test_modified_x420.html");
                setStarted(parse_date("2012-11-19 16:52:42"));
                setEnded(parse_date("2012-11-19 16:52:48"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("5.773261"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testX420");
                setLog_file("asn1_suite.testx420.html");
                setStarted(parse_date("2012-11-19 16:52:48"));
                setEnded(parse_date("2012-11-19 17:03:14"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("626.101607"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.340994.745.html");
                setGroup_props("[{name,group}]");
                setStarted(parse_date("2012-11-19 17:03:14"));
                setEnded(parse_date("2012-11-19 17:03:14"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
                setGroup_time("631.956s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTcapsystem");
                setLog_file("asn1_suite.testtcapsystem.html");
                setStarted(parse_date("2012-11-19 17:03:14"));
                setEnded(parse_date("2012-11-19 17:03:56"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("41.524458"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testNBAPsystem");
                setLog_file("asn1_suite.testnbapsystem.html");
                setStarted(parse_date("2012-11-19 17:03:56"));
                setEnded(parse_date("2012-11-19 17:06:33"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("157.041671"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_compile_options");
                setLog_file("asn1_suite.test_compile_options.html");
                setStarted(parse_date("2012-11-19 17:06:33"));
                setEnded(parse_date("2012-11-19 17:06:35"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.832763"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testDoubleEllipses");
                setLog_file("asn1_suite.testdoubleellipses.html");
                setStarted(parse_date("2012-11-19 17:06:35"));
                setEnded(parse_date("2012-11-19 17:06:36"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.561547"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_x691");
                setLog_file("asn1_suite.test_x691.html");
                setStarted(parse_date("2012-11-19 17:06:36"));
                setEnded(parse_date("2012-11-19 17:06:38"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.889708"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:ticket_6143");
                setLog_file("asn1_suite.ticket_6143.html");
                setStarted(parse_date("2012-11-19 17:06:38"));
                setEnded(parse_date("2012-11-19 17:06:38"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.044597"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testExtensionAdditionGroup");
                setLog_file("asn1_suite.testextensionadditiongroup.341198.837.html");
                setStarted(parse_date("2012-11-19 17:06:38"));
                setEnded(parse_date("2012-11-19 17:07:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("21.788653"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:test_OTP_9688");
                setLog_file("asn1_suite.test_otp_9688.html");
                setStarted(parse_date("2012-11-19 17:07:00"));
                setEnded(parse_date("2012-11-19 17:07:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.037403"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.341220.748.html");
                setGroup_props("[{name,parallel}]");
                setStarted(parse_date("2012-11-19 17:07:00"));
                setEnded(parse_date("2012-11-19 17:07:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
                setGroup_time("1780.337s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.341220.780.html");
                setGroup_props("[{name,app_test}]");
                setStarted(parse_date("2012-11-19 17:07:00"));
                setEnded(parse_date("2012-11-19 17:07:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.5e-5"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_suite");
                setLog_file("asn1_suite.end_per_suite.html");
                setStarted(parse_date("2012-11-19 17:07:00"));
                setEnded(parse_date("2012-11-19 17:07:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_app_test:init_per_suite");
                setLog_file("asn1_app_test.init_per_suite.html");
                setStarted(parse_date("2012-11-19 17:07:00"));
                setEnded(parse_date("2012-11-19 17:07:00"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.03667"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_app_test:fields");
                setLog_file("asn1_app_test.fields.html");
                setStarted(parse_date("2012-11-19 17:07:00"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.14e-4"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_app_test:modules");
                setLog_file("asn1_app_test.modules.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.002038"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_app_test:exportall");
                setLog_file("asn1_app_test.exportall.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("8.56e-4"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_app_test:app_depend");
                setLog_file("asn1_app_test.app_depend.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.061"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_app_test:end_per_suite");
                setLog_file("asn1_app_test.end_per_suite.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.0e-6"));
                setGroup_time("0.336s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_suite");
                setLog_file("asn1_suite.init_per_suite.341221.200.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("9.08e-4"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.341221.366.html");
                setGroup_props("[{name,app_test}]");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.5e-5"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.341221.403.html");
                setGroup_props("[{name,appup_test}]");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_suite");
                setLog_file("asn1_suite.end_per_suite.341221.435.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_appup_test:init_per_suite");
                setLog_file("asn1_appup_test.init_per_suite.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("6.0e-5"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_appup_test:appup");
                setLog_file("asn1_appup_test.appup.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.002736"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_appup_test:end_per_suite");
                setLog_file("asn1_appup_test.end_per_suite.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
                setGroup_time("0.071s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_suite");
                setLog_file("asn1_suite.init_per_suite.341221.569.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("5.87e-4"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.341221.716.html");
                setGroup_props("[{name,appup_test}]");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testComment");
                setLog_file("asn1_suite.testcomment.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:01"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.040794"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testName2Number");
                setLog_file("asn1_suite.testname2number.html");
                setStarted(parse_date("2012-11-19 17:07:01"));
                setEnded(parse_date("2012-11-19 17:07:06"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("4.268871"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:ticket_7407");
                setLog_file("asn1_suite.ticket_7407.html");
                setStarted(parse_date("2012-11-19 17:07:06"));
                setEnded(parse_date("2012-11-19 17:07:06"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.33156"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:ticket7904");
                setLog_file("asn1_suite.ticket7904.html");
                setStarted(parse_date("2012-11-19 17:07:06"));
                setEnded(parse_date("2012-11-19 17:07:06"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("0.150899"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:init_per_group");
                setLog_file("asn1_suite.init_per_group.341226.660.html");
                setGroup_props("[{name,performance}]");
                setStarted(parse_date("2012-11-19 17:07:06"));
                setEnded(parse_date("2012-11-19 17:07:06"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTimer_ber");
                setLog_file("asn1_suite.testtimer_ber.html");
                setStarted(parse_date("2012-11-19 17:07:06"));
                setEnded(parse_date("2012-11-19 17:07:14"));
                setResult(parse_result("ok"));
                setResult_msg(" encode: 155 micro, decode: 199 micro.  [ber]");
                setElapsed(parse_float("7.370036"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTimer_ber_bin");
                setLog_file("asn1_suite.testtimer_ber_bin.html");
                setStarted(parse_date("2012-11-19 17:07:14"));
                setEnded(parse_date("2012-11-19 17:07:21"));
                setResult(parse_result("ok"));
                setResult_msg(" encode: 153 micro, decode: 194 micro.  [ber_bin]");
                setElapsed(parse_float("7.396968"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTimer_ber_bin_opt");
                setLog_file("asn1_suite.testtimer_ber_bin_opt.html");
                setStarted(parse_date("2012-11-19 17:07:21"));
                setEnded(parse_date("2012-11-19 17:07:26"));
                setResult(parse_result("ok"));
                setResult_msg(" encode: 73 micro, decode: 89 micro.  [ber_bin,optimize]");
                setElapsed(parse_float("5.133003"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTimer_ber_bin_opt_driver");
                setLog_file("asn1_suite.testtimer_ber_bin_opt_driver.html");
                setStarted(parse_date("2012-11-19 17:07:26"));
                setEnded(parse_date("2012-11-19 17:07:31"));
                setResult(parse_result("ok"));
                setResult_msg(" encode: 75 micro, decode: 58 micro.  [ber_bin,optimize,driver]");
                setElapsed(parse_float("5.143168"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTimer_per");
                setLog_file("asn1_suite.testtimer_per.html");
                setStarted(parse_date("2012-11-19 17:07:31"));
                setEnded(parse_date("2012-11-19 17:07:38"));
                setResult(parse_result("ok"));
                setResult_msg(" encode: 160 micro, decode: 317 micro.  [per]");
                setElapsed(parse_float("6.546077"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTimer_per_bin");
                setLog_file("asn1_suite.testtimer_per_bin.html");
                setStarted(parse_date("2012-11-19 17:07:38"));
                setEnded(parse_date("2012-11-19 17:07:44"));
                setResult(parse_result("ok"));
                setResult_msg(" encode: 160 micro, decode: 271 micro.  [per_bin]");
                setElapsed(parse_float("6.147938"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTimer_per_bin_opt");
                setLog_file("asn1_suite.testtimer_per_bin_opt.html");
                setStarted(parse_date("2012-11-19 17:07:44"));
                setEnded(parse_date("2012-11-19 17:07:50"));
                setResult(parse_result("ok"));
                setResult_msg(" encode: 93 micro, decode: 91 micro.  [per_bin,optimize]");
                setElapsed(parse_float("5.453173"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:testTimer_uper_bin");
                setLog_file("asn1_suite.testtimer_uper_bin.html");
                setStarted(parse_date("2012-11-19 17:07:50"));
                setEnded(parse_date("2012-11-19 17:07:56"));
                setResult(parse_result("ok"));
                setResult_msg(" encode: 110 micro, decode: 269 micro.  []");
                setElapsed(parse_float("5.968391"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:smp");
                setLog_file("asn1_suite.smp.html");
                setStarted(parse_date("2012-11-19 17:07:56"));
                setEnded(parse_date("2012-11-19 17:07:56"));
                setResult(parse_result("skipped"));
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_group");
                setLog_file("asn1_suite.end_per_group.341276.137.html");
                setGroup_props("[{name,performance}]");
                setStarted(parse_date("2012-11-19 17:07:56"));
                setEnded(parse_date("2012-11-19 17:07:56"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("2.0e-6"));
                setGroup_time("49.478s");
            }
        });
        r.addChild(new CTResult(null) {
            {
                setCase_name("asn1_SUITE:end_per_suite");
                setLog_file("asn1_suite.end_per_suite.341276.169.html");
                setStarted(parse_date("2012-11-19 17:07:56"));
                setEnded(parse_date("2012-11-19 17:07:56"));
                setResult(parse_result("ok"));
                setElapsed(parse_float("1.0e-6"));
            }
        });

        return r;
    }
}
