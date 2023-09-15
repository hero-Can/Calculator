
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
public class NewCalculator extends JPanel implements ActionListener{
    
    
    JTextField textfield;
    JButton [] numberButtons = new JButton[10];
    JButton [] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
      
    Font font = new Font("Verdana",Font.BOLD,20);
    Font font2 = new Font("Verdana",Font.BOLD,35);
    Double num1=0d,num2=0d,result=0d;
    char operator;
    
    Color lightBlue = new Color(0xdee9ec);
    Color blue = new Color(0x7f8cdf);
    Color beige = new Color(0xeceebc);
    Color pink = new Color(0xf8a9a9);
    
    
    public NewCalculator(){
        
        textfield = new JTextField();
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("<=");
        clrButton = new JButton("C");
        negButton = new JButton("+-");
        
        functionButtons[0]= addButton;
        functionButtons[1]= subButton;
        functionButtons[2]= mulButton;
        functionButtons[3]= divButton;
        functionButtons[4]= decButton;
        functionButtons[5]= equButton;
        functionButtons[6]= delButton;
        functionButtons[7]= clrButton;
        functionButtons[8]= negButton;
        
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setBackground(beige);
            functionButtons[i].setFocusable(false);
        }
        
        for (int i = 0; i < 10; i++) {
            numberButtons[i] =new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setBackground(beige);
            numberButtons[i].setFocusable(false);
        }
        
    }
    
     public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBackground(g);
        drawBoard(g);
        
   }

    private void drawBackground(Graphics g) {
        setBackground(beige);
        g.setColor(blue);
        g.fillRect(0, 0, 400, 180);
        
    }

    private void drawBoard(Graphics g) {
        textfield.setBounds(5, 80, 360, 95);
        textfield.setFont(font);
        textfield.setForeground(Color.WHITE);
        textfield.setBackground(blue);
        textfield.setEditable(false);
        this.add(textfield);
        numberButtons[1].setBounds(30,210, 70, 70);
        numberButtons[2].setBounds(110,210, 70, 70);
        numberButtons[3].setBounds(190,210, 70, 70);
        addButton.setBounds(270,210, 70, 70);
        numberButtons[4].setBounds(30,290, 70, 70);
        numberButtons[5].setBounds(110,290, 70, 70);
        numberButtons[6].setBounds(190,290, 70, 70);
        subButton.setBounds(270,290, 70, 70);
        numberButtons[7].setBounds(30,370, 70, 70);
        numberButtons[8].setBounds(110,370, 70, 70);
        numberButtons[9].setBounds(190,370, 70, 70);
        mulButton.setBounds(270,370, 70, 70);
        numberButtons[0].setBounds(30,450, 70, 70);
        decButton.setBounds(110,450, 70, 70);
        delButton.setBounds(190,450, 70, 70);
        divButton.setBounds(270,450, 70, 70);
        negButton.setBounds(30,530, 70, 70);
        clrButton.setBounds(110,530, 70, 70);
        equButton.setBounds(190,530, 150, 70);
        equButton.setBackground(blue);
        clrButton.setBackground(pink);
        this.add(numberButtons[1]);
	this.add(numberButtons[2]);
        this.add(numberButtons[3]);
	this.add(addButton);
	this.add(numberButtons[4]);
	this.add(numberButtons[5]);
	this.add(numberButtons[6]);
	this.add(subButton);
	this.add(numberButtons[7]);
	this.add(numberButtons[8]);
	this.add(numberButtons[9]);
	this.add(mulButton);
	this.add(decButton);
	this.add(numberButtons[0]);
        this.add(equButton);
        this.add(divButton);
        this.add(negButton);
        this.add(delButton);
        this.add(clrButton);
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if(e.getSource()== numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        
        if(e.getSource()== addButton){
               num1 = Double.parseDouble(textfield.getText());
               operator='+';
               textfield.setText("");
            }
        if(e.getSource()== subButton){
               num1 = Double.parseDouble(textfield.getText());
               operator='-';
               textfield.setText("");
            }
        if(e.getSource()== mulButton){
               num1 = Double.parseDouble(textfield.getText());
               operator='*';
               textfield.setText("");
            }
        if(e.getSource()== divButton){
               num1 = Double.parseDouble(textfield.getText());
               operator='/';
               textfield.setText("");
            }
        if(e.getSource()== decButton){
                textfield.setText(textfield.getText().concat("."));
            }
        if(e.getSource()== clrButton){
               textfield.setText("");
            }
        if(e.getSource()== delButton){
               String string =textfield.getText();
               textfield.setText("");
               for (int i = 0; i < string.length()-1; i++) {
                   textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource()== negButton){
              double temp = Double.parseDouble(textfield.getText());
              temp*=-1;
              textfield.setText(String.valueOf(temp));
            }
        
        if(e.getSource()== equButton){
               num2 = Double.parseDouble(textfield.getText());
               switch(operator){
                   case'+':
                       result=num1+num2;
                       break;
                    case'-':
                       result=num1-num2;
                       break;  
                    case'*':
                       result=num1*num2;
                       break;  
                    case'/':
                       result=num1/num2;
                       break;   
               }
               textfield.setText("                                    "+String.valueOf(result));
               textfield.setFont(font2);
               num1=result;
            }
        
    }

    

}
