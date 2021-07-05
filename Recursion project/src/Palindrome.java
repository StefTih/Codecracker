import java.util.ArrayList;
import java.util.Iterator;

public class Palindrome {

    private String sentence;
    private ArrayList<Character> clearedSentence;


    public static void main(String[] args)
    {
        Palindrome word = new Palindrome("Are we not drawn onward to new era?");
        System.out.println("The word:"+word.getSentence()+", is it palindrome? Answer:"+word.checkForPalindromes());

    }


    public Palindrome(String sentence)
    {
        this.sentence = sentence;
        clearedSentence = new ArrayList();
    }

    public String getSentence()
    {
        return sentence;
    }

    public boolean checkForPalindromes()
    {
        removeSigns();
        System.out.println(sentence);
        if(sentence.length()>0)
        {
            return compareCharacters(sentence);
        }
        else
        {
            return false;
        }

    }

    public void removeSigns()
    {
        sentence = sentence.toLowerCase();
        for(int i = 0; i<sentence.length()-1; i++)
        {
            int ascii = (int) sentence.charAt(i);
            if (ascii>=97 && ascii<=122)
            {
                clearedSentence.add(sentence.charAt(i));
            }
        }
        combineNewString();
    }

    public void combineNewString()
    {
        sentence = "";
        for(Character c: clearedSentence)
        {
            sentence = sentence+c;
        }

    }

    public boolean compareCharacters(String newSentence)
    {
        if(newSentence.length()<2)
        {
            return true;
        }
        else
        {
            if(newSentence.charAt(0) == newSentence.charAt(newSentence.length()-1))
            {
                newSentence = newSentence.substring(1,newSentence.length()-1);
                return compareCharacters(newSentence);
            }
            else
            {
                System.out.println("New sentence:"+newSentence);
                return false;
            }
        }
    }
}

