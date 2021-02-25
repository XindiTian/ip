import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

public class StorageTest {
    @Test
    public void dummyTest() {
        assertEquals(2, 2);
    }

    /**
     * tests if the home path fetched by the program matches the expected path.
     */
    public void test1() {
        String expected = "C:" + File.separator + "Users" + File.separator + "xindi";
        assertEquals(expected, Storage.getHome());
    }

    /**
     * tests if the default path fetched by the program matches the expected path.
     */
    public void test2() {
        String expected = "C:" + File.separator + "Users" + File.separator + "xindi" + File.separator + "task.txt";
        assertEquals(expected, Storage.getDefaultFilePath());
    }
}
