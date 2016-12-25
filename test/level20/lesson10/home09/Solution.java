package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable
{
    int node;
    List<Solution> edges = new LinkedList<>();
    public Solution(){}
    public Solution(int node,List<Solution>edges)
    {
        this.node = node;
        this.edges = edges;
    }
    private void writeObject(ObjectOutputStream out)throws IOException
    {
        out.writeInt(node);
        out.writeObject(edges);
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException
    {
        node = in.readInt();
        edges =(List<Solution>)in.readObject();
    }
}
