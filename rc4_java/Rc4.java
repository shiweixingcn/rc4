package rc4_java;

public class Rc4 {
	private static int mod(int i, int j)
	{
		int r;
		if(i>j)
			r=i%j;
		else if(i<j)
			r=i;
		else
			r=0;
		return r;
	}
	public static void  rc4_init(short s[],String keys,int len) {
		int i = 0;
		int j = 0;
		short[] k= new short[256];
		short tmp = 0;
		byte[] key=keys.getBytes();
		for ( i=0;i<256;i++)
		{
			s[i]= (short) i;
			k[i]=key[mod(i,len)];
		}
		for( i=0;i<256;i++)
		{
			j= mod((int)(j+s[i]+k[i]),256);
			tmp=s[i];
			s[i] = s[j];
			s[j]=tmp;
		}
	}
	public static void  rc4_crypt(short s[],short data[],int len) {
		int i=0;
		int j=0;
		int t=0;
		int k=0;
		short tmp;
		for(k=0;k<len;k++)
		{
			i=mod((i+1),256);
			j=mod((j+s[i]),256);
			tmp=s[i];
			s[i]=s[j];
			s[j]=tmp;
			t=mod((s[i]+s[j]),256);
			data[k]^=s[t];
		}
	}
}
