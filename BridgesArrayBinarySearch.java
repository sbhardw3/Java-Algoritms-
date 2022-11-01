import bridges.base.Array1D;
import bridges.connect.Bridges;

public class BridgesArrayBinarySearch {

	/*
	 * TODO: Complete this function to perform binary search to look for a specific value in an array
	 * For each iteration, highlight the low and high index as 'green', the middle index as 'orange', and if you find the value highlight the index as 'red'.
	 * Also, for each iteration, visualize the state of the array by calling bridges.visualize();
	 * You can get the element of an array by doing: "arr.getElement(Index);"
	 * You can color an element by calling the setColor("green") on an element.
	 *
	 *  @param	searchValue		Is the value you are looking for the array
	 *  @param	arr				Is the array that we are searching in
	 *  @param	bridges			Is the bridges object used to visualize the data structure
	 */
	public static void BinarySearch(int searchValue, Array1D arr, Bridges bridges) throws Exception {
   
   // taking the lowest and highest value
     int low = (int) arr.getElement(0).getValue();
     arr.getElement(0).setColor("green");
     int high = (int) arr.getSize();
     
     int target = searchValue;
    
     while(low <= high){
          int mid = (low + high)/2;//Calculating the mid value 
          
          arr.getElement(mid).setColor("orange");
          
          if((int)arr.getElement(mid).getValue() > target){ // if the target value is higher than 
                                                           //the mid value changing the mid value 
                high = mid - 1;
                }
          else if ((int)arr.getElement(mid).getValue() < target){//if the target value is lower than 
                                                                 //the mid value updating the mid value
                low = mid + 1;
                }
          else{
            
            arr.getElement(mid).setColor("red");//If the value is achieved then coloring it red.
            }
           
      }

	  bridges.visualize();
		return;
	}

	public static void main(String[] args) throws Exception {
		//Bridges setup
		Bridges bridges = new Bridges(20, "sbhardw3", "672690204402");
		bridges.setTitle("Binary search using an Array");
		bridges.setDescription("Perform Binary Search on a BRIDGES array highlighing the lower, mid, and upper indicies of the list per iteration");

		int arraySize = 30;

		Array1D<Integer> arr = new Array1D<Integer>(arraySize); //this is a bridges array

		//populate the array with values that are the same as their index.
		//this will be a sorted array which is needed for binary search.
		for(int i = 0; i < arr.getSize(); i++) {
			arr.getElement(i).setValue(i);
			arr.getElement(i).setLabel(String.valueOf(i));
		}

		//set the data structure that bridges is going to use for visualization to the array we made
		bridges.setDataStructure(arr);

		//call binary search
		BinarySearch(3, arr, bridges);

		return;
	}
}