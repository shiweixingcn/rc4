package rc4_java;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short[] s1=new short[256];
		short[] s2 = new short[256];
		String key="test";
		short[] pData={0x6f,  0xc1, 0xbe,  0xe2, 0x2e, 0x40};
		int i;
		System.out.println("key:"+key.toString()+"    len:"+key.length());
		System.out.println("data:");
		 for(i=0;i<pData.length;i++)
			 System.out.printf("0x%2x,",pData[i]);
		 System.out.println();
		 // encode 
		 Rc4.rc4_init(s1,key,key.length());
		 Rc4.rc4_crypt(s1, pData, pData.length);
		 System.out.println("encry:");
		 for(i=0;i<pData.length;i++)
		 {
			 System.out.printf("0x%2x,",pData[i]);
		 }
		 System.out.println("");
		 
		 // decode
		 Rc4.rc4_init(s2,key,key.length());
		 Rc4.rc4_crypt(s2, pData, pData.length);
		 System.out.println("decry:");
		 for(i=0;i<pData.length;i++)
		 {
			 System.out.printf("0x%2x,",pData[i]);
		 }
		 System.out.println("");
	}
	

}
