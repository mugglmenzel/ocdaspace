package logic;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;



import com.stevesoft.pat.Regex;

import static logic.CheckTxtRegexMethods.*;

public class CheckTxtRegex {

	private static final String USER_MANAGEMENT = "#TESTNAME=2.4 Check file system and user management";
	private static final String ADD_USER = "#TESTNAME=2.4.a Add dummy user";
	private static final String WRITE_FILE = "#TESTNAME=2.4.b Write into a test file";
	private static final String READ_FILE = "#TESTNAME=2.4.c Read from a test file";
	private static final String DELETE_FILE = "#TESTNAME=2.4.d Delete the test file";
	private static final String USER_MAN = "#TESTNAME=2.4.e Check if the user management is working correctly";
	private static final String DELETE_USER = "#TESTNAME=2.4.f Add a dummy user";

	
	/**
	 * 
	 * @param filename : Name of the TXT file that you want to insert
	 * @return
	 * @throws IOException
	 */
	public static String readTxt(String filename) throws IOException
	{
		int i = 0;
    	int p = 0;
		String row = "";
		File inputFile = new File(filename);
    	FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);
        

        while( (row = br.readLine()) != null )
        {
          i++;
        }
        
    	FileReader nfr = new FileReader(inputFile);
        BufferedReader nbr = new BufferedReader(nfr);
        row="";
        String[] result = new String[i];
        while ((row = nbr.readLine()) != null)
		{
			result[p] = row;
			p++;
		}
		br.close();
		nbr.close();
		
		String resultString = "";
		for(int y = 0;y<result.length;y++)
			resultString = resultString + "~" +result[y];
		
		return resultString;
	}

	
	public static String[][] compareTxt(String input1, String input2, PropertiesConfiguration config) throws ConfigurationException, EvaluationException
	{
		//String[] output1 = new String;
		int p = 0;
		int counter;
		
		String[][] output1 = new String[500][2];

		
		//Kernel Version
		kernelVersion(input1,input2,config,output1,p);
		p=p+2;
		
		//CPU information
		cpu(input1,input2,config,output1,p);
		p=p+2;
		
		//Memory information
		memory(input1,input2,config,output1,p);
		p++;
		
		//Disc information
		discInfo(input1,input2,config,output1,p);
		p++;
		
		//Network Interfaces
		networkInterfaces(input1,input2,config,output1,p);
		p=p+2;
		
		//IP Address
		ipAddress(input1,input2,config,output1,p);
		p++;
		
		//Firewall
		firewall(input1,input2,config,output1,p);
		p++;
		
		//Routing
		routing(input1,input2,config,output1,p);
		p++;
		
		//ICMP private
		counter = icmp_private(input2,config,output1,p);
		p++;
		
		//ICMP public
		icmp_public(input2,config,output1,p,counter);
		p++;
		
		//DNS private Ip
		dnsPrivateIp(input2,config,output1,p);
		p++;
		
		//DNS public Ip
		dnsPublicIp(input2,config,output1,p);
		p++;
		
		//Process running
		processRunning(input2,config,output1,p);
		p++;
		
		//Remote Port
		remotePort(input2,config,output1,p);
		p++;
		
		//User Management
		output1[p][0] = USER_MANAGEMENT;
		p++;
		
		//Add dummy User
		userManagement(input2,config,output1,p, "2.4.a_Add_dummy_user_regex", ADD_USER);
		p++;
		
		//Write into a Testfile
		userManagement(input2,config,output1,p, "2.4.b_Write_into_a_test_file_regex", WRITE_FILE);
		p++;
		
		//Read from a Testfile
		userManagement(input2,config,output1,p, "2.4.c_Read_from_a_test_file_regex", READ_FILE);
		p++;
		
		//Delete a Testfile
		userManagement(input2,config,output1,p, "2.4.d_Delete_the_test_file_regex", DELETE_FILE);
		p++;
		
		//Change password
		userManagement(input2,config,output1,p,"2.4.e_Check_if_the_user_management_is_working_correctly_regex", USER_MAN);
		p++;
		
		//Delete User
		userManagement(input2,config,output1,p,"2.4.f_Delete_a_dummy_user_regex", DELETE_USER);
		p++;
		
		//Deleting null in List
				String[][] output2 = new String[p][2];
				for (int i = 0; i<p;i++){
					output2[i][0] = output1[i][0];
					output2[i][1] = output1[i][1];
					}
				return output2;
	}
	
	/**
	 * @param args
	 * @throws EvaluationException 
	 * @throws IOException 
	 */

	
	public static String[][] giveResults(String path1, String path2, String conf) throws ConfigurationException, EvaluationException, IOException{
		
		//String input1 = readTxt("C:/Users/Alexander/workspace/HiwiBerlin/src/outputCentOSVM");
		//String input2 = readTxt("C:/Users/Alexander/workspace/HiwiBerlin/src/outputCentOSVM2");
		PropertiesConfiguration config = new PropertiesConfiguration(conf);
		config.load();
		String input1 = readTxt(path1);
		String input2 = readTxt(path2);
		
	
		String [][] output = compareTxt(input1,input2,config);
//		for(int i = 0; i < output.length; i++)
//		{
//			System.out.println(output[i]);
//		}
		return output;
		
	}

}
