const StringBuilder = require("string-builder"); //Make sure to install string-builder before running "npm install string-builder"
const encoder = new StringBuilder();
const prompt = require("prompt-sync")({ sigint: true }); //Make sure to install prompt-sync before running "npm install prompt-sync"

class RunLengthEncode {
    encode(input) { //takes the input
        var count = 1; //sets count to 1 to account for the first comparison

        for(var x = 0; x < input.length; x++){ //loops through the whole string
            if(input.charAt(x) == input.charAt(x+1)){
                count++;
            }
            else{
                if(count > 4){
                    if(count <= 9){ //if count is 1 digit it adds a 0 before count 
                        encoder.append("/");
                        encoder.append(0);
                        encoder.append(count);
                        encoder.append(input.charAt(x));
                    }
                    else{
                        encoder.append("/"); //if count is 2 digits it doesnt add 0
                        encoder.append(count);
                        encoder.append(input.charAt(x));
                    }
                }
                else{
                    for(var i = 0; i < count; i++){ //adds char to string
                        encoder.append(input.charAt(x));
                    }
                }
                count = 1;
            }
        }
        if (count > 4) {
            if(count <= 9){
                encoder.append("/"); //once out of loop if count is less 10 it will add 0 before count
                encoder.append(0);
                encoder.append(count);
                encoder.append(input.charAt(input.length));
            }
            else{
                encoder.append("/"); //once out of loop if count is 2 digits it doesnt add 0
                encoder.append(count);
                encoder.append(input.charAt(input.length));
            }
        }
        else{
            for(var i = 0; i < count; i++){ //Else it just adds the last char to the string
                encoder.append(input.charAt(input.length));
            }
        }
        return encoder.toString();
    }}


console.log("======") //allows user to input string in terminal/ console
const userString = prompt("Enter a String: ");


console.log("======")
let myString = new RunLengthEncode; 
console.log(myString.encode(userString)) //calls method with user input
console.log("======")
