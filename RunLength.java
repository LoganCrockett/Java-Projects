
/**
 * This class will take an array of integer values, and compute the
 * longest sequence(run) of numbers.
 *
 * @author Logan Crockett
 * @version 1/14/19
 */
public class RunLength
{
    
    public static void main(String args[]) {
        
        //Initialize the array
        int[] values = {1,2,5,5,3,1,2,4,3,2,2,2,2,3,6,5,5,6,3,1};
        int runLength = 0;//Highest length of a run
        int currentRunLength = 1;//Length of the current run; Will at minimum be one
        int currentValue = values[0];//Current value to be tested for a run
        
        //Process the array for a run
        for (int i = 1; i < values.length; i++) {
            
            if (values[i] == currentValue) {
                
                currentRunLength++;//Increment the run length by one
                if (currentRunLength > runLength)
                    runLength = currentRunLength;//Set value for run length
                
            }
            else {
                
                currentValue = values[i];//Change value for next test
                currentRunLength = 1;//Reset for the next test
                
            }
        }
        
        System.out.println("Longest run length: " + runLength);
    }
}
