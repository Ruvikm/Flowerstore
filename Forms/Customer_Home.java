/*
 * Created by JFormDesigner on Thu May 14 18:04:12 CST 2020
 */

package FlowerStore.Forms;

import javax.swing.table.*;
import FlowerStore.Entity.Customer;
import FlowerStore.Entity.Flower;
import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Factory.FactoryService;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.UIManager;

/**
 * @author Ruvik
 */
public class Customer_Home extends JFrame {

    private String name;
    private Customer customer=new Customer();
    private int CustomerID;
    List<Flower> list=new ArrayList<>();
    DefaultTableModel tableModel=new DefaultTableModel();
    private String head[]=new String[] {"名字", "价格","数量", "颜色", "有货商店"};
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel Check;
    private JScrollPane scrollPane1;
    private JTable FlowerList;
    private JLabel ChooseTitle;
    private JLabel Namelabel;
    private JLabel Pricelabel;
    private JTextField price1;
    private JTextField price2;
    private JLabel label6;
    private JLabel numlabel;
    private JTextField num1;
    private JTextField num2;
    private JLabel label8;
    private JLabel label18;
    private JLabel label19;
    private JComboBox comboBox_name;
    private JComboBox comboBox_color;
    private JComboBox comboBox_shop;
    private JButton buttonchoose;
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
    private JScrollPane scrollPane2;
    private JTable table1;
    private JPanel Orders;
    private JPanel Me;
    private JLabel Title;
    private JLabel username;
    private JLabel sex;
    private JLabel phone;
    private JLabel sign;
    private JTextField usernametext;
    private JTextField sextext;
    private JTextField phonetext;
    private JTextField signtext;
    private JLabel PasswordTitle;
    private JLabel originalP;
    private JLabel newP;
    private JButton SaveInformation;
    private JLabel UserId_Title;
    private JLabel UserID;
    private JPasswordField original_password;
    private JPasswordField new_password;
    private JButton SavePass;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public Customer_Home(){
        initComponents();
    }
    private void thisWindowOpened(WindowEvent e) {
        // TODO add your code here
        InitData();

    }

    private void SaveInformationActionPerformed(ActionEvent e) {
        // TODO add your code here
        boolean flag = false;
        FactoryDAO.getICustomer().SetCustomer_name(CustomerID, usernametext.getText());
        FactoryDAO.getICustomer().SetCustomer_phone(CustomerID, phonetext.getText());
        FactoryDAO.getICustomer().SetCustomer_sign(CustomerID, signtext.getText());
        if (sextext.getText().equals("男") || sextext.getText().equals("女")) {
            FactoryDAO.getICustomer().SetCustomer_sex(CustomerID, sextext.getText());
        } else {
            JOptionPane.showMessageDialog(null, "性别请输入男or女！");
            flag=true;
        }
        if (!flag)
            JOptionPane.showMessageDialog(null, "修改成功！");
    }

    private void SavePassActionPerformed(ActionEvent e) {
        // TODO add your code here
        customer=FactoryDAO.getICustomer().getCustomerbyId(CustomerID);
        String OriginalP=String.valueOf(original_password.getPassword());
        String NewP=String.valueOf(new_password.getPassword());
        if(!OriginalP.equals("")&&!NewP.equals("")){
            if(OriginalP.equals(FactoryDAO.getIUser().CheckPassword(customer.getCustomer_name()))){
                FactoryDAO.getIUser().ChangePassword(CustomerID,NewP);
                JOptionPane.showMessageDialog(null, "修改成功！");
            }
            else
                JOptionPane.showMessageDialog(null, "原密码错误！");
        }
    }

