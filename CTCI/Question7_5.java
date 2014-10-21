
public class Question7_5 {
	class Line {
		double x1;
		double x2;
		double y1;
		double y2;
		public Line(double x1, double y1, double x2, double y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		
		public double getSlop() {
			if (x1 == x2) {
				return -1;
			} else {
				return (y2 - y1)/(x2 - x1);
			}
		}
	}
	
	class Square {
		double x1;
		double y1;
		double x2;
		double y2;
		
		public Square(double x1, double x2, double y1, double y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
		
		public double getMidX() {
			return (x1 + x2)/2;
		}
		
		public double getMidY() {
			return (y1 + y2)/2;
		}
	}
	
	public Line getLine(Square square1, Square square2) {
		double x1 = square1.getMidX();
		double x2 = square2.getMidX();
		double y1 = square1.getMidY();
		double y2 = square2.getMidY();
		return new Line(x1, y1, x2, y2);
	}
}
