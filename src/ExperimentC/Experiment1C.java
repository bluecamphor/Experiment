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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
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
	int id;
	int c;
	String stimulus =null;
    String command=null;
    String gesture=null;
    String con;
    String date;
    ArrayList List = new ArrayList();
    
	
    
	
    public MyMouseHandleFirstC() {  
    	
    	name = JOptionPane.showInputDialog(this, "Input participant ID");
    	
    	id = Integer.parseInt(name);
    	
    	if(id%2==0){
    		con = "uncongruent";
    	}
        if(id%2==1){
        	
            con = "congruent";
        }
    	   	
    	List.add(0);
    	List.add(1);
    	List.add(2);
    	List.add(3);
        
        
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
    	
    
    	
    	        c = e.getButton();
    	         mouseinfo=null;
    	         
    	            if (c == MouseEvent.BUTTON1) {  
        	            mouseinfo = "left"; 
        	        }
        	         else if (c == MouseEvent.BUTTON3) { 
        	            mouseinfo = "right"; 
        	         }
        	         else {  mouseinfo = "middle"; }  
    	            
    	            
    	            if(stimulus!=null){
    	            	
    	            	
    	            	if(stimulus.equals("Save") | stimulus.equals("g1")){
    	            		
    	            		//congruent 
    	            		if (con.equals("congruent")){
    	            			if (mouseinfo.equals("left")){
            	         			result="correct";
            	         		}
            	         		
            	         		if (mouseinfo.equals("right")){
            	         			result="wrong";
            	         		}
    	            		}
            	         		//congruent
            	         		if (con.equals("uncongruent")){
        	            			if (mouseinfo.equals("left")){
                	         			result="wrong";
                	         		}
                	         		
                	         		if (mouseinfo.equals("right")){
                	         			result="correct";
                	         		}	
    	            		}
        	         		
        	         	
        	         	
        	         	if(stimulus.equals("Save as") | stimulus.equals("g2")){
        	         		
        	         		if(con.equals("congruent")){
        	         			if (mouseinfo.equals("right")){
            	         			result="correct";
            	         		}
            	         		
            	         		if (mouseinfo.equals("left")){
            	         			result="wrong";
            	         		}
        	         		}
        	         		
        	         		if(con.equals("uncongruent")){
        	         			
        	         			if (mouseinfo.equals("right")){
            	         			result="wrong";
            	         		}
            	         		
            	         		if (mouseinfo.equals("left")){
            	         			result="correct";
            	         		}
        	         		}
        	         	}
        	         		
        	         	
        	         	
        	         }
        	            
    	            	
    	            }
    	           
    	            

    	        
//    	       
    	        
    	  //      i2 = random.nextInt(4);
    		   series[x]=start;
    		   
    		   
         int index = x%4;
         System.out.println((int)List.get(index));
         
         if((int)List.get(index)==0){
	        	cm.setText("Save");
	        	label1.setIcon(new ImageIcon(""));
	        	stimulus="Save";
	        	command="Save";
	        	gesture="null";
	        	
	        	
	        }
	        
	        if((int)List.get(index)==1){
	        	cm.setText("Save as");
	        	label1.setIcon(new ImageIcon(""));
	        	stimulus="Save as";
	        	command="Save as";
	        	gesture="null";

	        }
	        
	        
	        if((int)List.get(index)==2){
	        	cm.setText("");
	        	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/g1.jpg"));
	        	stimulus="g1";
	        	command="null";
	        	gesture="g1";

	        }
	        
	        if((int)List.get(index)==3){
	        	cm.setText("");
	        	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/g2.jpg"));
	        	stimulus="g2";
	        	command="null";
	        	gesture="g2";
        		
	        }
         
         
         if (index==0) {
        		Collections.shuffle(List);
         }

    	 if (x!=0 & x<=20){
    		 interval[x] = series[x]-series[x-1];
    		 time = String.valueOf(interval[x]);
    		     	 }
    		
    		 
    	  
    	if (x!=0 & x>20){
    		info.setText("Experiment 1 ends");
    		cm.setText("");
    		label1.setIcon(new ImageIcon(""));
    	}	 
    	
    	 x=x+1;
    	 
    	 
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	 date=df.format(new Date(start));
    	 
    //	 System.out.println(df.format(new Date(start)));// new Date()为获取当前系统时间
    	 
    	 
    	  try {
          	File csv = new File("/Users/mengyangwang/Documents/workspace/Experiment/src/" + name + ".csv");
          	BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
              bw.newLine(); 
              if(x>1 && x<=21){
            	  bw.write( name + "," + "1" + "," + (x-1) + "," + con + "," + stimulus + "," + command + "," + gesture + "," + mouseinfo + "," + result + "," + time + "," + date); 
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