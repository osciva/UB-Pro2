/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guinocomposer;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author d4v1dWINPC
 */
public class FrmLogin extends JFrame {

    public JPanel panel;
    public JLabel labelUser;
    public JTextField fieldUser;
    public JLabel labelPassword;
    public JTextField fieldPassword;
    public JCheckBox checkMantenir;
    public JButton btnLogin;

    public FrmLogin() {
        initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 220);
        this.setLocationRelativeTo(null);

        panel = new JPanel();

        this.add(panel);

        panel.setLayout(null);

        labelUser = new JLabel("Correu Electrónic:");
        labelUser.setBounds(20, 50, 150, 30);

        panel.add(labelUser);

        fieldUser = new JTextField();
        fieldUser.setBounds(180, 50, 300, 25);

        panel.add(fieldUser);

        labelPassword = new JLabel("Contrasenya:");
        labelPassword.setBounds(20, 80, 100, 30);

        panel.add(labelPassword);

        fieldPassword = new JTextField();
        fieldPassword.setBounds(180, 80, 300, 25);

        panel.add(fieldPassword);

        checkMantenir = new JCheckBox("Mantenir Sesió");

        checkMantenir.setBounds(370, 110, 120, 20);

        panel.add(checkMantenir);

        btnLogin = new JButton("Inciar Sesió");
        btnLogin.setBounds(360, 140, 120, 30);

        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionBtnLogin(evt);
            }
        });

        panel.add(btnLogin);

    }

    private void actionBtnLogin(ActionEvent evt) {
        new FrmList().setVisible(true);
    }
}
