package ls;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// Lsクラスのテスト

class LsTests {

    // Lsコマンドのみだったときにファイル名を取得するテスト
    @Test
    public void lsOnlyTest() throws IOException {
        Ls ls = new Ls();
        String[] args = {"src/test/resouces"};
        ls.ls(args);
        assertEquals("index.html ", ls.viewFiles[0]);
        assertEquals("test.txt ", ls.viewFiles[1]);
    }

    // オプションlに対応しているかを確認するテスト
    @Test
    public void optionLTest() throws IOException {
        Ls ls = new Ls();
        String[] args = {"src/test/resouces", "-l"};
        ls.ls(args);
        assertEquals("rw-r--r-- 1 wada TAGBANGERS\\Domain Users 0 Feb 27 15:00 test.txt", ls.viewFiles[1]);
    }

    /**
     * オプションRに対応しているかを確認するテスト
     * 配列a,b,cの順番が逆になっていることを期待する
     */
    @Test
    public void optionRTest() throws IOException {
        Ls ls = new Ls();
        String[] args = {"src/test/resouces", "-r"};
        ls.ls(args);
        assertEquals("test.txt ", ls.viewFiles[0]);
        assertEquals("index.html ", ls.viewFiles[1]);
    }

    /**
     * オプションaに対応しているかを確認するテスト
     * Ls.javaはオプションaには対応していないため、ファイル名を取得するテストになっている
     */
    @Test
    public void optionATest() throws IOException {
        Ls ls = new Ls();
        String[] args = {"src/test/resouces", "-a"};
        ls.ls(args);
        assertEquals("test.txt ", ls.viewFiles[1]);
    }

    /**
     * オプションtに対応しているかを確認するテスト
     * Ls.javaはオプションtには対応していないため、ファイル名を取得するテストになっている
     */
    @Test
    public void optionTTest() throws IOException {
        Ls ls = new Ls();
        String[] args = {"src/test/resouces", "-t"};
        ls.ls(args);
        assertEquals("test.txt ", ls.viewFiles[1]);
    }

    /**
     * 絶対パスを入力していない場合に、相対パスを取得しているかを確認するテスト
     */
    @Test
    public void shouldOneCallWhenArgsIsNull() throws IOException {
        Ls ls = new Ls();
        String[] args = new String[0];
        ls.ls(args);
        String userDir = System.getProperty("user.dir");
        assertEquals(userDir, ls.path);
    }

    /**
     * 絶対パスを入力したときに、絶対パスを取得しているかを確認するテスト
     */
    @Test
    public void shouldOneCallWhenArgsIsNotNull() throws IOException {
        Ls ls = new Ls();
        String[] args = new String[1];
        args[0] = "src/test/resouces";
        ls.ls(args);
        assertEquals("src/test/resouces", ls.path);
    }

    // オプションを取得しているかを確認するテスト
    @Test
    public void shouldOneCallWhenArgsIsOption() throws IOException {
        Ls ls = new Ls();
        String[] args = new String[1];
        args[0] = "-latr";
        ls.ls(args);
        assertEquals("-latr", ls.options);
    }
}