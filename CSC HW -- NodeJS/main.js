const StringBuilder = require("string-builder"); //Make sure to install string-builder before running "npm install string-builder"
const encoder = new StringBuilder();
const prompt = require("prompt-sync")({ sigint: true }); //Make sure to install prompt-sync before running "npm install prompt-sync"

class RunLengthEncode {
    encode(input) {
        var count = 1;

        for(var x = 0; x < input.length; x++){
            if(input.charAt(x) == input.charAt(x+1)){
                count++;
            }
            else{
                if(count > 4){
                    if(count <= 9){
                        encoder.append("/");
                        encoder.append(0);
                        encoder.append(count);
                        encoder.append(input.charAt(x));
                    }
                    else{
                        encoder.append("/");
                        encoder.append(count);
                        encoder.append(input.charAt(x));
                    }
                }
                else{
                    for(var i = 0; i < count; i++){
                        encoder.append(input.charAt(x));
                    }
                }
                count = 1;
            }
        }
        if (count > 4) {
            if(count <= 9){
                encoder.append("/");
                encoder.append(0);
                encoder.append(count);
                encoder.append(input.charAt(input.length));
            }
            else{
                encoder.append("/");
                encoder.append(count);
                encoder.append(input.charAt(input.length));
            }
        }
        else{
            for(var i = 0; i < count; i++){
                encoder.append(input.charAt(input.length));
            }
        }
        return encoder.toString();
    }}


console.log("======")
const input = prompt("Enter a String: ");


console.log("======")
let myString = new RunLengthEncode;
console.log(myString.encode(input))
console.log("======")