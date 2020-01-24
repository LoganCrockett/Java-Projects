	package project4;

	import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    
    /**
       An action listener that prints a message.
    */
    public class ClickListener implements ActionListener
    {
    	private int count = 0;//Number of times it has been clicked
       public void actionPerformed(ActionEvent event)
      {
    	   count++;
    	   
    	   if (count == 1)
    		   System.out.println("I was clicked " + count + " time.");
    	   else
    		   System.out.println("I was clicked " + count + " times.");
      }            
   }
