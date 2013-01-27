package se.nctrl.jenkins.plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.bind.JavaScriptMethod;

/**
 *
 * @author karl l <karl@ninjacontrol.com>
 */
public class CTReportLayout {
  
     
    private int num_tables;
    private int totalCount;
    private int passCount;
    private int failCount;
    private int skipCount;  
    
    private CTResult top_result;
    private Collection<CTReportTable> tables;
    
    
    
    
    public class CTReportTable {

        private String label;
        private ArrayList<CTResult> res;
        private int table_id;
        private int initial_state;
        
        private int passed = 0;
        private int failed = 0;
        private int skipped = 0;
        
        private int numCases = 0;

        public int getPassCount() {
            return passed;
        }

        public int getFailCount() {
            return failed;
        }

        public int getSkipCount() {
            return skipped;
        }

        public int getTotalCount() {
            return numCases;
        }

        public int getTable_id() {
            return table_id;
        }

        public int getInitial_state() {
            return initial_state;
        }
        
        
        public String getLabel() {
            return label;
        }
        
        public CTReportTable(String label, int id, int initial_s, Collection<CTResult> res) {
            this.label = label;
            this.res = new ArrayList<CTResult>();
            this.res.addAll(res);
            this.table_id = id;
            this.initial_state = initial_s;
            
            for (CTResult r : this.res)
            {
                this.numCases += r.getTotalCases();
                this.failed += r.getTotalFailedCases();
                this.passed += r.getTotalPassedCases();
                this.skipped += r.getTotalSkippedCases();
            }
                  
        }
        
        
        public CTResult getRow(int row_id)
        {
            return this.res.get(row_id);
        }
        
        public Collection<CTResult> getRows()
        {
            return this.res;
        }
        
        private Collection<JSONObject> getShortRows()
        {
            ArrayList<JSONObject> rows = new ArrayList<JSONObject>();
            
            for (CTResult r : this.res) 
            {
                JSONObject row = new JSONObject();
                row.element("result", r.getResult());
                row.element("started", r.getStarted().toString());
                row.element("testcase",r.getName());
                row.element("logfile",r.getLog_file());
                rows.add(row);
            }
            
            return rows;
        }
        
        public JSONObject getJSON()
        {
            JSONObject ret = new JSONObject();
            
            ret.element("label", this.label);
            ret.element("table_id", this.table_id);
            ret.element("passed", this.passed);
            ret.element("failed", this.failed);
            ret.element("num_cases", this.numCases);
            ret.element("skipped", this.skipped);
            ret.element("short_rows", this.getShortRows());

            return ret;
        }
        
       
        
    }

    public CTReportLayout(CTResult top_result) {
    
        int id_c = 1;
        int initial_state = 0; // 0 == data not loaded, 1 == data loaded
        
        this.top_result = top_result;
        this.tables = new ArrayList<CTReportTable>();
        
        for ( Map.Entry<String,Collection<CTResult>> e : top_result.getSuites().entrySet() )
        {
            
            CTReportTable t = new CTReportTable(e.getKey(),id_c,initial_state,e.getValue());
            
            this.totalCount  += t.getTotalCount();
            this.passCount += t.getPassCount();
            this.failCount += t.getFailCount();
            this.skipCount += t.getSkipCount();
            this.tables.add(t);
            id_c = id_c + 1;
            this.num_tables = this.num_tables + 1;
        }
    
    }

    public int getNum_tables() {
        return num_tables;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPassCount() {
        return passCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public int getSkipCount() {
        return skipCount;
    }

    public Collection<CTReportTable> getTables() {
        return tables;
    }
    
    public CTReportTable getTable( int table_id) 
    {
        // TODO: this.tables should be indexed
        for (Iterator<CTReportTable> i = this.tables.iterator(); i.hasNext();)
        {
            CTReportTable tab = i.next();
            if (tab.getTable_id() == table_id)
            {
                return tab;
                
            }
                     
        }
        
        return null;
    }
    
    @JavaScriptMethod
    public JSONObject getJSONTable ( int table_id )
    {
        
        
        CTReportTable t = this.getTable(table_id);
        
        if (t != null) {
            return t.getJSON();
        } else { return null; }
        
    }
}