    private void buttonchooseActionPerformed(ActionEvent e) {
        // TODO add your code here
        String flowerName = null;
        String color = null;
        String ShopName = null;
        int LowNum=-1;
        int HighNum=-1;
        int LowPrice=-1;
        int HighPrice=-1;
        if(!price1.getText().equals(""))
            LowPrice=Integer.parseInt(price1.getText());
        if(!price2.getText().equals(""))
            HighPrice=Integer.parseInt(price2.getText());
        if(!num1.getText().equals(""))
            LowNum=Integer.parseInt(num1.getText());
        if(!num2.getText().equals(""))
            HighNum=Integer.parseInt(num2.getText());
        if (comboBox_name.getSelectedItem() != null) {
            flowerName = (String) comboBox_name.getSelectedItem();
        } //获取被选中的项
        if (comboBox_color.getSelectedItem() != null) {
            color = (String) comboBox_color.getSelectedItem();
            System.out.println(color);
        }
        if (comboBox_shop.getSelectedItem() != null) {
            ShopName = (String) comboBox_shop.getSelectedItem();
        }

        tableModel.getDataVector().clear();
        tableModel=new DefaultTableModel(FactoryService.getiCustomerService().FilterFlowers(flowerName,color,ShopName,LowNum,HighNum,LowPrice,HighPrice,head),head);
        FlowerList.setModel(tableModel);//填充Jtable
        Check.revalidate();
        scrollPane1.validate();

        
        //System.out.println(name+color+ShopName);

    }

    private void InitData(){

        //region 个人信息获取及自动填充
        name=login.name;
        customer=FactoryDAO.getICustomer().getCustomerbyName(name);
        CustomerID=customer.getCustomer_id();
        UserID.setText(Integer.toString(customer.getCustomer_id()));
        usernametext.setText(customer.getCustomer_name());
        sextext.setText(customer.getCustomer_sex());
        phonetext.setText(customer.getCustomer_phone());
        signtext.setText(customer.getCustomer_sign());
        //endregion

        //region 获取全部花的信息
        tableModel=new DefaultTableModel(FactoryService.getiCustomerService().CheckAllFlowers(head),head){
            //使不可编辑
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        FlowerList.setModel(tableModel);//填充Jtable
        FlowerList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//


        //第一个为空值,默认不选以及可以实现多次选择
        comboBox_name.addItem(null);
        comboBox_color.addItem(null);
        comboBox_shop.addItem(null);
        //自动填充下拉菜单
        list=FactoryDAO.getIFlowers().CheckAllFlowers();
        //填充名字(名字不会出现重复)
        for(Flower v:list){
            comboBox_name.addItem(v.getFlower_name());
        }
        //填充颜色
        List<String> ColorList=FactoryDAO.getIFlowers().checkAllColors();
        for(String v:ColorList){
            comboBox_color.addItem(v);
        }
        //填充商店
        List<Integer> ShopID=FactoryDAO.getIFlowers().checkAllShops();
        for(Integer v:ShopID){
            comboBox_shop.addItem(FactoryDAO.getIStore().CheckStoreByID(v).getStore_name());
        }
        //endregion
    }



    private void initComponents() {
        
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        Check = new JPanel();
        scrollPane1 = new JScrollPane();
        FlowerList = new JTable();
        ChooseTitle = new JLabel();
        Namelabel = new JLabel();
        Pricelabel = new JLabel();
        price1 = new JTextField();
        price2 = new JTextField();
        label6 = new JLabel();
        numlabel = new JLabel();
        num1 = new JTextField();
        num2 = new JTextField();
        label8 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        comboBox_name = new JComboBox();
        comboBox_color = new JComboBox();
        comboBox_shop = new JComboBox();
        buttonchoose = new JButton();
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
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        Orders = new JPanel();
        Me = new JPanel();
        Title = new JLabel();
        username = new JLabel();
        sex = new JLabel();
        phone = new JLabel();
        sign = new JLabel();
        usernametext = new JTextField();
        sextext = new JTextField();
        phonetext = new JTextField();
        signtext = new JTextField();
        PasswordTitle = new JLabel();
        originalP = new JLabel();
        newP = new JLabel();
        SaveInformation = new JButton();
        UserId_Title = new JLabel();
        UserID = new JLabel();
        original_password = new JPasswordField();
        new_password = new JPasswordField();
        SavePass = new JButton();
        label2 = new JLabel();

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

                //======== scrollPane1 ========
                {

                    //---- FlowerList ----
                    FlowerList.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                        },
                        new String[] {
                            null, null, null, null, null
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = FlowerList.getColumnModel();
                        cm.getColumn(0).setResizable(false);
                    }
                    FlowerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    scrollPane1.setViewportView(FlowerList);
                }
                Check.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 690, 250);

