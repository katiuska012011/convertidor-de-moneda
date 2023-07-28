package model;

public enum EBills {
    DOLLAR("Convert your bills into dollars", 55.80),
    STERLING("Convert your bills into pounds sterling", 0.014),
    YEN("Convert your bills into yens", 2.52),
    EURO("Convert your bills into euro", 61.79);
    private final String value;
    private final Double coins;

    private EBills(String value, Double coins) {
        this.value = value;
        this.coins = coins;
    }

    public String getBill() {
        return value;
    }

    public Double getCoins() {
        return coins;
    }

    public  String getMessage(Double amount){
        return "You have $"+amount+" "+name().toLowerCase();
    }
    public static EBills getEnumByString(String item){
        for (EBills e : EBills.values()){
            if(e.getBill().equals(item)){
                return e;
            }
        }
        return null;
    }
}
