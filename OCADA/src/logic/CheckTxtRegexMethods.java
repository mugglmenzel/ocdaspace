package logic;



import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.stevesoft.pat.Regex;

/**
 * 
 * @author Alexander Bogenrieder
 * @version 1.0
 */
public class CheckTxtRegexMethods {
	private static final String OS_METADATA = "#TESTNAME=2.1 OS metadata";
	private static final String KERNEL_VERSION = "#TESTNAME=2.1.a Kernel version";
	private static final String RESOURCE_INFORMATION = "#TESTNAME=2.2 Check resource information";
	private static final String CPU_INFORMATION = "#TESTNAME=2.2.a CPU information";
	private static final String MEMORY_INFORMATION = "#TESTNAME=2.2.b Memory information";
	private static final String DISK_INFORMATION = "#TESTNAME=2.2.c Disk information";
	private static final String CONNECTIVITY = "#TESTNAME=2.3 Connectivity";
	private static final String NETWORK_INTERFACES = "#TESTNAME=2.3.a Network interfaces";
	private static final String IP_ADRESS = "#TESTNAME=2.3.b IP address";
	private static final String FIREWALL_RULES = "#TESTNAME=2.3.c Firewall rules";
	private static final String ROUTING = "#TESTNAME=2.3.d Routing";
	private static final String ICMP_PRIVATE = "#TESTNAME=2.3.e ICMP connectivity (private IP)";
	private static final String ICMP_PUBLIC = "#TESTNAME=2.3.f ICMP connectivity (public IP)";
	private static final String DNS_PRIVATE = "#TESTNAME=2.3.g DNS reverse loopup (private IP)";
	private static final String DNS_PUBLIC = "#TESTNAME=2.3.h DNS reverse loopup (public IP)";
	private static final String PROCESS_RUNNING = "#TESTNAME=2.3.i Remote Shell Process running";
	private static final String REMOTE_PORT = "#TESTNAME=2.3.j Remote Shell Port available";
	
	


	
	public static final String OK = "Okay";
	public static final String FAIL = "Failure";
	public static final String WARNING = "Warning";
	
	/**
	 * 
	 * @param input1 : Data of the original test file 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 * @throws EvaluationException
	 */

	public static void kernelVersion(String input1, String input2,PropertiesConfiguration config, String[][] output1,int counterOutput) throws EvaluationException
	{

		//Kernel Version
				output1[counterOutput][0] = OS_METADATA;
				counterOutput++;
				
				Evaluator evaluator = new Evaluator();

				
				String[][] result = new String[3][3];
				Regex e = new Regex(config.getString("2.1.a_Kernel_version_regex"));
				e.search(input1);
				result[1][2] = e.stringMatched(1);
				result[1][1] = e.stringMatched(2);
				e.search(input2);
				result[2][2] = e.stringMatched(1);
				result[2][1] = e.stringMatched(2);
				
				for(int i=0; i < result.length; i++){
					  for(int j=0; j < result[i].length; j++){
					    evaluator.putVariable("result_" + i + "_" + j,"'" +result[i][j]+"'");
					  }
					}
				
				String exp1 = evaluator.replaceVariables(config.getString("2.1.a_Kernel_version_succ"));
				String exp2 = evaluator.replaceVariables(config.getString("2.1.a_Kernel_version_warn"));
				output1[counterOutput][0] = KERNEL_VERSION;
				
				if(evaluator.getBooleanResult(exp1))
					{
					output1[counterOutput][1] = OK;
					}
				else if (evaluator.getBooleanResult(exp2))
				{
					output1[counterOutput][1] = WARNING;
				}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
				counterOutput++;
	}
	
