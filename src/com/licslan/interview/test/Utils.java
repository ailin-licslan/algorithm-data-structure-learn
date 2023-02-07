package com.licslan.interview.test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author WEILIN
 * Below includs unit tests to verify those question
 */
public class Utils {

    /**
     * Question1
     * sort by firstName + lastName + ext,
     * if firstName is the same then sort by lastName and ext,
     * please note lastName and ext can be empty string or null.
     **/
    public static List<Extension> sortByName(List<Extension> extensions) {
        if (extensions.isEmpty()) {
            return Collections.emptyList();
        }

        // multiple sorting conditions
        return extensions.stream().sorted(Comparator
                .comparing(Extension::getFirstName, Comparator.nullsFirst(String::compareTo))
                .thenComparing(Extension::getLastName, Comparator.nullsFirst(String::compareTo))
                .thenComparing(Extension::getExt, Comparator.nullsFirst(String::compareTo))
        ).collect(Collectors.toList());
    }


    /**
     * Question2
     * sort extType,
     * extType is a string and can be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     **/
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        if (extensions.isEmpty()) {
            return Collections.emptyList();
        }
        sortList(extensions);
        return extensions;
    }

    private static void sortList(List<Extension> ex) {
        //Definite a List<String> by ourselves
        String[] regRules = {"User", "Dept", "AO", "TMO", "Other"};
        final List<String> regulationOrder = Arrays.asList(regRules);
        ex.sort((o1, o2) -> {
            String extType1 = o1.getExtType();
            String extType2 = o2.getExtType();
            int io1 = regulationOrder.indexOf(extType1);
            int io2 = regulationOrder.indexOf(extType2);
            return (io1 == -1 || io2 == -1) ? (io2 - io1) : (io1 - io2);
        });
    }

    /**
     * Question3
     * sum all sales items by month
     **/
    public static List<MonthSalesItem> sumByMonth(List<SaleItem> saleItems) {

        if (saleItems == null || saleItems.isEmpty()) {
            return Collections.emptyList();
        }

        //group List by month and sum amount
        Map<Integer, Double> map = saleItems.stream().collect(Collectors.groupingBy(o -> getMonth(o.getTransationTime()),
                Collectors.summingDouble(o -> o.getAmount().doubleValue())));

        List<MonthSalesItem> monthSalesItemList = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            MonthSalesItem monthSalesItem = new MonthSalesItem();
            int month = entry.getKey();
            double money = entry.getValue();
            monthSalesItem.setMonth(month);
            monthSalesItem.setTotalAmount(BigDecimal.valueOf(money));
            monthSalesItemList.add(monthSalesItem);
        }
        return monthSalesItemList;
    }


    /**
     * GET SAME YEAR WITH DIFF MONTH
     */

    private static int getMonth(Instant instant) {
        LocalDateTime dateTime = instant.atZone(ZoneId.of("UTC")).toLocalDateTime();
        int year = dateTime.getYear();
        Month month = dateTime.getMonth();
        return year + month.getValue();
    }


    /**
     * FIND MAX SaleItem IN A LIST
     */

    private static SaleItem getMaxSaleItem(List<SaleItem> saleItemList) {
        double maxNum = 0.0000d;
        SaleItem max = new SaleItem();
        for (SaleItem saleItem : saleItemList) {
            if (saleItem.getAmount().doubleValue() > maxNum) {
                max = saleItem;
            }
        }
        return max;
    }

    /**
     * Question4
     * max all sales items by month
     **/
    public static List<MonthSalesItem> maxByMonth(List<SaleItem> saleItems) {

        if (saleItems == null || saleItems.isEmpty()) {
            return Collections.emptyList();
        }

        //GROUP BY TIME
        Map<Integer, List<SaleItem>> map =
                saleItems.stream().collect(Collectors.groupingBy(o -> getMonth(o.getTransationTime())));

        List<MonthSalesItem> monthSalesItemList = new ArrayList<>();
        for (Map.Entry<Integer, List<SaleItem>> entry : map.entrySet()) {
            MonthSalesItem monthSalesItem = new MonthSalesItem();
            int month = entry.getKey();
            List<SaleItem> saleItemList = entry.getValue();
            //FIND MAX SaleItem IN SAME YEAR AND MONTH
            SaleItem maxSaleItem = getMaxSaleItem(saleItemList);
            monthSalesItem.setMonth(month);
            monthSalesItem.setTotalAmount(maxSaleItem.getAmount() == null ? new BigDecimal(0) : maxSaleItem.getAmount());
            monthSalesItemList.add(monthSalesItem);
        }
        return monthSalesItemList;
    }

    /**
     * Question5
     * We have all Keys: 0-9;
     * usedKeys is an array to store all used keys like :[2,3,4];
     * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,]
     */

    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        if (allKeys.length == 0 && usedKeys.length == 0) {
            return new int[0];
        }
        if (usedKeys.length == 0) {
            return allKeys;
        }
        if (allKeys.length == 0) {
            return usedKeys;
        }

        Set<Integer> allSetList = Arrays.stream(allKeys).boxed().collect(Collectors.toSet());
        Set<Integer> diffSet = new HashSet<>();
        for (int o : usedKeys) {
            //Add it if not included
            if (!allSetList.contains(o)) {
                diffSet.add(o);
            }
        }
        return diffSet.stream().mapToInt(Integer::intValue).toArray();
    }


    /**
     * Question1 unit Test
     */
    public static void main(String[] args) {
        // Create parameters
        List<Extension> aList = new ArrayList(4);
        Extension a = new Extension("a", "sdaf", "sdafds", "afdsa");
        Extension b = new Extension("b", null, "", "");
        Extension c = new Extension("c", null, "x", "afds");
        Extension d = new Extension("a", "adaf=======", null, "");
        aList.add(a);
        aList.add(b);
        aList.add(c);
        aList.add(d);
        List<Extension> extensionList = sortByName(aList);
        for (Extension extension : extensionList) {
            System.out.println(extension.getFirstName() + "====" + extension.getLastName());
        }

    }


    /**
     * Question2 unit Test
     */
