/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class data_input {

    public ArrayList<Person> addData(final ArrayList<String> name) {
        final ArrayList<Person> b = new ArrayList<Person>();
        final JFrame jf = new JFrame("加入今日信息");
        JPanel jp1 = new JPanel(new GridLayout(5, 2));
        JPanel jp2 = new JPanel();
        final int i = 0;
        final int size = name.size();
        final String name1 = name.get(i);
        
        JLabel jl1 = new JLabel("姓名：");
        JLabel jl2 = new JLabel("高压：");
        JLabel jl3 = new JLabel("低压：");
        JLabel jl4 = new JLabel("血糖:");
        JLabel jl5 = new JLabel(name1);
        //JLabel jl5=new JLabel("Price:");
        final JTextField jtf1 = new JTextField(15);
        final JTextField jtf2 = new JTextField(15);
        final JTextField jtf3 = new JTextField(15);
        final JTextField jtf4 = new JTextField(15);
        
        // final JTextField jtf5=new JTextField(15);
        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int p = 1;
                
                
                String Id = name1;
                if (Id == null || Id.equals("")) {
                    JOptionPane.showMessageDialog(null, "姓名不可以为空");
                    jtf1.requestFocus();
                } else {
                    /*
                }
                    for (int j = 0; j < b.size(); j++) {
                        Person l = (Person) b.get(j);
                        if (l.getName().equals(jtf1.getText())) {
                            p = 0;
                        }
                    }
                    if (p == 0) {
                        JOptionPane.showMessageDialog(null, "人员姓名不存在，请重试");
                        jtf1.requestFocus();
                    } else if (p == 1) {
                          */
                        String pressure_high = jtf2.getText();
                        String pressure_low = jtf3.getText();
                        String xue_rang = jtf4.getText();
                        int high = 0;
                        int low = 0;
                        float xue_tang = 0;
                        try {
                            high = Integer.parseInt(pressure_high);
                        } catch (Exception e) {
                            System.out.println("输入非数字");
                        }
                        try {
                            low = Integer.parseInt(pressure_low);
                        } catch (Exception e) {
                            System.out.println("输入非数字");
                        }
                        try {
                            xue_tang = Float.parseFloat(xue_rang);
                        } catch (Exception e) {
                            System.out.println("输入非数字");
                        }
                        //String Price = jtf5.getText();
                        Person c = new Person(Id, xue_tang, high, low);
                        b.add(c);
                        int j = i;
                        if(size == 1){
                        JOptionPane.showMessageDialog(null, "输入完毕");
                        }
                        jtf2.requestFocus();
                        //some error here....
                        
                        if(name != null && name.size() != 0 && name.get(j) != null){
                            
                            name.remove(j);
                            if(name.size() != 0){
                            addData(name);
                            }
                            j++;
                        }
                        jf.dispose();//这一句在你需要关闭addCat窗口的时候调用
                    
                }
            }

          //  @Override
            // public void actionPerformed(ActionEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //  }
        });
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jf.dispose();
            }
        });
        jp1.add(jl1);
        jp1.add(jl5);
        jp1.add(jl2);
        jp1.add(jtf2);
        jp1.add(jl3);
        jp1.add(jtf3);
        jp1.add(jl4);
        jp1.add(jtf4);

        jp2.add(confirm);
        jp2.add(cancel);
        jf.add(jp1, BorderLayout.CENTER);
        jf.add(jp2, BorderLayout.SOUTH);
        jf.setSize(300, 200);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        return b;
    }

    public static void main(String[] args) {
        data_input guitest = new data_input();
       // guitest.addData();
        String a = "a";
        String b = "b";
        String c = "c";
        ArrayList<String> name = new ArrayList<String>();
        name.add(a);
        name.add(b);
        name.add(c);
        guitest.addData(name);
    }

}
