package no.difi;

import java.util.Map.Entry;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class AccumulateAmount {

    public static void main(String[] args) {
    	Integer ytd = 0; // Year To Date
        Table<String, Integer, Integer> tAmount = TreeBasedTable.create();
        
        tAmount.put("Formidling af viden", 5, 5);
        tAmount.put("Formidling af viden", 1, 1);
        tAmount.put("Motivering vha. podcast", 1, 1);
        tAmount.put("Formidling af viden", 4, 4);
        tAmount.put("Formidling af viden", 2, 2);
        tAmount.put("Formidling af viden", 11, 11);
        tAmount.put("Motivering vha. podcast", 2, 2);
        tAmount.put("Formidling af viden", 3, 3);
        System.out.println("guava table: " + tAmount.size());

        for (String item : tAmount.rowKeySet()) {
            System.out.println("guava rowKeySet(): " + item);
            ytd = 0;
            for (Entry<Integer, Integer> period : tAmount.row(item).entrySet()) {
            	ytd += period.getValue();
                System.out.println("period: " + period.getKey() + ", value: " + period.getValue() + ", YTD: " + ytd);
            }
        }
    }
}
