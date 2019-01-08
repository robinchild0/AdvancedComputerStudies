import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
class CompressTest {
  String initInput = "00010011110001101000000010000000000010100010000000000010000000011011110010000001001000011000100000110010000111001000101000100001010001101000000000101000010110010001100101000110000100100011010001011001000110111100011101010000100000000110100000011000010001110110000110010100001000000001110011000110111100001000000001101101000110000100011011100001111001000010000000011100100001100101000110110000011000010001110100000110100100011011110001101110000111001100011010000001101001000111000000011100110000100000000110100100011011100000100000000111010000101011010010110000000110110000011010010001100110000110010100100000110001101110000110110000101000100010101010001001101000011011110001110010001011010000011101110010011101000111011100011010010001101100000110110000001000000010100110000111001100011101000010001110001001010000001000000001100111001001110100101101010001110010001001010000011001110010000001000110000100110010010010110100000110100000100110100001110000000110000100101100100000100000001010000000011001000010011011000111010000011100100010111001001011101100010101000011011100001011001100011110010011010000000111010000011101010001110010001110101100100101000011000011000110001000011000010001100011000110101100111000010001101110001110001100101101010001100101000111100100001001110010100100001101000100110000000010011011001001110100011001100001100001001100110100100010010000100000000111100100100100000010001101000100000100111110010011011011001111110000111111100010011010001101001000011011100010011010001001110000001000000100000100001100110100001011000100001000010000101000100010010100011001010001010100011010000001101111000110110000111000110010101010010000111000100001010100010011001011000000011101110100011111001010001100100100000011001001001010001000011000110001100001001010010000000010100001001001001011001100111110110000100000000110010101000011010011111011001111110100110110100001100010001001101001001101000010101010001011111001001001010001100101001011000000111110110100110000010000110000111000110100101000010011011001000010000011010000000110011100011001010001110100001000010101001000010011111000001110001100110011010100101111010100110100011011000001101111000111001100101100100001100111010100100100111011110010010110001101111100011100100000001010000100001100101000000101011010001011010000101001010011001010000110110100100110100100101000001100011000110010000011001010001100110101011010100000100000010010111000101001000000111111010101111101011000010011101100001001010100011101000101100100001001111001011001110100101001001100011100110110100101101100001101101001011011110001100101010111000100100001000101111111000000101000010011010001101101000110110100011000100001101111000111000001000110010011110100000010000000011001000001110101011000110000011001000110001001000000101000010000100001100001011000110100100101010110001000011000101000001000000110010000011000111101100101010110010001000111000001100100110110011101011001011101100010010110001011011010000101100100000110001001001000001001100101000110010110010001100101000010010010010001000010110100011001010000101101011010110000100011010110000101011000011101101000110110011010011010010101100111010110010010011010100101100011100110011010011011010101100110110110100110011001111101101110100110100010011001100101101111100110111000000111000001101010000110100001011010101101000010100110101110011011000001000110110001010011001101111101001000100010000001011011000101001100010010110011010110000101100001100110110100011100011001001110000100010000010000000001000100110010001110010000101001000110100010010001000000101000010100000010100110000110111001010011010110010101000111001100011001010001100101000110010001000110010001110000011110001101111001010100010110010101010100011101110001100101000111001001111010110111101101001110000100101000110101010110001011101100100100110010010101010010111000101100110111101100001010000001111001010010100001010100000000100001010001100110001101101101111110000000001010000100101101111010000111000110011111111001111001000101011000001011010001000000110010110010010010001000011101010101001101010010100000011010010001100011001000011101000100110011010001001101010100011101110001110011010011000100011101000000100111000111001100001011101000100001";
  String decodeTest = "THere is a random point where things stop working but I cant pin point what is causing it so I am going to just kep typing until maybe I can figure out what is causing it because I have no clue so here goes nothing: Oh um what is it the init is what you want to convert to numbers and then the last is your next place to start wiht or the init plus last which is the entire thing is what goes into the dictionary why is this getting stuck already Time to add even more words to this sentence and run it through a massive stress test to ensure that nothing will ever break when it gets longer or differetn amounts of bits get added to the string we will also try to figure out what number of bits will create the smalles string compression size. It might be easier for me to simply make a method to do it for me but who really knows.";
 
  

  
  
