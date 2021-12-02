
/*import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;*/

/*import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;*/
import java.util.*;

public class Main {
	public static String[] rev(String[] gow){
		String temp = gow[0];
		  
		for(int i=0;i<4;i++){
			if(i!=3)
				gow[i]=gow[i+1];
		}
		gow[3]=temp;
		return gow;
	}
	public static String sbox(String s){
		String[][] subBox={{"63","7C","77","7B","F2","6B","6F","C5","30","01","67","2B","FE","D7","AB","76"},{"CA","82","C9","7D","FA","59","47","F0","AD","D4","A2","AF","9C","A4","72","C0"},{"B7","FD","93","26","36","3F","F7","CC","34","A5","E5","F1","71","D8","31","15"},{"04","C7","23","C3","18","96","05","9A","07","12","80","E2","EB","27","B2","75"},{"09","83","2C","1A","1B","6E","5A","A0","52","3B","D6","B3","29","E3","2F","84"},{"53","D1","00","ED","20","FC","B1","5B","6A","CB","BE","39","4A","4C","58","CF"},{"D0","EF","AA","FB","43","4D","33","85","45","F9","02","7F","50","3C","9F","A8"},{"51","A3","40","8F","92","9D","38","F5","BC","B6","DA","21","10","FF","F3","D2"},{"CD","0C","13","EC","5F","97","44","17","C4","A7","7E","3D","64","5D","19","73"},{"60","81","4F","DC","22","2A","90","88","46","EE","B8","14","DE","5E","OB","DB"},{"E0","32","3A","0A","49","06","24","5C","C2","D3","AC","62","91","95","E4","79"},{"E7","C8","37","6D","8D","D5","4E","A9","6C","56","F4","EA","65","7A","AE","08"},{"BA","78","25","2E","1C","A6","B4","C6","E8","DD","74","1F","4B","BD","8B","8A"},{"70","3E","B5","66","48","03","F6","0E","61","35","57","B9","86","C1","1D","9E"},{"E1","F8","98","11","69","D9","8E","94","9B","1E","87","E9","CE","55","28","DF"},{"8C","A1","89","0D","BF","E6","42","68","41","99","2D","0F","B0","54","BB","16"}};
		String s1=String.valueOf(s.charAt(0));
		String s2=String.valueOf(s.charAt(1));
		int a=Integer.parseInt(s1,16);
		int b=Integer.parseInt(s2,16);
		
		return subBox[a][b];
	}
	public static int toInt(char c){
		if (c >= '0' && c <= '9') {
			return c - '0';
		}
		if (c >= 'A' && c <= 'F') {
			return c - 'A' + 10;
		}
		if (c >= 'a' && c <= 'f') {
			return c - 'a' + 10;
		}
		throw new IllegalArgumentException();
	}
	public static char toHex(int c){
		return "0123456789ABCDEF".charAt(c);
	}
	public static String xorHex(String a,String b){
		
		char a0=a.charAt(0);
		char a1=a.charAt(1);
		
		char b0=b.charAt(0);
		char b1=b.charAt(1);
		
		int ai0=toInt(a0);
		int ai1=toInt(a1);
		
		int bi0=toInt(b0);
		int bi1=toInt(b1);
		
		int res0=ai0^bi0;
		int res1=ai1^bi1;
		String res="";
		
		char ch0=toHex(res0);
		res+=ch0;
		ch0=toHex(res1);
		res+=ch0;
		return res;
		
	}
	public static String[][] SBoxState(String[][] a){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				a[i][j]=sbox(a[i][j]);
				a[i][j].toUpperCase();
			}
		}
		return a;
	}
	public static String[][] ShiftRows(String[][] a){
		a[1]=rev(a[1]);
		a[2]=rev(a[2]);
		a[2]=rev(a[2]);
		a[3]=rev(a[3]);
		a[3]=rev(a[3]);
		a[3]=rev(a[3]);
		return a;
	}
	public static int mov(int a,int b) {
		int temp;
		if(b==1)
			return a;
		else if(b==2) {
			if(a>127)
				a=(a<<1)^283;
			else
				a=a<<1;
			return a;
		}
		else {
			temp=mov(a,2);
			a=a^temp;
			return a;
		}
	}
	public static String[][] MixColumns(String[][] a){
		int[][] fixed = {{2,3,1,1},{1,2,3,1},{1,1,2,3},{3,1,1,2}};
		String[][] ar= new String[4][4];
		int ai,fi,te;
		String temp;
		int[] res = {0,0,0,0};
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				a[i][j].toUpperCase();
				for(int k=0;k<4;k++) {
					ai=Integer.parseInt(a[k][j],16);
					fi=fixed[i][k];
					res[k]=mov(ai,fi);
					
				}
				te=res[0]^res[1];
				te=te^res[2];
				te=te^res[3];
				
				temp=Integer.toHexString(te).toUpperCase();
				if(temp.length()==1)
					temp="0"+temp;
				ar[i][j]=temp;

			}
		}
		return ar;
	}
	public static String[][] AddRoundKey(String[][] a,String[][] b){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				a[i][j]=xorHex(a[i][j],b[i][j]);
				a[i][j].toUpperCase();
			}
		}
		return a;
	}
	public static String[][] RoundKeys(String[][] RKeys,char[] key){
		
		
		//key={"T","h","a","t","s"," ","m","y"," ","K","u","n","g"," ","F","u"};
		
		String[] hexkeys = new String[16];
		int c;
		char te=' ';
		for(int i=0;i<16;i++){
			if(key[i]==te){
				hexkeys[i]="20";
				continue;
			}
			c=(int)key[i];
			hexkeys[i]=Integer.toHexString(c).toUpperCase();
		}
		
		RKeys[0]=hexkeys;
		
		String[][] w = new String[4][4];
		String[] gow = new String[4];
		
		String Rc[]={"01","02","04","08","10","20","40","80","1B","36"};
		
		for(int p=0;p<10;p++){
			
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					w[i][j]=RKeys[p][4*i+j];
				}
			}
		  
			for(int i=0;i<4;i++)
				gow[i]=w[3][i];
			
			gow=rev(gow);
		  
			for(int i=0;i<4;i++){
				gow[i]=sbox(gow[i]);
			}
			
			//gow[0]=Rc[p]^gow[0];
			gow[0]=xorHex(Rc[p],gow[0]);
		  
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					RKeys[p+1][4*i+j]=xorHex(w[i][j],gow[j]);
					gow[j]=RKeys[p+1][4*i+j];				}
			}
		  
		}
		return RKeys;
	}
	public static void main(String args[]){
		Scanner inp = new Scanner(System.in);
		
		String[][][] img = new String[2000][2000][3];
		String[][] RKeys = new String[11][16];
		String[][] tempState = new String[4][4];
		String[][] Rk = new String[4][4];
		char[] key = new char[16];
		String inpt=inp.nextLine();
		for(int i=0;i<inpt.length();i++)
			key[i]=inpt.charAt(i);
		
		RKeys=RoundKeys(RKeys,key);
		
		String[][] state={{"54","4F","4E","20"},{"77","6E","69","54"},{"6F","65","6E","77"},{"20","20","65","6F"}};
		
		
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++){
				tempState[i][j]=state[i][j];
				Rk[j][i]=RKeys[0][4*i+j];
			}
			
		tempState=AddRoundKey(tempState,Rk);
		
		for(int p=1;p<10;p++){
			for(int i=0;i<4;i++)
				for(int j=0;j<4;j++)
					Rk[j][i]=RKeys[p][4*i+j];
			tempState=SBoxState(tempState);
			tempState=ShiftRows(tempState);
			tempState=MixColumns(tempState);
			tempState=AddRoundKey(tempState,Rk);
			
		
		}
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				Rk[j][i]=RKeys[10][4*i+j];
		tempState=SBoxState(tempState);
		tempState=ShiftRows(tempState);
		tempState=AddRoundKey(tempState,Rk);
		
		
	}
}