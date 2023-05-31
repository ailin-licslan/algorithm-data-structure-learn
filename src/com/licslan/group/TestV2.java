package com.licslan.group;


import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Lin
 */
public class TestV2 {
    public static List<Map<Integer, List<String>>> groupNames(List<String> nameList) {
        // Shuffle the name list to randomize the order
        Collections.shuffle(nameList);
        int groupSize = 3;
        List<Map<Integer, List<String>>> groups = new ArrayList<>();
        int currentGroupIndex = 1;
        int currentGroupSize = 0;
        Map<Integer, List<String>> currentGroup = new HashMap<>();
        for (String name : nameList) {
            if (currentGroupSize == groupSize) {
                groups.add(currentGroup);
                currentGroupIndex++;
                currentGroupSize = 0;
                currentGroup = new HashMap<>();
            }

            if (!currentGroup.containsKey(currentGroupIndex)) {
                currentGroup.put(currentGroupIndex, new ArrayList<>());
            }

            currentGroup.get(currentGroupIndex).add(name);
            currentGroupSize++;
        }
        // Add the last group if it's not fully filled
        if (!currentGroup.isEmpty()) {
            groups.add(currentGroup);
        }
        //Check the last group if there are only one people please merger the group

        Map<Integer, List<String>> map = groups.get(groups.size() - 1);
        map.forEach((a, b) -> {
            if (b.size() == 1 && groups.size() - 1 > 1) {
                //Last group
                Map<Integer, List<String>> groupLast = groups.get(groups.size() - 1);
                AtomicReference<Integer> groupNo = new AtomicReference<>(0);
                AtomicReference<List<String>> names = new AtomicReference<>();
                groupLast.forEach((key, value) -> {
                    groupNo.set(key);
                    names.set(value);
                });

                //The second Last group
                Map<Integer, List<String>> groupSecLast = groups.get(groups.size() - 2);
                AtomicReference<Integer> groupNoSec = new AtomicReference<>(0);
                AtomicReference<List<String>> namesSec = new AtomicReference<>();
                groupSecLast.forEach((key, value) -> {
                    groupNoSec.set(key);
                    namesSec.set(value);
                });

                namesSec.get().addAll(names.get());
                groupSecLast.put(groupNoSec.get(), namesSec.get());
                groups.remove(groups.size() - 1);
            }
        });


        return groups;
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("本次参加的人数是：");

        String [] num = new String[1];
        num[0]=scanner.nextLine();


        int lng = Integer.parseInt(num[0]);
        System.out.println("length is "+ lng);
        String [] line = new String[lng];



        Scanner scanner2 = new Scanner(System.in);
        System.out.println("名称分别是：");

        for(int i=0;i<lng;i++){
            line[i]=scanner2.nextLine();
        }
        List<String> nameList = Arrays.asList(line);

        scanner.close();
        scanner2.close();

//        String fromWechat = "1. 群昵称/微信名\n" +
//                "2. Lighters\n" +
//                "3. Ada\n" +
//                "4. Saltie\n" +
//                "5. Amanda\n" +
//                "6. sunny\n" +
//                "7. seika\n" +
//                "8. popcorn\n" +
//                "9. Gabby\n" +
//                "10. Sarah.C\n" +
//                "11. Cici\n" +
//                "12. DAISY\n" +
//                "13. AKI";
//
//        String[] split = fromWechat.split("\\n");
//        List<String> nameList = new ArrayList<>(split.length);
//        for (String s : split) {
//            String s1 = s.split(". ")[1];
//            nameList.add(s1);
//        }


        List<String> roomList = Arrays.asList(
                "G1: 478-8861-9301\n" ,
                        "G2: 410-4417-3296\n" ,
                        "G3: 756-6799-0054\n" ,
                        "G4: 498-8362-1185\n" ,
                        "G5: 996-9781-1440\n" ,
                        "G6: 967-0700-2669\n" ,
                        "G7: 928-792-991\n" ,
                        "G8: 868-0177-7516\n" ,
                        "G9: 905-4432-6019\n" ,
                        "G10: 334-6750-8975\n" ,
                        "G11: 777-5534-5107\n" ,
                        "G12: 524-3216-4842\n" ,
                        "G13: 839-3059-3701\n" ,
                        "G14: 824-7677-4422\n" ,
                        "G15: 738-5844-3061\n");
        List<Map<Integer, List<String>>> groups = groupNames(nameList);

        for (Map<Integer, List<String>> group : groups) {
            for (Map.Entry<Integer, List<String>> entry : group.entrySet()) {
                int groupIndex = entry.getKey();
                List<String> names = entry.getValue();
                System.out.print("第 " + groupIndex + " 组参与的人分别是: " + names + "  The Room No is:  " + roomList.get(groupIndex - 1));
            }
        }
    }


}

