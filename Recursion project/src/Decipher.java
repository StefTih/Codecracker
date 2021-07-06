import java.util.*;

public class Decipher {

    private final char[] cipher;
    private final HashMap<String,String> Cipher_Alphabet_Mapping;

    Decipher()
    {
        Cipher_Alphabet_Mapping = new HashMap();
        cipher = new char[]{'!', ')', '"', '(', '£','*', '%', '&', '>', '<', '@', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o'};
        MapAlphabetToCipher();
    }

    public void MapAlphabetToCipher()
    {
        for( int ASCIValue = 97; ASCIValue<123; ASCIValue++)
        {
            char newChar = (char) ASCIValue;
            String character = Character.toString(newChar);
            Cipher_Alphabet_Mapping.put(Character.toString(cipher[ASCIValue-97]),character);

        }
    }

    public String Decrypt(String newWord)
    {
        String decryption = "";
        newWord = newWord.toLowerCase().trim();
        if (newWord.length() < 1)
        {
            System.out.println("Please enter a word longer than 0 characters!");
        }
        for(int i = 0; i<newWord.length(); i++)
        {
            String newLetter = findLetter(i,newWord);
            if(newLetter.equals("Error"))
            {
                return "This word cannot be translated because the symbol: "+newWord.charAt(i)+" is not part of the encrypted alphabet!";
            }
            decryption = decryption + newLetter;
        }
        return decryption;
    }

    public String findLetter(int index,String newWord)
    {
            String codedLetter = Character.toString(newWord.charAt(index));
            String letter = Cipher_Alphabet_Mapping.get(codedLetter);
            if(letter == null && !codedLetter.equals(" "))
            {
                codedLetter = "Error";
                letter = codedLetter;

            }
            else if (letter == null)
            {
                letter = codedLetter;
            }

            return letter;

    }

    public static void main(String Args[])
    {
        /*while (true)
        {
            System.out.println("Enter encrypted word:");
            Scanner input = new Scanner(System.in);
            Decipher newWord = new Decipher();
            String decryptedWord = newWord.Decrypt(input.nextLine());
            System.out.println("The encrypted code means: "+decryptedWord);
        }*/

        Test1();
        Test2();
        Test3();
        Test4();



    }

    public static void Test1()
    {
        System.out.println("Test 1: Normal input!");
        String decryptedWord = "!£o";
        Decipher newWord = new Decipher();
        System.out.println("The decrypted word: "+decryptedWord);
        decryptedWord = newWord.Decrypt(decryptedWord);
        System.out.println("The encrypted code means: "+decryptedWord+ "\n");
    }

    public static void Test2()
    {
        System.out.println("Test 2: Input with spaces!");
        String decryptedWord = "!£ o ";
        Decipher newWord = new Decipher();
        System.out.println("The decrypted word: "+decryptedWord);
        decryptedWord = newWord.Decrypt(decryptedWord);
        System.out.println("The encrypted code means: "+decryptedWord+ "\n");
    }

    public static void Test3()
    {
        System.out.println("Test 3: Input with the boundaries first and last letter!");
        String decryptedWord = "!o ";
        Decipher newWord = new Decipher();
        System.out.println("The decrypted word: "+decryptedWord);
        decryptedWord = newWord.Decrypt(decryptedWord);
        System.out.println("The encrypted code means: "+decryptedWord+ "\n");
    }

    public static void Test4()
    {
        System.out.println("Test 4: Invalid input!");
        String decryptedWord = "ppa";
        Decipher newWord = new Decipher();
        System.out.println("The decrypted word: "+decryptedWord);
        decryptedWord = newWord.Decrypt(decryptedWord);
        System.out.println("The encrypted code means: "+decryptedWord+ "\n");
    }
}
