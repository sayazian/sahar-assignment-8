package com.coderscampus.arraylisttest;

import com.coderscampus.arraylist.CustomArrayList;
import com.coderscampus.arraylist.CustomList;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomArrayListTest {
    // Test-Driven Development Methodology
    // Step 1 - Write a failing test
    // Step 2 - Write the business logic to make the test pass
    // Step 3 - Refactor your code

    @Test
    public void should_add_item_to_list_and_increase_size() {
        CustomList<String> sut = new CustomArrayList<>();
        sut.add("one");
        sut.add("two");
        sut.add("four");
        sut.add(2, "three");
        assert true;
        assertEquals(4, sut.getSize());
        sut.add(0, "zero");
        assert true;
        assertEquals(5, sut.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_fail_adding_at_negative_index_to_the_list() {
        CustomList<String> sut = new CustomArrayList<>();
        sut.add("one");
        sut.add("two");
        sut.add("four");
        sut.add(-2, "three");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_fail_adding_at_larger_than_size_index_to_the_list() {
        CustomList<String> sut = new CustomArrayList<>();
        sut.add("one");
        sut.add("two");
        sut.add("four");
        sut.add(4, "three");
    }

    @Test
    public void should_remove_item_from_list_and_return_the_correct_item_and_decrease_size() {
        CustomList<String> sut = new CustomArrayList<>();
        sut.add("one");
        sut.add("two");
        sut.add("four");
        String result = sut.remove(2);
        assertEquals("four", result);
        assertEquals(2, sut.getSize());
        result = sut.remove(0);
        assertEquals("one", result);
        assertEquals(1, sut.getSize());
        result = sut.remove(0);
        assertEquals("two", result);
        assertEquals(0, sut.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_fail_removing_at_negative_index_from_the_list() {
        CustomList<String> sut = new CustomArrayList<>();
        sut.add("one");
        sut.add("two");
        sut.add("four");
        sut.remove(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_fail_removing_at_larger_than_size_index_from_the_list() {
        CustomList<String> sut = new CustomArrayList<>();
        sut.add("one");
        sut.add("two");
        sut.add("four");
        sut.remove(4);
    }

    //Assignment 5 tests
    @Test
    public void must_be_able_to_get_all_valid_elements() {
        CustomList<String> myCustomList = getStringCustomList();
        for (int i = 0; i < myCustomList.getSize(); i++) {
            assertEquals(myCustomList.get(i), "element " + (i + 1));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_fail_getting_negative_index() {
        CustomList<String> myCustomList = getStringCustomList();
        myCustomList.get(-10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_fail_getting_out_of_bound_index() {
        CustomList<String> myCustomList = getStringCustomList();
        myCustomList.get(45);
    }

    @Test
    public void must_add_element_to_the_end() { //to cover resizeArray()
        CustomList<String> myCustomList = getStringCustomList();
        for (int i = 1; i <= 35; i++)
            myCustomList.add("element " + (i + 45));
        myCustomList.add(79, "new element");
        assertEquals("new element", myCustomList.get(79));
        assertEquals("element 80", myCustomList.get(80));
    }

    @Test
    public void should_add_item_at_last_available_index() {
        CustomList<String> myCustomList = new CustomArrayList<>();
        for (int i = 1; i <= 10; i++)
            myCustomList.add("element " + (i));
        myCustomList.add(10, "new element");
        assertEquals("new element", myCustomList.get(10));
    }

    private static CustomList<String> getStringCustomList() {
        CustomList<String> myCustomList = new CustomArrayList<>();
        for (int i = 1; i <= 45; i++)
            myCustomList.add("element " + i);
        return myCustomList;
    }
}
