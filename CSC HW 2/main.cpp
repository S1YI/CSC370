#include <iostream>
using namespace std;

string AccessLevel(int rights[], int minPermission, int arraySize) {  
    string str; //creates string to store access
    for(int i = 0; i < arraySize; i++){ //loops through the whole array
        if(rights[i] >= minPermission){ //if rights is greater or equal to minPerms add A to string
            str += "A";
        }
        else{ //Else add D
            str += "D";
        }
    }
    return str; //Returns the string to the main method
}

int main() {
    int rights[] = {5,3,2,10,0}; //The given array
    int minPermission = 20; //Given Min perms

    int getArrayLength = sizeof(rights) / sizeof(int); //Allows me to get the length of the array

    cout << AccessLevel(rights, minPermission, getArrayLength); //Prints and calls the method

    return 0;
}