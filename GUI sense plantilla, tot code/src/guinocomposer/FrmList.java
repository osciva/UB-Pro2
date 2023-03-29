/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guinocomposer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author d4v1dWINPC
 */
public class FrmList extends JFrame {

    public ArrayList<String> cognoms = new ArrayList<String>(Arrays.asList("Dionis", "Soler", "Albiac", "de Mariana", "de Vitoria", "Garriga", "Trias", "Vives", "Pujol", "Rivera", "de Quadras", "Castell", "Chapinal", "Torello", "Rallo", "Huerta de Sotos", "Bastos"));
    public JPanel panel;
    public JScrollPane scrollPane;
    public JList llista;
    public JButton btnSeleccionar;
    public JTextField fieldCognom;
    public JButton btnAfegir;
    public JButton btnEliminar;

    public FrmList() {
        initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);

        panel = new JPanel();

        this.add(panel);
        panel.setLayout(null);

        fieldCognom = new JTextField();
        fieldCognom.setBounds(5, 0, 295, 40);

        panel.add(fieldCognom);

        btnAfegir = new JButton("Afegir Cognom");
        btnAfegir.setBounds(300, 0, 180, 40);

        btnAfegir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionAfegirCognom(evt);
            }
        });

        panel.add(btnAfegir);

        llista = new JList();

        llista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //sol poder seleccionar 1
        carregarDadesLlista();

        scrollPane = new JScrollPane(llista); //necesita una la llista per funcionar bé.

        scrollPane.setBounds(5, 50, 475, 250);
        panel.add(scrollPane);

        btnSeleccionar = new JButton("Seleccionar");

        btnSeleccionar.setBounds(185, 310, 120, 30);

        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionBtnSeleccionar(evt);
            }
        }
        );

        panel.add(btnSeleccionar);
        
        btnEliminar = new JButton("Eliminar");

        btnEliminar.setBounds(185, 345, 120, 30);

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionEliminar(evt);
            }
        }
        );

        panel.add(btnEliminar);

    }

    private void carregarDadesLlista() {
        DefaultListModel model = new DefaultListModel();

        for (String cognom : cognoms) {
            model.addElement(cognom);
        }

        llista.setModel(model);

    }

    private void actionBtnSeleccionar(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Cognom Seleccionat: " + cognoms.get(llista.getSelectedIndex()), "Cognom", JOptionPane.DEFAULT_OPTION);
    }

    private void actionAfegirCognom(ActionEvent evt) {
        
        cognoms.add(fieldCognom.getText());
        carregarDadesLlista();
        
        fieldCognom.setText("");
    }
    
    private void actionEliminar(ActionEvent evt) {
        cognoms.remove(llista.getSelectedIndex());
        
        carregarDadesLlista();
        
        JOptionPane.showMessageDialog(null, "Cognom Eliminat", "Eliminat", JOptionPane.DEFAULT_OPTION);
    }
}
