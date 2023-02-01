import java.util.Scanner;

public class RunLengthEncode {
    public static String encode(String userString) {
        StringBuilder encoder = new StringBuilder(); //creates stringbuilder
        int count = 1; //starts at 1 because it doesnt account for comparing the first two char that are the same

        //Loop through the string
        for (int x = 0; x < userString.length() - 1; x++) {
            if (userString.charAt(x) == userString.charAt(x + 1)) {
                count++; //Adds if char at x and x+1 are the same
            }
            else{
                if (count >= 5) { //if count is greater or equal to 5 it will compress
                    encoder.append("/");
                    encoder.append(String.format("%02d", count));
                    encoder.append(userString.charAt(x));
                }
                else{ //else it will just add the char to the string
                    for(int i = 0; i < count; i++){
                        encoder.append(userString.charAt(x));
                    }
                }
                count = 1;
            }
        }
        if (count >= 5) { //once we finish looping if count is greater or equal 5 it will compress
            encoder.append("/");
            encoder.append(String.format("%02d", count));
            encoder.append(userString.charAt(userString.length() - 1));
        }
        else{ //else it will just at the last char to the string
            for(int i = 0; i < count; i++){
                encoder.append(userString.charAt(userString.length() - 1));
            }
        }
        return encoder.toString(); //returns our new string
    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //creates scanner

        System.out.println("Enter a String");
        String userString = s.nextLine(); //Takes in users string
        System.out.println(encode(userString)); //calls methods with users string and prints the return
    }
}

