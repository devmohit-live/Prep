#include <stdio.h>
// getting it in normal int array
void func(int arr[])
{
    arr[2] = 4;
    for (int i = 0; i < 3; i++)
    {
        printf("%d ", arr[i]);
    }
}

//using pointers
void func2(int *p)
{
    *(p + 2) = 5;
    for (int i = 0; i < 3; i++)
    {
        printf("%d ", *(p + i));
    }
}

int main(int argc, char const *argv[])
{
    int a[] = {1, 2, 3};
    func(a);
    printf("\n");
    func2(a);
    return 0;
}
