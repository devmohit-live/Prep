#include <stdio.h>
int main()
{
    int x = 2;
    int *p;
    p = &x;
    *p = x++ * (*p + 1);
    printf("%d", x);
    return 0;
}