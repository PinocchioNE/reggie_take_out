import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Data
class Solution {
    private String name;
    private Integer id;
    public Solution(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
    public Solution() {
    }
    public static void main(String[] args) {
        List<Double> list = Arrays.asList(1.1, 2.1, 3.1, 4.1);
        List<Double> collect = list.stream().filter(d -> d > 2).collect(Collectors.toList());
        System.out.println(collect);

        ArrayList<Solution> arrayList = new ArrayList<>();
        arrayList.add(new Solution("xth",1));
        arrayList.add(new Solution("wz",2));

        System.out.println(arrayList.stream().map(item -> item.getId()).collect(Collectors.toList()));

        List<String> list1 = arrayList.stream().map(item -> item.getName()).collect(Collectors.toList());
        list1.forEach(item-> System.out.println(item));

        list1.forEach(System.out::println);
    }
}