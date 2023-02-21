import java.util.ArrayList;
import java.util.List;

public class DrawTree {
    // Method to get the representation of a tree as a String[]
        public static String[] draw(int[] parents, String[] names) {
            List<String> finalArray = new ArrayList<>();
            int root = 0; //Initializes the root and finds where it is in the array
            for (int x = 0; x < parents.length; x++) {
                if (parents[x] == -1) {
                    root = x;
                }
            }
            finalArray.add("+-" + names[root]);  // Add the root to the finalArray
            subTrees(root, parents, names, "  ", finalArray);  // Recursively get the subtrees of the root and add them to the result
            return finalArray.toArray(new String[finalArray.size()]);
        }

        // Method to get the subtrees and add them to the result
        private static void subTrees(int root, int[] parents, String[] names, String space, List<String> finalArray) {
            List<Integer> children = new ArrayList<>();
            // Find the children of the root
            for (int x = 0; x < parents.length; x++) {
                if (parents[x] == root) {
                    children.add(x);
                }
            }
            // Recursively get the subtrees of each child and add them to the result
            for (int x = 0; x < children.size(); x++) {
                int child = children.get(x);
                String prefix = "+-";
                // Add the prefix to the finalArray
                finalArray.add(space + prefix + names[child]);
                if (x < children.size() - 1) {
                    // If the node is not the last child, recursively get its subtrees with a "|" indentation
                    subTrees(child, parents, names, space + "| ", finalArray);
                } else {
                    // If the node is the last child, recursively get its subtrees with a "  " indentation
                    subTrees(child, parents, names, space + "  ", finalArray);
                }
            }
        }

    // Main method for testing
    public static void main(String[] args) {
        int[] parents = {-1,0,1,1,2,2,3,3,0,8,8,9,9,10,10};
        String[] names = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

        String[] treeRepresentation = draw(parents, names);

        for (int i = 0; i < treeRepresentation.length; i++) {
                System.out.println(treeRepresentation[i]);
        }
    }
}
