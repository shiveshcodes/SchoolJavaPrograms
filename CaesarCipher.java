
class CaesarCipher
{
    //Biggest assumption here is that key value is positive, It shall be improvised after clearance.
    public static String encrypt(String plaintext, int key)
    {
        key=key%26;
        String cipherText="";//To store encrypted text
        char ch;
        for(int i=0;i<plaintext.length();i++)//iterating all characters
        {
            ch=(char)(plaintext.charAt(i)+key);
               if(!Character.isAlphabetic(plaintext.charAt(i)))
            {
                cipherText+=plaintext.charAt(i);
                continue;
            }
            ch=(char)(plaintext.charAt(i)+key);
            if(Character.isUpperCase(plaintext.charAt(i)))
            {
                if(ch < 'A')ch+=26;
                else if(ch > 'Z')ch-=26;
            }
            else
            {
                if(ch < 'a')ch+=26;
                else if(ch > 'z')ch-=26;
            }
            cipherText+=ch;        
        }
        return cipherText;
    }

    static String encode(String in,int shift)
    {
        int shf = shift%26;
        String ans = "";
        char ch;
        for(int i=0;i<in.length();i++)
        {
            if(!Character.isAlphabetic(in.charAt(i)))
            {
                ans+=in.charAt(i);
                continue;
            }
            ch=(char)(in.charAt(i)+shf);
            if(Character.isUpperCase(in.charAt(i)))
            {
                if(ch < 'A')ch+=26;
                else if(ch > 'Z')ch-=26;
            }
            else
            {
                if(ch < 'a')ch+=26;
                else if(ch > 'z')ch-=26;
            }
            ans+=ch;
        }
        return ans;
    }

    public static String decrypt(String cipherText, int key)
    {
        key=key%26;
        String plaintext="";
        char ch;
        for(int i=0;i<cipherText.length();i++)
        {
            if(!Character.isAlphabetic(cipherText.charAt(i)))
            {
                plaintext+=cipherText.charAt(i);
                continue;
            }
            ch=(char)(cipherText.charAt(i)-key);
            if(Character.isUpperCase(cipherText.charAt(i)))
            {
                if(ch < 'A')ch+=26;
                else if(ch > 'Z')ch-=26;
            }
            else
            {
                if(ch < 'a')ch+=26;
                else if(ch > 'z')ch-=26;
            }
            plaintext+=ch;
        }
        return plaintext;
    }

    public static void main(String[]args)
    {
        System.out.println(encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ",23));//expected xyzauvw
        System.out.println(decrypt("XYZABCDEFGHIJKLMNOPQRSTUVW",23));//expected ABCDXYZ
    }
}