import java.util.Scanner;

public class RunLengthEncode {
        public static String encode(String input) {
            StringBuilder encoder = new StringBuilder();
            int count = 1;

            //Loop through the string
            for (int x = 0; x < input.length() - 1; x++) {
                if (input.charAt(x) == input.charAt(x + 1)) {
                    count++;
                }
                else{
                    if (count > 4) {
                        encoder.append("/");
                        encoder.append(String.format("%02d", count));
                        encoder.append(input.charAt(x));
                    }
                    else{
                        for(int i = 0; i < count; i++){
                            encoder.append(input.charAt(x));
                        }
                    }
                    count = 1;
                }
            }
            if (count > 4) {
                encoder.append("/");
                encoder.append(String.format("%02d", count));
                encoder.append(input.charAt(input.length() - 1));
            }
            else{
                for(int i = 0; i < count; i++){
                    encoder.append(input.charAt(input.length() - 1));
                }
            }
            return encoder.toString();
        }



        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            System.out.println("Enter a String");
            String input = s.nextLine();
            System.out.println(encode(input));
        }
    }

