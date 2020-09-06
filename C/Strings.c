#include <string.h>
#include <stdio.h>

// scanf vs gets
/*
scanf() reads input until it encounters whitespace, newline or End Of File(EOF) whereas gets() reads input until it encounters newline or End Of File(EOF)
gets() does not stop reading input when it encounters whitespace instead it takes whitespace as a string
gets is specifically for takinf string as INPUT
*/

// printf vs puts
/* Puts => input: char array, return: void => counts the \0 as character
can only be used to print string, automatically moves the cursor to newline
puts(5); can't as puts only accepts string characters as input, 

Printf() => in: anydata type, also alows formatting, return: len(characters printed on console)
*/

int main(int argc, char const *argv[])
{ //Ways to get string into character array
    // /0 is know as null-terminator
    char name[] = {'M', 'O', 'H', 'I', 'T', '\0'}; // if we define as an array we have to give the '/0' to tell the end of string
    char name2[] = "Mohit";                        // Here it is implictly containing /0
    // Directly prints the string to console
    char name3[50];
    gets(name3);
    puts(name);
    puts(name2);
    int l1 = printf("Hello");
    printf("\n%s\n", name3);
    printf("Printf: %d  Puts: %d", l1, puts("hello"));

    strrev(name); //reverse the string in place
    printf("\n");
    puts(name);
    return 0;
}
