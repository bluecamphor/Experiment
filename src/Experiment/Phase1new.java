package Experiment;  
  
import java.awt.Image;
import java.awt.Toolkit;
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
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;  
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
  
class MouseHandle2 extends JFrame implements MouseListener {  
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
    Timer timer = new Timer();
	double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
	double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
    String name;
    String block;
    BufferedReader reader;
    String command1;
    String command2;
    String gesture1;
    String gesture2;
    String congruency;
    String trial;
    String semantic;
    String gestures;
    String mouse;
    String stimulus;
    ArrayList commandList = new ArrayList();
   // int index;
	int id;
	
	
    public MouseHandle2() {  
    	
       name = JOptionPane.showInputDialog(this, "Input participant ID");
    	block = JOptionPane.showInputDialog(this, "Input block number");
    	id=Integer.parseInt(name);
    	
    	commandList.add(0);
    	commandList.add(1);
    	commandList.add(2);
    	
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
        super.setTitle("Training");// ????  
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
            reader = new BufferedReader(new FileReader("/Users/mengyangwang/Documents/workspace/Experiment/src/trial.csv"));//换成你的文件名 
         //   reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉 
            String line = null;  
            ArrayList<String> user = new ArrayList<String>();
            while((line=reader.readLine())!=null){  
            	user.add(line);
            	
         //         String last = item[item.length-1];//这就是你要的数据了 
            }  
            
            for (int k=0;k<=36900;k++){
            	String item[] = user.get(k).split(",");
                if(item[0].equals(name)&&item[2].equals(block)){
                	
                	 trial=item[3];
                	 semantic=item[4];
                	 gestures=item[5];
                	 congruency=item[6];
                	 stimulus=item[7];
                	 mouse=item[8];
                	 
                	 if(id%3==0){
                    	 System.out.print(id);
                     if(semantic.equals("1")){
                   		 if(gestures.equals("1")){
                   			 
                   			 if(congruency.equals("0")){
                   				 command1="save";
                       			 command2="save as";
                       			 gesture1="g1-1";
                       			 gesture2="g1-2";
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="open";
                       			 command2="open recent";
                       			 gesture1="g2-2";
                       			 gesture2="g2-1";
                   			 }
                	        }
                   		 
                   		 if(gestures.equals("2")){
                   			 
                   			 if(congruency.equals("0")){
                   				 
                   				 command1="car";
                       			 command2="wheel";
                       			 gesture1="g4-1";
                       			 gesture2="g4-2";
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="Europe";
                       			 command2="France";
                       			 gesture1="g5-2";
                       			 gesture2="g5-1";
                   			 }
                	        }
                   		 
                   		 if(gestures.equals("3")){
                   			
                   		
                   			 if(congruency.equals("0")){
                   				 command1="hand";
                       			 command2="finger";
                       			 gesture1="g7-1";
                       			 gesture2="g7-2";
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="shirt";
                       			 command2="sleeve";
                       			 gesture1="g8-2";
                       			 gesture2="g8-1";
                   			 }
                	        }
                	        }
                   	 if(semantic.equals("2")){
                   		 if(gestures.equals("1")){
                   			 
                   			 if(congruency.equals("0")){
                   				 command1="open";
                       			 command2="close";
                       			 gesture1="g2-1";
                       			 gesture2="g2-2";
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="start";
                       			 command2="stop";
                       			 gesture1="g3-2";
                       			 gesture2="g3-1";
                   			 }
                	        }
                   		 
                   		 
                   		 
                   		 if(gestures.equals("2")){
                   			 
                   			 if(congruency.equals("0")){
                   				 command1="before";
                       			 command2="after";
                       			 gesture1="g5-1";
                       			 gesture2="g5-2";
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="precede";
                       			 command2="follow";
                       			 gesture1="g6-2";
                       			 gesture2="g6-1";
                   			 }
                	        }
                   		 
                   		 if(gestures.equals("3")){
                   			
                   			 if(congruency.equals("0")){
                   				 command1="above";
                       			 command2="below";
                       			 gesture1="g8-1";
                       			 gesture2="g8-2";
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="present";
                       			 command2="absent";
                       			 gesture1="g9-2";
                       			 gesture2="g9-1";
                   			 }
                	        }
                	        }
                   	 
                      	 
                      	 if(semantic.equals("3")){
                   		 if(gestures.equals("1")){
                   			
                   			 if(congruency.equals("0")){
                   				 command1="format";
                       			 command2="alignment";
                       			 gesture1="g3-1";
                       			 gesture2="g3-2";
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="tools";
                       			 command2="spelling";
                       			 gesture1="g1-2";
                       			 gesture2="g1-1";
                   			 }
                	        }
                   		 if(gestures.equals("2")){
                   			 
                   			 if(congruency.equals("0")){
                   				 command1="color";
                       			 command2="blue";
                       			 gesture1="g6-1";
                       			 gesture2="g6-2";
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="beverage";
                       			 command2="tea";
                       			 gesture1="g4-2";
                       			 gesture2="g4-1";
                   			 }
                	        }
                   		 
                   		 if(gestures.equals("3")){
                   			 
                   			 if(congruency.equals("0")){
                   				 command1="animal";
                       			 command2="cat";
                       			 gesture1="g9-1";
                       			 gesture2="g9-2";
                       			 
                       			System.out.println("hahaha");
                   			 }
                   			 if(congruency.equals("1")){
                   				 command1="shape";
                       			 command2="rectangular";
                       			 gesture1="g7-2";
                       			 gesture2="g7-1";
                   			 }
                	        }
                      	 }
                	      
                     }
                     if(id%3==1){
                    	 System.out.print(id);
                         if(semantic.equals("1")){
                       		 if(gestures.equals("1")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="save";
                           			 command2="save as";
                           			 gesture1="g4-1";
                           			 gesture2="g4-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="open";
                           			 command2="open recent";
                           			 gesture1="g5-2";
                           			 gesture2="g5-1";
                       			 }
                    	        }
                       		 
                       		 if(gestures.equals("2")){
                       			 
                       			 if(congruency.equals("0")){
                       				 
                       				 command1="car";
                           			 command2="wheel";
                           			 gesture1="g7-1";
                           			 gesture2="g7-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="Europe";
                           			 command2="France";
                           			 gesture1="g8-2";
                           			 gesture2="g8-1";
                       			 }
                    	        }
                       		 
                       		 if(gestures.equals("3")){
                       			
                       		
                       			 if(congruency.equals("0")){
                       				 command1="hand";
                           			 command2="finger";
                           			 gesture1="g1-1";
                           			 gesture2="g1-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="shirt";
                           			 command2="sleeve";
                           			 gesture1="g2-2";
                           			 gesture2="g2-1";
                       			 }
                    	        }
                    	        }
                       	 if(semantic.equals("2")){
                       		 if(gestures.equals("1")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="open";
                           			 command2="close";
                           			 gesture1="g5-1";
                           			 gesture2="g5-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="start";
                           			 command2="stop";
                           			 gesture1="g6-2";
                           			 gesture2="g6-1";
                       			 }
                    	        }
                       		 
                       		 
                       		 
                       		 if(gestures.equals("2")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="before";
                           			 command2="after";
                           			 gesture1="g8-1";
                           			 gesture2="g8-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="precede";
                           			 command2="follow";
                           			 gesture1="g9-2";
                           			 gesture2="g9-1";
                       			 }
                    	        }
                       		 
                       		 if(gestures.equals("3")){
                       			
                       			 if(congruency.equals("0")){
                       				 command1="above";
                           			 command2="below";
                           			 gesture1="g2-1";
                           			 gesture2="g2-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="present";
                           			 command2="absent";
                           			 gesture1="g3-2";
                           			 gesture2="g3-1";
                       			 }
                    	        }
                    	        }
                       	 
                          	 
                          	 if(semantic.equals("3")){
                       		 if(gestures.equals("1")){
                       			
                       			 if(congruency.equals("0")){
                       				 command1="format";
                           			 command2="alignment";
                           			 gesture1="g6-1";
                           			 gesture2="g6-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="tools";
                           			 command2="spelling";
                           			 gesture1="g4-2";
                           			 gesture2="g4-1";
                       			 }
                    	        }
                       		 if(gestures.equals("2")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="color";
                           			 command2="blue";
                           			 gesture1="g9-1";
                           			 gesture2="g9-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="beverage";
                           			 command2="tea";
                           			 gesture1="g7-2";
                           			 gesture2="g7-1";
                       			 }
                    	        }
                       		 
                       		 if(gestures.equals("3")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="animal";
                           			 command2="cat";
                           			 gesture1="g3-1";
                           			 gesture2="g3-2";
                           			 
                           			System.out.println("hahaha");
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="shape";
                           			 command2="rectangular";
                           			 gesture1="g1-2";
                           			 gesture2="g1-1";
                       			 }
                    	        }
                          	 }
                    	      
                         } 
                  	
                     if(id%3==2){
                    	 System.out.print(id);
                         if(semantic.equals("1")){
                       		 if(gestures.equals("1")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="save";
                           			 command2="save as";
                           			 gesture1="g7-1";
                           			 gesture2="g7-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="open";
                           			 command2="open recent";
                           			 gesture1="g8-2";
                           			 gesture2="g8-1";
                       			 }
                    	        }
                       		 
                       		 if(gestures.equals("2")){
                       			 
                       			 if(congruency.equals("0")){
                       				 
                       				 command1="car";
                           			 command2="wheel";
                           			 gesture1="g1-1";
                           			 gesture2="g1-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="Europe";
                           			 command2="France";
                           			 gesture1="g2-2";
                           			 gesture2="g2-1";
                       			 }
                    	        }
                       		 
                       		 if(gestures.equals("3")){
                       			
                       		
                       			 if(congruency.equals("0")){
                       				 command1="hand";
                           			 command2="finger";
                           			 gesture1="g4-1";
                           			 gesture2="g4-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="shirt";
                           			 command2="sleeve";
                           			 gesture1="g5-2";
                           			 gesture2="g5-1";
                       			 }
                    	        }
                    	        }
                       	 if(semantic.equals("2")){
                       		 if(gestures.equals("1")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="open";
                           			 command2="close";
                           			 gesture1="g8-1";
                           			 gesture2="g8-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="start";
                           			 command2="stop";
                           			 gesture1="g9-2";
                           			 gesture2="g9-1";
                       			 }
                    	        }
                       		 
                       		 
                       		 
                       		 if(gestures.equals("2")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="before";
                           			 command2="after";
                           			 gesture1="g2-1";
                           			 gesture2="g2-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="precede";
                           			 command2="follow";
                           			 gesture1="g3-2";
                           			 gesture2="g3-1";
                       			 }
                    	        }
                       		 
                       		 if(gestures.equals("3")){
                       			
                       			 if(congruency.equals("0")){
                       				 command1="above";
                           			 command2="below";
                           			 gesture1="g5-1";
                           			 gesture2="g5-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="present";
                           			 command2="absent";
                           			 gesture1="g6-2";
                           			 gesture2="g6-1";
                       			 }
                    	        }
                    	        }
                       	 
                          	 
                          	 if(semantic.equals("3")){
                       		 if(gestures.equals("1")){
                       			
                       			 if(congruency.equals("0")){
                       				 command1="format";
                           			 command2="alignment";
                           			 gesture1="g9-1";
                           			 gesture2="g9-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="tools";
                           			 command2="spelling";
                           			 gesture1="g7-2";
                           			 gesture2="g7-1";
                       			 }
                    	        }
                       		 if(gestures.equals("2")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="color";
                           			 command2="blue";
                           			 gesture1="g3-1";
                           			 gesture2="g3-2";
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="beverage";
                           			 command2="tea";
                           			 gesture1="g1-2";
                           			 gesture2="g1-1";
                       			 }
                    	        }
                       		 
                       		 if(gestures.equals("3")){
                       			 
                       			 if(congruency.equals("0")){
                       				 command1="animal";
                           			 command2="cat";
                           			 gesture1="g6-1";
                           			 gesture2="g6-2";
                           			 
                           			System.out.println("hahaha");
                       			 }
                       			 if(congruency.equals("1")){
                       				 command1="shape";
                           			 command2="rectangular";
                           			 gesture1="g4-2";
                           			 gesture2="g4-1";
                       			 }
                    	        }
                          	 }
                    	      
                         }
                	 
                   	 
                   	 
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
    		   int c = e.getButton();// ????????  
    	        String mouseInfo = null;// ????  
    	        
    	        	if (c == MouseEvent.BUTTON1) {  // ?????????  
        	            mouseInfo = "left";
        	            timer.cancel();
        	           
        	            if(x==0|x==1|x==2|x==3){
        	            	cm.setText("");
        	            	if(id%2==0){
        	            	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture1 + ".jpg"));
        	            	}
        	            	
        	            	if(id%2==1){
            	            	label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture2 + ".jpg"));
            	            	}
        	            	
        	            	
        	            	
        	            	TimerTask task = new TimerTask() {   
        	             		public void run() {   
        	             			label1.setIcon(new ImageIcon(""));
        	             		}   
        	             	};  
        	                timer = new Timer();
        	             	timer.schedule(task, 2000);
        	            }
        	            
        	            if(x==4|x==5|x==6|x==7){
        	            	
        	            	if(id%2==0){
        	            		cm.setText(command1);
        	            	}
        	            	
        	            	if(id%2==1){
        	            		cm.setText(command2);
        	            	}
        	            	
        	          
        	            	label1.setIcon(new ImageIcon(""));
        	            	
        	            	TimerTask task = new TimerTask() {   
        	             		public void run() {   
        	             			cm.setText("");
        	             		}   
        	             	};  
        	             	timer = new Timer();
        	             		timer.schedule(task, 2000);
        	            }
        	            
        	            if(x>=8){
        	            	i2 = random.nextInt(2);
        	            	if (i2==0){
        	            		if(id%2==0){
            	            		cm.setText(command1);
            	            	}
        	            		if(id%2==1){
            	            		cm.setText(command2);
            	            	}
        	            		label1.setIcon(new ImageIcon(""));
        	            		TimerTask task = new TimerTask() {   
            	             		public void run() {   
            	             			cm.setText("");
            	             		}   
            	             	};  
            	             	timer = new Timer();
            	             	timer.schedule(task, 2000);
        	            	}

        	            	if (i2==1){
        	            		cm.setText("");
        	            		
        	            		if(id%2==0){
        	            			label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture1 + ".jpg"));
            	            	}
        	            		if(id%2==1){
        	            			label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture2 + ".jpg"));
            	            	}
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
        	            	
        	            	if(id%2==0){
    	            			label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture2 + ".jpg"));
        	            	}
        	            	if(id%2==1){
    	            			label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture1 + ".jpg"));
        	            	}
        	            	
        	            
        	            	TimerTask task = new TimerTask() {   
        	             		public void run() {   
        	             			label1.setIcon(new ImageIcon(""));
        	             		}   
        	             	};  
        	             		
        	             		timer.schedule(task, 2000);
        	            }
        	            
        	            if(x==4|x==5|x==6|x==7){
        	            	if(id%2==0){
        	            	cm.setText(command2);
        	            	}
        	            	
        	            	if(id%2==1){
            	            	cm.setText(command1);
            	            	}
        	            	
        	            	
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
        	            		if(id%2==0){
                	            	cm.setText(command2);
                	            	}
        	            		if(id%2==1){
                	            	cm.setText(command1);
                	            	}
        	            		
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
        	            		if(id%2==0){
        	            			label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture2 + ".jpg"));
                	      
                	            	}
        	            		
        	            		if(id%2==1){
        	            			label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture1 + ".jpg"));
                	      
                	            	}
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
    	      //  }
    	        
    	        
    		   series[x]=start;
    		int   index = x%4;

    	 if (x!=0){
    		 interval[x] = series[x]-series[x-1];
    	//	 System.out.println(mouseInfo + ":" + interval[x]);	
    	 }
    	 
    	
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    		 x=x+1;
    		 
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

public class Phase1new {  
    public static void main(String[] args) { 
        new MouseHandle2();  
    }  
}  