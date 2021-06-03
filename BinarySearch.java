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
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    System.out.println(search(sortedArray, 11));

  }

  public static int search(int[] array, int number) {
    int awal = 0;
    int akhir = array.length;
    int ditemukan = -1;

    try {
      while (awal <= akhir) {
        int tengah = (awal + akhir) / 2;
        int pointer = array[tengah];

        if ( number > pointer ) {
          awal = tengah + 1;
        }

        if ( number < pointer ) {
          akhir = tengah - 1;
        }

        if ( number == pointer ) {
          return pointer;
        }

      }
      return ditemukan;
    } 

    catch (ArrayIndexOutOfBoundsException exception) {
      return ditemukan;
    }
    }
    
}
