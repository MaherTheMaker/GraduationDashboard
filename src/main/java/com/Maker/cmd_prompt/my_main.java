package com.Maker.cmd_prompt;

import com.Maker.model.Clinic;
import com.Maker.service.CodeGeneration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

	public class my_main {
	public static void RunDeploy(String clinicname) throws IOException {

//		String clinicname="Leen2";
		Path sourceDirectory = Paths.get("Servers/Template");
		Path targetDirectory = Paths.get("Servers/"+clinicname);
//        Files.copy(sourceDirectory, targetDirectory);
		File source = new File(sourceDirectory.toUri());
		File target = new File(targetDirectory.toUri());
		FileUtils.copyDirectory(source, target);

		CodeGeneration.GenerateApp(clinicname);
		CodeGeneration.GeneratePom(clinicname);
		Clinic clinic=new Clinic();
		clinic.setUsername(clinicname);
		CodeGeneration.GenerateData(clinic);


		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);

	    new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	    new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	    PrintWriter stdin = new PrintWriter(p.getOutputStream());
	    stdin.println("cd Servers\\"+clinicname+"\\spring-boot-jwt-25-7");
	    stdin.println("mvn clean package");
	    stdin.close();
	    p.waitFor();



	     	File warFile=new File("Servers\\"+clinicname+"\\spring-boot-jwt-25-7\\target\\"+clinicname+".war");

//			Path sourceDirectory1 = Paths.get(clinicname+"/spring-boot-jwt-25-7/target/");
//			Path targetDirectory1 = Paths.get("Servers/"+clinicname);

			Path copied = Paths.get("C:\\xampp\\Tomcat\\webapps\\"+clinicname+".war");
			Path originalPath = warFile.toPath();
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {
	 		e.printStackTrace();
		}



	}

	 
	
}	
