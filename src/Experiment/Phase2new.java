package Experiment;  
  
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;  
import javax.swing.JTextArea;
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
    Timer timer = new Timer();
    
    String lastname;
    String lastblock;
    String lastcongruency;
    String laststimulus;
    String lastcommand;
    String lastgesture;
    String lastresult;
    String trial;
    String semantic;
    String gestures;
    String mouse;
    int blockid0;
    int blockid1;
    int blockid2;
    int blockid3;
    int blockid4;
    int blockid5;
    int blockid6;
    int blockid7;
    int blockid8;
    int blockid9;
    
    ArrayList<String> stimuliList = new ArrayList<String>();

    String last[];
    String[] splitString;
    String get;
    
    
    public MyMouseHandleFirst2() {  
    	
    	name = JOptionPane.showInputDialog(this, "Input participant ID");
    	block = JOptionPane.showInputDialog(this, "Input block number");
    	blockid0=Integer.parseInt(block);
    	id=Integer.parseInt(name);
    	
    	blockid1=blockid0+1;
    	blockid2=blockid1+1;
    	blockid3=blockid2+1;
    	blockid4=blockid3+1;
    	blockid5=blockid4+1;
    	blockid6=blockid5+1;
    	blockid7=blockid6+1;
    	blockid8=blockid7+1;
    	blockid9=blockid8+1;
    	
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
        super.setTitle("Test");// ????  
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
            //      String last = item[item.length-1];//这就是你要的数据了 
            }  
            
            for (int k=0;k<=36900;k++){
            	String item[] = user.get(k).split(",");
            	
                if(item[0].equals(name) && item[2].equals(block)){
                	
                	 trial=item[3];
                	 semantic=item[4];
                	 gestures=item[5];
                	 congruency=item[6];
                	 stimulus=item[7];
                	 mouse=item[8];
                	 
                	 stimuliList.add(item[7]);
                	 System.out.println(item[6]);
                }
                
                
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid1))){
               	 stimuliList.add(item[7]);
               }
                
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid2))){
                  	 stimuliList.add(item[7]);
                  }
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid3))){
                  	 stimuliList.add(item[7]);
                  }
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid4))){
                  	 stimuliList.add(item[7]);
                  }
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid5))){
                  	 stimuliList.add(item[7]);
                  }
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid6))){
                  	 stimuliList.add(item[7]);
                  }
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid7))){
                  	 stimuliList.add(item[7]);
                  }
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid8))){
                  	 stimuliList.add(item[7]);
                  }
                if(item[0].equals(name) && item[2].equals(Integer.toString(blockid9))){
                  	 stimuliList.add(item[7]);
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
    	            cm.setText("");
         			label1.setIcon(new ImageIcon(""));
	             		
    	        }
    	         else if (c == MouseEvent.BUTTON3) { 
    	            mouseinfo = "right"; 
    	            cm.setText("");
         			label1.setIcon(new ImageIcon(""));
    	         }
    	         else {  mouseinfo = "middle"; }  
    	        

    	     	if(stimulus!=null){
    	        	
    	        	if(id%2==0)
    	        	{
    	        		if (stimulus.equals(command1)){
    	        		    
    	        			if (mouseinfo.equals("left")){
    		         			result="correct";
    		         		}
    		         		
    		         		if (mouseinfo.equals("right")){
    		         			result="wrong";
    		         		}
    	        		}
    	        		
    	        		
    	        		
    	        		if (stimulus.equals(gesture1)){
    	        		    
    	        			if (mouseinfo.equals("left")){
    		         			result="correct";
    		         		}
    		         		
    		         		if (mouseinfo.equals("right")){
    		         			result="wrong";
    		         		}
    	        		}

    	        		if (stimulus.equals(command2)){
		         			  
	            			if (mouseinfo.equals("left")){
	    	         			result="wrong";
	    	         		}
	    	         		
	    	         		if (mouseinfo.equals("right")){
	    	         			result="correct";
	    	         		}	
	        		}
	         	
		         		if (stimulus.equals(gesture2)){
		         			  
	            			if (mouseinfo.equals("left")){
	    	         			result="wrong";
	    	         		}
	    	         		
	    	         		if (mouseinfo.equals("right")){
	    	         			result="correct";
	    	         		}	
	        		}
    	        		
    	        		
    	        		}
    	        		
    		         		
    	         	if(id%2==1){
    	         		
    	         		if(stimulus.equals(command1) ){
    	         			if (mouseinfo.equals("left")){
    		         			result="wrong";
    		         		}
    		         		
    		         		if (mouseinfo.equals("right")){
    		         			result="correct";
    		         		}
    	         		}
    	         		
    	         		if(stimulus.equals(gesture1)){
    	         			if (mouseinfo.equals("left")){
    		         			result="wrong";
    		         		}
    		         		
    		         		if (mouseinfo.equals("right")){
    		         			result="correct";
    		         		}
    	         		}
    	         		
    	         		if(stimulus.equals(command2)){
    	         			if (mouseinfo.equals("left")){
    		         			result="correct";
    		         		}
    	         			if (mouseinfo.equals("right")){
    		         			result="wrong";
    		         		}
    	         		}
    	         		
    	         		
    	         		if(stimulus.equals(gesture2)){
    	         			if (mouseinfo.equals("left")){
    		         			result="correct";
    		         		}
    	         			if (mouseinfo.equals("right")){
    		         			result="wrong";
    		         		}
    		         		
    	         		}

    	         	}
    	         }

    	        
    	        
    	        
    	          String it0 = (String)stimuliList.get(0);
    	    	  String it1=(String)stimuliList.get(1);
    	    	  String it2 = (String)stimuliList.get(2);
    	    	  String it3=(String)stimuliList.get(3);
    	    	  String it4 = (String)stimuliList.get(4);
    	    	  String it5=(String)stimuliList.get(5);
    	    	  String it6 = (String)stimuliList.get(6);
    	    	  String it7=(String)stimuliList.get(7);
    	    	  String it8 = (String)stimuliList.get(8);
    	    	  String it9=(String)stimuliList.get(9);
    	    	  String it10 = (String)stimuliList.get(10);
    	    	  String it11=(String)stimuliList.get(11);
    	    	  String it12 = (String)stimuliList.get(12);
    	    	  String it13=(String)stimuliList.get(13);
    	    	  String it14 = (String)stimuliList.get(14);
    	    	  String it15=(String)stimuliList.get(15);
    	    	  String it16 = (String)stimuliList.get(16);
    	    	  String it17=(String)stimuliList.get(17);
    	    	  String it18 = (String)stimuliList.get(18);
    	    	  String it19=(String)stimuliList.get(19);
    	    	  String it20 = (String)stimuliList.get(20);
    	    	  String it21=(String)stimuliList.get(21);
    	    	  String it22 = (String)stimuliList.get(22);
    	    	  String it23=(String)stimuliList.get(23);
    	    	  String it24 = (String)stimuliList.get(24);
    	    	  String it25=(String)stimuliList.get(25);
    	    	  String it26 = (String)stimuliList.get(26);
    	    	  String it27=(String)stimuliList.get(27);
    	    	  String it28 = (String)stimuliList.get(28);
    	    	  String it29=(String)stimuliList.get(29);
    	    	  String it30 = (String)stimuliList.get(30);
    	    	  String it31=(String)stimuliList.get(31);
    	    	  String it32 = (String)stimuliList.get(32);
    	    	  String it33=(String)stimuliList.get(33);
    	    	  String it34 = (String)stimuliList.get(34);
    	    	  String it35=(String)stimuliList.get(35);
    	    	  String it36 = (String)stimuliList.get(36);
    	    	  String it37=(String)stimuliList.get(37);
    	    	  String it38 = (String)stimuliList.get(38);
    	    	  String it39=(String)stimuliList.get(39);
    	    	  String it40="end";
    	    	  
    	     String [] splitString = new String[]{it0,it1,it2,it3,it4,it5,it6,it7,it8,it9,it0,it11,it12,it13,it14,it15,it16,it17,it18,it19,it20,it21,it22,it23,it24,it25,it26,it27,it28,it29,it30,it31,it32,it33,it34,it35,it36,it37,it38,it39,it40};
    	        
    	     System.out.println(x);
    	     
    	     System.out.println(splitString[x]);
    	        
    	      
    	            
    	  //      i2 = random.nextInt(4);
    		   series[x]=start;
     //    System.out.println((int)List.get(index));
    		   
    		lastname=name;
   	        lastblock=block;
   	        lastcongruency=congruency;
   	        laststimulus=stimulus;
   	        lastcommand=command;
   	        lastgesture=gesture;
   	        lastresult=result;
         
         if(id%3==0){
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
         
     	 if(splitString[x].equals("g1")){
            	TimerTask task = new TimerTask() {   
             		public void run() {   
             			label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture1 + ".jpg"));
                 		cm.setText("");
                 		stimulus=gesture1;
                    	command=null;
                    	gesture=gesture1;
             		}   
             	};  
             		timer.schedule(task, 1000);
            	
            	
            	
     	 }
     	 
     	if(splitString[x].equals("g2")){
          	    
          	  TimerTask task = new TimerTask() {   
           		public void run() {   
           			label1.setIcon(new ImageIcon("/Users/mengyangwang/Documents/workspace/Experiment/src/" + gesture2 + ".jpg"));
             		cm.setText("");
             		stimulus=gesture2;
              	    command=null;
              	    gesture=gesture2;
           		}   
           	};  
           		timer.schedule(task, 1000);
     		
     	 }
     	
     	
     	
     	 
     	if(splitString[x].equals("c1")){
      	    
      	  TimerTask task = new TimerTask() {   
         		public void run() {   
         			label1.setIcon(new ImageIcon(""));
             		cm.setText(command1);
             		stimulus=command1;
              	    command=command1;
              	    gesture=null;
         		}   
         	};  
         		timer.schedule(task, 1000);
         		
     	 }
     	 
     	if(splitString[x].equals("c2")){
         	
         	  TimerTask task = new TimerTask() {   
           		public void run() {   
           			label1.setIcon(new ImageIcon(""));
             		cm.setText(command2);
             		stimulus=command2;
                 	command=command2;
                 	gesture=null;
           		}   
           	};  
           		timer.schedule(task, 1000);
     	 }
     	
     	if(splitString[x].equals("end")){
     		System.out.println("finish");
     		info.setText("Experiment ends");
    		cm.setText("");
    		label1.setIcon(new ImageIcon(""));
     		
     	}
     	
    	 if (x!=0 & x<=42){
    		 interval[x] = series[x]-series[x-1];
    		 time = String.valueOf(interval[x]);
    		     	 }
    		
    	  
    	if (x!=0 & x>=40){
    		info.setText("Experiment ends");
    		cm.setText("");
    		label1.setIcon(new ImageIcon(""));
    	}	 
    	
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	 date=df.format(new Date(start));
    	 
    	 
    	 x=x+1;
    	 
    	  try {
          	File csv = new File("/Users/mengyangwang/Documents/workspace/Experiment/src/" + name + ".csv");
          	BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
              bw.newLine(); 
              if(x>1 && x<=41){
            	  bw.write( name + "," + block + "," + (x-1) + "," + congruency + "," + laststimulus + "," + lastcommand + "," + lastgesture + "," + mouseinfo + "," + result + "," + time + "," + date); 
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