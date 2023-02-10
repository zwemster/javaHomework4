import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class taskPhoneBook {
    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<>();
        map.put("Иван Иванов", 88001122333L);
        map.put("Иван Курицин", 88001662333L);
        map.put("Иван Курицин", 88001112333L);
        map.put("Иван Незлобин", 88001122432L);
        map.put("Сергей Потапов", 88001112453L);
        map.put("Сергей Потапов", 88001632146L);
        map.put("Сергей Курицин", 88001424218L);
        map.put("Михаил Незлобин", 88001234331L);

        Map<String, Integer> counter = new HashMap<>();
        for (String name : map.keySet()) {
            String firstName = name.split(" ")[0];
            if (counter.containsKey(firstName)) {
                counter.put(firstName, counter.get(firstName) + 1);
            } else {
                counter.put(firstName, 1);
            }
        }

        Map<String, Integer> descendingSort = new TreeMap<>(
                (name1, name2) -> counter.get(name2) - counter.get(name1));
        descendingSort.putAll(counter);

        Set<Map.Entry<String, Integer>> entrySet = descendingSort.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
