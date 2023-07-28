package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.System.*;

public class BillsController implements IConvert {
    Components components = new Components();
    BillsModel model = new BillsModel();
    String[] combo = {"Currency Converter", "Temperature Converter"};

    @Override
    public void menu() {
        JFrame frame = components.getFrame();
        frame.setName("Menu");
        JComboBox comboBox = new JComboBox<>(combo);
        comboBox.setBounds(50, 50, 300, 50);
        frame.add(comboBox);
        JButton btn = new JButton("Ok");
        btn.setBounds(120, 100, 150, 30);
        btn.setBackground(new java.awt.Color(50, 77, 255));
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Object op = JOptionPane.showInputDialog("Ingress a mount to convert", JOptionPane.OK_OPTION);
                try {
                    model.setAmount(Integer.parseInt(op.toString()));
                    options();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Value not valid");
                }
            }
        });
        frame.add(btn);
        frame.setLayout(null);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        closeIt(frame);
    }

    @Override
    public void options() {
        JFrame frame = new JFrame("Monedas");
        JButton btn = new JButton("Convertir");
        JLabel lb = new JLabel("Elige la moneda que deseas convertir tu dinero");

        JComboBox comboBox = new JComboBox(comboOptions());
        comboBox.setBounds(60, 50, 350, 50);
        lb.setBounds(60, 10, 300, 50);
        lb.setVisible(true);
        btn.setBounds(130, 120, 150, 30);
        btn.setBackground(new Color(90, 154, 236, 181));
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setVisible(true);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setItem(comboBox.getSelectedItem().toString());
                frame.dispose();
                convert();
            }
        });
        frame.add(lb);
        frame.add(comboBox);
        frame.add(btn);
        frame.setLayout(null);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        closeIt(frame);
    }

    @Override
    public void closeIt(JFrame frame) {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void convert() {
        EBills bills = EBills.getEnumByString(model.getItem());
        Double result = model.getAmount() / bills.getCoins();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        model.setAmountConvert(Double.valueOf(decimalFormat.format(result)));
        JLabel label = new JLabel(bills.getMessage(model.getAmountConvert()));
        components.setLabel(label);
        valueConvert();
    }

    @Override
    public void valueConvert() {
        JOptionPane.showMessageDialog(null, components.getLabel());
        int option = JOptionPane.showConfirmDialog(null, "Do you want to continue", "Question", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            menu();
        }else{
            System.exit(0);
        }
    }
    public Object[] comboOptions() {
       return Arrays.stream(EBills.values()).map(EBills::getBill).toArray();
    }


}
