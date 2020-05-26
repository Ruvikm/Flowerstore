/*
 * Created by JFormDesigner on Tue May 19 11:17:28 CST 2020
 */

package FlowerStore.Forms;

import FlowerStore.Entity.Customer;
import FlowerStore.Entity.User;
import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Factory.FactoryService;
import FlowerStore.Realize.DAO.IUser;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Ruvik
 */
public class regist extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel username;
    private JLabel user;
    private JLabel password1;
    private JLabel password2;
    private JButton regist_button;
    private JTextField username_text;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public regist(){
        initComponents();
    }

    private void regist_buttonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String name = "";
        String password1 = "";
        String password2 = "";
        name = username_text.getText();
        User user = new User();
        Customer customer = new Customer();
        password1 = String.valueOf(passwordField1.getPassword());
        password2 = String.valueOf(passwordField2.getPassword());
        if (name.equals("") || password1.equals("") || password2.equals("")) {
            JOptionPane.showMessageDialog(null, "请输入用户名或密码");
        } else {
            if (password1.equals(password2)) {
                customer.setCustomer_name(name);
                user.setPassword(password1);
                user.setName(name);
                if (FactoryService.getiCustomerService().C_Regist(user, customer)) {
                    JOptionPane.showMessageDialog(null, "注册成功！");
                    this.dispose();
                } else
                    JOptionPane.showMessageDialog(null, "已有用户名！");


            } else
                JOptionPane.showMessageDialog(null, "两次密码不对！");
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        username = new JLabel();
        user = new JLabel();
        password1 = new JLabel();
        password2 = new JLabel();
        regist_button = new JButton();
        username_text = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();

        //======== this ========
        setTitle("\u6ce8\u518c");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- username ----
        username.setText("REGIST");
        username.setFont(username.getFont().deriveFont(username.getFont().getSize() + 6f));
        contentPane.add(username);
        username.setBounds(167, 60, 108, username.getPreferredSize().height);

        //---- user ----
        user.setText("\u7528\u6237\u540d");
        user.setFont(user.getFont().deriveFont(user.getFont().getSize() + 4f));
        contentPane.add(user);
        user.setBounds(new Rectangle(new Point(80, 140), user.getPreferredSize()));

        //---- password1 ----
        password1.setText("\u5bc6\u7801");
        password1.setFont(password1.getFont().deriveFont(password1.getFont().getSize() + 4f));
        contentPane.add(password1);
        password1.setBounds(80, 225, 40, 22);

        //---- password2 ----
        password2.setText("\u786e\u8ba4\u5bc6\u7801");
        password2.setFont(password2.getFont().deriveFont(password2.getFont().getSize() + 4f));
        contentPane.add(password2);
        password2.setBounds(new Rectangle(new Point(80, 310), password2.getPreferredSize()));

        //---- regist_button ----
        regist_button.setText("\u6ce8\u518c");
        regist_button.setFont(regist_button.getFont().deriveFont(regist_button.getFont().getSize() + 4f));
        regist_button.addActionListener(e -> regist_buttonActionPerformed(e));
        contentPane.add(regist_button);
        regist_button.setBounds(140, 460, 120, regist_button.getPreferredSize().height);
        contentPane.add(username_text);
        username_text.setBounds(80, 170, 240, 30);
        contentPane.add(passwordField1);
        passwordField1.setBounds(80, 255, 240, 30);
        contentPane.add(passwordField2);
        passwordField2.setBounds(80, 340, 240, 30);

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
        setSize(400, 560);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
