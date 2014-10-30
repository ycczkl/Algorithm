import java.util.ArrayList;
import java.util.HashMap;

public class Question7_6 {
	
	class Point {
		public double x;
		public double y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	class Line {
		public double slope;
		public double ep = 0.0001;
		public double intercept;
		public boolean infi_slope = false;
		
		public Line(Point point1, Point point2) {
			if (Math.abs(point1.x - point2.x) > ep) {
				slope = (point1.y - point2.y)/(point1.x - point2.x);
				intercept = point1.y - slope * point1.x;
			} else {
				infi_slope = true;
				intercept = point1.x;
			}
		}
		
		public boolean ifSame(Line b) {
			if (this.slope == b.slope && this.intercept == b.intercept || this.infi_slope == b.infi_slope == true && this.intercept == b.intercept) { 
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void addToHashMap(HashMap<Double, ArrayList<Line>> linesBySlope, Line line) {
		ArrayList<Line> lines = null;
		double key = line.slope;
		if (linesBySlope.containsKey(key)) {
			lines = linesBySlope.get(key);
		} else {
			lines = new ArrayList<Line>();
			linesBySlope.put(key, lines);
		}
		lines.add(line);
	}
	
	public int countEqule(HashMap<Double, ArrayList<Line>> linesBySlope, Line line) {
		if (line == null) {
			return 0;
		} else {
			int count = 0;
			double key = line.slope;
			ArrayList<Line> lines = linesBySlope.get(key);
			for (Line eachLine : lines) {
				if(line.ifSame(eachLine)) {
					count++;
				}
			}
			return count;
		}
	}
	
	public Line findBestLine (Point[] points) {
		Line bestLine = null;
		int bestCount = 0;
		HashMap<Double, ArrayList<Line>> linesBySlope = new HashMap<Double, ArrayList<Line>>();
		for (int i = 0; i < points.length; i++) {
			for (int j = 1; j < points.length; j++) {
				Line line = new Line(points[i], points[j]);
				addToHashMap(linesBySlope, line);
				
				int count = countEqule(linesBySlope, line);
				
				if (count > bestCount) {
					bestLine = line;
					bestCount = count;
				}
			}
		}
		return bestLine;
	}
	
	
}