  public static void main(String[] args) throws IOException {
    
    
	  new CompressTest();
  }
  public CompressTest() throws IOException
  {
    //System.out.println(decompress(initInput));
    //System.out.println(compress(decodeTest,9)+"\n\n\n\n\n\n\n\n\n");
	
	decodeTest = getFileContents("src/inputText");
	//System.out.println(decodeTest);
	//System.out.println(decompress(initInput));
	//System.out.println(decodeTest);
	//int smallDecode = findSmallestCompression(decodeTest);
    //System.out.println(smallDecode);
   // System.out.println(decompress(compress(decodeTest,findSmallestCompression(decodeTest))));
	int bestCompress = findSmallestCompression(decodeTest);
	writeFileContents("src/outputText",compress(decodeTest,bestCompress) );	
	System.out.println(bestCompress+"\n"+compress(decodeTest,bestCompress));
	System.out.println(compress(decodeTest,8));
  }
  public String decompress(String input)
  {
    HashMap<Integer, String> dictionary = new HashMap<>();
    //System.out.println("Input: "+input+"\n\n\n\n\n\n\n");
    //int bits = Integer.parseInt(input.substring(0,32),2);
    int bits = 10;
    //input = input.substring(32);
    //System.out.println(input);
    
    int putValue = 128;
    String original = "";
    String charA = "";
    String charB = "";
    
    while(input.length() >(bits*2)-1)
    {
    int curNum = Integer.parseInt(input.substring(0,bits),2);
    //System.out.println("CurNum: "+curNum);
    
    int nextNum = Integer.parseInt(input.substring(bits,2*bits),2);
    //System.out.println("NextNum: "+nextNum);
    //System.out.println(curNum);
      if(curNum < 128)
      {
        charA = ""+(char)curNum;
      }
      else
      {
        charA = dictionary.get(curNum);
      }
      if(nextNum < 128)
      {
        charB = ""+ (char)nextNum;
      }
      else
      {
    	  try
    	  {
    		  charB = dictionary.get(nextNum).substring(0,1);
    	  }
    	  catch(Exception E)
    	  {
    		  //System.out.println("aaaaaaaaaaaaaaaaaaaa" + nextNum);
    	  }
      }
      if(!dictionary.containsValue(charA+charB)  )
      {
        dictionary.put(putValue, charA+charB);
        putValue++;
      }
      original+= charA;
      //System.out.println(original);
      input = input.substring(bits);
    }
    int finalChar = Integer.parseInt(input,2);
    if(finalChar < 128)
    {
      original+= (char)finalChar;
    }
    else
    {
      original+= dictionary.get(finalChar);
    }
    return(original);
  }
  //TODO: if curChar+nextChar is not in dictionary then add to dictionary if its the add curChar+nextChar +1 and so on and so forth and the last bit a decind before
  public String compress(String original, int bits)
  {
    int endCount = 0;
    String compressed = "";
    int putVal = 128;
    
    HashMap<String,Integer> dictionary = new HashMap<>();
    for(int i = 0; i< original.length()-1; i++)
    {
      String curChar = original.charAt(i)+"";
      String nextChar = original.charAt(i+1)+"";
      //System.out.println("Begin:"+curChar);
      int count = 0;
      int temp = i;
      while(dictionary.containsKey(curChar+nextChar) && temp+2 < original.length())
      {
        curChar = curChar+nextChar;
        nextChar = original.charAt(temp+2)+"";
        temp++;
        count++;
      }
      
      if(putVal < Math.pow(2,bits))
      {
        dictionary.put(curChar+nextChar, putVal);
        
        //curChar = curChar.substring(0,curChar.length()-1);
        //System.out.println(curChar);
        putVal++;
      }
      
      //System.out.println("End:"+curChar+"  "+ curChar.contains(" "));
      String binRep = "";
      if(curChar.length()==1)
      {
        //System.out.println((int)curChar.charAt(0));
        binRep = Integer.toBinaryString((int)curChar.charAt(0));
      }
      else
      {
        //System.out.println(dictionary.get(curChar));
        binRep = Integer.toBinaryString(dictionary.get(curChar));
      }
      
      //System.out.println(Integer.parseInt(binRep,2));
      while(binRep.length() < bits)
      {
        binRep = "0"+binRep;
      }
      compressed+=binRep;
      i+=count;
      endCount = i;
    }
    //System.out.println(endCount);
    //System.out.println(original.length()-1);
    //System.out.println(original.charAt(original.length()-1));
    if(endCount == original.length()-2)
    {
      char endChar = original.charAt(original.length()-1);
      String binRep = Integer.toBinaryString((int)endChar);
      while(binRep.length() < bits)
      {
        binRep = "0"+binRep;
      }
      compressed+=binRep;
    }
    String numBits = Integer.toBinaryString(bits);
    while(numBits.length() < 32)
    {
      numBits = "0"+numBits;
    }
    compressed = numBits+compressed;
    //System.out.println(compressed);
    return(compressed);
  }
  public int findSmallestCompression(String input)
  {
    int smallestNum = 0;
    int smallest = Integer.MAX_VALUE;
    for(int i = 8; i < 32; i++)
    {
    	String test = compress(input,i);
    	//System.out.println(test);
      int num = test.length();
        if(num < smallest)
        {
          smallest = num;
          smallestNum = i;
        }
        System.out.println(i+":"+num+" "+smallestNum+":"+smallest);
    }
    return(smallestNum);
  }
  private static String getFileContents( String filename ) throws IOException {
      return new String(Files.readAllBytes(Paths.get(filename)));
  }
  
  private static void writeFileContents( String filename, String data ) throws IOException {
      FileWriter fw = new FileWriter(new File(filename));
      fw.write( data );
      fw.close();
  }
  
}