                //---- ChooseTitle ----
                ChooseTitle.setText("\u7b5b\u9009");
                ChooseTitle.setFont(ChooseTitle.getFont().deriveFont(ChooseTitle.getFont().getSize() + 2f));
                Check.add(ChooseTitle);
                ChooseTitle.setBounds(25, 275, 45, 20);

                //---- Namelabel ----
                Namelabel.setText("\u82b1\u540d");
                Namelabel.setFont(Namelabel.getFont().deriveFont(Namelabel.getFont().getSize() + 2f));
                Namelabel.setLabelFor(comboBox_name);
                Check.add(Namelabel);
                Namelabel.setBounds(60, 320, 45, 20);

                //---- Pricelabel ----
                Pricelabel.setText("\u4ef7\u683c\u533a\u95f4");
                Pricelabel.setFont(Pricelabel.getFont().deriveFont(Pricelabel.getFont().getSize() + 2f));
                Check.add(Pricelabel);
                Pricelabel.setBounds(new Rectangle(new Point(375, 321), Pricelabel.getPreferredSize()));
                Check.add(price1);
                price1.setBounds(460, 315, 50, 30);
                Check.add(price2);
                price2.setBounds(570, 315, 50, 30);

                //---- label6 ----
                label6.setText("- - - - -");
                Check.add(label6);
                label6.setBounds(520, 322, 40, label6.getPreferredSize().height);

                //---- numlabel ----
                numlabel.setText("\u6570\u91cf\u533a\u95f4");
                numlabel.setFont(numlabel.getFont().deriveFont(numlabel.getFont().getSize() + 2f));
                Check.add(numlabel);
                numlabel.setBounds(new Rectangle(new Point(375, 383), numlabel.getPreferredSize()));
                Check.add(num1);
                num1.setBounds(460, 377, 50, 30);
                Check.add(num2);
                num2.setBounds(570, 377, 50, 30);

                //---- label8 ----
                label8.setText("- - - - -");
                Check.add(label8);
                label8.setBounds(520, 384, 40, 17);

                //---- label18 ----
                label18.setText("\u989c\u8272");
                label18.setFont(label18.getFont().deriveFont(label18.getFont().getSize() + 2f));
                label18.setLabelFor(comboBox_color);
                Check.add(label18);
                label18.setBounds(new Rectangle(new Point(60, 383), label18.getPreferredSize()));

                //---- label19 ----
                label19.setText("\u6240\u5728\u5e97\u94fa");
                label19.setFont(label19.getFont().deriveFont(label19.getFont().getSize() + 2f));
                label19.setLabelFor(comboBox_shop);
                Check.add(label19);
                label19.setBounds(new Rectangle(new Point(60, 445), label19.getPreferredSize()));

                //---- comboBox_name ----
                comboBox_name.setSelectedIndex(-1);
                Check.add(comboBox_name);
                comboBox_name.setBounds(140, 315, 84, 30);

                //---- comboBox_color ----
                comboBox_color.setSelectedIndex(-1);
                Check.add(comboBox_color);
                comboBox_color.setBounds(140, 377, 84, 30);

                //---- comboBox_shop ----
                comboBox_shop.setSelectedIndex(-1);
                Check.add(comboBox_shop);
                comboBox_shop.setBounds(140, 439, 84, 30);

