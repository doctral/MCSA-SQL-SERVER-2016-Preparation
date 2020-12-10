
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex<0) return "";
        int endIndex = dna.indexOf("TAA", startIndex+3);
        if(endIndex<0 || (endIndex-startIndex)%3!=0 ) return "";
        
        return dna.substring(startIndex, endIndex+3);
    }
}
