package no.difi;

import no.difi.Pair;

import java.math.BigDecimal;
import java.util.Map.Entry;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class AccumulateAmount {

    public static void main(String[] args) {
    	BigDecimal ytd = new BigDecimal("0.0"); // Year To Date
    	// <Unique identifier, Period (month), Pair<amount (numeric(19,3))>>
        Table<String, Integer, Pair> tAmount = TreeBasedTable.create();
        
        tAmount.put("Formidling af viden", 5, new Pair(new BigDecimal("0.05")));
        tAmount.put("Formidling af viden", 1, new Pair(new BigDecimal("0.01")));
        tAmount.put("Motivering vha. podcast", 1, new Pair(new BigDecimal("0.01")));
        tAmount.put("Formidling af viden", 4, new Pair(new BigDecimal("0.04")));
        tAmount.put("Formidling af viden", 2, new Pair(new BigDecimal("0.02")));
        tAmount.put("Formidling af viden", 11, new Pair(new BigDecimal("0.11")));
        tAmount.put("Motivering vha. podcast", 2, new Pair(new BigDecimal("0.02")));
        tAmount.put("Formidling af viden", 3, new Pair(new BigDecimal("0.03")));
        tAmount.put("Formidling af viden", 6, new Pair(new BigDecimal("0.0")));
        System.out.println("guava table: " + tAmount.size());

        for (String item : tAmount.rowKeySet()) {
            System.out.println("guava rowKeySet(): " + item);
            ytd = BigDecimal.ZERO;
            for (Entry<Integer, Pair> period : tAmount.row(item).entrySet()) {
            	ytd = ytd.add(period.getValue().getAmount());
            	period.getValue().setYTDamount(ytd);
                System.out.println("period: " + period.getKey() + ", amount: " + period.getValue().getAmount() + ", YTD: " + period.getValue().getYTDamount());
            }
        }
    }
}
