package com.flm.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Logo {
public  void logo() {
		File f=new File("C:\\Users\\Lenovo\\Desktop\\Chaitra core programs\\banner.txt");
		try(BufferedReader bw=new BufferedReader(new FileReader(f));){
			String line=null;
			while((line=bw.readLine())!=null) {
				System.out.println(line);
			}
		}catch(Exception ex) {
			System.out.println("Error :"+ex.getMessage());
		}
}
}
