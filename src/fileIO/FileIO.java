package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileIO {
	
	private String fileName;
	private File file;
	
	public FileIO(String fileName) {
		this.fileName = fileName;
		file = new File( "C:\\tmp\\" + fileName+".txt");
	}
	
	//파일 생성
	public void create() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//파일 저장
	public void writeFile(String strArr[]) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for(String str : strArr) {
				pw.println(str);
			}
			pw.close();
			System.out.println("파일을 출력하였습니다.");
			
		} catch (IOException e) {
			System.out.println("입력에 실패하였습니다");
		}
	}
	
	
	//파일불러오기
	public String[] readFile() {
		
		String humanStrs[] = null;
		
		String str = "";
		int lineCount = 0;
		try {
			
			//갯수 파악
			BufferedReader brForCount = new BufferedReader(new FileReader(file));
			if(file.exists() && file.isFile() && file.canRead()) {
				while ((str = brForCount.readLine()) != null) {
					lineCount++;
				}
				brForCount.close();
			}else {
				System.out.println("파일이 존재하지 않습니다.");
			}
			
			//내용 추가
			humanStrs = new String[lineCount];
			BufferedReader br = new BufferedReader(new FileReader(file));
			int i = 0;
			while ((str = br.readLine()) != null) {
				humanStrs[i] = str;
				i++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("읽기에 실패하였습니다.");
		}
		return humanStrs;
	}
}
