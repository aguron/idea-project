package cse110.crossfit.IDEAproject;

import java.util.Date;

import cse110.crossfit.IDEAproject.Databases.DataManager;

import cse110.crossfit.IDEAproject.ModelsData.weightC;
import cse110.crossfit.IDEAproject.Utilities.DateDifference;
import cse110.crossfit.IDEAproject.Views.GraphView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class statistics_weightchart extends Activity implements OnClickListener {
	Button STchartBKbackBtn;
	Intent nextActivity;
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: onCreate()
	 * Description: Creates a line or bar graph of the weight information in the database
	 * Parameters:
	 * 		Bundle savedInstanceState - current state of application
	 * Error Conditions: To be filled in
	 * Return Value: None
	 */
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int numWeights = DataManager.getWeightCount(statistics_weightchart.this);
		
		/*
		 * GET ALL THE WEIGHTS FROM THE DATABASE
		 */
		String[] tempDates = new String[numWeights];
		long[] dates = new long[numWeights];
		float[] weights = new float[numWeights];
		weightC tempWeight = new weightC();
		
		for (int i = 0; i < numWeights; i++) {
			tempWeight = DataManager.getWeight(i+1,statistics_weightchart.this);
			tempDates[i] = tempWeight.getWeightDate();
			dates[i] = Long.parseLong(tempDates[i]);
			weights[i] = Float.parseFloat("" + tempWeight.getWeight()[0]) ;
		}
		
		/*
		 * CODE FOR TESTING:
		 * 
		 * PRINT VALUES READ FROM THE DATABASE
		 */
		for (int i = 0; i < numWeights; i++) {
			Log.d("MyApp", "Date: " + dates[i] + " Weight: " + weights[i]);
		}
		//long[] dates = {1000000000L};
		//float[] weights = { 120f };
		
		if (weights.length > 1) {
        	float[] horValues = makeHorValues(dates);
        	float[] verValues = weights;
        	String[] horlabels = makeHorLabels(dates);
        	String[] verlabels = makeVerLabels(weights);
         
        	GraphView graphView = new GraphView(this, horValues, verValues, "Tracking Weight", "Date", "lbs" , horlabels, verlabels);
        	setContentView(graphView);
		}
		
		else {
            nextActivity = new Intent(this, statistics.class);    
            startActivity(nextActivity);
		}
		
	}

	@Override
	public void onClick(View v) {
		switch( v.getId() ) {
			case R.id.STchartBKbackBtn:
				nextActivity = new Intent(this, statistics.class);    
		 	    startActivity(nextActivity);
		 	    break;
		}
	}
	
	/*
	 * This code needs to be moved to a GraphLogic.java class 
	 */
	
	/*
	 * Need to take care of the case when there is only one weight in the database. 
	 */
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: makeHorLabels()
	 * Description:
	 * Parameters: 
	 * 	
	 * Error Conditions:
	 * Return Value:
	 */
	public String[] makeHorLabels(long[] dates) {
		long min = getMin(dates);
    	// TESTING
			Log.d("MyApp", "Date: " + min);
		// END TESTING

		long max = getMax(dates);
		/*
		 * Convert the date values to "day" units
		 * 
		 * The first date will have a "day" value of 0
		 */
		float[] days = new float[dates.length];
		
		for (int i = 0; i < dates.length; i++) {
			days[i] = (float) DateDifference.daysBetween(new Date(min), new Date(dates[i]));
		}
		
		/*
		 * Fit at most two equally spaced labels in between the first and the last date.
		 */
		int datePeriod = DateDifference.daysBetween(new Date(min), new Date(max));
		String[] dateLabels;
		
		if (datePeriod < 4) {
			dateLabels = new String[datePeriod + 1];
		}
		
		else {
			dateLabels = new String[4];
		}

		long dateInterval = (max - min)/(dateLabels.length - 1);
		
		for (int i = 0; i < dateLabels.length; i++) {
			Date tempDate = new Date(min + (i * dateInterval));

			//Potential error here
			dateLabels[i] = tempDate.toString().substring(4,10) + ", " + tempDate.toString().substring(30,34);	
		}
		return dateLabels;
	}
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: makeHorValues()
	 * Description:
	 * Parameters: 
	 * 	
	 * Error Conditions:
	 * Return Value:
	 */
	public float[] makeHorValues(long[] dates) {
		long min = getMin(dates);
		/*
		 * Convert the date values to "day" units
		 * 
		 * The first date will have a "day" value of 0
		 */
		float[] days = new float[dates.length];
		
		for (int i = 0; i < dates.length; i++) {
			days[i] = (float) DateDifference.daysBetween(new Date(min), new Date(dates[i]));
		}
		return days;
	}
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: makeVerLabels()
	 * Description:
	 * Parameters: 
	 * 	
	 * Error Conditions:
	 * Return Value:
	 */
	public String[] makeVerLabels(float[] verValues) {
		float max = getMax(verValues);
		float min = getMin(verValues);
		
		/*
		 * Convert the min and max to the nearest multiples
		 * of 10, greater and less than respectively
		 */
		int max10;
		
		if (max % 10 == 0) {
			max10 = ((int) max/10) * 10;
		}
		
		else {
			max10 = (((int) max/10) + 1) * 10;
		}
		int min10 = ((int) min/10) * 10;
		/*
		 * Fit 9 labels in between max10 and min10
		 * 
		 * Perhaps this should depend on how many weights are in the database
		 */
		String[] verLabels = new String[11];
		
		for (int i = 0; i < 11; i++) {
			verLabels[i] = "" +  (max10 - (((max10 - min10) / 10) * i));
		}
		return verLabels;
	}
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: getMax()
	 * Description:
	 * Parameters: 
	 * 	
	 * Error Conditions:
	 * Return Value:
	 */
	public float getMax(float[] weights) {
		float largest = Float.MIN_VALUE;
		
		for (int i = 0; i < weights.length; i++)
			if (weights[i] > largest)
				largest = weights[i];
		return largest;
	}
	
	public long getMax(long[] dates) {
		long largest = Long.MIN_VALUE;
		
		for (int i = 0; i < dates.length; i++)
			if (dates[i] > largest)
				largest = dates[i];
		return largest;
	}
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: getMin()
	 * Description:
	 * Parameters: 
	 * 		
	 * Error Conditions: 
	 * Return Value: 
	 */
	private float getMin(float[] weights) {
		float smallest = Float.MAX_VALUE;
		
		for (int i = 0; i < weights.length; i++)
			if (weights[i] < smallest)
				smallest = weights[i];
		return smallest;
	}
	
	private long getMin(long[] dates) {
		long smallest = Long.MAX_VALUE;
		
		for (int i = 0; i < dates.length; i++)
			if (dates[i] < smallest)
				smallest = dates[i];
		return smallest;
	}
	
	/*
	 * This code needs to be moved to a GraphLogic.java class 
	 */
}