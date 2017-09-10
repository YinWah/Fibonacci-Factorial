/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculofiboyfac;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Sorzano Torres Pablo,Wah Ortiz Yin Chew
 */
public class Home extends JFrame implements ActionListener{
    JButton cerrar;
    JTextField Numero;
    JButton Fibonacci;
    JButton Factorial;
    JLabel resultado;
    JTextField resultado1;
    double nsaldo=0;
    int Fact,fibo;
    Boolean Continuar=false;
    private JLabel titulo, instruccion;
    /**
     * Constructor de la clase Home(),en el se inicializan los metodos configurarVentan() e iniciar Componentes(),
     * ademas se declara e inicializa una un objeto de la clase calculofiboyfac()
     */
    public Home(){
        calculofiboyfac.datos cdep= new calculofiboyfac.datos();
        configurarVentana();
       iniciarComponentes();
    }
    /**
     * En el metodo configurarVentana() se configura la ventana pricipal
     */
    public void configurarVentana(){
        setTitle("Convertido de numero entero a Fibonacci & Factorial");
        setSize(600,510);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(new Color(220,216,255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     /**
     * En el metodo iniciarComponentes() se inicializan los componentes (botones, combos, labels, textfields) que contendra la ventana pricipal
     */
    public void iniciarComponentes(){
        titulo = new JLabel("Convertidor de numero entero a Fibonacci & Factorial");
        titulo.setBounds(30, 25, 750, 30);
        titulo.setFont(new Font ("Arial",Font.BOLD,20));
        add(titulo);
        titulo.setVisible(true);
        
        instruccion =  new JLabel("Numero:");
        instruccion.setBounds(10, 80, 300, 30);
        instruccion.setFont(new Font("Arial",0,16));
        add(instruccion);
        instruccion.setVisible(true);
        
        Numero= new JTextField();
        Numero.setBounds(200, 80, 300, 30);
	Numero.setFont(new Font("Arial", Font.BOLD, 25));
        Numero.setHorizontalAlignment(JTextField.CENTER);
	Numero.setEditable(true);
        add(Numero);
        Numero.setVisible(true);
        
        Fibonacci = new JButton("Fibonacci");
        Fibonacci.setBounds(350, 140, 100, 50);
        add(Fibonacci);
        Fibonacci.addActionListener(this);
        add(Fibonacci);
      
        Factorial = new JButton("Factorial");
        Factorial.setBounds(350, 200, 100, 50);
        add(Factorial);
        Factorial.addActionListener(this);
        add(Factorial);     
        
        resultado =  new JLabel("Resultado:");
        resultado.setBounds(10, 300, 300, 30);
        resultado.setFont(new Font("Arial",0,16));
        add(resultado);
        resultado.setVisible(true);
        
        resultado1= new JTextField();
        resultado1.setBounds(200, 300, 300, 30);
	resultado1.setFont(new Font("Arial", Font.BOLD, 25));
        resultado1.setHorizontalAlignment(JTextField.CENTER);
	resultado1.setEditable(false);
        add(resultado1);
        resultado1.setVisible(true);
    }
    
    @Override
     /**
     * En el metodo actionPerformed(ActionEvent e) se recuperan la opcion que escoge el usuario y dependiendo de la opcion
     * el programa calcula el factorial o el fibonnaci con los datos que ingreso el usuario
     */
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==Fibonacci){
           String nada =Numero.getText();
        if(nada.length()>=11){
           JOptionPane.showMessageDialog(this, "Capacidad Maxima para valor tipo Int");
           resultado1.setText("No hay numero");
        }else if(nada.matches(".*[^0123456789].*") ){
          JOptionPane.showMessageDialog(this, "No ingreso numeros");
          resultado1.setText("No hay numero");
        }else{
        calculofiboyfac.datos cdep= new calculofiboyfac.datos();
           fibo=Integer.parseInt(Numero.getText());
           cdep.setNum1(fibo);
                   String s="0";

        if (fibo>0){ 
        int a=0; 
        int b=1;    
        int c; 
        for(int i=1; i<fibo;i++){ 
            c=a+b; 
            a=b; 
            b=c;     
            s = s + ", " + a;     
        }  
                resultado1.setText(s);

        }else{
            resultado1.setText("0 no tiene num de fibonacci ");
 
        }

        }
        
       }else if(e.getSource()==Factorial){
         String nada =Numero.getText();
        if(nada.length()>=11){
           JOptionPane.showMessageDialog(this, "Capacidad Maxima para valor tipo Int");
           resultado1.setText("No hay numero");
        }else if(nada.matches(".*[^0123456789].*") ){
          JOptionPane.showMessageDialog(this, "No ingreso numeros");
          resultado1.setText("No hay numero");
        }else{
        calculofiboyfac.datos cdep= new calculofiboyfac.datos();
           fibo=Integer.parseInt(Numero.getText());
           cdep.setNum2(fibo);
           double factorial=1;
           double numero = fibo;
           if(fibo==0){
            JOptionPane.showMessageDialog(this, "No hay factorial de 0");
            resultado1.setText("No existe");
           }else{
            while(numero!=0){
            factorial=factorial*numero;
            numero--;
            resultado1.setText(Double.toString(factorial));
           }  
           }
        }
        
       }
    }
   
}

