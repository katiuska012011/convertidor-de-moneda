package model;

import javax.swing.*;

public class BillsModel {

    private int amount;
    private Double amountConvert;
    private String[] options;
    private int selectIndex;
    private JLabel lb;

    private String item;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getAmountConvert() {
        return amountConvert;
    }

    public void setAmountConvert(Double amountConvert) {
        this.amountConvert = amountConvert;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }

    public JLabel getLb() {
        return lb;
    }

    public void setLb(JLabel lb) {
        this.lb = lb;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
