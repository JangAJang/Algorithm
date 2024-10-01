
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory; import javax.crypto.spec.DESKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
public class DES {

    private static Cipher c;
    private static String KSP = "64bitkey";
    private static DESKeySpec desKeySpec;
    private static AESKeySpec aesKeySpec;
    private static SecretKeyFactory keyFactory;
    private static Key key;

    public static void main(String[] args)throws Exception, IOException { SetEnc();
        byte[] cStr = null; byte[] dStr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        cStr = Encrypts(text);
        System.out.println("암호화 결과 : " + new String(cStr));
        dStr = Descyptions(cStr);
        System.out.println("복호화 결과 : " + new String(dStr));
    }

    public static void SetEnc() throws Exception{
        c = Cipher.getInstance("DES");
        desKeySpec = new DESKeySpec(KSP.getBytes()); keyFactory = SecretKeyFactory.getInstance("DES"); key = keyFactory.generateSecret(desKeySpec);
    }
    public static byte[] Encrypts(String str)throws Exception{ c.init(Cipher.ENCRYPT_MODE, key);
        return c.doFinal(str.getBytes());
    }
    public static byte[] Descyptions(byte[] str)throws Exception{ c.init(Cipher.DECRYPT_MODE, key);
        return c.doFinal(str);
    }

}


