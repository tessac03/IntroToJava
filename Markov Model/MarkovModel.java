/* *************************************************************************************
 * Description: Class to simulate a Markov Model using a symbol table, with methods to
 * get the order of the model, get the frequency of a kgram in the model, and to 
 * return a String representation of the model.
 ************************************************************************************ */
public class MarkovModel {
	//Number of character after the kgram
	 public static final int ascii = 128;
	
	 //Symbol table to store kgram as key and integer array of size 128 to correspond to each ascii character
	 //that stores the kgram's frequency as value
	 private ST<String, int[]> st;
	 private int k;	 
	 
    //Creates a Markov model of order k based on the specified text
    public MarkovModel(String text, int k){
        if(k < 0 || k > text.length())
            throw new RuntimeException("k must be non-negative integer which cannot be greater than length of text");
        
        st = new ST<String, int[]>();   
        this.k = k;
        char next_char;
        int[] value_array = new int[ascii];
        int text_length = text.length();
        //append the first k chars to the end of the string to make it 'circular'
        text += text.substring(0,k); 
        
        for(int i = 0; i < text_length; i++) { 
            String kgram = text.substring(i, i+k);
            if(!st.contains(kgram))           
                st.put(kgram, new int[ascii]); 
            
            next_char = text.charAt(i + k);
            value_array = st.get(kgram);       
            value_array[(int) next_char]++;
            st.put(kgram, value_array);       
        }       
    }

    //Returns the order of the model (also known as k)
    public int order(){
    	return k;
    }

    //Returns a String representation of the model (more info below)
    public String toString(){
    	String str="";
    	String temp="";
    	
    	for(Object key : st.keys()){
    		if(temp.equals("")){
    			str+=key.toString().substring(0,order())+":";
    		}else if(!temp.equals(key.toString().substring(0,order()))){
    			str+="\n";
    			str+=key.toString().substring(0,order())+":";
    		}
    		
    		str+=" "+key.toString().charAt(order())+" "+st.get(key.toString());
    		temp=key.toString().substring(0,order());
    	}
    	
    	return str;
    }

    //Returns the # of times 'kgram' appeared in the input text
    public int freq(String kgram){
    	if(kgram.length()!=k){
    		throw new RuntimeException("The string is not length k");
    	}
    	int count=0;
    	if(st.contains(kgram)){
    		int[] freq = st.get(kgram);
    		for(int i=0;i<ascii;i++){
    			count+=freq[i];
    		}
    	}
    	return count;
    }

    //Returns the # of times 'c' followed 'kgram' in the input text
    public int freq(String kgram, char c){
    	if(kgram.length()!=k){
    		throw new RuntimeException("The string is not length k");
    	}
    	int[] value=st.get(kgram);
    	return value[(int) c];
    }

    //Returns a random character, chosen with weight proportional to the
    //Number of times each character followed 'kgram' in the input text
    public char random(String kgram){
    	if(kgram.length()!=k){
    		throw new RuntimeException("The string is not length k");
    	}
    	int[] value=st.get(kgram);
    	int rand=StdRandom.discrete(value);
    	return((char)rand);
    }
    
 // unit tests this class
    public static void main(String[] args) {
        String text1 = "banana";
        MarkovModel model1 = new MarkovModel(text1, 2);
        System.out.println("freq(\"an\", 'a')    = " + model1.freq("an", 'a'));
        System.out.println("freq(\"na\", 'b')    = " + model1.freq("na", 'b'));
        System.out.println("freq(\"na\", 'a')    = " + model1.freq("na", 'a'));
        System.out.println("freq(\"na\")         = " + model1.freq("na"));
        System.out.println();

        String text2 = "one fish two fish red fish blue fish"; 
        MarkovModel model2 = new MarkovModel(text2, 4);
        System.out.println("freq(\"ish \", 'r') = " + model2.freq("ish ", 'r'));
        System.out.println("freq(\"ish \", 'x') = " + model2.freq("ish ", 'x'));
        System.out.println("freq(\"ish \")      = " + model2.freq("ish "));
        System.out.println("freq(\"tuna\")      = " + model2.freq("tuna"));
        System.out.println(model2.random("ish "));
    }
}
