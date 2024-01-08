package implementierung;

import geometrie.Gerade;
import geometrie.Punkt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import schnittstellen.IListElement;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ListTest {

    @Test
    @DisplayName("List")
    void testList() {

        List list = new List();

        assertNotNull(list.getHead());
        assertEquals(0, list.getSize());

        ValueElement beforeOne = new ValueElement("-1", -1);
        ValueElement one = new ValueElement("1", 1);
        ValueElement two = new ValueElement("2", 2);
        ValueElement three = new ValueElement("3", 3);
        ValueElement beforeFour = new ValueElement("3.9", 4);
        ValueElement four = new ValueElement("4", 4);
        ValueElement five = new ValueElement("5", 5);

        list.insertAtTheEnd(one);
        assertEquals(1, list.getSize());
        list.reverse();
        assertEquals("[1,1]", list.toString());

        System.out.println(list);
        IListElement oneEl = list.getHead().getSuccessor();
        assertSame(one, list.getHead().getPredecessor().getValueElement());
        assertSame(one, oneEl.getValueElement());
        assertSame(one, list.getElementAt(1));

        list.insertAtTheEnd(two);
        assertEquals(2, list.getSize());
        System.out.println(list);
        IListElement twoEl = list.getHead().getPredecessor();
        assertSame(two, list.getHead().getPredecessor().getValueElement());
        assertSame(oneEl, twoEl.getPredecessor());
        assertSame(two, list.getElementAt(2));

        assertSame(twoEl, oneEl.getSuccessor());
        assertNull(twoEl.getSuccessor());


        list.insertAtTheEnd(three);
        assertEquals(3, list.getSize());
        System.out.println(list);
        IListElement threeEl = list.getHead().getPredecessor();
        assertSame(three, list.getHead().getPredecessor().getValueElement());
        assertSame(twoEl, threeEl.getPredecessor());
        assertSame(three, list.getElementAt(3));
        assertSame(threeEl, twoEl.getSuccessor());
        assertNull(threeEl.getSuccessor());

        list.insertAtPos(-1, beforeOne);
        assertEquals(4, list.getSize());
        System.out.println(list);
        IListElement beforeOneEl = list.getHead().getSuccessor();
        assertSame(beforeOne, beforeOneEl.getValueElement());
        assertSame(oneEl, beforeOneEl.getSuccessor());
        assertSame(list.getHead(), beforeOneEl.getPredecessor());

        list.insertAtPos(10, four);
        assertEquals(5, list.getSize());
        System.out.println(list);
        IListElement fourEl = list.getHead().getPredecessor();
        assertSame(four, fourEl.getValueElement());
        assertSame(threeEl, fourEl.getPredecessor());
        assertSame(fourEl, threeEl.getSuccessor());

        //  items shifted due to beforeOneEl
        assertSame(three, list.getElementAt(4));
        assertSame(four, list.getElementAt(5));

        list.insertAtPos(5, beforeFour);
        assertEquals(6, list.getSize());
        System.out.println(list);
        assertSame(fourEl, list.getHead().getPredecessor());
        IListElement beforeFourEl = fourEl.getPredecessor();
        assertSame(beforeFour, beforeFourEl.getValueElement());
        assertSame(threeEl, beforeFourEl.getPredecessor());
        assertSame(fourEl, beforeFourEl.getSuccessor());

        list.deleteFirstOf(one);
        System.out.println(list);
        assertSame(list.getHead().getSuccessor(), beforeOneEl);
        assertSame(list.getHead(), beforeOneEl.getPredecessor());
        assertEquals("[-1,-1],[2,2],[3,3],[3.9,4],[4,4]", list.toString());
        list.deleteFirstOf(beforeOne);
        System.out.println(list);
        assertEquals("[2,2],[3,3],[3.9,4],[4,4]", list.toString());
        assertSame(list.getHead().getSuccessor(), twoEl);
        assertSame(list.getHead(), twoEl.getPredecessor());

        list.deleteAllOf(three);
        System.out.println(list);
        assertEquals("[2,2],[3.9,4],[4,4]", list.toString());

        list.insertAtPos(2, four);
        System.out.println(list);
        assertEquals("[2,2],[4,4],[3.9,4],[4,4]", list.toString());

        list.deleteAllOf(four);
        System.out.println(list);
        assertEquals("[2,2],[3.9,4]", list.toString());

        list.deleteAllOf(two);
        System.out.println(list);
        list.deleteAllOf(beforeFour);
        System.out.println(list);

        list.insertAtPos(-1, one);
        oneEl = list.getListElementAt(1);
        assertSame(one, oneEl.getValueElement());
        System.out.println(list);
        assertEquals("[1,1]", list.toString());
        assertSame(list.getHead(), oneEl.getPredecessor());
        list.insertAtPos(10000, three);
        System.out.println(list);
        assertEquals("[1,1],[3,3]", list.toString());
        list.insertAtPos(2, two);
        System.out.println(list);
        assertEquals("[1,1],[2,2],[3,3]", list.toString());

        assertFalse(list.member(five));
        assertTrue(list.member(two));

        list.deleteFirstOf(three);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        assertEquals("[2,2],[1,1]", list.toString());


        list.reverse();
        System.out.println(list);
        assertEquals("[1,1],[2,2]", list.toString());

        list.insertAtTheEnd(three);
        list.reverse();
        System.out.println(list);
        assertEquals("[3,3],[2,2],[1,1]", list.toString());
        list.reverse();
        assertEquals("[1,1],[2,2],[3,3]", list.toString());

        list.insertAtPos(4, four);
        list.insertAtPos(5, five);
        assertEquals(5, list.getSize());
        System.out.println(list);
        assertEquals("[1,1],[2,2],[3,3],[4,4],[5,5]", list.toString());

        list.reverse();
        System.out.println(list);
        assertEquals("[5,5],[4,4],[3,3],[2,2],[1,1]", list.toString());
    }
}