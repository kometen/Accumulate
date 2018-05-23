package no.difi;

public class Pair {
    
    private Integer amount;
    private Integer YTDamount;


    public Pair(Integer amount) {
        this.amount = amount;
    }

    public Integer getYTDamount() {
        return YTDamount;
    }
    public void setYTDamount(Integer yTDamount) {
        YTDamount = yTDamount;
    }
    public Integer getAmount() {
        return amount;
    }

}
