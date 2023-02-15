import java.util.Arrays;
import java.util.Comparator;

public class Project3 {
    public static void main(String[] args) {
        String[] dirs = {"/","/usr/","/usr/local/","/usr/local/bin/","/games/","/games/snake/","/homework/","/temp/downloads/"};
        Dirsort(dirs);
        for(int x = 0; x < dirs.length; x++){
            System.out.print(dirs[x] + "  ");
        }

        System.out.print("\n");

        dirs = new String[]{"/usr/","/usr/local/","/bin/","/usr/local/bin/","/usr/bin/ ","/bin/local/","/bin/local/"};
        Dirsort(dirs);
        for(int x = 0; x < dirs.length; x++){
            System.out.print(dirs[x] + "  ");
        }
    }

    public static String[] Dirsort(String[] dirs) { //sorts the file path
        Arrays.sort(dirs);
        Arrays.sort(dirs, new Comparator<String>() {
            public int compare(String n1, String n2) {
                int depth = count(n1), depth2 = count(n2);
                return depth - depth2;
            }
        });
        return dirs;
    }
    public static int count(String s) { // counts how long the path is
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/') {
                c++;
            }
        }
        return c;
    }

}