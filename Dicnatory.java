/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 *
 * @author Helfi Apriliyandi F
 */
public class Dicnatory {
    public String[] languageInput;
  public String[] languageLib;

  Dicnatory(String[][] languages) {
    this.languageInput = languages[0];
    this.languageLib = languages[1];
  }

  public static void main(String[] args) {

    String[] english = {
      "bootle", "lamp", "motorcycle", "water",
      "rescue", "cat", "Drees", "batle"
    };

    String[] indonesia = {
      "botol", "lampu", "motor", "air",
      "penolong", "kucing", "baju", "berantem"
    };

    String[][] ENG_TO_IND = { english, indonesia };
    String[][] IND_TO_ENG = { indonesia, english };

    // Nama Parameter bisa diatur
    Dicnatory kamus = new Dicnatory(IND_TO_ENG);

    kamus.translate("botol");


  }

  public void translate(String word) {
    try {
      int baseWordIndex = findIndexOfWord(word);
      String translatedWord = findTranslation(baseWordIndex);

      if ( word == "") {
        throw new WordException("Parameter tidak boleh kosong");
      }
      
      if ( baseWordIndex == -1) {
        throw new WordException(word + " Bahasa Tidak Ditemukan");
      }

      if ( translatedWord == "" ) {
        throw new WordException(word + " Tidak bisa diterjemahkan");
      }

      System.out.println(word + " artinya " + translatedWord);

    } catch(WordException exception) {
      System.out.println(exception.getMessage());
    }

  }

  public int findIndexOfWord(String word) {
    int hasil = -1;
    for (int i = 0; i < languageInput.length; i++) {
      if (languageInput[i].contains(word.toLowerCase())) {
        hasil = i;
        return hasil;
      }
    }

    return hasil;

  }

  public String findTranslation(int indexOfWord) {
    int awal = 0;
    int akhir = languageLib.length;
    String ditemukan = "";

    try {
      while (awal <= akhir) {
        int tengah = (awal + akhir) / 2;
        int pointer = tengah;

        if ( indexOfWord > pointer ) {
          awal = tengah + 1;
        }

        if ( indexOfWord < pointer ) {
          akhir = tengah - 1;
        }

        if ( indexOfWord == pointer ) {
          return languageLib[pointer];
        }

      }
      return ditemukan;
    } 

    catch (ArrayIndexOutOfBoundsException exception) {
      return ditemukan;
    }

  }

}


class WordException extends Throwable {

  private String message;

  public WordException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
