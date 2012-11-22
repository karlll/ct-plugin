package se.nctrl.jenkins.plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.kohsuke.stapler.bind.JavaScriptMethod;

/**
 *
 * @author karl
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

        public String getLabel() {
            return label;
        }
        
        public CTReportTable(String label, int id, Collection<CTResult> res) {
            this.label = label;
            this.res = new ArrayList<CTResult>();
            this.res.addAll(res);
            this.table_id = id;
            
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
        
       
        
    }

    public CTReportLayout(CTResult top_result) {
    
        int id_c = 0;
        
        this.top_result = top_result;
        this.tables = new ArrayList<CTReportTable>();
        
        for ( Map.Entry<String,Collection<CTResult>> e : top_result.getSuites().entrySet() )
        {
            
            CTReportTable t = new CTReportTable(e.getKey(),id_c,e.getValue());
            
            this.totalCount  += t.getTotalCount();
            this.passCount += t.getPassCount();
            this.failCount += t.getFailCount();
            this.skipCount += t.getSkipCount();
            this.tables.add(t);
            id_c = id_c + 1;
            this.num_tables = this.num_tables + 1;
        }
    
    }

     @JavaScriptMethod
        public String ajaxTest()
        {
          return "Hullo";  
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

}
