#include <stdio.h>

int main()
{
    printf("Lets learn about pointers\n");
    int a = 76;
    int *ptra = &a;
    int **ptr2 = &ptra;
    int ***ptr3 = &ptr2;
    printf("address of a is %p\n", &a);
    printf("value of first poiinter is %p\n", ptra);
    printf("\n");
    printf("The address of 1st pointer %p\n", &ptra);
    printf("The value of 2nd pointer %p\n", ptr2);
    printf("\n");
    printf("The address of 2nd pointer %p\n", &ptr2);
    printf("The value of 3rd pointer %p\n", ptr3);
    printf("\n");
    printf("The address of 3rd pointer %p\n", &ptr3);
    printf("\n");
    printf("The value of a using single pointer %d\n", *ptra);
    printf("The value of a using double pointer %d\n", **ptr2);
    printf("The value of a using triple pointer %d\n", ***ptr3);

    return 0;
}
