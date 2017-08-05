package cse110.crossfit.IDEAproject.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.Log;
import android.view.View;

/**
 * GraphView creates a scaled line or bar graph with x and y axis labels. 
 * @author Arno den Hond
 *
 */
public class GraphView extends View {
	private Paint paint;

	private float[] horValues;
	private float[] verValues;
	
	private String[] horlabels;
	private String[] verlabels;
	
	private String title;

	private String horAxisLabel;
	private String verAxisLabel;
	
	

	public GraphView(Context context, float[] horValues, float[] verValues,
			String title, String horAxisLabel, String verAxisLabel,
			String[] horlabels, String[] verlabels) {
		super(context);
		if (horValues == null)
			horValues = new float[0];
		else
			this.horValues = horValues;
		if (verValues == null)
			verValues = new float[0];
		else
			this.verValues = verValues;
		if (title == null)
			title = "";
		else
			this.title = title;
		if (horAxisLabel == null)
			horAxisLabel = "";
		else
			this.horAxisLabel = horAxisLabel;
		if (verAxisLabel == null)
			verAxisLabel = "";
		else
			this.verAxisLabel = verAxisLabel;
		if (horlabels == null)
			this.horlabels = new String[0];
		else
			this.horlabels = horlabels;
		if (verlabels == null)
			this.verlabels = new String[0];
		else
			this.verlabels = verlabels;
		paint = new Paint();
	}
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: onDraw()
	 * Description: Creates a line graph
	 * Parameters: 
	 * 		Canvas canvas
	 * Error Conditions: None
	 * Return Value: None
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		float buttonspace = 120;
		float textspace = 4;
		float border = 25;
		float horstart = border * 2;
		float height = getHeight();
		float width = getWidth() - 1;
		float max = getMax();
		float min = getMin();
		float diff = max - min;
		Log.d("GraphView", "" + diff); // Testing
		
		float graphheight = height - (2 * border) - buttonspace;
		float graphwidth = width - (2 * border);
		float graphbottom = height - border - buttonspace;

		/*
		 *  Graph Title
		 */
		paint.setTextAlign(Align.CENTER);
		paint.setColor(Color.WHITE);
		canvas.drawText(title, (graphwidth / 2) + horstart, border - textspace, paint);
		
		/*
		 *  Vertical Axis Label
		 */
		paint.setTextAlign(Align.RIGHT);
		paint.setColor(Color.WHITE);
		canvas.drawText(verAxisLabel, horstart - (9 * textspace), graphbottom - (graphheight / 2), paint);
		
		/*
		 *  Horizontal Axis Label
		 */
		paint.setTextAlign(Align.CENTER);
		paint.setColor(Color.WHITE);
		canvas.drawText(horAxisLabel, (graphwidth / 2) + horstart, graphbottom + (8 * textspace), paint);
		
		
		/*
		 *  Horizontal Grid Lines and Vertical Axis Labels
		 */
		paint.setTextAlign(Align.RIGHT);
		int vers = verlabels.length - 1;
		for (int i = 0; i < verlabels.length; i++) {
			float y = ((graphheight / vers) * i) + border;
			paint.setColor(Color.WHITE);
			canvas.drawLine(horstart, y, width, y, paint);
			paint.setColor(Color.WHITE);
			canvas.drawText(verlabels[i], horstart - textspace, y, paint);		
		}
		
