package AlgorithmTests;

import DataStructures.LinkedList;
import DataStructures.MyList;
import com.company.Fibonacci;
import com.company.TextEditor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlgorithmTests {

    @Test
    public void fibonacciTest() {
        Fibonacci fib = new Fibonacci();
        assertEquals(fib.fib(6), 8);
    }

    @Test
    public void TestMyList() {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.remove(0);

        assertEquals((int)myList.get(0), 2);
        assertEquals((int)myList.get(1), 3);
        assertEquals(myList.count(), 2);
    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.append(1);
        ll.append(2);
        ll.append(3);

        ll.prepend(0);
        assertEquals((int)ll.get(1), 1);
    }

    @Test
    public void TextEditorTestSingleBackspace() {
        TextEditor te = new TextEditor();
        byte[] c = new byte[1];
        c[0] = (byte)3;
        te.typeChar(c);

        assertEquals(te.backspace(),1);
    }

    @Test
    public void TextEditorDoubleCharBacksapce() {
        TextEditor te = new TextEditor();
        byte[] c = new byte[2];
        c[0] = (byte)120;
        c[1] = (byte)123;
        te.typeChar(c);

        assertEquals(te.backspace(), 2);
    }

    @Test
    public void TextEditorDoubleCharBacksapceEdgeCase1() {
        TextEditor te = new TextEditor();
        byte[] c = new byte[2];
        c[0] = (byte)129;
        c[1] = (byte)129;

        byte[] c2 = new byte[1];
        c2[0] = (byte)126;
        te.typeChar(c);
        te.typeChar(c2);

        assertEquals(te.backspace(), 1);
    }
}
