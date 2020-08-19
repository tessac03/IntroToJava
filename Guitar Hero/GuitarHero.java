/* *************************************************************************************
 * Description: Simulates a 37 keykeyboard using the keys on the keyboard using the 
 * method GuitarString.
 ************************************************************************************ */
public class GuitarHero {
	public static void main(String[] args){
		String keyboardStr = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";	
		int numStrings=37;
		GuitarString[] keyboard=new GuitarString[numStrings];
    
		for(int i=0;i<numStrings;i++){
	        double freq = 440 * Math.pow(2, ((i - 24) / 12.0));
			keyboard[i]=new GuitarString(freq);
		}
    
		while(true){
			if(StdDraw.hasNextKeyTyped()){
				char key=StdDraw.nextKeyTyped();
				int index=keyboardStr.indexOf(key);
				if(index==-1){
					continue;
				}
				keyboard[index].pluck();
			}
    	
			double sample=0;
    	
			for(int j=0;j< keyboard.length;j++){
				sample +=keyboard[j].sample();
			}
    	
			StdAudio.play(sample);
    	
			for(int k=0; k<keyboard.length; k++){
				keyboard[k].tic();
			}
		}
	}
}
