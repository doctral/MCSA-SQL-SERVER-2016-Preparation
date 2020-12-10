
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        int startIndex = dna.indexOf(startCodon);
        if(startIndex<0) return "";
        int endIndex = dna.indexOf(stopCodon, startIndex+3);
        if(endIndex<0 || (endIndex-startIndex)%3!=0 ) return "";
        
        return dna.substring(startIndex, endIndex+3);
    }
}
