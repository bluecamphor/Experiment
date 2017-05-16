package ExperimentC;  
  
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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


  



class MyMouseHandleFirstC extends JFrame implements MouseListener {  
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
	
	String name;
	String mouseinfo;
	String result;
	String time;
	
	
    public MyMouseHandleFirstC() {  
    	
    	name = JOptionPane.showInputDialog(this, "Input participant ID");
    	   	
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
        super.setTitle("First");// ????  
        JScrollPane pane = new JScrollPane(text);// ?????  
        pane.setBounds(5, 5, 300, 200);// ??????  
        super.add(pane);// ????????  
        text.addMouseListener(this);// ??mouse??  
        super.setSize((int)width,(int)height);  	
        super.setVisible(true);  
        
        
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
    			
    		   int c = e.getButton();
    	        mouseinfo = null;
    	        String stimulus =null;
    	        String command=null;
    	        String gesture=null;
    	        
    	        i2 = random.nextInt(4);
    	        
    	        if(i2==0){
    	        	cm.setText("Save");
    	        	label1.setIcon(new ImageIcon(""));
    	        	stimulus="Save";
    	        	command="Save";
    	        	gesture="null";
    	        	
    	        }
    	        
    	        if(i2==1){
    	        	cm.setText("Save as");
    	        	label1.setIcon(new ImageIcon(""));
    	        	stimulus="Save as";
    	        	command="Save as";
    	        	gesture="null";
    	        	
    	        }
    	        
    	        
    	        if(i2==2){
    	        	cm.setText("");
    	        	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/g1.jpg"));
    	        	stimulus="g1";
    	        	command="null";
    	        	gesture="g1";
    	        }
    	        
    	        if(i2==3){
    	        	cm.setText("");
    	        	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/g2.jpg"));
    	        	stimulus="g2";
    	        	command="null";
    	        	gesture="g2";
    	        }
    	        
    	        
    	        
    	        if (c == MouseEvent.BUTTON1) {  
    	            mouseinfo = "left"; 
    	        }
    	         else if (c == MouseEvent.BUTTON3) { 
    	            mouseinfo = "right"; 

    	         }
    	  
    	         else {  mouseinfo = "middle"; }  
    	        
    	        
    	        if ( mouseinfo=="left" && stimulus=="Save" |stimulus =="g1"){
    	        	result = "Correct";
    	        }
    	        else
    	        {result = "Wrong";}
    	        
    	        
    	        if ( mouseinfo=="right" && stimulus=="Save as" |stimulus =="g2"){
    	        	result = "Correct";
    	        }
    	        else
    	        {result = "Wrong";}
    	        
  
    		   series[x]=start;

    	 if (x!=0 & x<=20){
    		 interval[x] = series[x]-series[x-1];
    		 time = String.valueOf(interval[x]);
    //		 System.out.println(i2 + ","+mouseinfo + "," + interval[x]);		
    	 }
    		
    		 
    	  
    	if (x!=0 & x>20){
    		info.setText("Experiment 1 ends");
    		cm.setText("");
    		label1.setIcon(new ImageIcon(""));
    		
    	}	 
    	 x=x+1;
    	 
    	  try {
          	File csv = new File("/Users/mengyangwang/Documents/workspace/Experiment/src/result.csv");
          	BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
              bw.newLine(); 
              if(x!=1 && x<=21){
            	  bw.write( name + "," + "1" + "," + (x-1) + "," + "Congruent" + "," + stimulus + "," + command + "," + gesture + "," + mouseinfo + "," + result + "," + time); 
                  bw.close(); 
              }
              

          } catch (FileNotFoundException e1) { 
              // 捕获File对象生成时的异常 
              e1.printStackTrace(); 
          } catch (IOException e1) { 
              // 捕获BufferedWriter对象关闭时的异常 
              e1.printStackTrace(); 
          } 
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
	
	
public class Experiment1C {  
    public static void main(String[] args) { 
        new MyMouseHandleFirstC();  
        }
        
    }  