//    public static void main(String[] args) {
//        String[] regRules = {"User", "Dept", "AO", "TMO", "Other"};
//        List<Extension> aList = new ArrayList(4);
//        Extension a = new Extension("a", "sdaf", "sdafds", "User");
//        Extension f = new Extension("f", "adaf=======", null, "Other");
//        Extension b = new Extension("b", null, "", "Dept");
//        Extension c = new Extension("c", null, "x", "AO");
//        Extension d = new Extension("d", "adaf=======", null, "TMO");
//        Extension e = new Extension("e", "adaf=======", null, "User");
//        aList.add(a);
//        aList.add(b);
//        aList.add(c);
//        aList.add(d);
//        aList.add(e);
//        aList.add(f);
//        List<Extension> extensionList = sortByExtType(aList);
//        for (Extension extension : extensionList) {
//            System.out.println(extension.getFirstName() + "===" + extension.getExtType());
//        }
//    }

    /**
     * Question3 unit Test
     */
//    public static void main(String[] args) {
//
//        List<SaleItem> saleItemList = new ArrayList<>();
//
//        SaleItem saleItem = new SaleItem();
//        saleItem.setAmount(BigDecimal.valueOf(50.1));
//        saleItem.setTransationId("1");
//        saleItem.setTransationTime(Instant.parse("2018-11-30T18:35:24.00Z"));
//
//        SaleItem saleItem2 = new SaleItem();
//        saleItem2.setAmount(BigDecimal.valueOf(50.2));
//        saleItem2.setTransationId("2");
//        saleItem2.setTransationTime(Instant.parse("2023-11-30T18:35:24.00Z"));
//
//        SaleItem saleItem3 = new SaleItem();
//        saleItem3.setAmount(BigDecimal.valueOf(100.2));
//        saleItem3.setTransationId("3");
//        saleItem3.setTransationTime(Instant.parse("2023-11-30T18:35:24.00Z"));
//
//        saleItemList.add(saleItem);
//        saleItemList.add(saleItem2);
//        saleItemList.add(saleItem3);
//
//        Map<Integer, Double> map = saleItemList.stream().collect(Collectors.groupingBy(o ->
//                        getMonth(o.getTransationTime()),
//                Collectors.summingDouble(o -> o.getAmount().doubleValue())));
//        System.out.println(map.toString());
//
//        SaleItem maxSaleItem = getMaxSaleItem(saleItemList);
//        System.out.println(maxSaleItem.getAmount());
//    }


    /**
     * Question4 unit Test
     */
//    public static void main(String[] args) {
//
//        List<SaleItem> saleItemList = new ArrayList<>();
//
//        SaleItem saleItem = new SaleItem();
//        saleItem.setAmount(BigDecimal.valueOf(50.1));
//        saleItem.setTransationId("1");
//        saleItem.setTransationTime(Instant.parse("2018-11-30T18:35:24.00Z"));
//
//        SaleItem saleItem2 = new SaleItem();
//        saleItem2.setAmount(BigDecimal.valueOf(50.2));
//        saleItem2.setTransationId("2");
//        saleItem2.setTransationTime(Instant.parse("2023-11-30T18:35:24.00Z"));
//
//        SaleItem saleItem3 = new SaleItem();
//        saleItem3.setAmount(BigDecimal.valueOf(100.2));
//        saleItem3.setTransationId("3");
//        saleItem3.setTransationTime(Instant.parse("2023-11-30T18:35:24.00Z"));
//
//        SaleItem saleItem4 = new SaleItem();
//        saleItem4.setAmount(BigDecimal.valueOf(60.1));
//        saleItem4.setTransationId("4");
//        saleItem4.setTransationTime(Instant.parse("2018-11-20T18:35:24.00Z"));
//
//        //41 =201811  23 =202311
//        saleItemList.add(saleItem);
//        saleItemList.add(saleItem2);
//        saleItemList.add(saleItem3);
//        saleItemList.add(saleItem4);
//
//        List<MonthSalesItem> monthSalesItemList = maxByMonth(saleItemList);
//
//        for (MonthSalesItem monthSalesItem : monthSalesItemList) {
//            System.out.println("=====>" + monthSalesItem.getTotalAmount());
//        }
//        //value 60.1 100.2
//    }


    /**
     * Question5 unit Test
     */
//    public static void main(String[] args) {
//        int[] a = new int[]{2, 3, 4};
//        int[] b = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] unUsedKeys = getUnUsedKeys(a, b);
//        System.out.println(Arrays.toString(unUsedKeys));
//        //[0, 1, 5, 6, 7, 8, 9]
//    }

}
