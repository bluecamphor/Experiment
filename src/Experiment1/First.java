package Experiment1;  
  
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;  
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
  



class MyMouseHandle extends JFrame implements MouseListener {  
    private static final MouseEvent MouseEvent = null;
	private JTextArea text = new JTextArea();  
	int x=0;
	long[] series = new long[50000];
	long[] interval= new long [50000];
	JLabel cm = new JLabel("", SwingConstants.CENTER);
	ImageIcon g1;
	JLabel label1;
	Random random = new Random(1000);
	int i2;
	JLabel info;
	double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
	double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
	
	JPanel jp;
	JPanel myPanel;
	 JTextField xField;
     JTextField yField;
     JLabel j1;
	JFrame jf;
	Container container;
	
	
    public MyMouseHandle() {  
    	
    	String name = JOptionPane.showInputDialog(this, "Input participant ID");
        System.out.println(name);
    	
    	
//    	jf= new JFrame("tada!");
//    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	container=jf.getContentPane();
//    	j1 =new JLabel("Paticipant ID");
    	
    	
//    	jp= new JPanel();
//    	jp.setVisible(true);
//    	jp.add(jf);
//    	
//    	xField= new JTextField("Paticipant ID");
//    	yField= new JTextField("Block id");
//    	
//    	xField.setSize(800,500);
//    	xField.setLocation(0,200);
    	
    	
    	
//    	JDialog jd = new JDialog(jf,"A dialog",true);
//    	container=getContentPane();
//    	container.add(j1);
//    	jd.setSize(500, 300);
//    	jd.setVisible(true);
    	
//    	jd.add(j1);
//    	jd.add(xField);
//    	jd.add(yField);
    	
    	
    	
    	
    	
    	
    	info = new JLabel("Instrunction: Please click the left / right button to call for the command and gesture transformation.", SwingConstants.CENTER);
		 info.setSize((int)width, 100);
		 info.setLocation(0, 10);
		 super.add(info);
		 
		 cm.setSize((int)width, 80);
		 cm.setLocation(0, ((int)height)/3);
		 super.add(cm);
		 cm.setFont(new java.awt.Font("Dialog", 1, 30));
		 
		 g1 = new ImageIcon ("");
		 label1 = new JLabel("", g1, SwingConstants.CENTER);
		 label1.setSize((int)width, 200);
		 label1.setLocation(0, ((int)height)/3);
		 
		 super.add(label1);
		 
//		 ImageIcon g2 = new ImageIcon ("");
//		 JLabel label2 = new JLabel("", g2, SwingConstants.RIGHT);
//		 label2.setSize(300, 300);
//		 label2.setLocation(500, 200);
//		 super.add(label2);
		 
		 
		 
        super.setTitle("First");// ????  
        JScrollPane pane = new JScrollPane(text);// ?????  
        pane.setBounds(5, 5, 300, 200);// ??????  
        super.add(pane);// ????????  
        text.addMouseListener(this);// ??mouse??  
        super.setSize((int)width,(int)height);  	
        super.setVisible(true);  
        
        
//        
        
        super.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent arg0) {  
                System.exit(1);  
            }  
        });  
    }  
  
    
    @SuppressWarnings("null")
	public void mouseClicked(MouseEvent e)// ??????  
    {  
    	long start = System.currentTimeMillis();
    	
//    	  cm.setText(arr[x%4]);
//    	  if(x%4==0){
//    		  label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/C1.png"));
//    	  }
//    		
//    	  if(x%4==1){
//    		  
//    	  }
    	  
    			
    		   int c = e.getButton();
    	        String mouseInfo = null;
    	        
    	        i2 = random.nextInt(4);
    	        
    	        if(i2==0){
    	        	cm.setText("Save");
    	        	label1.setIcon(new ImageIcon(""));
    	        	
    	        }
    	        
    	        if(i2==1){
    	        	cm.setText("Save as");
    	        	label1.setIcon(new ImageIcon(""));
    	        	
    	        }
    	        
    	        
    	        if(i2==2){
    	        	cm.setText("");
    	        	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/g1.jpg"));
    	        	
    	        }
    	        
    	        if(i2==3){
    	        	cm.setText("");
    	        	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/g2.jpg"));
    	        	
    	        }
    	        
    	        
    	        
    	        if (c == MouseEvent.BUTTON1) {  // ?????????  
    	            mouseInfo = "left"; 
    	        }
    	         else if (c == MouseEvent.BUTTON3) {// ?????????  
    	            mouseInfo = "right"; 

    	         }
    	  
    	         else {  mouseInfo = "middle"; }  
    	        
  
    		   series[x]=start;

    	 if (x!=0 & x<=20){
    		 interval[x] = series[x]-series[x-1];
    		 System.out.println(i2 + ":"+mouseInfo + ":" + interval[x]);		
    	 }
    		
    		 
    	  
    	if (x!=0 & x>20){
    		info.setText("Experiment 1 ends");
    		cm.setText("");
    		label1.setIcon(new ImageIcon(""));
    		
    		
    		
    	}	 
    	 x=x+1;
    	 
    	 
 
    	 
//        text.append("????:" + mouseInfo + ".\n");  
    }  
    
    
   
  
    private Image getImage(Object documentBase, String string) {
		// TODO Auto-generated method stub
		return null;
	}


	private Object getDocumentBase() {
		// TODO Auto-generated method stub
		return null;
	}


	public void mouseEntered(MouseEvent e)// ??????  
    {  
    }  
  
    public void mouseExited(MouseEvent e)// ??????  
    {  
    }  
  
    public void mousePressed(MouseEvent e)// ????  
    {   
    }  
  
    public void mouseReleased(MouseEvent e)// ????  
    {  
    }  
    
	
	}
	
	
public class First {  
    public static void main(String[] args) { 
    	
    	
	    new JOptionPane();
        new MyMouseHandle();  

        
    }  
}  