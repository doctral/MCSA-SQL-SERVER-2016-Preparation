import edu.duke.*;
/**
 * Write a description of Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test {
    
    public void processGenes(StorageResource sr){
        for(String str : sr.data()){
            System.out.println(str);
        }
    }
    
    public void TestRun(){
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        System.out.println(dna);
    }
    
}
