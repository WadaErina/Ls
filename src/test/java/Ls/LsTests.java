package Ls;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class LsTests {

    @Test
    public void lsOnlyTest() {
        File file = new File("src/test/resouces");
        File[] files = file.listFiles();
        String[] viewFiles = Ls.makeNoOptionFiles(files);
        assertEquals("test.txt ", viewFiles[1]);
    }

    @Test
    public void optionLTest() throws IOException {
        File file = new File("src/test/resouces");
        File[] files = file.listFiles();
        String[] viewFiles = Ls.makeOptionLFiles(files);
        assertEquals("rw-r--r-- 1 wada TAGBANGERS\\Domain Users 0 Feb 27 15:00 test.txt", viewFiles[1]);
    }

    @Test
    public void optionRTest() {
        String[] viewFiles = {"a","b","c"};
        viewFiles = Ls.makeOptionRFiles(viewFiles);
        assertEquals("c", viewFiles[0]);
        assertEquals("b", viewFiles[1]);
        assertEquals("a", viewFiles[2]);
    }

    @Test
    public void optionATest() {
        File file = new File("src/test/resouces");
        File[] files = file.listFiles();
        String[] viewFiles = Ls.makeNoOptionFiles(files);
        viewFiles = Ls.makeOptionAFiles(viewFiles);
        assertEquals("test.txt ", viewFiles[1]);
    }

    @Test
    public void optionTTest() {
        File file = new File("src/test/resouces");
        File[] files = file.listFiles();
        String[] viewFiles = Ls.makeNoOptionFiles(files);
        viewFiles = Ls.makeOptionTFiles(viewFiles);
        assertEquals("test.txt ", viewFiles[1]);
    }

    @Test
    public void shouldOneCallWhenArgsIsNull() {
        Ls ls = new Ls();
//        ls.viewFiles

    }
}