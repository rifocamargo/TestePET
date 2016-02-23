/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lecom.testepetdao.util;

/**
 *
 * @author rcamargo
 */
public class DaoUtils {
    /**
     * WHERE or AND puts according to the situation of the sentence
     * @param s the String
     * @return
     */
    public static String returnWhereOrAnd(final String s) {
        if (s == null) {
            return "";
        }

        if (s.contains("WHERE")) {
            return " AND ";
        } else {
            return " WHERE ";
        }

    }
}
