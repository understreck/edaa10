package inlamning;

import se.lth.cs.p.inl1.TextWindow;
import se.lth.cs.p.inl1.TextView;
import se.lth.cs.p.inl1.nbr12.*;

public class Decypher {
  public static void main(String args[]) {
    Key key = new Key();

    Decryptographer d = new Decryptographer(key.get5DigitNumber());

    TestCase tCase = new TestCase();

    TextWindow window = new TextWindow("Window");

    TextView encrypted = new TextView("Chiffertext", 2, 100);
    window.addView(encrypted);

    TextView decrypted = new TextView("Min klartext", 2, 100);
    window.addView(decrypted);

    TextView answer = new TextView("Korrekt klartext", 2, 100);
    window.addView(answer);

    for (int i = 1; i <= 5; ++i) {
      encrypted.displayText(tCase.getCryptoText(i));
      decrypted.displayText(d.decrypt(tCase.getCryptoText(i)));
      answer.displayText(tCase.getClearText(i));
      window.waitForMouseClick();
    }
  }
}
