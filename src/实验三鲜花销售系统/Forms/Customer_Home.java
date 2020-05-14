/*
 * Created by JFormDesigner on Thu May 14 18:04:12 CST 2020
 */

package 实验三鲜花销售系统.Forms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Ruvik
 */
public class Customer_Home extends JFrame {
    public Customer_Home() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        Check = new JPanel();
        Buy = new JPanel();
        label1 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        buy_numtext = new JTextField();
        label16 = new JLabel();
        label17 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        shopping_cart = new JPanel();
        button4 = new JButton();
        Orders = new JPanel();
        Me = new JPanel();
        Title = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        usertext = new JTextField();
        sextext = new JTextField();
        phonetext = new JTextField();
        signtext = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        original_password = new JTextField();
        new_password = new JTextField();
        button1 = new JButton();

        //======== this ========
        setIconImage(new ImageIcon("E:\\college\\code\\Java\\src\\\u5b9e\u9a8c\u4e09\u9c9c\u82b1\u9500\u552e\u7cfb\u7edf\\img\\\u5934\u50cf.PNG").getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setTabPlacement(SwingConstants.LEFT);

            //======== Check ========
            {
                Check.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < Check.getComponentCount(); i++) {
                        Rectangle bounds = Check.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = Check.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    Check.setMinimumSize(preferredSize);
                    Check.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u67e5\u8be2\u9c9c\u82b1", Check);

            //======== Buy ========
            {
                Buy.setLayout(null);

                //---- label1 ----
                label1.setIcon(new ImageIcon(getClass().getResource("/\u5b9e\u9a8c\u4e09\u9c9c\u82b1\u9500\u552e\u7cfb\u7edf/img/flowers/\u90c1\u91d1\u9999.png")));
                Buy.add(label1);
                label1.setBounds(20, 5, 220, 220);

                //---- label9 ----
                label9.setText("\u989c\u8272\uff1a");
                Buy.add(label9);
                label9.setBounds(new Rectangle(new Point(290, 100), label9.getPreferredSize()));

                //---- label10 ----
                label10.setText("\u5e93\u5b58\uff1a");
                Buy.add(label10);
                label10.setBounds(new Rectangle(new Point(290, 150), label10.getPreferredSize()));

                //---- label11 ----
                label11.setText("\u540d\u5b57\uff1a");
                Buy.add(label11);
                label11.setBounds(new Rectangle(new Point(290, 50), label11.getPreferredSize()));

                //---- label12 ----
                label12.setText("\u90c1\u91d1\u9999");
                Buy.add(label12);
                label12.setBounds(new Rectangle(new Point(340, 50), label12.getPreferredSize()));

                //---- label13 ----
                label13.setText("\u7c89\u7ea2\u8272");
                Buy.add(label13);
                label13.setBounds(new Rectangle(new Point(340, 100), label13.getPreferredSize()));

                //---- label14 ----
                label14.setText("160");
                Buy.add(label14);
                label14.setBounds(new Rectangle(new Point(340, 150), label14.getPreferredSize()));

                //---- label15 ----
                label15.setText("\u8d2d\u4e70\u6570\u91cf");
                label15.setLabelFor(buy_numtext);
                Buy.add(label15);
                label15.setBounds(new Rectangle(new Point(60, 310), label15.getPreferredSize()));
                Buy.add(buy_numtext);
                buy_numtext.setBounds(150, 305, 60, buy_numtext.getPreferredSize().height);

                //---- label16 ----
                label16.setText("\u5355\u4ef7\uff1a");
                Buy.add(label16);
                label16.setBounds(new Rectangle(new Point(290, 200), label16.getPreferredSize()));

                //---- label17 ----
                label17.setText("4\u5143");
                Buy.add(label17);
                label17.setBounds(new Rectangle(new Point(340, 200), label17.getPreferredSize()));

                //---- button2 ----
                button2.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
                Buy.add(button2);
                button2.setBounds(new Rectangle(new Point(100, 410), button2.getPreferredSize()));

                //---- button3 ----
                button3.setText("\u8d2d\u4e70");
                Buy.add(button3);
                button3.setBounds(new Rectangle(new Point(290, 410), button3.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < Buy.getComponentCount(); i++) {
                        Rectangle bounds = Buy.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = Buy.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    Buy.setMinimumSize(preferredSize);
                    Buy.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u8d2d\u4e70\u9c9c\u82b1", Buy);

            //======== shopping_cart ========
            {
                shopping_cart.setLayout(null);

                //---- button4 ----
                button4.setText("\u7ed3\u7b97");
                shopping_cart.add(button4);
                button4.setBounds(new Rectangle(new Point(345, 415), button4.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < shopping_cart.getComponentCount(); i++) {
                        Rectangle bounds = shopping_cart.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = shopping_cart.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    shopping_cart.setMinimumSize(preferredSize);
                    shopping_cart.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u8d2d\u7269\u8f66", shopping_cart);

            //======== Orders ========
            {
                Orders.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < Orders.getComponentCount(); i++) {
                        Rectangle bounds = Orders.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = Orders.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    Orders.setMinimumSize(preferredSize);
                    Orders.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u6211\u7684\u8ba2\u5355", Orders);

            //======== Me ========
            {
                Me.setLayout(null);

                //---- Title ----
                Title.setText("\u6211\u7684\u8d44\u6599");
                Me.add(Title);
                Title.setBounds(new Rectangle(new Point(30, 20), Title.getPreferredSize()));

                //---- label2 ----
                label2.setText("\u7528\u6237\u540d");
                label2.setLabelFor(usertext);
                Me.add(label2);
                label2.setBounds(new Rectangle(new Point(60, 60), label2.getPreferredSize()));

                //---- label3 ----
                label3.setText("\u6027\u522b");
                label3.setLabelFor(sextext);
                Me.add(label3);
                label3.setBounds(new Rectangle(new Point(60, 100), label3.getPreferredSize()));

                //---- label4 ----
                label4.setText("\u624b\u673a");
                label4.setLabelFor(phonetext);
                Me.add(label4);
                label4.setBounds(new Rectangle(new Point(60, 140), label4.getPreferredSize()));

                //---- label5 ----
                label5.setText("\u7b7e\u540d");
                label5.setLabelFor(signtext);
                Me.add(label5);
                label5.setBounds(new Rectangle(new Point(60, 180), label5.getPreferredSize()));
                Me.add(usertext);
                usertext.setBounds(120, 55, 230, 30);
                Me.add(sextext);
                sextext.setBounds(120, 95, 230, 30);
                Me.add(phonetext);
                phonetext.setBounds(120, 135, 230, 30);
                Me.add(signtext);
                signtext.setBounds(120, 175, 230, 65);

                //---- label6 ----
                label6.setText("\u4fee\u6539\u5bc6\u7801");
                Me.add(label6);
                label6.setBounds(new Rectangle(new Point(30, 280), label6.getPreferredSize()));

                //---- label7 ----
                label7.setText("\u539f\u5bc6\u7801");
                label7.setLabelFor(original_password);
                Me.add(label7);
                label7.setBounds(new Rectangle(new Point(60, 325), label7.getPreferredSize()));

                //---- label8 ----
                label8.setText("\u65b0\u5bc6\u7801");
                label8.setLabelFor(new_password);
                Me.add(label8);
                label8.setBounds(new Rectangle(new Point(60, 365), label8.getPreferredSize()));
                Me.add(original_password);
                original_password.setBounds(120, 320, 230, 30);
                Me.add(new_password);
                new_password.setBounds(120, 360, 230, 30);

                //---- button1 ----
                button1.setText("\u4fdd\u5b58");
                Me.add(button1);
                button1.setBounds(180, 420, 110, button1.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < Me.getComponentCount(); i++) {
                        Rectangle bounds = Me.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = Me.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    Me.setMinimumSize(preferredSize);
                    Me.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5173\u4e8e\u6211", Me);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 5, 540, 465);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel Check;
    private JPanel Buy;
    private JLabel label1;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JTextField buy_numtext;
    private JLabel label16;
    private JLabel label17;
    private JButton button2;
    private JButton button3;
    private JPanel shopping_cart;
    private JButton button4;
    private JPanel Orders;
    private JPanel Me;
    private JLabel Title;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField usertext;
    private JTextField sextext;
    private JTextField phonetext;
    private JTextField signtext;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField original_password;
    private JTextField new_password;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