		/*
		 *  Vertical Grid Lines and Horizontal Axis Labels
		 */
		int hors = horlabels.length - 1;
		for (int i = 0; i < horlabels.length; i++) {
			paint.setColor(Color.WHITE);
			float x = ((graphwidth / hors) * i) + horstart;
			canvas.drawLine(x, graphbottom, x, border, paint);
			paint.setTextAlign(Align.CENTER);
			if (i==horlabels.length-1)
				paint.setTextAlign(Align.RIGHT);
			if (i==0)
				paint.setTextAlign(Align.LEFT);
			paint.setColor(Color.WHITE);
			canvas.drawText(horlabels[i], x, graphbottom + (4 * textspace), paint);
		}
		
//		// Introduce shifting and rescaling here
//		this.verValues = rescaleVerValues(this.verValues);

		
		/*
		 * Plotting the values
		 */
		paint.setColor(Color.BLUE);
		if ((horValues.length == verValues.length) && (verValues.length > 1)) {
			int datalength = horValues.length;
			float segwidth = graphwidth/horValues[datalength - 1];
			// previous horizontal position
			float lastp = 0;
			// previous vertical height
			float lasth = 0;
			for (int i = 0; i < datalength; i++) {
				// determine the current horizontal position
				float p = horValues[i];
				// calculate the current vertical height
				float val = verValues[i] - min;
				float frac = val / diff;
				float h = graphheight * frac;
				if (i > 0)
					canvas.drawLine((lastp * segwidth) + (horstart + 1), (border - lasth) + graphheight,
									(p * segwidth) + (horstart + 1), (border - h) + graphheight, paint);
				lastp = p;
				lasth = h;
			}	
		}
		
		
	}

	private float getMax() {
		return new Float(verlabels[0]);
	}

	private float getMin() {
		return new Float(verlabels[verlabels.length-1]);
	}	
	
//	private float getMax() {
//		float largest = Integer.MIN_VALUE;
//		for (int i = 0; i < verValues.length; i++)
//			if (verValues[i] > largest)
//				largest = verValues[i];
//		return largest;
//	}
//
//	private float getMin() {
//		float smallest = Integer.MAX_VALUE;
//		for (int i = 0; i < verValues.length; i++)
//			if (verValues[i] < smallest)
//				smallest = verValues[i];
//		return smallest;
//	}

	
//	/*
//	 * Author: Akinyinka Omigbodun
//	 * Function Name: rescaleVerValues()
//	 * Description:
//	 * Parameters: 
//	 * 	
//	 * Error Conditions:
//	 * Return Value:
//	 */
//	public float[] rescaleVerValues(float[] verValues) {
//		float max = getMax(verValues);
//		float min = getMin(verValues);
//		
//		/*
//		 * Convert the min and max to the nearest multiples
//		 * of 10, greater and less than respectively
//		 */
//		int max10 = (((int) max/10) + 1) * 10;
//		int min10 = ((int) min/10) * 10;
//		
//		float[] rescaledVerValues = new float[verValues.length];
//		
//		/*
//		 * Shift the values down by this amount
//		 */
//		float shift = ((float) min10) - min;
//		/*
//		 * Scale the values by this amount
//		 */
//		float rescaling = ((float) (max10 - min10))/(max - min);				
//		for (int i = 0; i < verValues.length; i++) {
//			rescaledVerValues[i] = (verValues[i] + shift) * rescaling;
//		}
//		
//		return rescaledVerValues;
//	}
//	
//	/*
//	 * Author: Akinyinka Omigbodun
//	 * Function Name: getMax()
//	 * Description:
//	 * Parameters: 
//	 * 	
//	 * Error Conditions:
//	 * Return Value:
//	 */
//	public float getMax(float[] weights) {
//		float largest = Integer.MIN_VALUE;
//		for (int i = 0; i < weights.length; i++)
//			if (weights[i] > largest)
//				largest = weights[i];
//		return largest;
//	}
//	
//	/*
//	 * Author: Akinyinka Omigbodun
//	 * Function Name: getMin()
//	 * Description:
//	 * Parameters: 
//	 * 		
//	 * Error Conditions: 
//	 * Return Value: 
//	 */
//	private float getMin(float[] weights) {
//		float smallest = Integer.MAX_VALUE;
//		for (int i = 0; i < weights.length; i++)
//			if (weights[i] < smallest)
//				smallest = weights[i];
//		return smallest;
//	}

}