	/**
	 * 
	 * @param input1 : Data of the original test file 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 * @throws EvaluationException
	 */
	public static void cpu(String input1, String input2,PropertiesConfiguration config, String[][] output1,int counterOutput) throws EvaluationException
	{
		//CPU Information
				output1[counterOutput][0] = RESOURCE_INFORMATION;
				counterOutput++;
				String result_1;
				String result_2;
				Evaluator evaluator = new Evaluator();
				Regex e = new Regex(config.getString("2.2.a_Get_CPU_information_regex"));
				e.search(input1);
				result_1 = e.stringMatched(1);

				e.search(input2);
				result_2 = e.stringMatched(1);

				evaluator.putVariable("result_1",result_1);
				evaluator.putVariable("result_2",result_2);
				
				String exp1 = evaluator.replaceVariables(config.getString("2.2.a_Get_CPU_information_succ"));
				String exp2 = evaluator.replaceVariables(config.getString("2.2.a_Get_CPU_information_warn"));
				output1[counterOutput][0] = CPU_INFORMATION;
				
				if(evaluator.getBooleanResult(exp1))
					{
					output1[counterOutput][1] = OK;
					}
				else if (evaluator.getBooleanResult(exp2))
				{
					output1[counterOutput][1] = WARNING;
				}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
	/**
	 * 
	 * @param input1 : Data of the original test file 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 * @throws EvaluationException
	 */
	public static void memory(String input1, String input2,PropertiesConfiguration config, String[][] output1,int counterOutput) throws EvaluationException
	{
		//Memory Information
				String result_1;
				String result_2;
				Evaluator evaluator = new Evaluator();
				Regex e = new Regex(config.getString("2.2.b_Get_memory_information_regex"));
				e.search(input1);
				result_1 = e.stringMatched(1);

				e.search(input2);
				result_2 = e.stringMatched(1);
				
				evaluator.putVariable("result_1",result_1);
				evaluator.putVariable("result_2",result_2);
				
				String exp1 = evaluator.replaceVariables(config.getString("2.2.b_Get_memory_information_succ"));
				String exp2 = evaluator.replaceVariables(config.getString("2.2.b_Get_memory_information_warn"));
				output1[counterOutput][0] = MEMORY_INFORMATION;
				
				if(evaluator.getBooleanResult(exp1))
					{
					output1[counterOutput][1] = OK;
					}
				else if (evaluator.getBooleanResult(exp2))
				{
					output1[counterOutput][1] = WARNING;
				}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
	/**
	 * 
	 * @param input1 : Data of the original test file 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 */
	public static void discInfo(String input1, String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		Regex e = new Regex(config.getString("2.2.c_Get_disk_information_regex"));
		Regex r = new Regex("(\\S*).*?(\\d+).*?/(\\S*)");
		boolean success = true;
		boolean warning = true;
		int counter = 0;
		
		//Fill in original array with mountpoints
		e.search(input1);
		String testString1 = e.stringMatched();
		String[] fieldInput1 = testString1.split("~");
		String[][] fieldOriginal = new String[fieldInput1.length][3];
		
		for(int i = 0 ; i < fieldInput1.length;i++)
			if(r.search(fieldInput1[i])&&r.stringMatched(1)!=null&&r.stringMatched(2)!=null&&r.stringMatched(3)!=null)
			{
				fieldOriginal[counter][0]=r.stringMatched(1);
				fieldOriginal[counter][1]=r.stringMatched(2);
				fieldOriginal[counter][2]=r.stringMatched(3);
				counter++;
			}
		
		//Fill in hypervisor array with mountpoints
		e.search(input2);
		String testString2 = e.stringMatched();
		String[] fieldInput2 = testString2.split("~");
		String[][] fieldHypervisor = new String[fieldInput2.length][3];
		counter = 0;

		for(int i = 0 ; i < fieldInput2.length;i++)
		{
			if(r.search(fieldInput2[i])&&r.stringMatched(1)!=null&&r.stringMatched(2)!=null&&r.stringMatched(3)!=null)
			{
				fieldHypervisor[counter][0]=r.stringMatched(1);
				fieldHypervisor[counter][1]=r.stringMatched(2);
				fieldHypervisor[counter][2]=r.stringMatched(3);
				counter++;
			}
		}

		for(int i = 0; i < counter; i++)
			for(int j = 0; j < 3;j++)
			{
				//Check if size has changed
				if(j == 1)
				{
					if(!fieldHypervisor[i][j].equals(fieldOriginal[i][j]))
						success = false;
				}
				//Check if mountpoints have changed
				else
				{
					if(!fieldHypervisor[i][j].equals(fieldOriginal[i][j]))
						warning = false;
				}
			}
		output1[counterOutput][0] = DISK_INFORMATION;
		
		if(success&&warning)
			output1[counterOutput][1] =  OK;
		else if(!success && warning)
			output1[counterOutput][1] = WARNING;
		else
			output1[counterOutput][1] = FAIL;

		
	}
	/**
	 * 
	 * @param input1 : Data of the original test file 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 */
	
	public static void networkInterfaces(String input1, String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		//Network Inferfaces
				output1[counterOutput][0] = CONNECTIVITY;
				counterOutput++;
			
				Regex e = new Regex(config.getString("2.3.a_Network_interfaces_regex"));
				
				boolean original = e.search(input1);

				boolean hypervisor = e.search(input2);
				
				output1[counterOutput][0] = NETWORK_INTERFACES;
				
				if(original && hypervisor)
					{
					output1[counterOutput][1] = OK;
					}
				else if (hypervisor)
				{
					output1[counterOutput][1] = WARNING;
				}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
	/**
	 * 
	 * @param input1 : Data of the original test file 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : ouput array
	 * @param counterOutput : counter for the output array
	 */
	public static void ipAddress(String input1, String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		//IP Adress
			
				Regex e = new Regex(config.getString("2.3.b_IP_address_regex"));
				
				 e.search(input1);
				 String original = e.stringMatched(1);
				 e.search(input2);
				 String hypervisor = e.stringMatched(1);
				 output1[counterOutput][0] = IP_ADRESS;
				 
				 if(hypervisor != null && original != null)
				 {
					 if(original.equals(hypervisor))
						{
						 output1[counterOutput][1] = OK;
						}
					else
					{
						output1[counterOutput][1] = WARNING;
					}
				 }
				
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
	/**
	 * 
	 * @param input1 : Data of the original test file 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 */
	public static void firewall(String input1, String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		//Firewall Rules		
		Regex e = new Regex(config.getString("2.3.c_Firewall_rules_regex"));
		
		 e.search(input1);
		 String original = e.stringMatched(1);
		 e.search(input2);
		 String hypervisor = e.stringMatched(1);
		 output1[counterOutput][0] = FIREWALL_RULES;
		 
		 if(hypervisor != null && original != null)
		 {
			 if(original.equals(hypervisor))
				{
				 output1[counterOutput][1] = OK;
				}
			else
			{
				output1[counterOutput][1] = WARNING;
			}
		 }
		
		else
		{
			output1[counterOutput][1] = FAIL;
		}
	}
	
	/**
	 * 
	 * @param input1 : Data of the original test file 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : ouput array
	 * @param counterOutput : counter for the output array
	 */
	public static void routing(String input1, String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		//Routing
				String original;
				String hypervisor=null;

				Regex e = new Regex(config.getString("2.3.d_Routing_regex"));
				e.search(input1);
				original = e.stringMatched(1);
				
				e.search(input2);
				output1[counterOutput][0] = ROUTING;
				
				if(e.stringMatched(1)!=null)
				{
				hypervisor = e.stringMatched(1);
				
					if(original.equals(hypervisor))
					{
						output1[counterOutput][1] = OK;
					}
					else 
					{
						output1[counterOutput][1] = WARNING;
					}
				}
				
				else
				{
					output1[counterOutput][1] = FAIL;
				}
				

				
				
	}
	/**
	 * 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 * @return returns where the search has stopped
	 * @throws EvaluationException
	 */
	public static int icmp_private(String input2,PropertiesConfiguration config, String[][] output1,int counterOutput) throws EvaluationException
	{
		//ICMP Private
				String packages;
				String loss;
				String ping;
				int counter = 0;
				
				Evaluator evaluator = new Evaluator();
				Regex e = new Regex(config.getString("2.3.e_ICMP_connectivity_(private_IP)_regex"));
				e.search(input2);
				
				if(e.stringMatched()!=null)
				{
				packages = e.stringMatched(1);
				loss = (e.stringMatched(2));
				ping = e.stringMatched(3);
				
				evaluator.putVariable("packages",packages);
				evaluator.putVariable("loss", loss);
				evaluator.putVariable("ping", ping);
							
				String exp1 = evaluator.replaceVariables(config.getString("2.3.e_ICMP_connectivity_(private_IP)_succ"));
				String exp2 = evaluator.replaceVariables(config.getString("2.3.e_ICMP_connectivity_(private_IP)_warn"));
				counter = e.matchedTo();

				output1[counterOutput][0] = ICMP_PRIVATE;
				if(evaluator.getBooleanResult(exp1))
					{
					output1[counterOutput][1] = OK;
					}
				else if (evaluator.getBooleanResult(exp2))
				{
					output1[counterOutput][1] = WARNING;
				}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
				}
				
				else
				{
					output1[counterOutput][1] = FAIL;
				}
				return counter;
	}
	/**
	 * 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 * @param counter int where to continue the search
	 * @throws EvaluationException
	 */
	public static void icmp_public(String input2,PropertiesConfiguration config, String[][] output1,int counterOutput, int counter) throws EvaluationException
	{
		//ICMP Private
				String packages;
				String loss;
				String ping;
		
				Evaluator evaluator = new Evaluator();
				Regex e = new Regex(config.getString("2.3.f_ICMP_connectivity_(public_IP)_regex"));
				e.searchFrom(input2, counter);
				
				
				if(e.stringMatched()!=null)
				{
					packages = e.stringMatched(1);
					loss = (e.stringMatched(2));
					ping = e.stringMatched(3);
					
					evaluator.putVariable("packages",packages);
					evaluator.putVariable("loss", loss);
					evaluator.putVariable("ping", ping);
					
					String exp1 = evaluator.replaceVariables(config.getString("2.3.f_ICMP_connectivity_(public_IP)_succ"));
					String exp2 = evaluator.replaceVariables(config.getString("2.3.f_ICMP_connectivity_(public_IP)_warn"));
					output1[counterOutput][0] = ICMP_PUBLIC;
					
					if(evaluator.getBooleanResult(exp1))
						{
						output1[counterOutput][1] = OK;
						}
					else if (evaluator.getBooleanResult(exp2))
					{
						output1[counterOutput][1] = WARNING;
					}
					else
					{
						output1[counterOutput][1] = FAIL;
					}
				}
				
				else
				{
					output1[counterOutput][1] = FAIL;
				}
				
	}
	/**
	 * 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 */
	public static void processRunning(String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		//ICMP Private
				String testString;
				Regex e = new Regex(config.getString("2.3.i_Remote_Shell_process_running_regex"));
				e.search(input2);
				testString = e.stringMatched();
				output1[counterOutput][0] = PROCESS_RUNNING;

				if(testString != null)
					{
					output1[counterOutput][1] = OK;
					}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
	/**
	 *  
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 */
	public static void remotePort(String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		//ICMP Private
				String testString;
				Regex e = new Regex(config.getString("2.3.j_Remote_Shell_Port_available_regex"));
				e.search(input2);
				testString = e.stringMatched();
				output1[counterOutput][0] = REMOTE_PORT;
				
				if(testString != null)
					{
					output1[counterOutput][1] =  OK;
					}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
	/**
	 * 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 */
	public static void dnsPrivateIp(String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		//DNS private IP
				String testString;
				Regex e = new Regex(config.getString("2.3.g_DNS_reverse_lookup_(private_IP)_regex"));
				e.search(input2);
				testString = e.stringMatched();
				output1[counterOutput][0] = DNS_PRIVATE;

				if(testString != null)
					{
					output1[counterOutput][1] = OK;
					}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
	/**
	 * 
	 * @param input2 : Data of the new test file
	 * @param config : properties
	 * @param output1 : output array
	 * @param counterOutput : counter for the output array
	 */
	public static void dnsPublicIp(String input2,PropertiesConfiguration config, String[][] output1,int counterOutput)
	{
		//DNS public IP
				String testString;
				Regex e = new Regex(config.getString("2.3.h_DNS_reverse_lookup_(public_IP)_regex"));
				e.search(input2);
				testString = e.stringMatched();
				output1[counterOutput][0] = DNS_PUBLIC;

				if(testString != null)
					{
					output1[counterOutput][1] = OK;
					}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
/**
 * 
 * @param input2 : Data of the new test file
 * @param config : properties
 * @param output1 : output array
 * @param counterOutput : counter for the output array
 * @param key : the key for the config file
 * @param test : the name of the test
 */
	public static void userManagement(String input2,PropertiesConfiguration config, String[][] output1,int counterOutput, String key, String test)
	{
		//User Management
				String testString;
				Regex e = new Regex(config.getString(key));
				e.search(input2);
				testString = e.stringMatched();
				output1[counterOutput][0] = test;

				if(testString != null)
					{
					output1[counterOutput][1] = OK;
					}
				else
				{
					output1[counterOutput][1] = FAIL;
				}
	}
}