                //---- buttonchoose ----
                buttonchoose.setText("\u7b5b\u9009");
                buttonchoose.addActionListener(e -> buttonchooseActionPerformed(e));
                Check.add(buttonchoose);
                buttonchoose.setBounds(545, 450, 85, 31);

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
                button4.setBounds(new Rectangle(new Point(560, 445), button4.getPreferredSize()));

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(table1);
                }
                shopping_cart.add(scrollPane2);
                scrollPane2.setBounds(0, 0, 690, 260);

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
                Title.setBounds(new Rectangle(new Point(45, 20), Title.getPreferredSize()));

                //---- username ----
                username.setText("\u7528\u6237\u540d");
                username.setLabelFor(usernametext);
                username.setFont(username.getFont().deriveFont(username.getFont().getSize() + 6f));
                Me.add(username);
                username.setBounds(new Rectangle(new Point(135, 60), username.getPreferredSize()));

                //---- sex ----
                sex.setText("\u6027\u522b");
                sex.setLabelFor(sextext);
                sex.setFont(sex.getFont().deriveFont(sex.getFont().getSize() + 6f));
                Me.add(sex);
                sex.setBounds(new Rectangle(new Point(135, 100), sex.getPreferredSize()));

                //---- phone ----
                phone.setText("\u624b\u673a");
                phone.setLabelFor(phonetext);
                phone.setFont(phone.getFont().deriveFont(phone.getFont().getSize() + 6f));
                Me.add(phone);
                phone.setBounds(new Rectangle(new Point(135, 140), phone.getPreferredSize()));

                //---- sign ----
                sign.setText("\u7b7e\u540d");
                sign.setLabelFor(signtext);
                sign.setFont(sign.getFont().deriveFont(sign.getFont().getSize() + 6f));
                Me.add(sign);
                sign.setBounds(new Rectangle(new Point(135, 180), sign.getPreferredSize()));
                Me.add(usernametext);
                usernametext.setBounds(205, 55, 230, 30);
                Me.add(sextext);
                sextext.setBounds(205, 95, 230, 30);
                Me.add(phonetext);
                phonetext.setBounds(205, 135, 230, 30);
                Me.add(signtext);
                signtext.setBounds(205, 175, 230, 65);

                //---- PasswordTitle ----
                PasswordTitle.setText("\u4fee\u6539\u5bc6\u7801");
                PasswordTitle.setFont(PasswordTitle.getFont().deriveFont(PasswordTitle.getFont().getSize() + 8f));
                Me.add(PasswordTitle);
                PasswordTitle.setBounds(new Rectangle(new Point(45, 305), PasswordTitle.getPreferredSize()));

                //---- originalP ----
                originalP.setText("\u539f\u5bc6\u7801");
                originalP.setFont(originalP.getFont().deriveFont(originalP.getFont().getSize() + 6f));
                Me.add(originalP);
                originalP.setBounds(new Rectangle(new Point(135, 350), originalP.getPreferredSize()));

                //---- newP ----
                newP.setText("\u65b0\u5bc6\u7801");
                newP.setFont(newP.getFont().deriveFont(newP.getFont().getSize() + 6f));
                Me.add(newP);
                newP.setBounds(new Rectangle(new Point(135, 390), newP.getPreferredSize()));

                //---- SaveInformation ----
                SaveInformation.setText("\u4fdd\u5b58");
                SaveInformation.setFont(SaveInformation.getFont().deriveFont(SaveInformation.getFont().getSize() + 2f));
                SaveInformation.addActionListener(e -> SaveInformationActionPerformed(e));
                Me.add(SaveInformation);
                SaveInformation.setBounds(530, 240, 100, 30);

                //---- UserId_Title ----
                UserId_Title.setText("UserID :");
                UserId_Title.setFont(UserId_Title.getFont().deriveFont(UserId_Title.getFont().getSize() + 1f));
                Me.add(UserId_Title);
                UserId_Title.setBounds(530, 15, 48, 20);

                //---- UserID ----
                UserID.setText("           ");
                UserID.setFont(UserID.getFont().deriveFont(UserID.getFont().getSize() + 1f));
                Me.add(UserID);
                UserID.setBounds(590, 15, 50, 20);
                Me.add(original_password);
                original_password.setBounds(205, 350, 230, 30);
                Me.add(new_password);
                new_password.setBounds(205, 390, 230, 30);

                //---- SavePass ----
                SavePass.setText("\u4fdd\u5b58");
                SavePass.setFont(SavePass.getFont().deriveFont(SavePass.getFont().getSize() + 2f));
                SavePass.addActionListener(e -> SavePassActionPerformed(e));
                Me.add(SavePass);
                SavePass.setBounds(530, 445, 100, 30);

                //---- label2 ----
                label2.setText("\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8\u00a8");
                Me.add(label2);
                label2.setBounds(5, 285, 675, 8);

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
        tabbedPane1.setBounds(0, 5, 765, 510);

        contentPane.setPreferredSize(new Dimension(780, 560));
        setSize(780, 560);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
