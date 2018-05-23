package no.difi;

import no.difi.Pair;

import java.util.Map.Entry;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class AccumulateAmount {

    public static void main(String[] args) {
    	Integer ytd = 0; // Year To Date
    	// <Unique identifier, Period (month), Pair<amount (numeric(19,3))>>
        Table<String, Integer, Pair> tAmount = TreeBasedTable.create();
        
        tAmount.put("Formidling af viden", 5, new Pair(5));
        tAmount.put("Formidling af viden", 1, new Pair(1));
        tAmount.put("Motivering vha. podcast", 1, new Pair(1));
        tAmount.put("Formidling af viden", 4, new Pair(4));
        tAmount.put("Formidling af viden", 2, new Pair(2));
        tAmount.put("Formidling af viden", 11, new Pair(11));
        tAmount.put("Motivering vha. podcast", 2, new Pair(2));
        tAmount.put("Formidling af viden", 3, new Pair(3));
        tAmount.put("Formidling af viden", 6, new Pair(0));
        System.out.println("guava table: " + tAmount.size());

        for (String item : tAmount.rowKeySet()) {
            System.out.println("guava rowKeySet(): " + item);
            ytd = 0;
            for (Entry<Integer, Pair> period : tAmount.row(item).entrySet()) {
            	ytd += period.getValue().getAmount();
            	period.getValue().setYTDamount(ytd);
                System.out.println("period: " + period.getKey() + ", amount: " + period.getValue().getAmount() + ", YTD: " + period.getValue().getYTDamount());
            }
        }
    }
}
