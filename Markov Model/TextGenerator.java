/* *************************************************************************************
 * Description: Class to generate random text using a Markov Model, given two integer 
 * inputs for the length of the kgrams to use and the length of the generated 
 * output, and a string to use.
 ************************************************************************************ */
public class TextGenerator {
	public static void main(String[] args){
		int k=Integer.parseInt(args[0]);
		int length=Integer.parseInt(args[1]);
		String txt=args[2];

		if(k>length){
			throw new RuntimeException("The length of the text must be at least k");
		}
		
		MarkovModel model=new MarkovModel(txt,k);
		
		String generatedTxt=txt.substring(0,k);
		for(int i=0; i<length-k; i++){
			generatedTxt+=String.valueOf(model.random(generatedTxt.substring(i,i+k)));
		}
		System.out.println(generatedTxt);
	}
}
