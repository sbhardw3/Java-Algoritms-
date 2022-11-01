package testing;

import bridges.base.LineChart;
import bridges.benchmark.SortingBenchmark;
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class sorting {

  private static void swap(int [] array, int i1, int i2){
  
  int temp = array[i1];
  array[i1] = array[i2];
  array[i2] = temp;
  
  }

  static Consumer <int[]> sort = arr -> {
	//TODO: implement insertion sort
    int n = arr.length;
    for(int i = 1; i < n; i++){//Inserting the ith record
      int current = arr[i];
      int j = i - 1;    
      while(j >= 0 && arr[j] > current){
        arr[j + 1] = arr[j];
        j--;
       }   
       arr[j] = current;
     
    }
      

  };

  static Consumer <int[]> javasort = arr -> {
    Arrays.sort(arr);

  };


  static Consumer <int[]> bubbleSort = arr -> {
	  //TODO: implement bubble sort
      int n = arr.length;
      
      for(int i = 0; i < n; i++){
         for(int j = 1; j < n; j++){
            if(arr[j] < arr[j - 1]){
            swap(arr, j , j- 1);
            }
            
         }
      }

  };

  public static void main(String[] args) throws IOException, RateLimitException, InterruptedException {

    Bridges bridges = new Bridges(29, "YOUR_BRIDGES_ACC_NAME", "YOUR_API_KEY");

    bridges.setTitle("Sorting Benchmark");
    bridges.setDescription("Sorting Benchmark test");

    LineChart plot = new LineChart();
    plot.setTitle("Sort Runtime");
    SortingBenchmark bench = new SortingBenchmark(plot);

    bench.setGenerator("random");

    LineChart plot2 = new LineChart();
    plot2.setTitle("Sort Runtime");
    SortingBenchmark bench2 = new SortingBenchmark(plot2);
    bench2.geometricRange(100, 10000, 1.5);

    bench2.run("SelectionSort", sort);
    bench2.run("bubblesort", bubbleSort);
    bench2.run("javasort", javasort);

    bridges.setDataStructure(plot2);
    bridges.visualize();
  }

}
