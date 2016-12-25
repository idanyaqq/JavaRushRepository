package com.javarush.test.level04.lesson16.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int a = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {

            int b = Integer.parseInt(reader.readLine());
            a = a + b;
            if (b == -1) break;
        }
        System.out.println(a);

    }

}

