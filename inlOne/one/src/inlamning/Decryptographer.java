package inlamning;

import java.lang.StringBuilder;

import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr12.*;

class Decryptographer {
  Decryptographer(int key) {
    for (int i = m_keyLength - 1; i >= 0; --i) {
      int digit = key % 10;
      key /= 10;

      m_key[i] = digit;
    }
  }

  public String decrypt(String string) {
    StringBuilder decryptedString = new StringBuilder();

    char[] encryptedChars = string.toCharArray();

    int keyPos = 0;
    for (char c : encryptedChars) {
      if (c == ' ') {
        decryptedString.append(c);
        continue;
      }
      decryptedString.append(actualChar(c, m_key[keyPos++ % m_keyLength]));
    }

    return decryptedString.toString();
  }

  private int position(char c, int keyPos) {
    int pos = 0;
    while (k.getLetter(pos, keyPos) != c) {
      pos++;
    }
    return pos;
  }

  private char actualChar(char encrypted, int keyPos) {
    return (char) (position(encrypted, keyPos) + 'A');
  }

  static final Key k = new Key();
  private final int m_keyLength = 5;
  private final int[] m_key = new int[m_keyLength];
}
