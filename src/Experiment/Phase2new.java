package Experiment;  
  
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


class MyMouseHandleFirst2 extends JFrame implements MouseListener {  
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
	String block;
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
    BufferedReader reader;
    String command1;
    String command2;
    String gesture1;
    String gesture2;
    String congruency;
    
    String lastname;
    String lastblock;
    String lastcongruency;
    String laststimulus;
    String lastcommand;
    String lastgesture;
    
    
    
    public MyMouseHandleFirst2() {  
    	
    	name = JOptionPane.showInputDialog(this, "Input participant ID");
    	block = JOptionPane.showInputDialog(this, "Input block number");
    	
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
        super.setTitle("second");// ????  
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
        
        try {  
            reader = new BufferedReader(new FileReader("/Users/mengyangwang/Documents/workspace/Experiment/src/toread-csv.csv"));//换成你的文件名 
         //   reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉 
            String line = null;  
            ArrayList<String> user = new ArrayList<String>();
            while((line=reader.readLine())!=null){  
            	user.add(line);
            //      String last = item[item.length-1];//这就是你要的数据了 
            }  
            
            for (int k=0;k<=180;k++){
            	String item[] = user.get(k).split(",");
                if(item[0].equals(name) && item[1].equals(block)){
                	 command1=item[2];
                	 command2=item[3];
                	 gesture1=item[4];
                	 gesture2=item[5];
                	 congruency=item[6];
                }
            }
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } 
        
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
    	            	
    	            	
    	            	if(congruency.equals("TRUE"))
    	            	{
    	            		if (stimulus.equals(command1)|stimulus.equals(gesture1)){
    	            		    
    	            			if (mouseinfo.equals("left")){
            	         			result="correct";
            	         		}
            	         		
            	         		if (mouseinfo.equals("right")){
            	         			result="wrong";
            	         		}
    	            		}
    	            		}
    	            		
            	         		if (stimulus.equals(command2)|stimulus.equals(gesture2)){
            	         			  
        	            			if (mouseinfo.equals("left")){
                	         			result="wrong";
                	         		}
                	         		
                	         		if (mouseinfo.equals("right")){
                	         			result="correct";
                	         		}	
    	            		}
        	         	
        	         	if(congruency.equals("FALSE")){
        	         		
        	         		if(stimulus.equals(command2) | stimulus.equals(gesture1)){
        	         			if (mouseinfo.equals("left")){
            	         			result="wrong";
            	         		}
            	         		
            	         		if (mouseinfo.equals("right")){
            	         			result="correct";
            	         		}
        	         		}
        	         		
        	         		if(stimulus.equals(command1) | stimulus.equals(gesture2)){
        	         			
        	         			if (mouseinfo.equals("right")){
            	         			result="wrong";
            	         		}
            	         		
            	         		if (mouseinfo.equals("left")){
            	         			result="correct";
            	         		}
        	         		}
        	         	}
        	         }
    	            
    	  //      i2 = random.nextInt(4);
    		   series[x]=start;
    		   
         int index = x%4;
     //    System.out.println((int)List.get(index));
         
         lastname=name;
         lastblock=block;
         lastcongruency=congruency;
         laststimulus=stimulus;
         lastcommand=command;
         lastgesture=gesture;
         
         if((int)List.get(index)==0){
	        	cm.setText(command1);
	        	label1.setIcon(new ImageIcon(""));
	        	stimulus=command1;
	        	command=command1;
	        	gesture="null";
	        	
	        	
	        }
	        
	        if((int)List.get(index)==1){
	        	cm.setText(command2);
	        	label1.setIcon(new ImageIcon(""));
	        	stimulus=command2;
	        	command=command2;
	        	gesture="null";

	        }
	        
	        
	        if((int)List.get(index)==2){
	        	cm.setText("");
	        	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture1 + ".jpg"));
	        	stimulus=gesture1;
	        	command="null";
	        	gesture=gesture1;

	        }
	        
	        if((int)List.get(index)==3){
	        	cm.setText("");
	        	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture2 + ".jpg"));
	        	stimulus=gesture2;
	        	command="null";
	        	gesture=gesture2;
        		
	        }
         
         
         if (index==0) {
        		Collections.shuffle(List);
         }

    	 if (x!=0 & x<=40){
    		 interval[x] = series[x]-series[x-1];
    		 time = String.valueOf(interval[x]);
    		     	 }
    		
    	  
    	if (x!=0 & x>40){
    		info.setText("Experiment ends");
    		cm.setText("");
    		label1.setIcon(new ImageIcon(""));
    	}	 
    	
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	 date=df.format(new Date(start));
    	 
    //	 System.out.println(df.format(new Date(start)));// new Date()为获取当前系统时间
    	 
    	 x=x+1;
    	  try {
          	File csv = new File("/Users/mengyangwang/Documents/workspace/Experiment/src/" + name + ".csv");
          	BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
              bw.newLine(); 
              if(x>1 && x<=41){
            	  bw.write( lastname + "," + lastblock + "," + (x-1) + "," + lastcongruency + "," + laststimulus + "," + lastcommand + "," + lastgesture + "," + mouseinfo + "," + result + "," + time + "," + date); 
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
	
	
public class Phase2new {  
    public static void main(String[] args) { 
        new MyMouseHandleFirst2();  
        }
        
    }  