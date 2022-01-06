
package com.company;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener {

    static JFrame f;
    static JTextField textovePole;

    String cislicko;
    String pocetnioperace;
    String sekunda;

    calculator() {
        cislicko = pocetnioperace = sekunda = "";
    }

    public static void main(String[] args) {
        // create a frame
        f = new JFrame("Kalkulačka");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        calculator c = new calculator();
        textovePole = new JTextField(16);
        textovePole.setEditable(false);

        JButton cislo0;
        JButton cislo1;
        JButton cislo2;
        JButton cislo3;
        JButton cislo4;
        JButton cislo5;
        JButton cislo6;
        JButton cislo7;
        JButton cislo8;
        JButton cislo9;
        JButton plus;
        JButton minus;
        JButton krat;
        JButton deleno;
        JButton mod;
        JButton carka;
        JButton vycistit;
        JButton rovnaSe;

        cislo0 = new JButton("0");
        cislo1 = new JButton("1");
        cislo2 = new JButton("2");
        cislo3 = new JButton("3");
        cislo4 = new JButton("4");
        cislo5 = new JButton("5");
        cislo6 = new JButton("6");
        cislo7 = new JButton("7");
        cislo8 = new JButton("8");
        cislo9 = new JButton("9");

        rovnaSe = new JButton("=");
        plus = new JButton("+");
        minus = new JButton("-");
        deleno = new JButton("*");
        krat = new JButton("/");
        mod = new JButton("mod");
        vycistit = new JButton("C");
        carka = new JButton(".");

        // create a panel
        JPanel p = new JPanel();

        // add action listeners
        plus.addActionListener(c);
        minus.addActionListener(c);
        krat.addActionListener(c);
        deleno.addActionListener(c);
        mod.addActionListener(c);
        cislo9.addActionListener(c);
        cislo8.addActionListener(c);
        cislo7.addActionListener(c);
        cislo6.addActionListener(c);
        cislo5.addActionListener(c);
        cislo4.addActionListener(c);
        cislo3.addActionListener(c);
        cislo2.addActionListener(c);
        cislo1.addActionListener(c);
        cislo0.addActionListener(c);
        carka.addActionListener(c);
        vycistit.addActionListener(c);
        rovnaSe.addActionListener(c);

        // add elements to panel
        p.add(textovePole);

        p.add(cislo1);
        p.add(cislo2);
        p.add(cislo3);
        p.add(cislo4);
        p.add(cislo5);
        p.add(cislo6);
        p.add(cislo7);
        p.add(cislo8);
        p.add(cislo9);
        p.add(plus);
        p.add(cislo0);
        p.add(minus);
        p.add(krat);
        p.add(deleno);
        p.add(mod);
        p.add(carka);
        p.add(vycistit);
        p.add(rovnaSe);

        p.setBackground(Color.gray);

        f.add(p);
        f.setSize(250, 290);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!pocetnioperace.equals("")) {
                sekunda = sekunda + s;
            }
            else{
                cislicko = cislicko + s;
            }

            textovePole.setText(cislicko + pocetnioperace + sekunda);
        } else if (s.charAt(0) == 'C') {
            cislicko = pocetnioperace = sekunda = "";

            textovePole.setText(cislicko + pocetnioperace + sekunda);
        } else if (s.charAt(0) == '=') {

            double te = switch (pocetnioperace) {
                case "+" -> (Double.parseDouble(cislicko) + Double.parseDouble(sekunda));
                case "-" -> (Double.parseDouble(cislicko) - Double.parseDouble(sekunda));
                case "*" -> (Double.parseDouble(cislicko) * Double.parseDouble(sekunda));
                case "/" -> (Double.parseDouble(cislicko) / Double.parseDouble(sekunda));
                case "mod" -> (Double.parseDouble(cislicko) % Double.parseDouble(sekunda));
                default -> Double.parseDouble(cislicko);
            };

            textovePole.setText(cislicko + pocetnioperace + sekunda + "=" + te);

            cislicko = Double.toString(te);

            pocetnioperace = sekunda = "";
        } else {
            if (pocetnioperace.equals("") || sekunda.equals(""))
                pocetnioperace = s;
            else {
                double vysledek = switch (pocetnioperace) {
                    case "+" -> (Double.parseDouble(cislicko) + Double.parseDouble(sekunda));
                    case "-" -> (Double.parseDouble(cislicko) - Double.parseDouble(sekunda));
                    case "*" -> (Double.parseDouble(cislicko) * Double.parseDouble(sekunda));
                    case "/" -> (Double.parseDouble(cislicko) / Double.parseDouble(sekunda));
                    case "mod" -> (Double.parseDouble(cislicko) % Double.parseDouble(sekunda));
                    default -> Double.parseDouble(cislicko);
                };

                cislicko = Double.toString(vysledek);

                pocetnioperace = s;

                sekunda = "";
            }
            textovePole.setText(cislicko + pocetnioperace + sekunda);
        }
    }
}
