package ExperimentU;  
  
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;
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
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;  
import javax.swing.JTextArea;
import javax.swing.SwingConstants;  
  



class MouseHandleTwo extends JFrame implements MouseListener {  
    private static final MouseEvent MouseEvent = null;
	private JTextArea text = new JTextArea();  
	int x=0;
	long[] series = new long[50000];
	long[] interval= new long [50000];
	JLabel cm = new JLabel("", SwingConstants.CENTER );
	String str;
	ImageIcon g1;
	JLabel label1;
	JLabel next;
	int i2;
	Random random = new Random(1000);
	java.util.Timer timer = new java.util.Timer(true);
	double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
	double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
	
	
    public MouseHandleTwo() {  
    	
    	JLabel info = new JLabel("Instrunction: Please click the left / right button to call for the command and gesture transformation.", SwingConstants.CENTER);
    	 info.setSize((int)width, 100);
		 info.setLocation(0, 10);
		 super.add(info);
		 
		 cm.setSize((int)width, 80);
		 cm.setLocation(0, ((int)height)/3);
		 cm.setFont(new java.awt.Font("Dialog", 1, 30));
		 super.add(cm);
		 
		 g1 = new ImageIcon ("");
		 label1 = new JLabel("", g1, SwingConstants.CENTER);
		 label1.setSize((int)width, 200);
		 label1.setLocation(0, ((int)height)/3);
		 
		 super.add(label1);
		 
        super.setTitle("Training Two"); 
        JScrollPane pane = new JScrollPane(text); 
        pane.setBounds(5, 5, 300, 200);
        super.add(pane);// ????????  
        text.addMouseListener(this);
        super.setSize((int)width,(int)height);  
        super.setVisible(true);  
        
           
        
        super.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent arg0) {  
                System.exit(1);  
            }  
        });  
    }  
  
    
    @SuppressWarnings("null")
	public void mouseClicked(MouseEvent e)  
    {  
    	long start = System.currentTimeMillis();
    	
    //	System.out.println(start);
    			
    		   int c = e.getButton();// ????????  
    	        String mouseInfo = null;// ????  
    	        
    	        if (c == MouseEvent.BUTTON1) {  // ?????????  
    	            mouseInfo = "left";
    	            if(x==0|x==1|x==2|x==3){
    	            	cm.setText("");
    	            	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/trans1.jpg"));
    	            	
    	            	TimerTask task = new TimerTask() {   
    	             		public void run() {   
    	             			label1.setIcon(new ImageIcon(""));
    	             		}   
    	             	};  
    	             		
    	             		timer.schedule(task, 2000);
    	            	
    	            	
    	            }
    	            
    	            if(x==4|x==5|x==6|x==7){
    	            	cm.setText("Save & Save as");
    	            	label1.setIcon(new ImageIcon(""));
    	            	
    	            	TimerTask task = new TimerTask() {   
    	             		public void run() {   
    	             			cm.setText("");
    	             		}   
    	             	};  
    	             		
    	             		timer.schedule(task, 2000);
    	            	
    	            }
    	            
    	            if(x>=8){
    	            	
    	            	
    	            	i2 = random.nextInt(2);
    	            	
    	            	if (i2==0){
    	            		cm.setText("Save & Save as");
    	            		label1.setIcon(new ImageIcon(""));
    	            		
    	            		TimerTask task = new TimerTask() {   
        	             		public void run() {   
        	             			cm.setText("");
        	             		}   
        	             	};  
        	             		
        	             		timer.schedule(task, 2000);
    	            		
    	            	}

    	            	if (i2==1){
    	            		cm.setText("");
    	            		label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/trans1.jpg"));
    	            	
    	            		TimerTask task = new TimerTask() {   
        	             		public void run() {   
        	             			label1.setIcon(new ImageIcon(""));
        	             		}   
        	             	};  
        	             		
        	             		timer.schedule(task, 2000);
    	            	}
    	            	
    	            	
    	            	
    	            }
    	            
    	            
    	        }
    	         else if (c == MouseEvent.BUTTON3) {// ?????????  
    	            mouseInfo = "right"; 
    	        
    	            if(x==0|x==1|x==2|x==3){
    	            	cm.setText("");
    	            	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/trans2.jpg"));
    	            	
    	            	TimerTask task = new TimerTask() {   
    	             		public void run() {   
    	             			label1.setIcon(new ImageIcon(""));
    	             		}   
    	             	};  
    	             		
    	             		timer.schedule(task, 2000);
    	            }
    	            
    	            if(x==4|x==5|x==6|x==7){
    	            	cm.setText("Save & Save as");
    	            	label1.setIcon(new ImageIcon(""));
    	            	
    	            	TimerTask task = new TimerTask() {   
    	             		public void run() {   
    	             			cm.setText("");
    	             		}   
    	             	};  
    	             		
    	             		timer.schedule(task, 2000);
    	            }
    	            
    	            if(x>=8){
    	            	
    	            	
    	            	i2 = random.nextInt(2);
    	            	
    	            	if (i2==0){
    	            		cm.setText("Save & Save as");
    	            		label1.setIcon(new ImageIcon(""));
    	            		
    	            		TimerTask task = new TimerTask() {   
        	             		public void run() {   
        	             			cm.setText("");
        	             		}   
        	             	};  
        	             		
        	             		timer.schedule(task, 2000);
    	            	}

    	            	if (i2==1){
    	            		cm.setText("");
    	            		label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/trans2.jpg"));
    	            	   
    	            		TimerTask task = new TimerTask() {   
        	             		public void run() {   
        	             			label1.setIcon(new ImageIcon(""));
        	             		}   
        	             	};  
        	             		
        	             		timer.schedule(task, 2000);
    	            	
    	            	}
    	            	
    	            	
    	            	
    	            }
    	            
    	            
    	            
    	            
    	            
    	         }
    	  
    	         else {  mouseInfo = "middle"; }  
    	        
  
    		   series[x]=start;

    	 if (x!=0){
    		 interval[x] = series[x]-series[x-1];
    //		 System.out.println(mouseInfo + ":" + interval[x]);		
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
	
	
public class Training2U {  
    public static void main(String[] args) { 
    	
    	
	 
        new MouseHandleTwo();  

        
    }  
}  