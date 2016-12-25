package com.javarush.test.level03.lesson12.home02;

/* Я не хочу изучать Java, я хочу большую зарплату
Вывести на экран десять раз надпись «Я не хочу изучать Java, я хочу большую зарплату»
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();
        String d = reader.readLine();
        int aa = Integer.parseInt(a);
        int qq, ww;
        int bb= Integer.parseInt(b);
        int cc = Integer.parseInt(c);
        int dd= Integer.parseInt(d);
        if (aa > bb)
        { qq = aa;}
        else

        {qq = bb;}
        if (cc > dd)
        {ww = cc;}
        else
        {ww = dd;}
        if (qq > ww)
            System.out.println(qq);
        else
            System.out.println(ww);

    }
}
