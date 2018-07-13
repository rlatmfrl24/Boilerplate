package FileSearch;

import java.io.File;

public class FileSearcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void subDirList(String source){
		File dir = new File(source); 
		File[] fileList = dir.listFiles();
		
		try{
			for(int i = 0 ; i < fileList.length ; i++){
				File file = fileList[i]; 
				if(file.isFile()){
					file.delete();
				}else if(file.isDirectory()){
					subDirList(file.getCanonicalPath().toString()); 
					file.delete();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
