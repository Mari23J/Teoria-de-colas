package com.mycompany.io_teoriadecolas_maricelajoaquinmoreno;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IO_TeoriaDeColas_MaricelaJoaquinMoreno extends JFrame implements ActionListener {
      private JTextField txtLlegada, txtServicio, txtN;
    private JLabel lblLlegada, lblServicio, lblN, lblResultado;
    private JButton btnCalcular;
    
    public IO_TeoriaDeColas_MaricelaJoaquinMoreno() {
        setTitle("TEORIA DE COLAS");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        
        lblLlegada = new JLabel("Ingrese el vlor de (λ):");
        add(lblLlegada);
        txtLlegada = new JTextField();
        add(txtLlegada);
        
        lblServicio = new JLabel("Ingrese el valor de (μ):");
        add(lblServicio);
        txtServicio = new JTextField();
        add(txtServicio);
        
        lblN = new JLabel("Cantiad de datos (n):");
        add(lblN);
        txtN = new JTextField();
        add(txtN);
        
        btnCalcular = new JButton("Calcular.");
        btnCalcular.addActionListener(this);
        add(btnCalcular);
        lblResultado = new JLabel("");
        add(lblResultado);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            double llegada = Double.parseDouble(txtLlegada.getText());
            double servicio = Double.parseDouble(txtServicio.getText());
            double n = Integer.parseInt(txtN.getText());
            
            double pTServicio = 1 - (servicio / llegada);
            double pTLlegada = llegada / servicio;
            double pNdatosAntes = Math.pow(pTServicio, n);
            
            lblResultado.setText("<html>Probabilidad de tiempo de servicio en la cola: " + pTServicio +
                                "<br>Probabilidad de taza de llegada en la cola: " + pTLlegada +
                                "<br>Capacidad de que haya " + n + " datos antes en la cola: " + pNdatosAntes + "</html>");
        }
    }
    

    public static void main(String[] args) {
        

//public class CalculadoraCola extends JFrame implements ActionListener {
  
   // public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IO_TeoriaDeColas_MaricelaJoaquinMoreno ventana = new IO_TeoriaDeColas_MaricelaJoaquinMoreno();
            ventana.setVisible(true);
        });
    }
}
