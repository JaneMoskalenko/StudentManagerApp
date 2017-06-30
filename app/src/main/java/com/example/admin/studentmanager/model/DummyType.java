package com.example.admin.studentmanager.model;

import com.example.admin.studentmanager.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by admin on 25.06.2017.
 */

public class DummyType {

    //Group data
    public static final String[] GROUPNAMES = { "В-156", "АБ-78", "ИК-45", "ИК-06", "АМ-01", "ГПУА-17" };

    // Users data
    public static final String[] FIRSTNAMES = { "John", "Katy", "Alla", "Gregory", "Alex", "Anna",
            "Semen", "Kristy", "Екатерина", "0222", "444", "Johnatan", "Kitty", "Helen", "Julia",
            "Nayasha", "Marie", "Laura" };
    public static final String[] MIDDLENAMES = { "Николаев", "Андреев", "Григорьев", "Константинов",
            "Дмитриева", "Петрова", "Геннадьева", "Владимиров" };
    public static final String[] LASTNAMES = { "Иванов", "Петров", "Сидоров", "Медведев", "Никифоров",
            "Усов", "Зубков", "Семёнов", "Кондратьев", "Курпатов", "Кузнецов", "Егоров", "Жданов" };

    //Subject data
    public static final String[] SUBJECTNAMES = {"Механика", "Математика", "Алгебра", "Русский язык",
            "Литература", "Труд", "ИЗО", "Музыка", "Английский язык", "Физика"};

    //Lesson data
    public static final String[] LESSONNAMES = {"Способы решения квадратных уравнений", "Правописание безударных гласных",
            "Сложение дробей", "Образ тургеневской девушки", "Технологи труда",
            "Приемы работы с акварелью", "Гаммы и аккорды", "Present Perfect",
            "Термодинамика", "Деепричастие"};
    public static final String[] LECTORNAMES = {"Ильичев Станислав Дмитриевич", "Иванова Елена Георгиевна",
            "Смирнов Николай Вячеславович"};

    //Date data
 /*   public Date generateNewDateSimpleFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
       return dateFormat.format(new Date());

    }*/

    public static int[] getImages() {
        int[] images = {
                R.drawable.thumb_1_0, R.drawable.thumb_1_1, R.drawable.thumb_1_2, R.drawable.thumb_1_3,
                R.drawable.thumb_1_4, R.drawable.thumb_1_5, R.drawable.thumb_1_6, R.drawable.thumb_1_7,
                R.drawable.thumb_1_8, R.drawable.thumb_1_9,
                R.drawable.thumb_2_0, R.drawable.thumb_2_1, R.drawable.thumb_2_2, R.drawable.thumb_2_3,
                R.drawable.thumb_2_4, R.drawable.thumb_2_5, R.drawable.thumb_2_6, R.drawable.thumb_2_7,
                R.drawable.thumb_2_8, R.drawable.thumb_2_9,
                R.drawable.thumb_3_0, R.drawable.thumb_3_1, R.drawable.thumb_3_2, R.drawable.thumb_3_3,
                R.drawable.thumb_3_4, R.drawable.thumb_3_5, R.drawable.thumb_3_6, R.drawable.thumb_3_7,
                R.drawable.thumb_3_8, R.drawable.thumb_3_9,
                R.drawable.thumb_4_0, R.drawable.thumb_4_1, R.drawable.thumb_4_2, R.drawable.thumb_4_3,
                R.drawable.thumb_4_4, R.drawable.thumb_4_5, R.drawable.thumb_4_6, R.drawable.thumb_4_7,
                R.drawable.thumb_4_8, R.drawable.thumb_4_9,
                R.drawable.thumb_5_0, R.drawable.thumb_5_1, R.drawable.thumb_5_2, R.drawable.thumb_5_3,
                R.drawable.thumb_5_4, R.drawable.thumb_5_5, R.drawable.thumb_5_6, R.drawable.thumb_5_7,
                R.drawable.thumb_5_8, R.drawable.thumb_5_9,
                R.drawable.thumb_6_0, R.drawable.thumb_6_1, R.drawable.thumb_6_2, R.drawable.thumb_6_3,
                R.drawable.thumb_6_4, R.drawable.thumb_6_5, R.drawable.thumb_6_6, R.drawable.thumb_6_7,
                R.drawable.thumb_6_8, R.drawable.thumb_6_9,
                R.drawable.thumb_7_0, R.drawable.thumb_7_1, R.drawable.thumb_7_2, R.drawable.thumb_7_3,
                R.drawable.thumb_7_4
            };
        return images;
    }
    public static int getRandomImageIndex(){
        int[] images = getImages();
        Random random = new Random();
        return random.nextInt(images.length);
    }
    public  static int getRandomImage() {
        return getImages()[getRandomImageIndex()];
    }

}
