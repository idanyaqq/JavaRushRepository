package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.equals(javaRush));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat dater = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
           if(this.users!=null)
           {
               for(User user :users)
               {
                   printWriter.println(user.getFirstName());
                   printWriter.println(user.getLastName());
                   printWriter.println(dater.format(user.getBirthDate()));
                   printWriter.println(user.isMale());
                   printWriter.println(user.getCountry().getDisplayedName());

                }
           }


        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line=reader.readLine())!=null)
            {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                Date dater = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(reader.readLine());
                user.setBirthDate(dater);
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                switch (reader.readLine())
                {
                    case"Ukraine":
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    case"Russia":
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    case"Other":
                        user.setCountry(User.Country.OTHER);
                        break;
                }
                this.users.add(user);
            }
            reader.close();

        }
    }
}
