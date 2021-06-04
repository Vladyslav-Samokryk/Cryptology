package test;

import com.SHA256;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

public class TestSHA256 {
    @Test
    public void testSHA256() {
        Charset cs = Charset.forName("UTF-8");
        String value = "Hello, it's me. This is a text for cryptology";
        byte[] data = value.getBytes(cs);
        byte[] hash = SHA256.encode(data);

        StringBuilder hex = new StringBuilder(hash.length * 2);
        int len = hash.length;
        for (int i = 0 ; i < len ; i++) {
            hex.append(String.format("%02X", hash[i]));
        }
        Assert.assertTrue(hex.toString().toLowerCase().equals("9bc5f82e36a2337472627f2ba58d92286ffb1f094bbd47a7b1f1f9182b2177a0"));
    }
}
