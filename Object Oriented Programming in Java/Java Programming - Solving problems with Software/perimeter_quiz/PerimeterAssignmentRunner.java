import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for(Point p : s.getPoints()){
            count++;
        }
        // Put code here
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        
        double perimeter = getPerimeter(s);
        int count = getNumPoints(s);
        
        return perimeter/count;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        
        Point prevPt = s.getLastPoint();
        double max = 0;
        
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if(max<currDist) max = currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("example1.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("shape 1 perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        String[] files = new String[]{"datatest1.txt", "datatest2.txt", "datatest3.txt", "datatest4.txt", "datatest5.txt", "datatest6.txt"};
        double maxPeri = 0;
        FileResource fr;
        Shape s;
        String f="";
        for(String fileName : files){
            fr = new FileResource(fileName);
            s = new Shape(fr);
            double peri = getPerimeter(s);
            if(maxPeri<peri){
                maxPeri = peri;
                f = fileName;
            } 
            System.out.println("Perimeter = "+ peri);
        }
        System.out.println("max perimeter is "+maxPeri);
        System.out.println("file name is "+ f);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeterMultipleFiles();
    }
}
