package ru.discomfortDeliverer.customlinkedlist;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Методы CustomLinkedList вызываются в тестах
        // Здесь преобразование стрима в CustomLinkedList
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        CustomLinkedList<Integer> customLinkedList = stream.reduce(
                new CustomLinkedList<>(),
                (list, element) -> {
                    list.add(element);
                    return list;
                },
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }
        );

        customLinkedList.printList();
    }
}
