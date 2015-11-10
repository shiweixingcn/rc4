#include<stdio.h>
#include<string.h>

void rc4_init(unsigned char *s, unsigned char *key, unsigned long Len)
{
    int i =0;
    int j =0;
    char k[256] = {0};
    unsigned char tmp = 0;
    for(i=0;i<256;i++)
    {
        s[i]=i;
        k[i]=key[i%Len];
    }
    for(i=0; i<256; i++)
    {
        j=(j+s[i]+k[i])%256;
        tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}

void rc4_crypt(unsigned char *s, unsigned char *Data, unsigned long Len)
{
    int i = 0;
    int j = 0;
    int t = 0;
    unsigned long k = 0;
    unsigned char tmp;
    for(k=0;k<Len;k++)
    {
        i=(i+1)%256;
        j=(j+s[i])%256;
        tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        t=(s[i]+s[j])%256;
        Data[k] ^= s[t];
    }
}

void main()
{
    unsigned char s1[256] = {0};
    unsigned char s2[256] = {0};
    char key[256] = {"test"};
    char pData[6] = {0x6f, 0xc1, 0xbe, 0xe2, 0x2e, 0x40};
    int i;
    unsigned long len = 6;
    printf("key = %s, length = %d\n",key,strlen(key));
    printf("data:");
    for(i=0;i<len;i++)
        printf("0x%2x,",*(pData+i));
    printf("\n");
    //encode
    rc4_init(s1,(unsigned char *)key,strlen(key));
    rc4_crypt(s1,(unsigned char *)pData,len);
    printf("encry:");
    for(i=0;i<len;i++)
        printf("0x%2x,",*(pData+i));
    printf("\n");
    //decode
    rc4_init(s2,(unsigned char *)key, strlen(key));
    rc4_crypt(s2,(unsigned char *)pData,len);
    printf("decry:");
    for(i=0;i<len;i++)
        printf("0x%2x,",*(pData+i));
    printf("\n");
}
