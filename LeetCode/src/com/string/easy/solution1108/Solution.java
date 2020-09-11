package com.string.easy.solution1108;

/**
 * @author LiSheng
 * @date 2020/4/5 21:26
 */
public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
