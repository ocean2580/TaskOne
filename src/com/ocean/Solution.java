package com.ocean;
import com.ocean.entity.Lost;
import com.ocean.entity.sub.BookLost;
import com.ocean.entity.sub.CardLost;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Solution{

    /**
     * 失物排序方法
     * @param lostArray 待排序的失物数组
     */
    public static void sortLost(Lost[] lostArray) {
        Arrays.stream(lostArray)
                .sorted(Comparator.comparing(Lost::getDate))    // 时间作比较器
                .forEach(System.out::println);
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     * @param lostArray 失物数组
     * @param keyword 用户输入的关键字
     * @return 返回查找到的失物
     */
    public static Lost[] selectByKeyword(Lost[] lostArray,String keyword){
        List<Lost> list = new ArrayList<>();
        List<CardLost> cardList = new ArrayList<>();
        List<BookLost> bookList = new ArrayList<>();

        for (Lost lost : lostArray) {   // 分类
            if (lost instanceof CardLost) {
                cardList.add((CardLost) lost);
            } else if (lost instanceof BookLost) {
                bookList.add((BookLost) lost);
            }
        }

        for (CardLost cardLost : cardList) {    // 匹配
            if (keyword.equals(cardLost.getId())
                    || keyword.equals(cardLost.getOwnerName())
                    || keyword.equals(cardLost.getDate())
                    || keyword.equals(cardLost.getCollege())
                    || keyword.equals(cardLost.getPlace()))
                list.add(cardLost);
        }

        for (BookLost bookLost : bookList) {
            if (keyword.equals(bookLost.getBookName())
                    || keyword.equals(bookLost.getDate())
                    || keyword.equals(bookLost.getPlace())
            )
                list.add(bookLost);
        }

        if (list.size() == 0) System.out.println("没有该项的匹配结果");
        return list.toArray(new Lost[]{});
    }

    public static void main(String[] args) {

        Lost[] lostArray = new Lost[]{
                new BookLost("中心食堂","2022-1-6","基督山伯爵"),
                new CardLost("2教","2022-1-2","Olivia","理学院","0002"),
                new CardLost("4教","2022-1-3","Naya","马克思学院","0003"),
                new BookLost("5教","2022-1-4","百年孤独"),
                new CardLost("2教","2022-1-1","Oliver","计算机","0001"),
                new BookLost("8教","2022-1-5","霍乱时期的爱情"),
        };

        System.out.println("Test One:");
        sortLost(lostArray);

        System.out.println("=================================");

        System.out.println("Test Two:");
        for (Lost lost : selectByKeyword(lostArray, "黄金时代")) {  // bookName
            System.out.println(lost);
        }

        for (Lost lost : selectByKeyword(lostArray, "Oliver")) {  // ownerName
            System.out.println(lost);
        }
        for (Lost lost : selectByKeyword(lostArray, "2022-1-5")) {  // date
            System.out.println(lost);
        }

        for (Lost lost : selectByKeyword(lostArray, "2教")) {  // place
            System.out.println(lost);
        }

        for (Lost lost : selectByKeyword(lostArray, "0003")) {  // id
            System.out.println(lost);
        }

        for (Lost lost : selectByKeyword(lostArray, "马克思学院")) {  // college
            System.out.println(lost);
        }


    }
}
