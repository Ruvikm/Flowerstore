package 实验三鲜花销售系统.Forms;/*
 * Created by JFormDesigner on Wed May 06 18:33:22 CST 2020
 */

import sun.security.util.Password;
import 实验三鲜花销售系统.Factory.FactoryService;
import 实验三鲜花销售系统.Realize.Service.ICustomerService;
import 实验三鲜花销售系统.Realize.Service.IFlowerStoreService;
import 实验二图书销售系统.Interface.ICustomer;

import javax.naming.Name;
import javax.swing.JOptionPane;//导入java.swing包下的JOptionPane类
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * @author Ruvik
 */
public class login {
    public login() {
        initComponents();
    }

    private String select="";

    private void Login_buttonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String name = username_test.getText();
        String password = password_test.getPassword().toString();
        IFlowerStoreService iFlowerStoreService = FactoryService.factoryService.getFlowerStoreService();
        ICustomerService iCustomerService = FactoryService.factoryService.getiCustomerService();
        if (select.equals("管理员")) {
            if(iFlowerStoreService.Login(name, password))
                JOptionPane.showMessageDialog(null, "欢迎登录，管理员！");
            else
                JOptionPane.showMessageDialog(null, "用户名或密码输入错误！");
        } else if (select.equals("用户")) {
            if(iCustomerService.C_Login(name, password))
                JOptionPane.showMessageDialog(null, "欢迎登录，" + name + "！");
            else
                JOptionPane.showMessageDialog(null, "用户名或密码输入错误！");
        } else
            JOptionPane.showMessageDialog(null, "请选择用户类型！");

    }

    private void manager_checkActionPerformed(ActionEvent e) {
        // TODO add your code here
        JRadioButton sourceButton=(JRadioButton)e.getSource();
        select=sourceButton.getText();

    }

    private void user_checkActionPerformed(ActionEvent e) {
        // TODO add your code here
        JRadioButton sourceButton=(JRadioButton)e.getSource();
        select=sourceButton.getText();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Login_Form = new JFrame();
        Login_title = new JLabel();
        Login_user = new JLabel();
        Login_password = new JLabel();
        username_test = new JTextField();
        password_test = new JPasswordField();
        Login_button = new JButton();
        user_check = new JRadioButton();
        manager_check = new JRadioButton();

        //======== Login_Form ========
        {
            Login_Form.setMinimumSize(new Dimension(360, 430));
            Container Login_FormContentPane = Login_Form.getContentPane();
            Login_FormContentPane.setLayout(null);

            //---- Login_title ----
            Login_title.setText("WELCOME");
            Login_title.setFont(Login_title.getFont().deriveFont(Login_title.getFont().getSize() + 2f));
            Login_FormContentPane.add(Login_title);
            Login_title.setBounds(145, 25, 75, 30);

            //---- Login_user ----
            Login_user.setText("\u7528\u6237\u540d");
            Login_FormContentPane.add(Login_user);
            Login_user.setBounds(new Rectangle(new Point(65, 85), Login_user.getPreferredSize()));

            //---- Login_password ----
            Login_password.setText("\u5bc6\u7801");
            Login_password.setFont(Login_password.getFont().deriveFont(Login_password.getFont().getSize() + 1f));
            Login_FormContentPane.add(Login_password);
            Login_password.setBounds(new Rectangle(new Point(65, 195), Login_password.getPreferredSize()));
            Login_FormContentPane.add(username_test);
            username_test.setBounds(65, 120, 220, 28);
            Login_FormContentPane.add(password_test);
            password_test.setBounds(65, 235, 220, 28);

            //---- Login_button ----
            Login_button.setText("\u767b\u5f55");
            Login_button.addActionListener(e -> Login_buttonActionPerformed(e));
            Login_FormContentPane.add(Login_button);
            Login_button.setBounds(110, 355, 143, Login_button.getPreferredSize().height);

            //---- user_check ----
            user_check.setText("\u7528\u6237");
            user_check.addActionListener(e -> user_checkActionPerformed(e));
            Login_FormContentPane.add(user_check);
            user_check.setBounds(new Rectangle(new Point(225, 315), user_check.getPreferredSize()));

            //---- manager_check ----
            manager_check.setText("\u7ba1\u7406\u5458");
            manager_check.addActionListener(e -> manager_checkActionPerformed(e));
            Login_FormContentPane.add(manager_check);
            manager_check.setBounds(new Rectangle(new Point(280, 315), manager_check.getPreferredSize()));

            Login_FormContentPane.setPreferredSize(new Dimension(360, 430));
            Login_Form.pack();
            Login_Form.setLocationRelativeTo(Login_Form.getOwner());
        }

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(user_check);
        buttonGroup1.add(manager_check);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame Login_Form;
    private JLabel Login_title;
    private JLabel Login_user;
    private JLabel Login_password;
    private JTextField username_test;
    private JPasswordField password_test;
    private JButton Login_button;
    private JRadioButton user_check;
    private JRadioButton manager_check;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new login().Login_Form.setVisible(true);
    }
}
