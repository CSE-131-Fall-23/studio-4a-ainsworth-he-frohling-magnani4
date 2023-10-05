package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		String type= in.next();
		int red = in.nextInt();
		int green = in.nextInt();
		int blue = in.nextInt();
		boolean isFilled = in.nextBoolean();
		double x = in.nextDouble();
		double y = in.nextDouble();
		
		StdDraw.setPenColor(red, green, blue);
		
		if(type.equals("rectangle")) {
			double hw = in.nextDouble();
			double hh = in.nextDouble();
			if(isFilled)
			{
			StdDraw.filledRectangle(x, y, hw, hh);
			}
			else
			{
			StdDraw.rectangle(x, y, hw, hh);
			}
		}
		if(type.equals("ellipse")) {
			double sMa = in.nextDouble();
			double sma = in.nextDouble();
			if(isFilled)
			{
			StdDraw.filledEllipse(x, y, sMa, sma);
			}
			else
			{
			StdDraw.ellipse(x, y, sMa, sma);
			}
		}
		if(type.equals("triangle")) {
			double x2 = in.nextDouble();
			double y2 = in.nextDouble();
			double x3 = in.nextDouble();
			double y3 = in.nextDouble();
			double[] xs = {x, x2, x3};
			double[] ys = {y, y2, y3};
			if (isFilled) {
				StdDraw.filledPolygon(xs, ys);
			}
			else {
				StdDraw.polygon(xs, ys);
			}
		}
	}
}
