/*
 * Created by JFormDesigner on Thu May 14 18:04:12 CST 2020
 */

package FlowerStore.Forms;

import FlowerStore.Factory.FactoryDAO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;

/**
 * @author Ruvik
 */
public class Customer_Home extends JFrame {


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
    private JLabel username;
    private JLabel sex;
    private JLabel phone;
    private JLabel sign;
    private JTextField usertext;
    private JTextField sextext;
    private JTextField phonetext;
    private JTextField signtext;
    private JLabel PasswordTitle;
    private JLabel originalP;
    private JLabel newP;
    private JTextField original_password;
    private JTextField new_password;
    private JButton Save;
    private JLabel UserId_Title;
    private JLabel UserID;
    public Customer_Home(){
        initComponents();
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private void thisWindowOpened(WindowEvent e) {
        // TODO add your code here
        String name=login.name;
        UserID.setText(FactoryDAO.getICustomer().getCustomer(name).getCustomer_id()+" ");
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
        username = new JLabel();
        sex = new JLabel();
        phone = new JLabel();
        sign = new JLabel();
        usertext = new JTextField();
        sextext = new JTextField();
        phonetext = new JTextField();
        signtext = new JTextField();
        PasswordTitle = new JLabel();
        originalP = new JLabel();
        newP = new JLabel();
        original_password = new JTextField();
        new_password = new JTextField();
        Save = new JButton();
        UserId_Title = new JLabel();
        UserID = new JLabel();

        //======== this ========
        setIconImage(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setTabPlacement(SwingConstants.LEFT);
            tabbedPane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

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
                label1.setIcon(new ImageIcon(getClass().getResource("/FlowerStore/img/flowers/\u90c1\u91d1\u9999.png")));
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
                Me.setFont(Me.getFont().deriveFont(Me.getFont().getSize() + 6f));
                Me.setLayout(null);

                //---- Title ----
                Title.setText("\u6211\u7684\u8d44\u6599");
                Title.setFont(Title.getFont().deriveFont(Title.getFont().getSize() + 8f));
                Me.add(Title);
                Title.setBounds(new Rectangle(new Point(70, 30), Title.getPreferredSize()));

                //---- username ----
                username.setText("\u7528\u6237\u540d");
                username.setLabelFor(usertext);
                username.setFont(username.getFont().deriveFont(username.getFont().getSize() + 6f));
                Me.add(username);
                username.setBounds(new Rectangle(new Point(160, 85), username.getPreferredSize()));

                //---- sex ----
                sex.setText("\u6027\u522b");
                sex.setLabelFor(sextext);
                sex.setFont(sex.getFont().deriveFont(sex.getFont().getSize() + 6f));
                Me.add(sex);
                sex.setBounds(new Rectangle(new Point(160, 125), sex.getPreferredSize()));

                //---- phone ----
                phone.setText("\u624b\u673a");
                phone.setLabelFor(phonetext);
                phone.setFont(phone.getFont().deriveFont(phone.getFont().getSize() + 6f));
                Me.add(phone);
                phone.setBounds(new Rectangle(new Point(160, 165), phone.getPreferredSize()));

                //---- sign ----
                sign.setText("\u7b7e\u540d");
                sign.setLabelFor(signtext);
                sign.setFont(sign.getFont().deriveFont(sign.getFont().getSize() + 6f));
                Me.add(sign);
                sign.setBounds(new Rectangle(new Point(160, 205), sign.getPreferredSize()));
                Me.add(usertext);
                usertext.setBounds(230, 80, 230, 30);
                Me.add(sextext);
                sextext.setBounds(230, 120, 230, 30);
                Me.add(phonetext);
                phonetext.setBounds(230, 160, 230, 30);
                Me.add(signtext);
                signtext.setBounds(230, 200, 230, 65);

                //---- PasswordTitle ----
                PasswordTitle.setText("\u4fee\u6539\u5bc6\u7801");
                PasswordTitle.setFont(PasswordTitle.getFont().deriveFont(PasswordTitle.getFont().getSize() + 8f));
                Me.add(PasswordTitle);
                PasswordTitle.setBounds(new Rectangle(new Point(70, 290), PasswordTitle.getPreferredSize()));

                //---- originalP ----
                originalP.setText("\u539f\u5bc6\u7801");
                originalP.setLabelFor(original_password);
                originalP.setFont(originalP.getFont().deriveFont(originalP.getFont().getSize() + 6f));
                Me.add(originalP);
                originalP.setBounds(new Rectangle(new Point(160, 335), originalP.getPreferredSize()));

                //---- newP ----
                newP.setText("\u65b0\u5bc6\u7801");
                newP.setLabelFor(new_password);
                newP.setFont(newP.getFont().deriveFont(newP.getFont().getSize() + 6f));
                Me.add(newP);
                newP.setBounds(new Rectangle(new Point(160, 375), newP.getPreferredSize()));
                Me.add(original_password);
                original_password.setBounds(230, 330, 230, 30);
                Me.add(new_password);
                new_password.setBounds(230, 370, 230, 30);

                //---- Save ----
                Save.setText("\u4fdd\u5b58");
                Save.setFont(Save.getFont().deriveFont(Save.getFont().getSize() + 6f));
                Me.add(Save);
                Save.setBounds(280, 430, 110, Save.getPreferredSize().height);

                //---- UserId_Title ----
                UserId_Title.setText("UserID :");
                UserId_Title.setFont(UserId_Title.getFont().deriveFont(UserId_Title.getFont().getSize() + 1f));
                Me.add(UserId_Title);
                UserId_Title.setBounds(530, 25, 48, 20);

                //---- UserID ----
                UserID.setText("           ");
                UserID.setFont(UserID.getFont().deriveFont(UserID.getFont().getSize() + 1f));
                Me.add(UserID);
                UserID.setBounds(590, 25, 50, 20);

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
        tabbedPane1.setBounds(0, 5, 750, 495);

        contentPane.setPreferredSize(new Dimension(760, 540));
        setSize(760, 540);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
