/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Miguel Quiroz
 */
public class CifradoCesar {

    /*
    public static void main(String[] args) {

        String str = "Estimados estudiantes esta es la segunda leccion  del interciclo final de la materia programacion distribuida les deseo muchos exitos en su vida profesional";
        int key = 17;

        String encrypted = encrypt(str, key);
        System.out.println(encrypted);
        String decrypted = decrypt(encrypted, key);
        System.out.println(decrypted);
    }*/
    public static String encrypt(String str, int key) {

        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c + (key % 26);
                if (c > 'Z') {
                    c = c - 26;
                }
            } else if (Character.isLowerCase(c)) {
                c = c + (key % 26);
                if (c > 'z') {
                    c = c - 26;
                }
            }
            encrypted += (char) c;
        }
        return encrypted;
    }

    public static String decrypt(String str, int key) {
        String decrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c - (key % 26);
                if (c < 'A') {
                    c = c + 26;
                }
            } else if (Character.isLowerCase(c)) {
                c = c - (key % 26);
                if (c < 'a') {
                    c = c + 26;
                }
            }
            decrypted += (char) c;
        }
        return decrypted;
    }

}
