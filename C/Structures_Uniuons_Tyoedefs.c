#include <stdio.h>
#include <string.h>

// only one attribute will be selected at a time =>
// struct's memory => each memeber has it's own memory
//uniouns mem=> by default max(size of all attributes)
// single shared memory is used.
union KK {
    char name[40]; //40bytes
    int a;         //4bytes=>win32
};
//unoun will take 40 bytes

//defining structs => similar to class with the only difference functions can't be created in structs
struct Student
{
    /* data */
    int id;
    char name[50];
};

typedef struct Employee
{
    /* data */
    int id;
    char name[50];
} emp; //here emp isn;t an object it;s an alias for Employee

typedef int *intptr;
intptr a, b;
//as int* a, b; will be treated as int *a,b; => a= int*, b= int

struct Interns
{
    /* data */
    int id;
    char name[50];
} intern1, intern2; // here we are creating objects just after creation(initializing members here too)

int main(int argc, char const *argv[])
{
    /* code */
    struct Student student1; //creating Student's object here

    // We access members using '.' (know as structure member operator)
    intern1.id = 1;

    // intern1.name[] = "Mohit"; # We can't assign directly we use strcpy
    strcpy(intern1.name, "Mohit");
    student1.id = 2;
    printf("Details of interns : %d, %s \n", intern1.id, intern1.name);
    printf("Details of Student : %d", student1.id);

    return 0;
}
