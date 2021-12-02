package com.project.todo;


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
	public static String[] forward(String[] gow) {
		String temp = gow[3];
		  
		for(int i=3;i>=0;i--){
			if(i!=0)
				gow[i]=gow[i-1];
		}
		gow[0]=temp;
		return gow;
	}
	public static String Invsbox(String s){
		String[][] subBox= {{"52","09","6A","D5","30","36","A5","38","BF","40","A3","9E","81","F3","D7","FB"},{"7C","E3","39","82","9B","2F","FF","87","34","8E","43","44","C4","DE","E9","CB"},{"54","7B","94","32","A6","C2","23","3D","EE","4C","95","0B","42","FA","C3","4E"},{"08","2E","A1","66","28","D9","24","B2","76","5B","A2","49","6D","8B","D1","25"},{"72","F8","F6","64","86","68","98","16","D4","A4","5C","CC","5D","65","B6","92"},{"6C","70","48","50","FD","ED","B9","DA","5E","15","46","57","A7","8D","9D","84"},{"90","D8","AB","00","8C","BC","D3","0A","F7","E4","58","05","B8","B3","45","06"},{"D0","2C","1E","8F","CA","3F","0F","02","C1","AF","BD","03","01","13","8A","6B"},{"3A","91","11","41","4F","67","DC","EA","97","F2","CF","CE","F0","B4","E6","73"},{"96","AC","74","22","E7","AD","35","85","E2","F9","37","E8","1C","75","DF","6E"},{"47","F1","1A","71","1D","29","C5","89","6F","B7","62","0E","AA","18","BE","1B"},{"FC","56","3E","4B","C6","D2","79","20","9A","DB","C0","FE","78","CD","5A","F4"},{"1F","DD","A8","33","88","07","C7","31","B1","12","10","59","27","80","EC","5F"},{"60","51","7F","A9","19","B5","4A","0D","2D","E5","7A","9F","93","C9","9C","EF"},{"A0","E0","3B","4D","AE","2A","F5","B0","C8","EB","BB","3C","83","53","99","61"},{"17","2B","04","7E","BA","77","D6","26","E1","69","14","63","55","21","0C","7D"}};
		String s1=String.valueOf(s.charAt(0));
		String s2=String.valueOf(s.charAt(1));
		int a=Integer.parseInt(s1,16);
		int b=Integer.parseInt(s2,16);
		
		return subBox[a][b];
	}
	
	public static String sbox(String s){
		String[][] subBox= {{"63","7C","77","7B","F2","6B","6F","C5","30","01","67","2B","FE","D7","AB","76"},{"CA","82","C9","7D","FA","59","47","F0","AD","D4","A2","AF","9C","A4","72","C0"},{"B7","FD","93","26","36","3F","F7","CC","34","A5","E5","F1","71","D8","31","15"},{"04","C7","23","C3","18","96","05","9A","07","12","80","E2","EB","27","B2","75"},{"09","83","2C","1A","1B","6E","5A","A0","52","3B","D6","B3","29","E3","2F","84"},{"53","D1","00","ED","20","FC","B1","5B","6A","CB","BE","39","4A","4C","58","CF"},{"D0","EF","AA","FB","43","4D","33","85","45","F9","02","7F","50","3C","9F","A8"},{"51","A3","40","8F","92","9D","38","F5","BC","B6","DA","21","10","FF","F3","D2"},{"CD","0C","13","EC","5F","97","44","17","C4","A7","7E","3D","64","5D","19","73"},{"60","81","4F","DC","22","2A","90","88","46","EE","B8","14","DE","5E","OB","DB"},{"E0","32","3A","0A","49","06","24","5C","C2","D3","AC","62","91","95","E4","79"},{"E7","C8","37","6D","8D","D5","4E","A9","6C","56","F4","EA","65","7A","AE","08"},{"BA","78","25","2E","1C","A6","B4","C6","E8","DD","74","1F","4B","BD","8B","8A"},{"70","3E","B5","66","48","03","F6","0E","61","35","57","B9","86","C1","1D","9E"},{"E1","F8","98","11","69","D9","8E","94","9B","1E","87","E9","CE","55","28","DF"},{"8C","A1","89","0D","BF","E6","42","68","41","99","2D","0F","B0","54","BB","16"}};
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
	public static String[][] InvSBoxState(String[][] a){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				a[i][j]=Invsbox(a[i][j]);
				a[i][j].toUpperCase();
			}
		}
		return a;
	}
	public static String[][] InvShiftRows(String[][] a){
		a[1]=forward(a[1]);
		a[2]=forward(a[2]);
		a[2]=forward(a[2]);
		a[3]=forward(a[3]);
		a[3]=forward(a[3]);
		a[3]=forward(a[3]);
		return a;
	}
	public static int InvMov(int a,int b) {
		int temp,at;
		
		if(b==1)
			return a;
		else if(b==2) {
			if(a>127)
				a=(a<<1)^283;
			else
				a=a<<1;
			return a;
		}
		else if(b==3){
			temp=InvMov(a,2);
			a=a^temp;
			return a;
		}
		else if(b==9) {
			at=a;
			a=InvMov(a,2);
			a=InvMov(a,2);
			a=InvMov(a,2);
			a=a^at;
			return a;
		}
		else if(b==11) {
			at=a;
			a=InvMov(a,2);
			a=InvMov(a,2);
			a=a^at;
			a=InvMov(a,2);
			a=a^at;
			return a;
		}
		else if(b==13) {
			at=a;
			a=InvMov(a,2);
			a=a^at;
			a=InvMov(a,2);
			a=InvMov(a,2);
			a=a^at;
			return a;
		}
		else if(b==14) {
			at=a;
			a=InvMov(a,2);
			a=a^at;
			a=InvMov(a,2);
			a=a^at;
			a=InvMov(a,2);
			return a;
		}
		else {
			throw new IllegalArgumentException();
		}
		
	}
	public static String[][] InvMixColumns(String[][] a){
		int[][] fixed = {{14,11,13,9},{9,14,11,13},{13,9,14,11},{11,13,9,14}};
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
					res[k]=InvMov(ai,fi);
					
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
		
		String[][] state={{"29","57","40","1A"},{"C3","14","22","02"},{"50","20","99","D7"},{"5F","F6","B3","3A"}};
		
		
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++){
				tempState[i][j]=state[i][j];
				Rk[j][i]=RKeys[10][4*i+j];
			}
			
		tempState=AddRoundKey(tempState,Rk);
		
		for(int p=9;p>0;p--){
			for(int i=0;i<4;i++)
				for(int j=0;j<4;j++)
					Rk[j][i]=RKeys[p][4*i+j];
			tempState=InvShiftRows(tempState);
			tempState=InvSBoxState(tempState);
			tempState=AddRoundKey(tempState,Rk);
			tempState=InvMixColumns(tempState);
			
			
		
		}
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				Rk[j][i]=RKeys[0][4*i+j];
		
		tempState=InvShiftRows(tempState);
		tempState=InvSBoxState(tempState);
		tempState=AddRoundKey(tempState,Rk);
		
	}
}