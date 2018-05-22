package no.difi;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class AccumulateAmount {

    public static void main(String[] args) {
        Map<String, Map<Integer, Integer>> records = new HashMap<>();
        Map<Integer, Integer> amount = new HashMap<>();
        amount.put(5, 5);
        amount.put(3, 3);
        amount.put(4, 4);
        amount.put(1, 1);
        amount.put(11, 11);
        amount.put(2, 2);
        records.put("Formidling af viden", amount);

        records.forEach((k1, v1) -> {
            System.out.println("primary key: " + k1 + ", value: " + v1);
            v1.forEach((k2, v2) -> {
                System.out.println("period: " + k2 + ", value: " + v2);
            });
        });
        
        Table<String, Integer, Integer> tAmount = TreeBasedTable.create();
    }

}
