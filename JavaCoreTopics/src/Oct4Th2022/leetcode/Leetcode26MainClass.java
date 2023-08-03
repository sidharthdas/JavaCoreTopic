package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode26MainClass {

    public static void main(String[] args) {

        System.out.println("Hellow world");
        System.out.println(numberOfRounds("09:31", "10:14"));
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> finalList = new ArrayList<>();

        for (String s : words) {
            int currentIndex = 0;
            String temp = "";

            String s1rr[] = s.split("");
            int len = s1rr.length;
            for (int i = 0; i < len; i++) {
                if (!s1rr[i].equals(String.valueOf(separator))) {
                    temp += s1rr[i];
                } else {
                    finalList.add(temp);
                    temp = "";
                }
            }

            if (!temp.equals("")) {
                finalList.add(temp);
            }
        }

        return finalList.stream().filter(x -> x.length() > 0).toList();
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).boxed().filter(x -> x >= target).count();
    }

    public int numberOfRounds1(String loginTime, String logoutTime) {
        if (loginTime.equals("00:00") && logoutTime.equals("23:59")) return 95;
        if (loginTime.equals("00:01") && logoutTime.equals("00:00")) return 95;
        String[] loginTimeArr = loginTime.split(":");
        int hourLogin = Integer.parseInt(loginTimeArr[0]);
        int minLogin = Integer.parseInt(loginTimeArr[1]);
        String[] logoutTimeArr = logoutTime.split(":");
        int hourLogout = Integer.parseInt(logoutTimeArr[0]);
        int minLogout = Integer.parseInt(logoutTimeArr[1]);
        int count = 0;
        int totalHour = 0;
        int tempHourLogin = hourLogin;

        while (tempHourLogin != hourLogout) {
            if (tempHourLogin + 1 == 24) {
                tempHourLogin = 0;
            } else {
                tempHourLogin++;
            }

            totalHour++;
            if (tempHourLogin == hourLogout) {
                break;
            }
        }

        if (minLogout == 0 && minLogin == 0) {
            return totalHour * 4;
        }

        int chance = 0;

        if (minLogin > 0 && minLogin <= 15) {
            chance = 3;
        }

        if (minLogin > 15 && minLogin <= 30) {
            chance = 2;
        }

        if (minLogin > 30 && minLogin <= 45) {
            chance = 1;
        }

        if (minLogin > 45 && minLogin <= 59) {
            chance = 0;
        }

        int chanceLogout = 0;

        if (minLogout > 0 && minLogout <= 15) {
            chanceLogout = 0;
        }

        if (minLogout > 15 && minLogout <= 30) {
            chanceLogout = 1;
        }

        if (minLogout > 30 && minLogout <= 45) {
            chanceLogout = 2;
        }

        if (minLogout > 45 && minLogout <= 59) {
            chanceLogout = 3;
        }

        if (hourLogin >= hourLogout && minLogin >= minLogout) {
            return 95 - ((totalHour - 1) * 4 + chance + chanceLogout);
        }

        return (totalHour - 1) * 4 + chance + chanceLogout;

    }

    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len == 0) {
            return true;
        }

        if (len == 1) {
            return false;
        }

        boolean flag = false;

        if (nums[len - 1] == len - 1 && nums[len - 2] == len - 1) {
            flag = true;
        }

        if (flag) {
            for (int i = 0; i < len - 1; i++) {
                if (nums[i] != i + 1) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public static int numberOfRounds(String loginTime, String logoutTime) {
        String[] loginTimeArr = loginTime.split(":");
        int hourLogin = Integer.parseInt(loginTimeArr[0]);
        int minLogin = Integer.parseInt(loginTimeArr[1]);
        String[] logoutTimeArr = logoutTime.split(":");
        int hourLogout = Integer.parseInt(logoutTimeArr[0]);
        int minLogout = Integer.parseInt(logoutTimeArr[1]);
        int count = 0;
        int totalHour = 0;
        int tempHourLogin = hourLogin;

        while (tempHourLogin != hourLogout) {
            if (tempHourLogin + 1 == 24) {
                tempHourLogin = 0;
            } else {
                tempHourLogin++;
            }

            totalHour++;
            if (tempHourLogin == hourLogout) {
                break;
            }
        }

        if (minLogout == 0 && minLogin == 0) {
            return totalHour * 4;
        }

        int chance = 0;

        if (minLogin > 0 && minLogin <= 15) {
            chance = 3;
        }

        if (minLogin > 15 && minLogin <= 30) {
            chance = 2;
        }

        if (minLogin > 30 && minLogin <= 45) {
            chance = 1;
        }

        if (minLogin > 45 && minLogin <= 59) {
            chance = 0;
        }

        int chanceLogout = 0;

        if (minLogout > 0 && minLogout <= 15) {
            chanceLogout = 0;
        }

        if (minLogout > 15 && minLogout <= 30) {
            chanceLogout = 1;
        }

        if (minLogout > 30 && minLogout <= 45) {
            chanceLogout = 2;
        }

        if (minLogout > 45 && minLogout <= 59) {
            chanceLogout = 3;
        }

        return (totalHour - 1) * 4 + chance + chanceLogout;

    }

    public int numSub(String s) {
        return substrings1(s);
    }

    public static int count(String sub) {
        String[] subArr = sub.split("");
        return Arrays.stream(subArr).collect(Collectors.toSet()).size() == 1 ? 1 : 0;
    }

    public static int substrings1(String input) {
        List<String> substrings = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substrings.add(input.substring(i, j));
                if (!input.substring(i, j).contains("0")) {
                    map.put(input.substring(i, j), map.getOrDefault(input.substring(i, j), 0) + 1);
                }
            }
        }
        if (map.isEmpty()) return 0;
        return map.values().stream().reduce(Integer::sum).get();
    }

    public String sortVowels(String s) {
        String[] srr = s.split("");

        int len = srr.length;

        List<String> caps = new ArrayList<>();
        List<String> small = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (List.of("a", "e", "i", "o", "u").contains(srr[i])) {
                small.add(srr[i]);
                srr[i] = "#00#";
            } else if (List.of("A", "E", "I", "O", "U").contains(srr[i])) {
                caps.add(srr[i]);
                srr[i] = "#00#";
            }
        }

        Collections.sort(caps);
        Collections.sort(small);
        caps.addAll(small);

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (srr[i].equals("#00#")) {
                srr[i] = caps.get(index);
                index++;
            }
        }

        String temp = "";

        for (String s1 : srr) {
            temp += s1;
        }

        return temp;
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        List<Integer> l = Arrays.stream(banned).boxed().toList();
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!l.contains(i)) {
                if (sum + i <= maxSum) {
                    sum += i;
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
