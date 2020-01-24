package project4;  

  import java.awt.event.ActionListener;
  import javax.swing.JFrame;
  import javax.swing.JButton;
  
  public class ButtonViewer {
	  
	  private static final int Frame_Width = 300;
	  private static final int Frame_Height = 120;
	  
	  public static void main(String args[]) {
		  
		  JFrame frame = new JFrame();
		  JButton button = new JButton("Click me!");
		  frame.add(button);
		  
		  ActionListener listener = new ClickListener();
		  button.addActionListener(listener);
		  
		  frame.setSize(Frame_Width, Frame_Height);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
		  
	  }
	  
  }
